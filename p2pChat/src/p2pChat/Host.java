package p2pChat;

public class Host {
	
	private String _IPAddress;
	private int _port;

	public Host(String ip, int port){
		_IPAddress = ip;
		_port = port;
	}
	
	public String getIPAddress()
	{
		return _IPAddress;
	}
	
	public int getPort()
	{
		return _port;
	}
	
}
