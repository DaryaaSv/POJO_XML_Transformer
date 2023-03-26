package lt.viko.eif.svyrydenko.d.hospital.Models;

import jakarta.xml.bind.annotation.*;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
/**
 * Represents a doctor in a medical application. Doctors can have appointments and are identified by their unique ID.
 * This class is an entity that is mapped to the "doctor" table in a database. It contains
 * attributes such as name, specialty, salary, and appointments.
 */
@Entity
@Table(name="doctor")
@XmlAccessorType(XmlAccessType.FIELD)
public class Doctor {
    /**
     * The unique identifier for this doctor.
     * This field is the primary key of the entity and is generated automatically by the database.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    /**
     * The first name of this doctor.
     */
    private String firstName;

    /**
     * The surname of this doctor.
     */
    private String surname;

    /**
     * The phone number of this doctor.
     */
    private String phoneNumber;

    /**
     * The specialty of this doctor (e.g. cardiology, pediatrics).
     */
    private String specialty;

    /**
     * The salary of this doctor.
     */
    private double salary;

    /**
     * The list of appointments for this doctor.
     * This field is a one-to-many relationship with the Appointment entity and is serialized as an XML
     * element named "appointments".
     */
    @OneToMany(targetEntity = Appointment.class, cascade = CascadeType.ALL)
    @XmlElementWrapper(name = "appointments")
    @XmlElement(name = "appointment")
    private List<Appointment> appointments = new ArrayList<>();

    /**
     * Creates a new doctor with default values for all fields.
     */
    public Doctor() {
    }

    /**
     * Creates a new doctor with the given values for all fields except id.
     *
     * @param firstName    The first name of the doctor.
     * @param surname      The surname of the doctor.
     * @param phoneNumber  The phone number of the doctor.
     * @param specialty    The specialty of the doctor.
     * @param salary       The salary of the doctor.
     * @param appointments The list of appointments for the doctor.
     */
    public Doctor(String firstName, String surname, String phoneNumber, String specialty, double salary, List<Appointment> appointments) {
        this.firstName = firstName;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.specialty = specialty;
        this.salary = salary;
        this.appointments = appointments;
    }

    /**
     * Creates a new doctor with the given values for all fields.
     *
     * @param id           The unique identifier for the doctor.
     * @param firstName    The first name of the doctor.
     * @param surname      The surname of the doctor.
     * @param phoneNumber  The phone number of the doctor.
     * @param specialty    The specialty of the doctor.
     * @param salary       The salary of the doctor.
     * @param appointments The list of appointments for the doctor.
     */
    public Doctor(int id, String firstName, String surname, String phoneNumber, String specialty, double salary, List<Appointment> appointments) {
        this.id = id;
        this.firstName = firstName;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.specialty = specialty;
        this.salary = salary;
        this.appointments = appointments;
    }

    /**
     * Returns a string representation of this doctor.
     * The string contains all the doctor's attributes, as well as a list of appointments.
     * @return A string representation of this doctor.
     */
    @Override
    public String toString() {
        return String.format("""
                        \tDoctor's first name: %s,
                        \t\t\tSurname: %s,
                        \t\t\tPhone number: %s,
                        \t\t\tSpecialty: %s,
                        \t\t\tSalary: %f;
                        \t\t\tAppointments:
                        \t\t\t\t%s
                        """,
                this.firstName, this.surname, this.phoneNumber, this.specialty, this.salary,
                constructAppointmentString());
    }

    /**
     * Returns a string representation of the appointments of the doctor, in a specific format.
     * @return a string representation of the appointments of the doctor
     */
    private String constructAppointmentString() {
        StringBuilder result = new StringBuilder();
        for (Appointment appointment : this.appointments) {
            result.append(appointment.toString());
            result.append("\t\t");
        }
        return result.toString();
    }

    /**
     * Returns a list of appointments of the doctor.
     * @return a list of appointments of the doctor
     */
    public List<Appointment> getAppointments() {
        return appointments;
    }

    /**
     * Sets the list of appointments of the doctor to the specified value.
     * @param appointments the new list of appointments of the doctor
     */
    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }

    /**
     * Returns the unique identifier of the doctor.
     * @return the unique identifier of the doctor
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the unique identifier of the doctor to the specified value.
     * @param id the new unique identifier of the doctor
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Returns the first name of the doctor.
     * @return the first name of the doctor
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the first name of the doctor to the specified value.
     * @param firstName the new first name of the doctor
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Returns the phone number of the doctor.
     * @return the phone number of the doctor
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Sets the phone number of the doctor to the specified value.
     * @param phoneNumber the new phone number of the doctor
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Returns the surname of the doctor.
     * @return the surname of the doctor
     */
    public String getSurname() {
        return surname;
    }

    /**
     * Sets the surname of the doctor to the specified value.
     * @param surname the new surname of the doctor
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     * Returns the specialty of the doctor.
     * @return the specialty of the doctor
     */
    public String getSpecialty() {
        return specialty;
    }

    /**
     * Sets the specialty of the doctor to the specified value.
     * @param specialty the new specialty of the doctor
     */
    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    /**
     * Returns the salary of the doctor.
     * @return the salary of the doctor
     */
    public double getSalary() {
        return salary;
    }

    /**
     * Sets the salary of the doctor to the specified value.
     * @param salary the new salary of the doctor
     */
    public void setSalary(double salary) {
        this.salary = salary;
    }
}