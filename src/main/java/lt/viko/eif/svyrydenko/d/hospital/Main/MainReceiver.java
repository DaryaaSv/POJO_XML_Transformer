package lt.viko.eif.svyrydenko.d.hospital.Main;

import lt.viko.eif.svyrydenko.d.hospital.Util.MessageReceiver;
import javax.jms.JMSException;

public class MainReceiver {
    public static void main(String[] args) {
        MessageReceiver receiver = null;
        try {
            receiver = new MessageReceiver("MY_QUEUE5");
            receiver.receiveMessage("hospitalOutput.xml");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                receiver.close();
            } catch(JMSException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
