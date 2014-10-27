package com.dreamworks.dsl;

/**
 * @author mmonti
 */
public class ReviveRequest extends IdentifiableRequest implements Delete {

    private ReviveStatement statement;

    @Override
    public Identifiable delete(final String entity) {
        statement = new ReviveStatement(entity);

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
