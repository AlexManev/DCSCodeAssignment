package p2pChat;

import java.io.IOException;
import java.net.Socket;

public class NetScan implements Runnable
{
	private String _host;
	private int _port;
	
	public NetScan(int port)
	{

		_port = port;
	}
	
	public boolean hostAvailabilityCheck() 
	{ 
		
	   try (Socket s = new Socket(_host, _port)) {
		   s.isConnected();
		   System.out.println(s.isConnected());
		   return true;
	   } catch (IOException ex) {
	       /* ignore */
		   
	   }
	   return false;
	}

	@Override
	public void run() 
	{
		while(true)
		{
			for(int i=0;i<255; i++)
			{
				
				_host = "192.168.1."+i;
				if(hostAvailabilityCheck())
				{
					System.out.println(_host);
				}
				
			}
		}
	}
	
}
