package net.azul.command.commands;

import net.azul.Azul;
import net.azul.board.Board;
import net.azul.board.BoardSolver;
import net.azul.command.Command;
import net.azul.command.argument.CommandArgumentList;
import net.azul.util.LogUtil;

public class SolveCommand extends Command {
	
	private BoardSolver solver = new BoardSolver();
	
	public SolveCommand() {
		super("solve");
	}
	
	@Override
	public void execute(CommandArgumentList arguments) {
		Board board = Azul.getBoard();
		
		boolean solved = solver.solve(board);
		
		String s = solved ? "Position solved." : "Position unsolvable!";
		LogUtil.log(s);
	}
	
	public BoardSolver getSolver() {
		return solver;
	}
	
}
