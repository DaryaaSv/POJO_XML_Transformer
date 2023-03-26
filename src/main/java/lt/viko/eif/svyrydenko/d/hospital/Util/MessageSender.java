package lt.viko.eif.svyrydenko.d.hospital.Util;

import org.apache.activemq.ActiveMQConnectionFactory;
import javax.jms.*;
import java.io.*;

public class MessageSender {
    private Connection connection;
    private Session session;
    private MessageProducer producer;
    private static String QUEUE_NAME;
    private String xmlFileName;
    public MessageSender(String QUEUE_NAME, String xmlFileName) throws JMSException {
        this.QUEUE_NAME = QUEUE_NAME;
        this.xmlFileName = xmlFileName;

        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(ActiveMQConnectionFactory.DEFAULT_BROKER_URL);
        this.connection = connectionFactory.createConnection();
        this.connection.start();

        this.session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Destination destination = session.createQueue(QUEUE_NAME);

        this.producer = this.session.createProducer(destination);
    }
    public void sendMessage() {
        try{
            TextMessage message = session.createTextMessage();
            message.setText(readFile(xmlFileName));
            producer.send(message);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    public void close() throws JMSException {
        this.connection.close();
    }

    private static String readFile(String fileName) throws IOException {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
        }
        return sb.toString();
    }
}
