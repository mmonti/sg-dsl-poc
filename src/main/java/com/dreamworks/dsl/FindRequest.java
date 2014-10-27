package com.dreamworks.dsl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author mmonti
 */
public class FindRequest implements Find {

    FindStatement statement;
    List<String> requestFields;
    List<Condition> requestConditions;
    List<String> requestSorts;
    int requestOffset;
    int requestLimit;

    Statement buildStatement() {
        statement.fields = requestFields;
        statement.conditions = requestConditions;
        statement.sorts = requestSorts;
        return statement;
    }

    FindPaging paging = new FindPaging() {
        @Override
        public FindPaging limit(final int limit) {
            requestLimit = limit;
            return this;
        }

        @Override
        public FindPaging offset(final int offset) {
            requestOffset = offset;
            return this;
        }

        @Override
        public Statement build() {
            return buildStatement();
        }
    };

    FindSortPaging sortPaging = new FindSortPaging() {
        @Override
        public FindPaging limit(final int size) {
            return paging.limit(size);
        }

        @Override
        public FindPaging offset(final int page) {
            return paging.offset(page);
        }

        @Override
        public FindSortPaging sortBy(final String field) {
            requestSorts.add(field);
            return this;
        }

        @Override
        public Statement build() {
            return buildStatement();
        }
    };

    FindSelectWhere selectWhere = new FindSelectWhere() {
        @Override
        public FindPaging limit(final int size) {
            return paging.limit(size);
        }

        @Override
        public FindPaging offset(final int page) {
            return paging.offset(page);
        }

        @Override
        public FindSelectWhere select(final String... field) {
            requestFields.addAll(Arrays.asList(field));
            return this;
        }

        @Override
        public FindSortPaging sortBy(final String field) {
            return sortPaging.sortBy(field);
        }

        @Override
        public FindWhereSort where(final String field, final String operator, final String value) {
            return whereSort.where(field, operator, value);
        }

        @Override
        public Statement build() {
            return buildStatement();
        }
    };

    FindWhereSort whereSort = new FindWhereSort() {
        @Override
        public FindPaging limit(final int size) {
            return paging.limit(size);
        }

        @Override
        public FindPaging offset(final int page) {
            return paging.offset(page);
        }

        @Override
        public FindSortPaging sortBy(final String field) {
            return sortPaging.sortBy(field);
        }

        @Override
        public FindWhereSort where(final String field, final String operator, final String value) {
            requestConditions.add(new Condition(field, operator, value));
            return this;
        }

        @Override
        public Statement build() {
            return buildStatement();
        }
    };

    @Override
    public FindConstraints from(final String entity) {

        statement = new FindStatement(entity);
        requestFields = new ArrayList<String>();
        requestConditions = new ArrayList<Condition>();
        requestSorts = new ArrayList<String>();
        requestOffset = 1;
        requestLimit = 10;

        return new FindConstraints() {
            @Override
            public FindSelectWhere select(final String... fields) {
                return selectWhere.select(fields);
            }

            @Override
            public FindWhereSort where(final String field, final String operator, final String value) {
                return whereSort.where(field, operator, value);
            }

            @Override
            public FindSortPaging sortBy(final String field) {
                return sortPaging.sortBy(field);
            }

            @Override
            public FindPaging limit(final int size) {
                return paging.limit(size);
            }

            @Override
            public FindPaging offset(final int page) {
                return paging.offset(page);
            }

            @Override
            public Statement build() {
                return buildStatement();
            }
        };
    }
}
