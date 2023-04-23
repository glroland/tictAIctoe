package com.glroland.tictAIctoe.svc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;

import java.io.Reader;
import org.jline.terminal.TerminalBuilder;
import org.jline.terminal.Terminal;

@SpringBootApplication
public class TicTacToeAIServiceApplication implements CommandLineRunner 
{

	public static void main(String[] args) 
	{
		SpringApplication.run(TicTacToeAIServiceApplication.class, args);
	}

	@Override
    public void run(String... args) 
	{
		try 
		{	
			Terminal terminal = TerminalBuilder.builder()
				.jna(true)
				.system(true)
				.build();

			// raw mode means we get keypresses rather than line buffered input
			terminal.enterRawMode();
			Reader reader = terminal.reader();

			int read = 0;
			while (read != 'q')
			{
				read = reader.read();

				System.out.println("Character: " + read);
			}

			reader.close();
			terminal.close();
		} 
		catch (Exception e) 
		{
			System.out.println("Caught exception: " + e.toString());
		}
	}
}
