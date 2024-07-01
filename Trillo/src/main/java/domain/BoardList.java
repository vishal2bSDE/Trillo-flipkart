package main.java.domain;

import java.util.HashMap;
import java.util.Map;

public class BoardList {

	private String id;
	private String name;
	private Map<String, Card> cards;
	public BoardList(String id, String name) {
		super();
		this.id = id;
		this.name = name;
		cards=new HashMap();
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
	public Map<String, Card> getCards() {
		return cards;
	}
	public void setCards(Map<String, Card> cards) {
		this.cards = cards;
	}
	@Override
	public String toString() {
		return "BoardList [id=" + id + ", name=" + name + ", cards=" + cards.toString() + "]";
	}
	
	
}
