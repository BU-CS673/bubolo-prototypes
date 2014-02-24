package app.net;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.concurrent.atomic.AtomicBoolean;

import app.Command;

/**
 * Adapted from http://docs.oracle.com/javase/tutorial/displayCode.html?code=http://docs.oracle.com/javase/tutorial/networking/sockets/examples/EchoClient.java
 * @author BU CS673 - Clone Productions
 */
public class Client implements Runnable 
{
	private InetAddress address;
	
	private AtomicBoolean acceptData = new AtomicBoolean(true);
	
	private static Client instance;
	
	public static Client getInstance()
	{
		if (instance == null)
		{
			instance = new Client();
		}
		return instance;
	}
	
	private Client()
	{
		// The ip address to connect to.
		try
		{
			address = Inet4Address.getByName("192.168.1.142");
			System.out.println("Client created.");
		}
		catch (Exception e)
		{
			throw new RuntimeException(e);
		}
	}
	
	public void setAcceptData(boolean acceptData)
	{
		this.acceptData.set(acceptData);
	}
	
	@Override
	public void run()
	{
		try (
	            Socket socket = new Socket(address, Server.port);
				ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream()); 
	        ) 
	    {
			while (acceptData.get())
			{
				Command data = (Command)inputStream.readObject();
				data.execute();
			}
	    } 
		catch (IOException | ClassNotFoundException e) 
		{
	            System.err.println("Network error " + address.getHostAddress());
	            e.printStackTrace();
	            System.exit(1);
	    }
	}
}