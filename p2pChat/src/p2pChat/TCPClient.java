import java.net.*;
import java.io.*;
/**
 * Write a description of class TCPClient here.
 * 
 * @author Leanne Dyer (100593490) 
 * @version 1.0
 */
public class TCPClient
{
    // instance variables - replace the example below with your own
    private static int port;
    private static string ip;
    private static string fileName

    /**
     * Constructor for objects of class TCPClient
     */
    public TCPClient()
    {
        // initialise instance variables
        x = 0;
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
            if(args[0] == null || args[0].isEmpty())
            {
                System.out.println("ERROR: no ip address provided);
            }
            else  String ipSections = args[0].split(".");
            if(ipSections.length == 4)
            {
                for(String s : ipSections)
                {
                    int i = Integer.parseInt(s);
                    if(i < 0 || i > 255)
                    {
                        System.out.println("ERROR: ip address is invalid");
                    }
                }
                if(ipSections.endsWith("."))
                {
                    System.out.println("ERROR: ip address is invalid");
                }
                if(Integer.parseInt(args[1]) < 4000 && Integer.parseInt(args[1]) > 4010)
                {
                    System.out.println("ERROR: port number is invalid");
                }
                else if(args[2] == null || args[2].toString == "")
                {
                    System.out.println("ERROR: file name is invalid
                }
            }
            else System.out.println("ERROR: input is invlaid");
        }
    }
}
