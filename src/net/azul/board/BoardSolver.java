package net.azul.board;

import net.azul.util.LogUtil;

public class BoardSolver {
	
	public boolean solve(Board board) {
		if(board.isSolved()) return true;
		
		int[] occupiedPositions = board.getOccupiedPositions();
		int occupiedPositionAmount = board.getOccupiedPositionAmount();
		int[] positions = new int[occupiedPositionAmount];
		
		for(int index = 0; index < occupiedPositionAmount; index++) {
			
			positions[index] = occupiedPositions[index];
		}
		
		for(int position : positions) {
			for(BoardDirection direction : BoardDirection.getDirections()) {
				
				if(board.isIllegalMove(position, direction)) continue;
				
				board.playMove(position, direction);
				
				boolean solved = solve(board);
				if(solved) {
					
					String s = board.toString();
					LogUtil.log(s);
					
					s = String.format("%s, %s", position, direction);
					LogUtil.log(s);
				}
				
				board.undoMove(position, direction);
				
				if(solved) return true;
			}
		}
		
		return false;
	}
	
}
