package JMS.ChatApp;

import java.io.IOException;

import javax.jms.JMSException;

public class App1 {
	public static void main(String[] args) throws JMSException, IOException {
		MessageUser2 user2 = new MessageUser2();
		
		user2.receive();
	}
}
