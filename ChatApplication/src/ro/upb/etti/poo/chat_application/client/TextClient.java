package ro.upb.etti.poo.chat_application.client;
import java.util.Scanner;
import java.net.Socket;
import java.net.InetAddress;
public class TextClient
{
    private static final String HOST = "127.0.0.1";
    private static final int PORT = 9000;
    public static void main (String args[])
    {
        Scanner input = new Scanner(System.in);
        String userName = input.nextLine();
        
        try
        {
            Socket soc = new Socket(HOST,PORT);
            ClientPeer peer = new ClientPeer(userName,soc);
            while (true)
            {
                String temp = input.nextLine();
                if (temp.charAt(0)=='/' && temp.charAt(1)=='q')
                {
                    soc.close();
                    break;
                }
                else if (temp.charAt(0)=='/' && temp.charAt(1)=='w')
                {
                    String[] array = temp.split(" ");
                    peer.sendMessage(array[2],array[1]);
                }
                else 
                    peer.sendMessage(temp);
            }
        }
        catch (Exception e)
        {
        
        }

        
    }
}