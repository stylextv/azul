package net.azul.board;

public class BoardDirection {
	
	public static final BoardDirection SOUTH_EAST = new BoardDirection("SOUTH_EAST", 1, 1);
	public static final BoardDirection SOUTH_WEST = new BoardDirection("SOUTH_WEST", -1, 1);
	public static final BoardDirection NORTH_EAST = new BoardDirection("NORTH_EAST", 1, -1);
	public static final BoardDirection NORTH_WEST = new BoardDirection("NORTH_WEST", -1, -1);
	
	public static final BoardDirection EAST = new BoardDirection("EAST", 1, 0);
	public static final BoardDirection WEST = new BoardDirection("WEST", -1, 0);
	public static final BoardDirection SOUTH = new BoardDirection("SOUTH", 0, 1);
	public static final BoardDirection NORTH = new BoardDirection("NORTH", 0, -1);
	
	private static final BoardDirection[] DIRECTIONS = new BoardDirection[] {
			NORTH, SOUTH, WEST, EAST,
			NORTH_WEST, NORTH_EAST, SOUTH_WEST, SOUTH_EAST
	};
	
	private String name;
	
	private int positionOffsetX;
	private int positionOffsetY;
	
	public BoardDirection(String name, int positionOffsetX, int positionOffsetY) {
		this.name = name;
		this.positionOffsetX = positionOffsetX;
		this.positionOffsetY = positionOffsetY;
	}
	
	@Override
	public String toString() {
		return name;
	}
	
	public String getName() {
		return name;
	}
	
	public int getPositionOffsetX() {
		return positionOffsetX;
	}
	
	public int getPositionOffsetY() {
		return positionOffsetY;
	}
	
	public static BoardDirection[] getDirections() {
		return DIRECTIONS;
	}
	
}
