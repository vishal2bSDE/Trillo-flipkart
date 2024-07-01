package main.java.domain.service;

import java.util.HashMap;
import java.util.Map;

import main.java.domain.User;

public class UserService {

	private Map<String, User> users;

	public UserService() {
		super();
		users=new HashMap();
	}
	public Map<String, User> getUsers() {
		return users;
	}

	public void setUsers(Map<String, User> users) {
		this.users = users;
	}

	
	
	
}
