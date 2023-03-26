package lt.viko.eif.svyrydenko.d.hospital.Models;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HospitalRoomTest {

    @Test
    void testToString() {
        HospitalRoom hospitalRoom = new HospitalRoom(242, "Single room", 1, 4);

        Assert.assertTrue(hospitalRoom.toString().contains(("Single room")));
    }
}