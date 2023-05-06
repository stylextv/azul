package net.azul.board;

public class Board {
	
	private static final String BOARD_PART_SEPERATOR = "/";
	private static final int FIRST_BOARD_PART_INDEX = 0;
	
	private static final int SOLVED_OCCUPIED_POSITION_AMOUNT = 1;
	private static final int INVALID_POSITION = -1;
	private static final int FIRST_TILE_POSITION = 0;
	
	private int width;
	private int height;
	private int size;
	
	private BoardTile[] tiles;
	
	private int[] occupiedPositions;
	private int[] occupiedPositionIndex;
	private int occupiedPositionAmount;
	
	public Board(int width, int height) {
		resize(width, height);
	}
	
	public boolean isIllegalMove(int position, BoardDirection direction) {
		if(!isTileOccupied(position)) return true;
		
		position = neighbourPosition(position, direction);
		if(position == INVALID_POSITION) return true;
		
		BoardTile tile = getTile(position);
		if(tile != BoardTile.OCCUPIED) return true;
		
		position = neighbourPosition(position, direction);
		if(position == INVALID_POSITION || !isTileEmpty(position)) return true;
		
		return false;
	}
	
	public void playMove(int position, BoardDirection direction) {
		BoardTile tile = getTile(position);
		
		setTile(position, BoardTile.EMPTY);
		
		position = neighbourPosition(position, direction);
		setTile(position, BoardTile.EMPTY);
		
		position = neighbourPosition(position, direction);
		setTile(position, tile);
	}
	
	public void undoMove(int position, BoardDirection direction) {
		int fromPosition = position;
		
		position = neighbourPosition(position, direction);
		setTile(position, BoardTile.OCCUPIED);
		
		position = neighbourPosition(position, direction);
		BoardTile tile = getTile(position);
		
		setTile(position, BoardTile.EMPTY);
		setTile(fromPosition, tile);
	}
	
	public void resize(int width, int height) {
		this.width = width;
		this.height = height;
		this.size = width * height;
		this.tiles = new BoardTile[size];
		this.occupiedPositions = new int[size];
		this.occupiedPositionIndex = new int[size];
		this.occupiedPositionAmount = 0;
		
		for(int position = FIRST_TILE_POSITION; position < size; position++) {
			
			tiles[position] = BoardTile.EMPTY;
		}
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		
		for(int position = FIRST_TILE_POSITION; position < size; position++) {
			
			BoardTile tile = getTile(position);
			
			String s = tile + " ";
			builder.append(s);
			
			int x = positionX(position);
			int lastRowX = width - 1;
			
			if(x == lastRowX) {
				
				s = System.lineSeparator();
				builder.append(s);
			}
		}
		
		return builder.toString();
	}
	
	private int neighbourPosition(int position, BoardDirection direction) {
		int x = positionX(position);
		int y = positionY(position);
		
		x += direction.getPositionOffsetX();
		y += direction.getPositionOffsetY();
		
		if(x < 0 || y < 0 || x >= width || y >= height) return INVALID_POSITION;
		
		return position(x, y);
	}
	
	private int positionY(int position) {
		return position / width;
	}
	
	private int positionX(int position) {
		return position % width;
	}
	
	private int position(int x, int y) {
		return width * y + x;
	}
	
	public boolean isTileOccupied(int position) {
		BoardTile tile = getTile(position);
		
		return tile.isOccupied();
	}
	
	public boolean isTileEmpty(int position) {
		BoardTile tile = getTile(position);
		
		return tile == BoardTile.EMPTY;
	}
	
	public BoardTile getTile(int position) {
		return tiles[position];
	}
	
	public void setTile(int position, BoardTile tile) {
		BoardTile t = getTile(position);
		
		tiles[position] = tile;
		
		if(tile.isOccupied() && !t.isOccupied()) {
			
			occupiedPositions[occupiedPositionAmount] = position;
			occupiedPositionIndex[position] = occupiedPositionAmount;
			occupiedPositionAmount++;
			
		} else if(!tile.isOccupied() && t.isOccupied()) {
			
			occupiedPositionAmount--;
			int index = occupiedPositionIndex[position];
			
			for(int i = index; i < occupiedPositionAmount; i++) {
				
				position = occupiedPositions[i + 1];
				
				occupiedPositions[i] = position;
				occupiedPositionIndex[position]--;
			}
		}
	}
	
	public boolean isSolved() {
		return occupiedPositionAmount == SOLVED_OCCUPIED_POSITION_AMOUNT;
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public int getSize() {
		return size;
	}
	
	public BoardTile[] getTiles() {
		return tiles;
	}
	
	public int[] getOccupiedPositions() {
		return occupiedPositions;
	}
	
	public int getOccupiedPositionAmount() {
		return occupiedPositionAmount;
	}
	
	public static Board ofString(String s) {
		String[] parts = s.split(BOARD_PART_SEPERATOR);
		String firstPart = parts[FIRST_BOARD_PART_INDEX];
		
		int width = firstPart.length();
		int height = parts.length;
		
		Board board = new Board(width, height);
		
		int position = FIRST_TILE_POSITION;
		
		for(String part : parts) {
			for(char c : part.toCharArray()) {
				
				s = String.valueOf(c);
				BoardTile tile = BoardTile.getTile(s);
				
				board.setTile(position, tile);
				position++;
			}
		}
		
		return board;
	}
	
}
