package com.dreamworks.dsl;

/**
 * @author mmonti
 */
public interface FindWhere extends Buildable {

    FindWhereSort where(String field, String operator, String value);

}
