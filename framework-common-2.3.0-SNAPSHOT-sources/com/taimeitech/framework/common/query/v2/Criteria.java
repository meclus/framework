package com.taimeitech.framework.common.query.v2;

import com.taimeitech.framework.common.dto.PropertySelector;
import com.taimeitech.framework.common.query.Joint;
import com.taimeitech.framework.common.query.Sort;
import com.taimeitech.framework.common.query.SortProperty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Thomason
 * @version 1.0
 * @since 2017/6/15 17:26
 */
public final class Criteria {
	//对象名称
	private String entityName;
	//筛选条件
	private List<Condition> conditions = new ArrayList<>();
	//排序属性列
	private List<SortProperty> sortProperties;
	//属性选择器
	private PropertySelector selector;

	public static Criteria create() {
		return new Criteria();
	}

	public Criteria addCriterion(Condition... condition) {
		if (conditions == null) {
			conditions = new ArrayList<>();
		}
		if (condition != null) {
			conditions.addAll(Arrays.asList(condition));
		}
		return this;
	}

	public Criteria clear() {
		this.conditions = new ArrayList<>();
		this.sortProperties = null;
		return this;
	}

	public Criteria addSortProperty(SortProperty... sortProperty) {
		if (sortProperty == null || sortProperty.length == 0) {
			return this;
		}
		if (this.sortProperties == null) {
			this.sortProperties = new ArrayList<>();
		}
		sortProperties.addAll(Arrays.asList(sortProperty));
		return this;
	}

	public Criteria and(String prop, Operator operator, String value) {
		return and(new String[]{prop}, operator, value);
	}

	public Criteria and(String[] props, Operator operator, String value) {
		if (props != null && props.length > 0) {
			for (String prop : props) {
				Condition condition = new Condition(prop, operator, value);
				this.addCriterion(condition);
			}
		}
		return this;
	}

	public Criteria or(String prop, Operator operator, String value) {
		return or(new String[]{prop}, operator, value);
	}

	public Criteria or(String[] props, Operator operator, String value) {
		if (props != null && props.length > 0) {
			Condition condition = new Condition();
			List<Condition> subConditions = new ArrayList<>();
			for (String prop : props) {
				Condition subCondition = new Condition(prop, operator, value);
				subCondition.setJoint(Joint.OR);
				subConditions.add(subCondition);
			}
			condition.setSubConditions(subConditions);
			this.addCriterion(condition);
		}
		return this;
	}

	public Criteria asc(String... props) {
		if (props != null && props.length > 0) {
			for (String prop : props) {
				this.addSortProperty(new SortProperty(prop, Sort.ASC));
			}
		}
		return this;
	}

	public Criteria desc(String... props) {
		if (props != null && props.length > 0) {
			for (String prop : props) {
				this.addSortProperty(new SortProperty(prop, Sort.DESC));
			}
		}
		return this;
	}


	public String getEntityName() {
		return entityName;
	}

	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}

	public List<Condition> getConditions() {
		return conditions;
	}

	public List<SortProperty> getSortProperties() {
		return sortProperties;
	}

	public PropertySelector getSelector() {
		return selector;
	}

	public void setSelector(PropertySelector selector) {
		this.selector = selector;
	}
}
