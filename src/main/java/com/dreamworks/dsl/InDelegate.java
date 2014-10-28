/**
 * 
 */
package com.dreamworks.dsl;

/**
 * @author mmonti
 *
 */
public class InDelegate implements In {
	
	private CreateInsert createInsert;
	private UpdateIdentifiable updateIdentifiable;
	
	public InDelegate(final String entity) {
		createInsert = new CreateRequest().in(entity);
		updateIdentifiable = new UpdateRequest().in(entity);
	}

	@Override
	public CreateInsertSelect insert(Entry... entries) {
		return createInsert.insert(entries);
	}

	@Override
	public CreateInsertSelect insert(String name, Object value) {
		return createInsert.insert(name, value);
	}

	@Override
	public CreateInsertSelect insert(String name, Entry value) {
		return createInsert.insert(name, value);
	}

	@Override
	public UpdateUpdate withId(final Integer id) {
		return updateIdentifiable.withId(id);
	}

}
