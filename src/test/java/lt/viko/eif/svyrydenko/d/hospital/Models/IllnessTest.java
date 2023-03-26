package lt.viko.eif.svyrydenko.d.hospital.Models;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IllnessTest {

    @Test
    void testToString() {
        Illness illness = new Illness( "Flu", "Chills", "High temperature", "Not given");

        Assert.assertTrue(illness.toString().contains(("Chills")));
    }
}