package com.dreamworks.dsl;

/**
 * @author mmonti
 */
public class DeleteStatement implements Statement {

    String entity;
    int id;

    DeleteStatement(final String entity) {
        this.entity = entity;
    }

    public String getEntity() {
        return entity;
    }

    public int getId() {
        return id;
    }

}
