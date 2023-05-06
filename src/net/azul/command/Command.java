package net.azul.command;

import java.util.HashMap;
import java.util.Map;

import net.azul.command.argument.CommandArgumentList;
import net.azul.command.commands.PrintCommand;
import net.azul.command.commands.SetupCommand;
import net.azul.command.commands.SolveCommand;
import net.azul.command.commands.StopCommand;

public abstract class Command {
	
	private static final Map<String, Command> COMMANDS = new HashMap<>();
	
	public static final Command PRINT = new PrintCommand();
	public static final Command SOLVE = new SolveCommand();
	public static final Command SETUP = new SetupCommand();
	public static final Command STOP = new StopCommand();
	
	private String name;
	
	public Command(String name) {
		this.name = name;
		
		registerCommand(this);
	}
	
	public abstract void execute(CommandArgumentList arguments);
	
	public String getName() {
		return name;
	}
	
	private static void registerCommand(Command command) {
		String name = command.getName();
		
		COMMANDS.put(name, command);
	}
	
	public static Command getCommand(String name) {
		name = name.toLowerCase();
		
		return COMMANDS.get(name);
	}
	
	public static Map<String, Command> getCommands() {
		return COMMANDS;
	}
	
}
