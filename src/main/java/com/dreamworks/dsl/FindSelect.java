package com.dreamworks.dsl;

/**
 * @author mmonti
 */
public interface FindSelect extends Buildable {

    FindSelectWhere select(final String ... field);

}
