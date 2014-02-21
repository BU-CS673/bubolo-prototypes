package app;

import java.io.IOException;

import app.net.Client;
import app.net.Server;

public class Main 
{
	public static void main(String[] args) throws IOException, InterruptedException
	{
		Thread serverThread = new Thread(new Server());
		serverThread.start();
		
		Thread clientThread = new Thread(Client.getInstance());
		clientThread.start();
		
		serverThread.join();
		
		System.out.println("Exiting.");
	}
}
