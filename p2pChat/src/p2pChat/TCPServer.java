
/**
 * TCP File-Sharing Server.
 * 
 * @author Leanne Dyer (100593490) 
 * @version 1.0
 */
import java.net.*;
import java.io.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

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
                System.out.println("Server is running on port " + port);
                
                //connect to client
                Socket clientSocket = serverSocket.accept();
                String serverAddress = serverSocket.getInetAddress().toString();
                //sSocket.close();
                try
                {
                    InputStream inStream = clientSocket.getInputStream();
                    DataInputStream clientData = new DataInputStream(inStream);
                    DataOutputStream outStream = new DataOutputStream(clientSocket.getOutputStream());
                    BufferedReader receivePacket = new BufferedReader (new InputStreamReader(clientSocket.getInputStream()));
                    String fileName = clientData.readUTF();
                    File myFile = new File("files/" + fileName);
                
                    BufferedImage originalImg = ImageIO.read(myFile);
                    ByteArrayOutputStream baos = new ByteArrayOutputStream();
                    ImageIO.write(originalImg, "png", baos);
                    byte[] imageInBytes = baos.toByteArray();
                    
                    outStream.writeInt(imageInBytes.length);
                    outStream.write(imageInBytes);
                    
                    System.out.println("The file has been sent.... Closing Socket.");
                }
                catch(IOException e)
                {
                    System.out.println("\nError in TCP. Please try again.");
                }
                //Close streams and socket.
                clientSocket.close();
            }   
            
            }
            catch (IOException e) 
            {
            System.out.println("\nConnection error, please try again.");
            }
            
        }
        
    }

