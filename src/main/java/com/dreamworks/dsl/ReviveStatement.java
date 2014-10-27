package com.dreamworks.dsl;

/**
 * @author mmonti
 */
public class ReviveStatement implements Statement {

    String entity;
    int id;

    ReviveStatement(final String entity) {
        this.entity = entity;
    }

    public String getEntity() {
        return entity;
    }

    public int getId() {
        return id;
    }

}
