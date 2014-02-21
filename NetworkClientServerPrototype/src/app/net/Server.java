package app.net;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import app.Command;
import app.EndOfStreamCommand;

/**
 * Sources:
 * http://docs.oracle.com/javase/tutorial/displayCode.html?code=http://docs.oracle.com/javase/tutorial/networking/sockets/examples/KKMultiServerThread.java
 * http://docs.oracle.com/javase/tutorial/networking/sockets/readingWriting.html
 * http://docs.oracle.com/javase/tutorial/networking/sockets/clientServer.html
 * 
 * Note: use an ObjectOutputStream.
 * @author BU CS673 - Clone Productions
 */
public class Server implements Runnable
{
	public static final int port = 19014;
	
	private ServerSocket socket = null;

	public Server() throws IOException
	{
		this.socket = new ServerSocket(port);
		System.out.println("Server created.");
	}

	@Override
	public void run()
	{
		try (Socket client = socket.accept())
		{
			ObjectOutputStream outputStream = new ObjectOutputStream(client.getOutputStream());
			outputStream.writeObject(new Command("Test message"));
			outputStream.writeObject(new Command("This is a longer test message."));
			outputStream.writeObject(new Command("This is a much, much, much looooooooooonnnnnnnnngggggggggggeeeeeeeeeerrrrrrrrr message."));
			outputStream.writeObject(new EndOfStreamCommand());
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}
