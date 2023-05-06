package net.azul.command.argument;

public class CommandArgumentList {
	
	private static final int FIRST_ARGUMENT_INDEX = 0;
	
	private String[] arguments;
	private int size;
	
	public CommandArgumentList(int capacity) {
		this.arguments = new String[capacity];
	}
	
	public void addArgument(String argument) {
		arguments[size] = argument;
		size++;
	}
	
	public String getFirstArgument() {
		return getArgument(FIRST_ARGUMENT_INDEX);
	}
	
	public String getArgument(int index) {
		return arguments[index];
	}
	
	public String[] getArguments() {
		return arguments;
	}
	
	public int getSize() {
		return size;
	}
	
}
