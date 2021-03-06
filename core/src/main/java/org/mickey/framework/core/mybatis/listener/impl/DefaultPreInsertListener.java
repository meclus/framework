package org.mickey.framework.core.mybatis.listener.impl;

import lombok.extern.slf4j.Slf4j;
import org.mickey.framework.common.SystemContext;
import org.mickey.framework.common.po.AbstractCommonPo;
import org.mickey.framework.common.po.BasePo;
import org.mickey.framework.common.po.BaseProjectPo;
import org.mickey.framework.common.util.StringUtil;
import org.mickey.framework.common.util.UUIDUtils;
import org.mickey.framework.core.mybatis.listener.spi.PreInsertListener;

import java.util.Date;

/**
 * description
 *
 * @author mickey
 * 23/07/2019
 */
@Slf4j
public class DefaultPreInsertListener implements PreInsertListener {
    @Override
    public boolean preInsert(Object object) {
        if (object == null) {
            return true;
        }

        if (object instanceof AbstractCommonPo) {
            AbstractCommonPo po = (AbstractCommonPo) object;
            if (StringUtil.isBlank(po.getId())) {
                po.setId(UUIDUtils.getUuid());
            }
            po.setVersion(0L);
            if (po.getCreateTime() == null) {
                po.setCreateTime(new Date());
            }
            if (po.getUpdateTime() == null) {
                po.setUpdateTime(new Date());
            }
            if (po.getCreateBy() == null) {
                po.setCreateBy(SystemContext.getUserId());
            }
            if (po.getUpdateBy() == null) {
                po.setUpdateBy(SystemContext.getUserId());
            }
            po.setIsDeleted(Boolean.FALSE);
        }
        if (object instanceof BasePo) {
            ((BasePo) object).setTenantId(SystemContext.getTenantId());
        }
        if (object instanceof BaseProjectPo) {
            ((BaseProjectPo) object).setProjectId(SystemContext.getProjectId());
        }
        return true;
    }

    @Override
    public int getOrder() {
        return -1;
    }
}
