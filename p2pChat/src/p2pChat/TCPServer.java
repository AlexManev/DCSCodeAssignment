
/**
 * TCP File-Sharing Server.
 * 
 * @author Leanne Dyer (100593490) 
 * @version 1.0
 */
import java.net.*;
import java.io.*;

public class TCPServer
{
    // instance variables - replace the example below with your own
    private static int port;

    /**
     * Constructor for objects of class TCPServer
     */
    public TCPServer()
    {
        // initialise instance variables
    }

    /**
     * Main method - provides validation at execution
     */
    public static void main (String[] args)
    {
        if(args.length == 1 && port > 3999 && port < 4011)
        {
            try
            {
                System.out.println("Port: " + Integer.parseInt(args[0]));
            }
            catch(Exception ex)
            {
                System.out.println(ex.getMessage());
                System.exit(0);
            }
            runServer(port);
        }
        else
        {
            System.out.println("Please type TCPServer and a port between 4000 and 4010 to run");
        }
    }
    
    /**
     * runServer - starts the server once input is validated
     * 
     * @param port integer representation of port
     */
    public static void runServer(int port)
    {
        try
        {
            while(true)
            {
                ServerSocket serverSocket = new ServerSocket(port);
                Socket clientSocket = serverSocket.accept();
                String serverAddress = serverSocket.getInetAddress().toString();
                //sSocket.close();
                InputStream inStream = clientSocket.getInputStream();
                DataInputStream clientData = new DataInputStream(inStream);
                String fileName = clientData.readUTF();
                //File myFile = new File();
                //wait for request
                //find file
                //send file
                //messageOK
            }
        }
        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }
    }
}
