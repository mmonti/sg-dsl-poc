/**
 * 
 */
package com.dreamworks.dsl;

/**
 * @author mmonti
 *
 */
public interface UpdateMode extends Buildable {
	
	UpdateMode set(String entity);
	
	UpdateMode add(String entity);
	
	UpdateMode remove(String entity);

}
