package net.azul.command.commands;

import net.azul.Azul;
import net.azul.command.Command;
import net.azul.command.argument.CommandArgumentList;
import net.azul.util.LogUtil;

public class SetupCommand extends Command {
	
	public SetupCommand() {
		super("setup");
	}
	
	@Override
	public void execute(CommandArgumentList arguments) {
		String board = arguments.getFirstArgument();
		
		Azul azul = Azul.getAzul();
		azul.setupBoard(board);
		
		LogUtil.log("Position set-up.");
	}
	
}
