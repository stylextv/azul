package net.azul.board;

import java.util.HashMap;
import java.util.Map;

public class BoardTile {
	
	// TODO KING_OCCUPIED and BLOCKED
	
	private static final Map<String, BoardTile> TILES = new HashMap<>();
	
	public static final BoardTile EMPTY = new BoardTile(".", false);
	public static final BoardTile BLOCKED = new BoardTile("B", false);
	public static final BoardTile OCCUPIED = new BoardTile("O", true);
	public static final BoardTile KING_OCCUPIED = new BoardTile("K", true);
	
	private String displayName;
	private boolean occupied;
	
	public BoardTile(String displayName, boolean occupied) {
		this.displayName = displayName;
		this.occupied = occupied;
		
		registerTile(this);
	}
	
	@Override
	public String toString() {
		return displayName;
	}
	
	public String getDisplayName() {
		return displayName;
	}
	
	public boolean isOccupied() {
		return occupied;
	}
	
	private static void registerTile(BoardTile tile) {
		String displayName = tile.getDisplayName();
		
		TILES.put(displayName, tile);
	}
	
	public static BoardTile getTile(String displayName) {
		return TILES.get(displayName);
	}
	
}
