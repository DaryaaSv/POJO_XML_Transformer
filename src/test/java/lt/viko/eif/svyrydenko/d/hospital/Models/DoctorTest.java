package lt.viko.eif.svyrydenko.d.hospital.Models;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DoctorTest {

    @Test
    void testToString() throws ParseException {
        HospitalRoom hospitalRoom1 = new HospitalRoom(242, "Single room", 1, 4);

        Patient patient1 = new Patient("Alice", "Pattinson", 19, "+37063945276",
                "alicepattinson@gmail.com", hospitalRoom1,
                List.of(new Illness( "Flu", "Chills", "High temperature", "Not given"),
                        new Illness( "Cough", "Upper respiratory infection",
                                "Cough present for 3 weeks", "Not given")));

        Appointment appointment1 = new Appointment( "monitoring", new SimpleDateFormat("yyyy-MM-dd").
                parse(java.time.LocalDate.now().toString()), "The patient got a list of medicines", patient1);

        Doctor doctor = new Doctor("Bob", "Stevens", "+37067645456",
                "Physiotherapist", 5000, List.of(appointment1));

        Assert.assertTrue(doctor.toString().contains(("Stevens")));
    }
}