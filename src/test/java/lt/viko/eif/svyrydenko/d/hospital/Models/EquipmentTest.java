package lt.viko.eif.svyrydenko.d.hospital.Models;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EquipmentTest {
    @Test
    void testToString() {
        Equipment equipment = new Equipment("Patient monitor", 5643, "HospEq",
                "For monitoring", "Utility room");

        Assert.assertTrue(equipment.toString().contains(("HospEq")));
    }

}