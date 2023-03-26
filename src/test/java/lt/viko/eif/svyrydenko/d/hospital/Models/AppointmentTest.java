package lt.viko.eif.svyrydenko.d.hospital.Models;

import org.junit.jupiter.api.Test;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import org.junit.Assert;


class AppointmentTest {

    @Test
    void testToString() throws ParseException {
        HospitalRoom hospitalRoom = new HospitalRoom(1, 242, "Single room", 1, 4);
        Patient patient = new Patient(1, "Alice", "Pattinson", 19, "+37063945276",
                "whs@gmail.com", hospitalRoom,
                List.of(new Illness(1, "Flu", "Caught", "High temperature", "No"),
                new Illness(2, "ekw", "jewk", "kkssl", "ejkw")));
        Appointment appointment = new Appointment(1, "monitoring", new SimpleDateFormat("yyyy-MM-dd")
                .parse(java.time.LocalDate.now().toString()), "No problems found", patient);

        Assert.assertTrue(appointment.toString().contains("monitoring"));
    }
}