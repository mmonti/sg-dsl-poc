package com.dreamworks.dsl;

/**
 * @author mmonti
 */
public interface CreateSelect extends Buildable {

    CreateSelect select(final String ... field);

}
