package com.dreamworks.dsl;

/**
 * @author mmonti
 */
public interface FindConstraints extends Buildable {

    /**
     *
     * @param fields
     * @return
     */
    FindSelectWhere select(final String ... fields);

    /**
     *
     * @param field
     * @param operator
     * @param value
     * @return
     */
    FindWhereSort where(final String field, final String operator, final String value);

    /**
     *
     * @param field
     * @return
     */
    FindSortPaging sortBy(final String field);

    /**
     *
     * @param size
     * @return
     */
    FindPaging limit(final int size);

    /**
     *
     * @param page
     * @return
     */
    FindPaging offset(final int page);
}
