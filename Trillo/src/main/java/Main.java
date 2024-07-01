package main.java;

import java.util.Map;
import java.util.Optional;

import main.java.domain.Board;
import main.java.domain.BoardList;
import main.java.domain.Card;
import main.java.domain.IdGenerator;
import main.java.domain.Privacy;
import main.java.domain.User;
import main.java.domain.service.BoardService;
import main.java.domain.service.UserService;

public class Main {

	private static UserService userService;
	private static BoardService boardService;
	public static void main(String[] args) {
		System.out.println("Trillo app started");
		
		userService=new UserService();
		boardService=new BoardService();
		registerUser("user1", "user1", "user1@gmail");
		registerUser("user2", "user2", "user2@gmail");
		registerUser("user2", "user3", "user3@gmail");
		
		createBoard("board1", Privacy.PUBLIC);
		showBoards();
		createBoard("board2", Privacy.PRIVATE);
		showBoards();
		
		createListForBoard("board1", "list1");
		createListForBoard("board1", "list2");
		createListForBoard("board2", "list1");
		createListForBoard("board2", "list2");
		
		addMemberToBoard("board1", "user1");
		addMemberToBoard("board1", "user2");
		addMemberToBoard("board1", "user4");
		
		addCard("board1", "list1", "card1", "desc1");
		addCard("board1", "list1", "card2", "desc2");
		addCard("board1", "list2", "card1", "desc1");
		addCard("board1", "list2", "card2", "desc2");
		
		showBoards();
		
		assignMemberToCard("board1", "list1", "card1", "user1");
		assignMemberToCard("board1", "list1", "card3", "user1");
		
		deleteCard("board1", "list1", "card3");
		showBoards();
		deleteList("board1", "list1");
		showBoards();
		deleteBoard("board1");
		showBoards();
		deleteBoard("board2");
		showBoards();
		System.out.println("Trillo app stopped");
	}

	private static void deleteBoard(String boardName) {
		if(boardService.getBoards().containsKey(boardName)) {
			boardService.getBoards().remove(boardName);
		} else {
			System.out.println("Board Deleted, "+boardName);
		}
	}

	private static void deleteList(String boardName, String boardListName) {
		if(boardService.getBoards().get(boardName).getBoardLists().containsKey(boardListName)) {
			boardService.getBoards().get(boardName).getBoardLists().remove(boardListName);
		} else {
			System.out.println("BoardList Deleted, "+boardListName);
		}
	}
	

	private static void deleteCard(String boardName, String boardListName, String cardName) {
		if(boardService.getBoards().get(boardName).getBoardLists().get(boardListName).getCards().containsKey(cardName)) {
			boardService.getBoards().get(boardName).getBoardLists().get(boardListName).getCards().remove(cardName);
		} else {
			System.out.println("Card Deleted, "+cardName);
		}
	}
	

	private static void assignMemberToCard(String boardName, String boardListName, String cardName, String userId) {
		System.out.println("Assigning member to card, "+userId);
		Optional<Card> cardOptional = Optional.ofNullable(boardService.getBoards().get(boardName).getBoardLists().get(boardListName).getCards().get(cardName));
		cardOptional.ifPresent(card -> card.setAssignedUser(userId));
		if(cardOptional.isEmpty()) {
			System.out.println("Card is not present");
			return;
		}
		System.out.println("Assigned card, "+userId);
	}

	private static void addCard(String boardName, String boardListName, String cardName, String desc) {
		System.out.println("Started creating card, "+cardName);
		BoardList boardList = boardService.getBoards().get(boardName).getBoardLists().get(boardListName);
		Card card = new Card(IdGenerator.generateId(), cardName);
		boardList.getCards().put(cardName, card);
		card.setDesc(desc);
		System.out.println("Successfully created card, "+cardName);
	}

	private static void addMemberToBoard(String boardName, String userId) {
		System.out.println("Adding user, "+userId+" to board, "+boardName);
		if(userService.getUsers().containsKey(userId)) {
			boardService.getBoards().get(boardName).getMembers().add(userId);
		} else {
			System.out.println("User not present");
		}
	}

	private static void createListForBoard(String boardName, String boardListName) {
		System.out.println("Started creating a list, "+ boardListName+"for board, "+boardName);
		Map<String, BoardList> boardLists=boardService.getBoards().get(boardName).getBoardLists();
		boardLists.put(boardListName, new BoardList(IdGenerator.generateId(), boardListName));
		System.out.println("Successfully created a list, "+ boardListName+"for board, "+boardName);
	}

	private static void showBoards() {
		System.out.println("Showing boards");
		boardService.getBoards().values().stream().forEach(System.out::println);
	}

	private static void createBoard(String boardName, Privacy privacy) {
		System.out.println("Started creating a board, "+boardName);
		Board board=new Board(IdGenerator.generateId(), boardName, privacy);
		boardService.getBoards().put(boardName, board);
		System.out.println("Successfully created a board, "+boardName);
	}

	private static void registerUser(String userId, String user, String email) {
		System.out.println("Started registering user, "+user);
		userService.getUsers().put(userId, new User(userId, user, email));
		System.out.println("Successfully registerd user, "+user);
	}

}
