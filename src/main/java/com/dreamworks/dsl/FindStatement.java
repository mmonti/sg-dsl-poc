package com.dreamworks.dsl;

import java.util.List;

/**
 * @author mmonti
 */
public class FindStatement implements Statement {

    String entity;
    List<String> fields;
    List<Condition> conditions;
    List<String> sorts;

    FindStatement(final String entity) {
        this.entity = entity;
    }

    public String getEntity() {
        return entity;
    }

    public List<String> getFields() {
        return fields;
    }

    public List<Condition> getConditions() {
        return conditions;
    }

    public List<String> getSorts() {
        return sorts;
    }
}
