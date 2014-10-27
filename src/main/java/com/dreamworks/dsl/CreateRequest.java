package com.dreamworks.dsl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author mmonti
 */
public class CreateRequest implements Create {

    private CreateStatement statement;
    private List<String> requestFields;
    private List<Entry> requestEntries;

    Statement buildStatement() {
        statement.fields = requestFields;
        statement.entries = requestEntries;
        return statement;
    }

    CreateSelect createSelect = new CreateSelect() {
        @Override
        public CreateSelect select(String... fields) {
            requestFields.addAll(Arrays.asList(fields));
            return this;
        }

        @Override
        public Statement build() {
            return buildStatement();
        }
    };

    CreateInsertSelect createInsertSelect = new CreateInsertSelect() {
        @Override
        public CreateSelect select(String... fields) {
            return createSelect.select(fields);
        }

        @Override
        public Statement build() {
            return buildStatement();
        }
    };

    @Override
    public CreateInsert in(String entity) {

        statement = new CreateStatement(entity);
        requestFields = new ArrayList<String>();
        requestEntries = new ArrayList<Entry>();

        return new CreateInsert() {
            @Override
            public CreateInsertSelect insert(Entry... entries) {
                requestEntries.addAll(Arrays.asList(entries));
                return createInsertSelect;
            }

            @Override
            public CreateInsertSelect insert(String name, Object value) {
                requestEntries.add(new Entry(name, value));
                return createInsertSelect;
            }

            @Override
            public CreateInsertSelect insert(String name, Entry value) {
                requestEntries.add(new Entry(name, value));
                return createInsertSelect;
            }
        };
    }
}
