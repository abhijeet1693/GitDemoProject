package JMS.ChatApp;

import java.io.IOException;

import javax.jms.JMSException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws JMSException, IOException
    {
    	MessageUser1 user = new MessageUser1();
    	
    	user.sendMessage();
    }
}
