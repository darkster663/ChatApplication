package ro.upb.etti.poo.chat_application.structs;
public class PrivateMessage extends Message
{
    private String mRecipient;
    
    public PrivateMessage(String recipient, String sender,String content)
    {
        super(sender,content);
        mRecipient = recipient;
    }
    
    public String toString()
    {
        return String.format("(priv) %s",super.toString());
    }
    
    public String getRecipient()
    {
        return mRecipient;
    }
}