package org.mickey.framework.core.mybatis.sharding.impl;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.mickey.framework.common.database.Column;
import org.mickey.framework.common.database.Table;
import org.mickey.framework.core.mybatis.sharding.ShardingManager;
import org.mickey.framework.core.mybatis.sharding.table.po.IdMapping;
import org.mickey.framework.dbinspector.common.ThreadPoolExecutor;
import org.mickey.framework.dbinspector.mybatis.sharding.table.po.ShardingMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.stream.Collectors;

/**
 * description
 *
 * @author mickey
 * 23/07/2019
 */
@Slf4j
public class DoubleWriteManager implements ShardingManager {

    private static Logger logger = LoggerFactory.getLogger(DoubleWriteManager.class);

    private ShardingManager jdbcShardingManager;
    private ShardingManager redisShardingManager;
    private ThreadPoolExecutor poolExecutor;


    @Override
    public int saveShardingMappings(ShardingMapping... shardingMappings) {
        poolExecutor.execute(() -> {
            jdbcShardingManager.saveShardingMappings(shardingMappings);
        });
        return redisShardingManager.saveShardingMappings(shardingMappings);
    }

    @Override
    public int saveIdMappings(IdMapping... idMappings) {
        poolExecutor.execute(() -> {
            jdbcShardingManager.saveIdMappings(idMappings);
        });
        return redisShardingManager.saveIdMappings(idMappings);
    }

    @Override
    public String getShardingTableNameByValue(Table table, String shardingValue) {
        String shardingTableName = redisShardingManager.getShardingTableNameByValue(table, shardingValue);
        if (StringUtils.isBlank(shardingTableName)) {
            shardingTableName = jdbcShardingManager.getShardingTableNameByValue(table, shardingValue);
            if (StringUtils.isBlank(shardingTableName)) {
                shardingTableName = shardingTable(table, shardingValue);
                ShardingMapping shardingMapping = createShardingMapping(table, shardingValue, shardingTableName);
                saveShardingMappings(shardingMapping);
            } else {
                ShardingMapping shardingMapping = createShardingMapping(table, shardingValue, shardingTableName);
                redisShardingManager.saveShardingMappings(shardingMapping);
            }
        }
        return shardingTableName;
    }

    private ShardingMapping createShardingMapping(Table table, String shardingValue, String shardingTableName) {
        ShardingMapping shardingMapping = new ShardingMapping();
        shardingMapping.setTableName(table.getSqlName());
        shardingMapping.setShardingValue(shardingValue);
        shardingMapping.setShardingKey(table.getColumns().stream().filter(Column::isSharding).map(Column::getSqlName).collect(Collectors.joining(",")));
        shardingMapping.setShardingTableName(shardingTableName);
        return shardingMapping;
    }

    @Override
    public String getShardingTableNameById(Table table, String id) {
        String shardingTableName = redisShardingManager.getShardingTableNameById(table, id);
        if (StringUtils.isBlank(shardingTableName)) {
            shardingTableName = jdbcShardingManager.getShardingTableNameById(table, id);
            if (StringUtils.isBlank(shardingTableName)) {
                return null;
            } else {
                IdMapping idMapping = createIdMapping(table, id, shardingTableName);
                redisShardingManager.saveIdMappings(idMapping);
            }
        }
        return shardingTableName;
    }

    private IdMapping createIdMapping(Table table, String id, String shardingTableName) {
        IdMapping idMapping = new IdMapping();
        idMapping.setId(id);
        idMapping.setTableName(table.getSqlName());
        idMapping.setShardingKey(table.getColumns().stream().filter(Column::isSharding).map(Column::getSqlName).collect(Collectors.joining(",")));
        idMapping.setShardingTableName(shardingTableName);
        return idMapping;
    }

    @Override
    public Map<String, String> getShardingTableNameByValues(Table table, Set<String> shardingValues) {
        if (CollectionUtils.isEmpty(shardingValues)) {
            return null;
        }
        Map<String, String> resultMap = redisShardingManager.getShardingTableNameByValues(table, shardingValues);
        if (resultMap.keySet().size() == shardingValues.size()) {
            return resultMap;
        }
        //this case usually occurs when redis is crash,redis's cache is missing,so wo need to find from DB
        Set<String> subtract = new HashSet<>(CollectionUtils.subtract(shardingValues, resultMap.keySet()));
        Map<String, String> jdbcMap = jdbcShardingManager.getShardingTableNameByValues(table, subtract);
        //if the DB really have those keys
        if (subtract.size() == jdbcMap.size()) {
            resultMap.putAll(jdbcMap);
            //save redis missing value
            List<ShardingMapping> shardingMappings = new ArrayList<>();
            jdbcMap.forEach((k, v) -> shardingMappings.add(createShardingMapping(table, k, v)));
            redisShardingManager.saveShardingMappings(shardingMappings.toArray(new ShardingMapping[shardingMappings.size()]));
        }
        //when DB and redis both missing the value,we need to re-sharding the value,and save the new value
        else {
            Collection<String> reallyMissingValues = CollectionUtils.subtract(subtract, jdbcMap.keySet());
            List<ShardingMapping> shardingMappings = new ArrayList<>();
            for (String reallyMissingValue : reallyMissingValues) {
                String shardingTableName = shardingTable(table, reallyMissingValue);
                shardingMappings.add(createShardingMapping(table, reallyMissingValue, shardingTableName));
                resultMap.put(reallyMissingValue, shardingTableName);
            }
            this.saveShardingMappings(shardingMappings.toArray(new ShardingMapping[shardingMappings.size()]));
        }
        return resultMap;
    }

    @Override
    public Map<String, String> getShardingTableNameByIds(Table table, Set<String> ids) {
        if (CollectionUtils.isEmpty(ids)) {
            return null;
        }
        Map<String, String> resultMap = redisShardingManager.getShardingTableNameByIds(table, ids);
        if (resultMap.keySet().size() == ids.size()) {
            return resultMap;
        }
        //this case usually occurs when redis is crash,redis's cache is missing,so wo need to find from DB
        Set<String> subtract = new HashSet<>(CollectionUtils.subtract(ids, resultMap.keySet()));
        Map<String, String> jdbcMap = jdbcShardingManager.getShardingTableNameByIds(table, subtract);
        if (jdbcMap != null && !jdbcMap.isEmpty()) {
            resultMap.putAll(jdbcMap);
            List<IdMapping> idMappingList = new ArrayList<>();
            for (Map.Entry<String, String> entry : jdbcMap.entrySet()) {
                String id = entry.getKey();
                String value = entry.getValue();
                IdMapping idMapping = createIdMapping(table, id, value);
                idMappingList.add(idMapping);
            }
            redisShardingManager.saveIdMappings(idMappingList.toArray(new IdMapping[idMappingList.size()]));
        }
        return resultMap;
    }

    public void setJdbcShardingManager(ShardingManager jdbcShardingManager) {
        this.jdbcShardingManager = jdbcShardingManager;
    }

    public void setRedisShardingManager(ShardingManager redisShardingManager) {
        this.redisShardingManager = redisShardingManager;
    }

    public void setPoolExecutor(ThreadPoolExecutor poolExecutor) {
        this.poolExecutor = poolExecutor;
    }
}
