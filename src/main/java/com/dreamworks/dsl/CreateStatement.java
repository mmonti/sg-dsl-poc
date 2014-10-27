package com.dreamworks.dsl;

import java.util.List;

/**
 * @author mmonti
 */
public class CreateStatement implements Statement {

    String entity;
    List<String> fields;
    List<Entry> entries;

    CreateStatement(final String entity) {
        this.entity = entity;
    }

    public String getEntity() {
        return entity;
    }

    public List<String> getFields() {
        return fields;
    }

    public List<Entry> getEntries() {
        return entries;
    }
}
