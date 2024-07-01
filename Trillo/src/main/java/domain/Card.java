package main.java.domain;

public class Card {

	private String id;
	private String name;
	private String desc;
	private String assignedUser;
	public Card(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getAssignedUser() {
		return assignedUser;
	}
	public void setAssignedUser(String assignedUser) {
		this.assignedUser = assignedUser;
	}
	
	@Override
	public String toString() {
		return "Card [id=" + id + ", name=" + name + ", desc=" + desc + ", assignedUser=" + assignedUser + "]";
	}
	
}
