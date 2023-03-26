package lt.viko.eif.svyrydenko.d.hospital.Main;

import lt.viko.eif.svyrydenko.d.hospital.Models.*;
import lt.viko.eif.svyrydenko.d.hospital.Util.HibernateUtil;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

public class HibernateMainSave {

    public static void main(String[] args) throws ParseException {
        HospitalRoom hospitalRoom1 = new HospitalRoom(242, "Single room", 1, 4);
        HospitalRoom hospitalRoom2 = new HospitalRoom(240, "Single room", 1, 3);

        Patient patient1 = new Patient("Alice", "Pattinson", 19, "+37063945276", "alicepattinson@gmail.com", hospitalRoom1,
                List.of(new Illness( "Flu", "Chills", "High temperature", "Not given"),
                        new Illness( "Cough", "Upper respiratory infection", "Cough present for 3 weeks", "Not given")));

        Patient patient2 = new Patient("Peter", "Parker", 28, "+37015947852", "peter.park@gmail.com", hospitalRoom2,
                List.of(new Illness( "Common Cold", "Upper respiratory infection", "Fever, cough, sore throat", "Treat with fluids and rest")));

        Appointment appointment1 = new Appointment( "monitoring", new SimpleDateFormat("yyyy-MM-dd").parse(java.time.LocalDate.now().toString()), "The patient got a list of medicines", patient1);
        Appointment appointment2 = new Appointment( "monitoring", new SimpleDateFormat("yyyy-MM-dd").parse(java.time.LocalDate.now().toString()), "No problems found", patient2);

        Doctor doctor1 = new Doctor("Bob", "Stevens", "+37067645456", "Physiotherapist", 5000, List.of(appointment1));
        Doctor doctor2 = new Doctor("Alex", "Vivien", "+37065645456", "Cardiology", 4000, List.of(appointment2));

        Equipment equipment1 = new Equipment("Patient monitor", 5643, "HospEq", "For monitoring", "Utility room");
        Equipment equipment2 = new Equipment("Elliptical", 579, "Precor", "Cardio Equipment", "Fitness Center");

        Hospital hospital = new Hospital("Central hospital", "Clinic",
                "Vilnius", "+3706390235276", List.of(doctor1, doctor2), List.of(equipment1, equipment2));

        HibernateUtil.saveToDatabase(List.of(hospital));
    }

}
