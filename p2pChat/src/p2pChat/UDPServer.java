package p2pChat;
import java.io.*;
import java.net.*;

public class UDPServer implements Runnable
{
	private DatagramSocket _serverSocket;
	private byte[] _receiveData;
	private byte[] _sendData;
    
	public UDPServer()
	{
		
		try {
			_serverSocket = new DatagramSocket(4005);
		} catch (SocketException e) {
			System.out.println("Failed to create Datagram Socket.");
		}
		_receiveData = new byte[1024];
		_sendData = new byte[1024];
	}
	
	public void run()
	{
		while(true)
		{
			
			DatagramPacket receivePacket = new DatagramPacket(_receiveData, _receiveData.length);
	        try {
				_serverSocket.receive(receivePacket);
				
			} catch (IOException e) {
				e.printStackTrace();
			}
	        InetAddress IPAddress = receivePacket.getAddress();
	        String sentence = new String( receivePacket.getData()).trim();
	        System.out.println(IPAddress.getHostAddress() + ": " + sentence);
	        _receiveData = new byte[1024];
	        int port = receivePacket.getPort();
	        String confirm = "delivered..";
	        _sendData = confirm.getBytes();
	        DatagramPacket sendPacket =
	        new DatagramPacket(_sendData, _sendData.length, IPAddress, port);
	        try {
				_serverSocket.send(sendPacket);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void close()
	{
		_serverSocket.close();
	}
	
}
