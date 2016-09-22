package p2pChat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class Main {

	public static void main(String[] args) {
			try {
				System.out.println(InetAddress.getLocalHost().getHostAddress());
			} catch (UnknownHostException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			int port = Integer.parseInt(args[0]);
			Thread listen = new Thread(new UDPServer());
			Thread portScan = new Thread(new NetScan(9001));
			listen.start();
			portScan.start();
			
			while(true)
			{
			BufferedReader inFromUser =
					new BufferedReader(new InputStreamReader(System.in));
			
			try {
				String msg = inFromUser.readLine();
				UDPClient client = new UDPClient("192.168.56.1", port, msg);
				client.run();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
