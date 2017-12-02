package ro.upb.etti.poo.chat_application.structs;
import java.io.Serializable;
public class Message implements Serializable
{
	private String mSender;
	private String mContent;
	private static final long serialversionUID=1L;
	
	public Message(String name,String mess)
	{
		mSender=name;
		mContent=mess;
	}
	
	public String toString()
	{
		return String.format("%s:%s",mSender,mContent);
	}

}