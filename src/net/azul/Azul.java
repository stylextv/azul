package net.azul;

import net.azul.board.Board;
import net.azul.command.CommandParser;
import net.azul.command.ConsoleReader;
import net.azul.util.LogUtil;

public class Azul {
	
	private static final String DEFAULT_NAME = "Azul";
	private static final String DEFAULT_VERSION = "1.0.0";
	private static final String DEFAULT_AUTHOR = "StylexTV";
	private static final String DEFAULT_BOARD = "...../.OOO./.OKO./.OOO./.....";
	
	private static Azul instance;
	
	private String name;
	private String version;
	private String author;
	
	private Board board = Board.ofString(DEFAULT_BOARD);
	
	private CommandParser commandParser = new CommandParser();
	private ConsoleReader consoleReader = new ConsoleReader();
	
	private boolean stopped;
	
	public Azul() {
		this(DEFAULT_NAME, DEFAULT_VERSION, DEFAULT_AUTHOR, DEFAULT_BOARD);
	}
	
	public Azul(String name, String version, String author, String board) {
		this.name = name;
		this.version = version;
		this.author = author;
		
		setupBoard(board);
		instance = this;
	}
	
	public void onStart() {
		try {
			
			String s = String.format("%s v%s by %s", name, version, author);
			LogUtil.log(s);
			
			consoleReader.open();
			
			while(!stopped) {
				
				String line = consoleReader.readLine();
				if(line == null) break;
				
				commandParser.parseCommand(line);
			}
			
			consoleReader.close();
			
		} catch(Exception exception) {
			exception.printStackTrace();
		}
	}
	
	public void stop() {
		stopped = true;
	}
	
	public void setupBoard(String board) {
		this.board = Board.ofString(board);
	}
	
	public static String getName() {
		return instance.name;
	}
	
	public static String getVersion() {
		return instance.version;
	}
	
	public static String getAuthor() {
		return instance.author;
	}
	
	public static Board getBoard() {
		return instance.board;
	}
	
	public static CommandParser getCommandParser() {
		return instance.commandParser;
	}
	
	public static ConsoleReader getConsoleReader() {
		return instance.consoleReader;
	}
	
	public static Azul getAzul() {
		return instance;
	}
	
}
