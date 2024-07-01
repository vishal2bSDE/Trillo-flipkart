package main.java.domain;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Board {

	private String id;
	private String name;
	private Privacy privacy;
	private String url;
	private Set<String> members;
	private Map<String, BoardList> boardLists;
	public Board(String id, String name, Privacy privacy) {
		super();
		this.id = id;
		this.name = name;
		this.privacy = privacy;
		url="trillo.com/board/"+id;
		members=new HashSet();
		boardLists=new HashMap();
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
	public Privacy getPrivacy() {
		return privacy;
	}
	public void setPrivacy(Privacy privacy) {
		this.privacy = privacy;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Set<String> getMembers() {
		return members;
	}
	public void setMembers(Set<String> members) {
		this.members = members;
	}
	public Map<String, BoardList> getBoardLists() {
		return boardLists;
	}
	public void setBoardLists(Map<String, BoardList> boardLists) {
		this.boardLists = boardLists;
	}
	@Override
	public String toString() {
		return "Board [id=" + id + ", name=" + name + ", privacy=" + privacy + ", url=" + url + ", members=" + members
				+ ", boardLists=" + boardLists + "]";
	}
	
	
}
