package ro.upb.etti.poo.chat_application.server;
import ro.upb.etti.poo.chat_application.server.config.ServerConfig;
import ro.upb.etti.poo.chat_application.server.ServerPeer;
import java.net.ServerSocket;
public class Server
{
    
    public static void main (String[] args)
    {
        try
        {
            ServerConfig config = new ServerConfig();
            int port = config.getTcpPort();
            ServerSocket soc = new ServerSocket(port);
            ServerPeer peer = new ServerPeer(soc.accept());
            peer.run();
        }
        catch (Exception e)
        {
            
        }
        
        
    }
    
}