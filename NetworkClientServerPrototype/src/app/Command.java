package app;

import java.io.Serializable;

public class Command implements Serializable
{
	private final String message;
	
	public Command(String message)
	{
		this.message = message;
	}
	
	public void execute()
	{
		System.out.println(message);
	}
}
