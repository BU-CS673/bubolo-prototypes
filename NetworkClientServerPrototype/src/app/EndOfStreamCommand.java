package app;

import app.net.Client;

public class EndOfStreamCommand extends Command
{
	public EndOfStreamCommand()
	{
		super("End of stream received");
	}

	@Override
	public void execute()
	{
		super.execute();
		Client.getInstance().setAcceptData(false);
	}
}
