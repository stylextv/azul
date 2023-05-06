package net.azul.command.commands;

import net.azul.Azul;
import net.azul.board.Board;
import net.azul.command.Command;
import net.azul.command.argument.CommandArgumentList;
import net.azul.util.LogUtil;

public class PrintCommand extends Command {
	
	public PrintCommand() {
		super("print");
	}
	
	@Override
	public void execute(CommandArgumentList arguments) {
		Board board = Azul.getBoard();
		
		String s = board.toString();
		LogUtil.log(s);
	}
	
}
