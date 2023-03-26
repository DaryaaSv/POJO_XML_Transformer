package lt.viko.eif.svyrydenko.d.hospital.Main;

import lt.viko.eif.svyrydenko.d.hospital.Models.Hospital;
import lt.viko.eif.svyrydenko.d.hospital.Util.HibernateUtil;
import java.util.List;

public class HibernateMainGet {
    public static void main(String[] args) {
        List<Hospital> hospitals = HibernateUtil.getFromDatabase();
    }
}
