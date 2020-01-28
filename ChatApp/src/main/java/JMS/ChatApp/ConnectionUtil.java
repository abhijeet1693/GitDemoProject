package JMS.ChatApp;

import java.util.Properties;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnectionFactory;

public class ConnectionUtil {
	
	public Properties getProperty() throws JMSException {
		Properties prop = new Properties();
		ConnectionFactory factory = new ActiveMQConnectionFactory(ActiveMQConnectionFactory.DEFAULT_BROKER_URL);
		Connection connection = factory.createConnection();
		connection.start();
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		Destination queue = session.createQueue("GWQueue");
		Destination queue1 = session.createQueue("user2");
		prop.put("session", session);
		prop.put("queue", queue);
		prop.put("queue1", queue1);
		prop.put("connection", connection);
		return prop;
	}
	
}
