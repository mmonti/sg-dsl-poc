package com.dreamworks.dsl;

import java.util.Arrays;

/**
 * @author mmonti
 */
public class EntryBuilder implements EntryName {

    Entry current;

    @Override
    public EntryValue name(String name) {

        current = new Entry(name, null);

        return new EntryValue() {

            @Override
            public Entry value(String value) {
                current.value = value;
                return current;
            }

            @Override
            public Entry value(Object value) {
                current.value = value;
                return current;
            }

            @Override
            public Entry value(Entry ... entries) {
                current.value = Arrays.asList(entries);
                return current;
            }
        };
    }
}
