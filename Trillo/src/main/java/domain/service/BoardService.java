package main.java.domain.service;

import java.util.HashMap;
import java.util.Map;

import main.java.domain.Board;

public class BoardService {

	private Map<String, Board> boards;

	public BoardService() {
		super();
		boards=new HashMap();
	}

	public Map<String, Board> getBoards() {
		return boards;
	}

	public void setBoards(Map<String, Board> boards) {
		this.boards = boards;
	}
	
}
