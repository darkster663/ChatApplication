package ro.upb.etti.poo.chat_application.client;
import java.util.Scanner;
import java.net.Socket;
import java.net.InetAddress;
public class TextClient
{
    public static void main (String args[])
    {
        Scanner input = new Scanner(System.in);
        String userName = input.nextLine();
        try
        {
            Socket soc = new Socket(InetAddress.getLocalHost(),9000);
            ClientPeer peer = new ClientPeer(userName,soc);
            String ok = "ok";
            while (ok.equals("ok"))
            {
                String temp = input.nextLine();
                if (temp.charAt(0)=='/' && temp.charAt(1)=='q')
                    ok = "exit";
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