package com.dreamworks.dsl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author mmonti
 */
public class UpdateRequest implements Update {

    private UpdateStatement statement;
    
    private Integer requestId;
    private Map<String, String> requestModes;
    private List<Entry> requestEntries;
    
	@Override
	public UpdateIdentifiable in(String entity) {
		
		statement = new UpdateStatement(entity);
		
		return new UpdateIdentifiable() {
			
			@Override
			public UpdateUpdate withId(Integer id) {
				
				requestId = id;
				requestEntries = new ArrayList<Entry>();
				requestModes = new HashMap<String, String>();
				
				return new UpdateUpdate() {
					
					@Override
					public UpdateMode update(String name, Object value) {
						
						requestEntries.add(new Entry(name, value));
						
						return new UpdateMode() {
							
							@Override
							public Statement build() {
								statement.id = requestId;
								statement.entries = requestEntries;
								statement.fields = null;
								statement.modes = requestModes;
								
								return statement;
							}
							
							@Override
							public UpdateMode set(String entity) {
								requestModes.put("set", entity);
								return this;
							}
							
							@Override
							public UpdateMode remove(String entity) {
								requestModes.put("remove", entity);
								return this;
							}
							
							@Override
							public UpdateMode add(String entity) {
								requestModes.put("add", entity);
								return this;
							}
						};
					}
				};
			}
		};
	}
       
}
