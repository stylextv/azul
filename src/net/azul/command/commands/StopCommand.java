package net.azul.command.commands;

import net.azul.Azul;
import net.azul.command.Command;
import net.azul.command.argument.CommandArgumentList;

public class StopCommand extends Command {
	
	public StopCommand() {
		super("stop");
	}
	
	@Override
	public void execute(CommandArgumentList arguments) {
		Azul azul = Azul.getAzul();
		azul.stop();
	}
	
}
