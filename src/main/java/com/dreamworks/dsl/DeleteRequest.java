package com.dreamworks.dsl;

/**
 * @author mmonti
 */
public class DeleteRequest extends IdentifiableRequest implements Delete {

    private DeleteStatement statement;

    @Override
    public Identifiable delete(final String entity) {
        statement = new DeleteStatement(entity);

        return new Identifiable() {
            @Override
            public Buildable withId(final Integer id) {
                requestId = id;
                return new Buildable() {
                    @Override
                    public Statement build() {
                        statement.id = requestId;
                        return statement;
                    }
                };
            }
        };
    }

}
