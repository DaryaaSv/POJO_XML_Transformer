package lt.viko.eif.svyrydenko.d.hospital.Models;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PatientTest {

    @Test
    void testToString() {
        HospitalRoom hospitalRoom = new HospitalRoom(242, "Single room", 1, 4);

        Patient patient = new Patient("Alice", "Pattinson", 19, "+37063945276",
                "alicepattinson@gmail.com", hospitalRoom,
                List.of(new Illness( "Flu", "Chills", "High temperature", "Not given"),
                        new Illness( "Cough", "Upper respiratory infection",
                                "Cough present for 3 weeks", "Not given")));

        Assert.assertTrue(patient.toString().contains(("Alice")));

    }
}