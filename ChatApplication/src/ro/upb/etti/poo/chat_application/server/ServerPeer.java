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
        while (soc.isConnected())
        {
            try (ObjectInputStream inputStream = new ObjectInputStream (soc.getInputStream()))
            {
                Object m = inputStream.readObject();
                Message temp =(Message) m;
                System.out.println(temp.toString());
                
                
            }
        }
    }
}