package com.dreamworks.dsl;

/**
 * @author mmonti
 */
public interface FindPaging extends Buildable {

    FindPaging limit(int size);

    FindPaging offset(int page);

}
