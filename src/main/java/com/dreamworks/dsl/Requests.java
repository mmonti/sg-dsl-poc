package com.dreamworks.dsl;

/**
 * @author mmonti
 */
public class Requests {

    public static Identifiable delete(final String entity) {
        return new DeleteRequest().delete(entity);
    }

    public static Identifiable revive(final String entity) {
        return new DeleteRequest().delete(entity);
    }

    public static FindConstraints from(final String entity) {
        return new FindRequest().from(entity);
    }

    public static CreateInsert in(final String entity) {
        return new CreateRequest().in(entity);
    }

}
