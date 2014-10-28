package com.dreamworks.api;

import com.dreamworks.dsl.Entry;
import com.dreamworks.dsl.Statement;

import static com.dreamworks.dsl.Requests.delete;
import static com.dreamworks.dsl.Requests.from;
import static com.dreamworks.dsl.Requests.revive;
import static com.dreamworks.dsl.Requests.in;

import static com.dreamworks.dsl.Entries.name;

/**
 * @author mmonti
 */
public class Main {
    public static void main(String[] args) {
        Statement delete = delete("entity").withId(1).build();
        Statement revive = revive("entity").withId(1).build();
        Statement find = from("entity").select("field1", "field2").where("field1", "is", "operator").sortBy("field1").sortBy("field2").limit(12).offset(2).build();
        Statement create = in("entity").insert("name", "value").select("id").select("a").build();

        Statement create2 = in("entity").insert(
            name("name").value(
                name("name1").value("value1"),
                name("name11").value("value11")
            )
        ).select("id", "code").build();

        Statement update = in("entity").withId(1).update("", "").build();
        
        System.out.println(find);
    }
}
