package com.dreamworks.dsl;

import java.util.List;
import java.util.Map;

/**
 * @author mmonti
 */
public class UpdateStatement implements Statement {

    String entity;
    Integer id;
    List<String> fields;
    List<Entry> entries;
    Map<String, String> modes;

    UpdateStatement(final String entity) {
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
    
    public Map<String, String> getModes() {
		return modes;
	}
    
    public Integer getId() {
		return id;
	}
}
