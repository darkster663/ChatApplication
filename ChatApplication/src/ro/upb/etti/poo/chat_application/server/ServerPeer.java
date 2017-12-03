package ro.upb.etti.poo.chat_application.server;
import java.net.Socket;
import java.io.IOException;
import java.io.ObjectInputStream;
import ro.upb.etti.poo.chat_application.structs.Message;
public class ServerPeer
{
    Socket soc;
    public ServerPeer(Socket s)
    {
        soc = s;
    }
    
    public void run() throws IOException, ClassNotFoundException 
    {
        try 
        {
            ObjectInputStream input = new ObjectInputStream(soc.getInputStream());
            
            while (true)
            {
                System.out.println(input.readObject().toString().trim());
            }
        }
        catch (Exception e)
        {
            
        }
        
    }
}