package com.dreamworks.dsl;

/**
 * @author mmonti
 */
public interface EntryValue {

    Entry value(final String value);

    Entry value(final Object value);

    Entry value(final Entry ... entry);

}
