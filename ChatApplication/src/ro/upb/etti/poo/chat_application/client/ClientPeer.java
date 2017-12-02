package ro.upb.etti.poo.chat_application.client;
import java.net.Socket;
import java.io.ObjectOutputStream;
import java.io.IOException;
import ro.upb.etti.poo.chat_application.structs.Message;
import ro.upb.etti.poo.chat_application.structs.PrivateMessage;
public class ClientPeer
{
    String userName;
    Socket soc;
   public ClientPeer(String u, Socket s)
    {
        userName = u;
        soc = s;
    }
    
    public void sendMessage(String message)
    {
        try
        {
        ObjectOutputStream out = new ObjectOutputStream(soc.getOutputStream());
        out.writeObject(new Message(userName,message));
        out.flush();
        }
        catch (IOException i)
        {
            i.printStackTrace();
        }
    }
    
    public void sendMessage(String message, String recipient)
    {
        try
        {
        ObjectOutputStream out = new ObjectOutputStream(soc.getOutputStream());
        out.writeObject(new PrivateMessage(recipient,userName,message));
        out.flush();
        }
        catch (IOException i)
        {
            i.printStackTrace();
        }
        
    }
    
}
