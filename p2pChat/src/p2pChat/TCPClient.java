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
        run(ip, port, fileName);
        
    }

    public void run(String ip, int port, String fileName)
    {
        try
        {
            Socket connect = new Socket(ip, port);
            PrintWriter reqFile = new PrintWriter(connect.getOutputStream());
            DataInputStream recFile = new DataInputStream(connect.getInputStream());
            reqFile.flush();
            try
                {
                    //Save image and determine size
                    FileOutputStream fOStream = new FileOutputStream("picRec.png");
                    int fileLength = recFile.readInt();
                    if(fileLength > 0)
                    {
                        byte[] fileBytes = new byte[fileLength];
                        recFile.readFully(fileBytes, 0, fileBytes.length);
                        //Write file to client
                        for(byte b : fileBytes)
                        {
                            fOStream.write(b);
                        }
                        System.out.println("File received successfully. Socket closed");
                    }
                }
                catch(Exception ex)
                {
                    System.out.println("ERROR: failed to process file");
                    System.exit(0);
                }
        }
        catch(Exception ex)
        {
            System.out.println("ERROR: failed to read from stream");
        }
        
        
    }
}
