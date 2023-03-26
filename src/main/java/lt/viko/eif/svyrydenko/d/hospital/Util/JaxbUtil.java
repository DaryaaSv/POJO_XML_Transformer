package lt.viko.eif.svyrydenko.d.hospital.Util;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import lt.viko.eif.svyrydenko.d.hospital.Models.Hospital;

import java.io.File;

public class JaxbUtil {
    private JAXBContext context = JAXBContext.newInstance(Hospital.class);

    public JaxbUtil() throws JAXBException {
    }

    public void transformToXML(Hospital hospital, String fileName) {
        try{
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty("jaxb.formatted.output", Boolean.TRUE);
            marshaller.marshal(hospital, new File(fileName));
            marshaller.marshal(hospital, System.out);
        } catch(Exception e) {
            e.printStackTrace();
        }

    }

    public Hospital transformToPOJO(String xmlFile) {
        Hospital hospital = new Hospital();
        try {
            File file = new File(xmlFile);
            Unmarshaller jaxbUnmarshaller = context.createUnmarshaller();
            hospital = (Hospital) jaxbUnmarshaller.unmarshal(file);
        } catch(Exception e) {
            e.printStackTrace();
        }
        return hospital;
    }
}
