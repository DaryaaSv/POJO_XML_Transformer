package lt.viko.eif.svyrydenko.d.hospital.Util;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import javax.jms.*;
import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.FileOutputStream;
import java.io.StringReader;

public class MessageReceiver {
    private static String QUEUE_NAME;
    private Connection connection;
    private Session session;
    private MessageConsumer consumer;
    public MessageReceiver(String QUEUE_NAME) throws JMSException {
        this.QUEUE_NAME = QUEUE_NAME;

        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(ActiveMQConnectionFactory.DEFAULT_BROKER_URL);
        this.connection = connectionFactory.createConnection();
        this.connection.start();

        this.session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Destination destination = session.createQueue(QUEUE_NAME);

        consumer = session.createConsumer(destination);
    }

    public void receiveMessage(String fileName) throws Exception {
        Message message = consumer.receive();

        if (message instanceof TextMessage) {
            TextMessage textMessage = (TextMessage) message;

            StringBuilder xmlMessage = new StringBuilder(textMessage.getText());

            System.out.println(xmlMessage.toString());

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new InputSource(new StringReader(xmlMessage.toString())));

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);

            File file = new File(fileName);
            StreamResult result;
            if (file.exists()) {
                result = new StreamResult(file);
            } else {
                result = new StreamResult(new FileOutputStream(file));
            }
            transformer.transform(source, result);

            File xsdFile = new File("hospital.xsd");

            SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = schemaFactory.newSchema(xsdFile);
            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(file));

        }
    }

    public void close() throws JMSException {
        this.connection.close();
    }
}
