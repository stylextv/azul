package net.azul.command;

import net.azul.command.argument.CommandArgumentList;
import net.azul.util.LogUtil;

public class CommandParser {
	
	private static final String PARAMETER_SEPERATOR = " ";
	
	public void parseCommand(String command) {
		String[] parameters = command.split(PARAMETER_SEPERATOR);
		
		String name = parameters[0];
		Command c = Command.getCommand(name);
		
		if(c == null) {
			
			String s = String.format("Cannot find command with name \"%s\"!", name);
			LogUtil.log(s);
			
			return;
		}
		
		int length = parameters.length;
		
		CommandArgumentList arguments = new CommandArgumentList(length - 1);
		
		for(int i = 1; i < length; i++) {
			
			String argument = parameters[i];
			arguments.addArgument(argument);
		}
		
		c.execute(arguments);
	}
	
}
