package JMS.ChatApp;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public class User2Listener implements MessageListener{
	
	private String user;
	public User2Listener() {
		// TODO Auto-generated constructor stub
	}
	public User2Listener(String user) {
		this.user = user;
	}
	
	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public void onMessage(Message message) {
		try {
			TextMessage msg = (TextMessage) message;
			System.out.println("User 2 : "+msg.getText());
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
