package com.dreamworks.dsl;

/**
 * @author mmonti
 */
public class Entries {

    public static EntryValue name(String name) {
        return new EntryBuilder().name(name);
    }
}
