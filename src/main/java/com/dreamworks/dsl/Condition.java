package com.dreamworks.dsl;

/**
 * @author mmonti
 */
public class Condition {

    private String field;
    private String operator;
    private String value;

    public Condition(final String field, final String operator, final String value) {
        this.field = field;
        this.operator = operator;
        this.value = value;
    }

    public String getField() {
        return field;
    }

    public String getOperator() {
        return operator;
    }

    public String getValue() {
        return value;
    }
}
