package ro.upb.etti.poo.chat_application.server.config;
import java.util.*;
import java.io.*;
import java.lang.*;
import ro.upb.etti.poo.chat_application.server.exceptions.InvalidFormatException;
import ro.upb.etti.poo.chat_application.server.exceptions.UnknownKeyException;
import ro.upb.etti.poo.chat_application.server.exceptions.MissingKeyException;


public class ServerConfig 
{
    
    private int port;
    private int maxClients;
    private int ok = 0;
    
    public ServerConfig() throws FileNotFoundException, InvalidFormatException, UnknownKeyException, MissingKeyException

    {
        this("server.conf");
        
    }
    
    public ServerConfig (String fileName) throws FileNotFoundException, InvalidFormatException, UnknownKeyException, MissingKeyException
    {
        
        Scanner input = new Scanner(new File(fileName));
        while (input.hasNext())
        {
            String line = input.nextLine();
            String tester = "#";
            line = line.trim();
            
            if (!line.startsWith(tester) && !line.isEmpty())
            {
                if (line.matches("[A-Z_]+=[0-9]+"))
                {
                    String[] array = line.split("=");
                    if (array[0].compareTo("TCP_PORT")==0)
                    {
                        port = Integer.parseInt(array[1]);
                        ok++;
                        
                    }
                    else if (array[0].compareTo("MAX_CLIENTS")==0)
                    {
                        maxClients = Integer.parseInt(array[1]);
                        ok++;
                    }
                    else 
                        throw new UnknownKeyException("Unknown key exception");
                    
                }
                else
                    throw new InvalidFormatException("Invalid format exception");
            }
        }
        if (ok!=2)
            throw new MissingKeyException("Missing key exception");
        
    }
    
    public int getTcpPort()
    {
        return port;
    }
    
    public int getMaxClients()
    {
        return maxClients;
    }
}