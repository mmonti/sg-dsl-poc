package com.dreamworks.dsl;

/**
 * @author mmonti
 */
public interface CreateInsert {

    CreateInsertSelect insert(final Entry ... entries);

    CreateInsertSelect insert(final String name, final Object value);

    CreateInsertSelect insert(final String name, final Entry value);

}
