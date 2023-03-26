package lt.viko.eif.svyrydenko.d.hospital.Models;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * This class represents a patient object in a hospital management system.
 * It is annotated with @Entity and @Table, indicating it can be persisted in a database table.
 * The table name is "patient".
 * It also includes several fields such as id, firstName, surname, age, phoneNumber,
 * email, hospitalRoom, and illnessesList.
 * The class includes constructors, getter and setter methods for each field, and a toString method
 * that returns a formatted string representation of a patient's information.
 */
@Entity
@Table(name="patient")
@XmlAccessorType(XmlAccessType.FIELD)
public class Patient {
    /**
     * The unique identifier for a patient.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    /**
     * The first name of the patient.
     */
    private String firstName;

    /**
     * The surname of the patient.
     */
    private String surname;

    /**
     * The age of the patient.
     */
    private int age;

    /**
     * The phone number of the patient.
     */
    private String phoneNumber;

    /**
     * The email address of the patient.
     */
    private String email;

    /**
     * The hospital room assigned to the patient. This is a one-to-one relationship with the HospitalRoom entity and is
     * stored in a separate table. The cascade type is set to CascadeType. ALL, indicating that any changes made to the
     * patient will be propagated to the HospitalRoom.
     */
    @OneToOne(targetEntity = HospitalRoom.class, cascade = CascadeType.ALL)
    private HospitalRoom hospitalRoom;

    /**
     * A list of illnesses that the patient has. This is a one-to-many relationship with the Illness entity and is
     * stored in a separate table. The cascade type is set to CascadeType. ALL, indicating that any changes made to the
     * patient will be propagated to the Illnesses. JAXB annotations are used to specify the element and wrapper names
     * for XML serialization/deserialization.
     */
    @OneToMany(targetEntity = Illness.class, cascade = CascadeType.ALL)
    @XmlElementWrapper(name = "illnesses")
    @XmlElement(name = "illness")
    private List<Illness> illnessesList = new ArrayList<>();

    /**
     * Default constructor for the patient class.
     */
    public Patient() {
    }

    /**
     * Constructor for the patient class that sets all fields except for the unique identifier.
     * @param firstName The first name of the patient.
     * @param surname The surname of the patient.
     * @param age The age of the patient.
     * @param phoneNumber The phone number of the patient.
     * @param email The email address of the patient.
     * @param hospitalRoom The hospital room assigned to the patient.
     * @param illnessesList A list of illnesses that the patient has.
     */
    public Patient(String firstName, String surname, int age, String phoneNumber, String email,
                   HospitalRoom hospitalRoom, List<Illness> illnessesList) {
        this.firstName = firstName;
        this.surname = surname;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.hospitalRoom = hospitalRoom;
        this.illnessesList = illnessesList;
    }

    /**
     * Constructor for the patient class that sets all fields.
     * @param id The ID of the patient.
     * @param firstName The first name of the patient.
     * @param surname The surname of the patient.
     * @param age The age of the patient.
     * @param phoneNumber The phone number of the patient.
     * @param email The email address of the patient.
     * @param hospitalRoom The hospital room assigned to the patient.
     * @param illnessesList A list of illnesses that the patient has.
     */
    public Patient(int id, String firstName, String surname, int age, String phoneNumber, String email,
                   HospitalRoom hospitalRoom, List<Illness> illnessesList) {
        this.id = id;
        this.firstName = firstName;
        this.surname = surname;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.hospitalRoom = hospitalRoom;
        this.illnessesList = illnessesList;
    }
    /**
     * Returns a string representation of the patient's data.
     * @return A string representation of the patient's personal data.
     */
    @Override
    public String toString() {
        return String.format("""
                        \t\t\t\t\tFirst name: %s,
                        \t\t\t\t\tSurname: %s,
                        \t\t\t\t\tAge: %d,
                        \t\t\t\t\tPhone number: %s,
                        \t\t\t\t\tEmail: %s, 
                        \t\t\t\t\t%s
                        \t\t\t\t\tIllnesses: %s""",
                this.firstName, this.surname, this.age, this.phoneNumber, this.email, this.hospitalRoom,
                constructIllnessesString());
    }

    /**
     * Constructs a string representation of the patient's illnesses.
     * @return A string representation of the patient's illnesses.
     */
    private String constructIllnessesString() {
        StringBuilder result = new StringBuilder();
        for (Illness illness : this.illnessesList) {
            result.append(illness.toString());
            result.append("\t\t");
        }
        return result.toString();
    }

    /**
     * Returns the hospital room the patient is staying in.
     * @return The hospital room the patient is staying in.
     */
    public HospitalRoom getHospitalRoom() {
        return hospitalRoom;
    }

    /**
     * Sets the hospital room the patient is staying in.
     * @param hospitalRoom The hospital room the patient is staying in.
     */
    public void setHospitalRoom(HospitalRoom hospitalRoom) {
        this.hospitalRoom = hospitalRoom;
    }

    /**
     * Returns the list of illnesses the patient has.
     * @return The list of illnesses the patient has.
     */
    public List<Illness> getIllnessesList() {
        return illnessesList;
    }

    /**
     * Sets the list of illnesses for the patient.
     * @param illnessesList a list of illnesses to be assigned to the patient
     */
    public void setIllnessesList(List<Illness> illnessesList) {
        this.illnessesList = illnessesList;
    }

    /**
     * Returns the ID of the patient.
     * @return the ID of the patient
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the ID of the patient.
     * @param id the ID to be assigned to the patient
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Returns the first name of the patient.
     * @return the first name of the patient
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the first name of the patient.
     * @param firstName the first name to be assigned to the patient
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Returns the surname of the patient.
     * @return the surname of the patient
     */
    public String getSurname() {
        return surname;
    }

    /**
     * Sets the surname of the patient.
     * @param surname the surname to be assigned to the patient
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     * Returns the age of the patient.
     * @return the age of the patient
     */
    public int getAge() {
        return age;
    }

    /**
     * Sets the age of the patient.
     * @param age the age to be assigned to the patient
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Returns the phone number of the patient.
     * @return the phone number of the patient
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Sets the phone number of the patient.
     * @param phoneNumber the phone number to be assigned to the patient
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Returns the email of the patient.
     * @return the email of the patient
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email of the patient.
     * @param email the email to be assigned to the patient
     */
    public void setEmail(String email) {
        this.email = email;
    }
}
