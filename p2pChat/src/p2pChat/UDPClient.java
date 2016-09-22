package p2pChat;
import java.io.*;
import java.net.*;

public class UDPClient {
	private byte[] _sendData;
	private byte[] _receiveData;
	private DatagramSocket _clientSocket;
	private InetAddress _destIP;
	private int _port;
	
	public UDPClient(String destIP, int port, String message) throws IOException
	{
		_sendData = new byte[1024];
		_receiveData = new byte[1024];
		_clientSocket = new DatagramSocket();
		_destIP = InetAddress.getByName(destIP);
		_port = port;
		_sendData = message.getBytes();
	}
	

	public void run()
	{
		DatagramPacket sendPacket = new DatagramPacket(_sendData, _sendData.length, _destIP, _port);
		try {
			_clientSocket.send(sendPacket);
		} catch (IOException e) {
			System.out.println("Failed sending data.");
		}
		DatagramPacket receivePacket = new DatagramPacket(_receiveData, _receiveData.length);
		try {
			_clientSocket.receive(receivePacket);
		} catch (IOException e) {
			System.out.println("Failed receaving data.");
		}
		String status = new String(receivePacket.getData()).trim();
		System.out.println(".." + status);
		_sendData = null;
		_clientSocket.close();
	}
}
