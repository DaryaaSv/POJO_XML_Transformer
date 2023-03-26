package lt.viko.eif.svyrydenko.d.hospital.Main;

import lt.viko.eif.svyrydenko.d.hospital.Util.MessageSender;
import javax.jms.JMSException;

public class MainSender {
    public static void main(String[] args) {

        MessageSender sender = null;
        try {
            sender = new MessageSender("MY_QUEUE5", "hospital.xml");
            sender.sendMessage();
        } catch (JMSException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                sender.close();
            } catch(JMSException e) {
                System.out.println(e.getMessage());
            }
        }

    }
}