package com.dreamworks.dsl;

/**
 * @author mmonti
 */
public class Entry {

    String name;
    Object value;

    /**
     *
     * @param name
     * @param value
     */
    public Entry(final String name, final Object value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public Object getValue() {
        return value;
    }
}
