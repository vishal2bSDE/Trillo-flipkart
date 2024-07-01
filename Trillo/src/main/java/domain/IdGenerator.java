package main.java.domain;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class IdGenerator {

	private static Set<String> randomsUsed=new HashSet();
	
	private IdGenerator() {}
	
	public static String generateId() {
		String id=UUID.randomUUID().toString();
		while(randomsUsed.contains(id)) {
			id=UUID.randomUUID().toString();
		}
		randomsUsed.add(id);
		
		return id;
	}
}
