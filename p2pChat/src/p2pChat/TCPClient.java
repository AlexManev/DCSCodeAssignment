import java.net.*;
import java.io.*;
/**
 * TCP file transfer client.
 * 
 * @author Leanne Dyer (100593490) 
 * @version 1.0
 */
public class TCPClient //extends thread
{
    // instance variables - replace the example below with your own
    private static int port;
    private static String ip;
    private static String fileName;
    private Socket clientSocket;
    private final int BUFFER_SIZE = 65536;

    /**
     * Constructor for objects of class TCPClient
     * 
     * @param client Socket for client to run on
     */
    public TCPClient(String address, int port)
    {
        this.ip = address;
        this.port = port;
        this.clientSocket = new Socket(address, port);  
    }

    /**
     * Main method for TCPClient
     * 
     * @param  args   command line input
     */
    public static void main(String[] args)
    {
        // put your code here
        try
        {
            if(args == null)
            {
                System.out.println("ERROR: input is invlaid");
                System.exit(0);
            }
            
            else
            if(args[0] != null || !args[0].isEmpty())
            {
                String ipSections = args[0].split('.').toString();
                if(ipSections.length == 4)
                {
                    for(String s : ipSections)
                    {
                        int i = Integer.parseInt(s);
                        if(i < 0 || i > 255)
                        {
                            System.out.println("ERROR: ip address is invalid");
                            System.exit(0);
                        }
                    }
                    if(ipSections.endsWith("."))
                    {
                        System.out.println("ERROR: ip address is invalid");
                        System.exit(0);
                    }
                    
                }
            
                if(Integer.parseInt(args[1]) < 4000 && Integer.parseInt(args[1]) > 4010)
                {
                    System.out.println("ERROR: port number is invalid");
                    System.exit(0);
                }
                else if(args[2] == null || args[2].toString == "")
                {
                    System.out.println("ERROR: file name is invalid");
                }
            }
            else
            {
                System.out.println("ERROR: Please provide a valid IP address, port number and file name");
                System.exit(0);
            }
            
        }
        catch(Exception ex)
            {
                System.out.println("ERROR: Please provide a valid IP address, port number and file name");
                System.exit(0);
            }
        ip = args[0].toString();
        port = Integer.parseInt(args[1].toString());
        fileName = args[2];
        Socket connect = new Socket(ip, port);
        OutputStream oStream = connect.getOuputStream();
        DataOutputStream dOStream = new DataOutputStream(oStream);
    }

    public void run()
    {
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        System.out.println("Select an option:");
        System.out.println("1 - Recieve file");
        System.out.println("2 - Send file");
        String clientChoice;
        while((clientChoice = in.readLine() != null))
        {
            if(!clientChoice.matches("^d{1,2}"))
            {
                System.out.printLn("Please enter either 1 or 2 to select an option");
                clientChoice = in.readLine();
            }
            switch(clientChoice)
            {
                case "1": //recieve file code
                case "2": //send file code
            }
        }
    }
}
