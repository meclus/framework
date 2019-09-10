package org.mickey.framework.common.query.v2;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.mickey.framework.common.query.Joint;

import javax.persistence.criteria.JoinType;
import java.io.Serializable;
import java.util.List;

/**
 * description
 *
 * @author mickey
 * 23/07/2019
 */
@Slf4j
@Data
public class Condition implements Serializable {
    //条件连接字符串 and or
    private Joint joint = Joint.AND;
    //查询主实体名称
    private String entityName;
    //实体对应的属性名称
    private String propertyName;
    /**
     * 多个属性之间的连接方式
     */
    private JoinType joinType = JoinType.INNER;
    //查询关系符号
    private Operator operator = Operator.equal;
    //条件的值
    private String value;
    //子条件
    private List<Condition> subConditions;

    public Condition() {
    }

    public Condition(String propertyName, String value) {
        this.propertyName = propertyName;
        this.value = value;
    }

    public Condition(String propertyName, Operator operator, String value) {
        this.propertyName = propertyName;
        this.operator = operator;
        this.value = value;
    }

    public boolean hasSubCondition() {
        return this.subConditions != null && this.subConditions.size() > 0;
    }

//    /**
//     * 判断属性是否为关联属性
//     *
//     * @return
//     */
//	/*public static boolean isRelativeProperty(String propertyName) {
//		if (propertyName != null && !propertyName.isEmpty()) {
//			if (propertyName.contains(PATH_SEPARATOR)) {
//				return true;
//			}
//		}
//		return false;
//	}*/
//    public Joint getJoint() {
//        return joint;
//    }
//
//    public void setJoint(Joint joint) {
//        this.joint = joint;
//    }
//
//    public String getEntityName() {
//        return entityName;
//    }
//
//    public void setEntityName(String entityName) {
//        this.entityName = entityName;
//    }
//
//    public String getPropertyName() {
//        return propertyName;
//    }
//
//    public void setPropertyName(String propertyName) {
//        this.propertyName = propertyName;
//    }
//
//    public Operator getOperator() {
//        return operator;
//    }
//
//    public void setOperator(Operator operator) {
//        this.operator = operator;
//    }
//
//    public String getValue() {
//        return value;
//    }
//
//    public void setValue(String value) {
//        this.value = value;
//    }
//
//    public List<Condition> getSubConditions() {
//        return subConditions;
//    }
//
//    public void setSubConditions(List<Condition> subConditions) {
//        this.subConditions = subConditions;
//    }
//
//    public JoinType getJoinType() {
//        return joinType;
//    }
//
//    public void setJoinType(JoinType joinType) {
//        this.joinType = joinType;
//    }
}