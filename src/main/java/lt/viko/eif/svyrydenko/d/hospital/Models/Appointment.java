package lt.viko.eif.svyrydenko.d.hospital.Models;

import javax.persistence.*;
import java.util.Date;
/**
 * Appointment class represents a medical appointment made by a patient to see a doctor or specialist.
 * It contains information about the appointment such as its unique id, type, date, and result.
 * The class also has a Patient object that represents the patient who made the appointment.
 */
@Entity
@Table(name="appointment")
public class Appointment {

    /**
     * The unique id of the appointment.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    /**
     * The type of the appointment, e.g. "checkup", "surgery", "consultation", etc.
     */
    private String type;

    /**
     * The date of the appointment.
     */
    private Date date;

    /**
     * The result of the appointment, e.g. "normal", "abnormal", "inconclusive", etc.
     */
    private String result;

    /**
     * The Patient object representing the patient who made the appointment.
     */
    @OneToOne(targetEntity = Patient.class, cascade = CascadeType.ALL)
    private Patient patient;

    /**
     * Constructs an empty Appointment object.
     */
    public Appointment() {
    }

    /**
     * Constructs an Appointment object with the given parameters.
     * @param type the type of the appointment
     * @param date the date of the appointment
     * @param result the result of the appointment
     * @param patient the patient who made the appointment
     */
    public Appointment(String type, Date date, String result, Patient patient) {
        this.type = type;
        this.date = date;
        this.result = result;
        this.patient = patient;
    }
    /**
     * Constructs an Appointment object with the given parameters.
     * @param id the unique id of the appointment
     * @param type the type of the appointment
     * @param date the date of the appointment
     * @param result the result of the appointment
     * @param patient the patient who made the appointment
     */
    public Appointment(int id, String type, Date date, String result, Patient patient) {
        this.id = id;
        this.type = type;
        this.date = date;
        this.result = result;
        this.patient = patient;
    }

    /**
     * Returns a string representation of the Appointment object.
     * The string contains the appointment's unique id, type, date, and result.
     * @return a string representation of the Appointment object
     */
    @Override
    public String toString() {
        return String.format("""
                Appointment Type: %s,
                \t\t\t\tDate: %s,
                \t\t\t\tResult: %s,
                \t\t\t\tPatient: \n%s""",
                this.type, this.date.toString(), this.result, this.patient.toString());
    }

    /**
     * Returns the unique id of the appointment.
     * @return the unique id of the appointment
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the unique id of the appointment.
     * @param id the unique id of the appointment
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Returns the type of the appointment.
     * @return the type of the appointment
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the type of the appointment.
     * @param type the type of the appointment
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Returns the date of the appointment.
     * @return the date of the appointment
     */
    public Date getDate() {
        return date;
    }

    /**
     * Sets the date of the appointment.
     * @param date the date of the appointment
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * Returns the result of the appointment.
     * @return the result of the appointment
     */
    public String getResult() {
        return result;
    }

    /**
     * Sets the result of the appointment.
     * @param result the result of the appointment
     */
    public void setResult(String result) {
        this.result = result;
    }

    /**
     * Returns the Patient object representing the patient who made the appointment.
     * @return the Patient object representing the patient who made the appointment
     */
    public Patient getPatient() {
        return patient;
    }

    /**
     * Sets the Patient object representing the patient who made the appointment.
     * @param patient the Patient object representing the patient who made the appointment
     */
    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}
