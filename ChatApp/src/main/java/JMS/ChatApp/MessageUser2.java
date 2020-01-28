package JMS.ChatApp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

public class MessageUser2 implements MessageListener{

	
	public void receive() throws JMSException, IOException {
		ConnectionUtil util = new ConnectionUtil();
		Properties prop = util.getProperty();
		Connection connection = (Connection) prop.get("connection");
		Session session = (Session) prop.get("session");
		Destination user1 = (Destination) prop.get("queue");
		Destination user2 = (Destination) prop.get("queue1");
		MessageProducer producer = session.createProducer(user2);
		MessageConsumer consumer = session.createConsumer(user1);
		TextMessage message = session.createTextMessage();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		consumer.setMessageListener(this);
		connection.start();
		
		while (true) {
			String data = br.readLine();
			if(data.equals("exit"))
				break;
			message.setText(data);
			producer.send(message);
		}
		
	}
	
	public void onMessage(Message message) {
		try {
			TextMessage msg = (TextMessage) message;
			System.out.println("user 2 : "+msg.getText());
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
