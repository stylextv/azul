package net.azul.command;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

public class ConsoleReader {
	
	private BufferedReader reader;
	
	public String readLine() throws IOException {
		return reader.readLine();
	}
	
	public void open() {
		Reader inputReader = new InputStreamReader(System.in);
		
		reader = new BufferedReader(inputReader);
	}
	
	public void close() throws IOException {
		reader.close();
	}
	
}
