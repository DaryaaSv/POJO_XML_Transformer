package lt.viko.eif.svyrydenko.d.hospital.Models;

import jakarta.xml.bind.annotation.*;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
/**
 * This class represents a hospital entity and contains properties such as its ID,
 * name, type, address, phone number, doctors list, and equipment list. It also
 * provides methods for constructing string representations of its doctors and
 * equipment lists, as well as constructors and getters/setters for its properties.
 * The entity is annotated with various annotations such as @Entity, @Table, @XmlRootElement, and @XmlAccessorType
 * to provide metadata to the Java Persistence API and to support XML serialization and deserialization.
 */
@Entity
@Table(name="hospital")
@XmlRootElement(name="hospital")
@XmlType(propOrder = {"id", "hospitalName", "type", "address", "phoneNumber", "doctorsList", "equipmentList"})
@XmlAccessorType(XmlAccessType.FIELD)
public class Hospital {
    /**
     * The unique identifier for a hospital.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    /**
     * The name of the hospital.
     */
    private String hospitalName;

    /**
     * The type of the hospital.
     */
    private String type;

    /**
     * The address of the hospital.
     */
    private String address;

    /**
     * The phone number of the hospital.
     */
    private String phoneNumber;

    /**
     * The list of doctors associated with the hospital.
     */
    @OneToMany(targetEntity = Doctor.class, cascade = CascadeType.ALL)
    @XmlElementWrapper(name = "doctors")
    @XmlElement(name = "doctor")
    private List<Doctor> doctorsList = new ArrayList<>();

    /**
     * The list of equipment associated with the hospital.
     */
    @OneToMany(targetEntity = Equipment.class, cascade = CascadeType.ALL)
    @XmlElementWrapper(name = "equipments")
    @XmlElement(name = "equipment")
    private List<Equipment> equipmentList = new ArrayList<>();

    /**
     * Default constructor
     */
    public Hospital() {
    }

    /**
      * Constructor for the Hospital class with parameters for all fields.
      * @param hospitalName The name of the hospital.
      * @param type The type of hospital.
      * @param address The street address of the hospital.
      * @param phoneNumber The phone number of the hospital.
      * @param doctorsList The list of doctors who work at the hospital.
      * @param equipmentList The list of equipment available at the hospital.
     */
    public Hospital(String hospitalName, String type, String address, String phoneNumber,
                    List<Doctor> doctorsList, List<Equipment> equipmentList) {
        this.hospitalName = hospitalName;
        this.type = type;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.doctorsList = doctorsList;
        this.equipmentList = equipmentList;
    }

    /**
      * Constructor for the Hospital class with parameters for all fields, including an ID.
      * @param id The ID of the hospital.
      * @param hospitalName The name of the hospital.
      * @param type The type of hospital.
      * @param address The street address of the hospital.
      * @param phoneNumber The phone number of the hospital.
      * @param doctorsList The list of doctors who work at the hospital.
      * @param equipmentList The list of equipment available at the hospital.
     */
    public Hospital(int id, String hospitalName, String type, String address, String phoneNumber, List<Doctor> doctorsList, List<Equipment> equipmentList) {
        this.id = id;
        this.hospitalName = hospitalName;
        this.type = type;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.doctorsList = doctorsList;
        this.equipmentList = equipmentList;
    }

    /**
     * Returns a string representation of this object, including its ID (if set), name, type, address,
     * phone number, and lists of doctors and equipment.
     * @return A string representation of the Hospital object.
     */
    @Override
    public String toString() {
        return String.format("""
                Hospital №%d,
                \tHospital name: %s,
                \tType: %s,
                \tAddress: %s,
                \tPhone number: %s, 
                \tDoctors:
                %s
                \tEquipments:
                %s
                """, this.id, this.hospitalName, this.type, this.address, this.phoneNumber,
                constructDoctorString(), constructEquipmentString());
    }

    /**
     * Constructs a string representation of the Equipment objects in the equipmentList field.
     * @return A string representation of the equipmentList field.
     */
    private String constructEquipmentString() {
        StringBuilder result = new StringBuilder();
        result.append("\t\t");
        for(Equipment equipment : this.equipmentList) {
            result.append(equipment.toString());
            result.append("\t\t");

        }
        return result.toString();
    }

    /**
     * Constructs a string representation of the Doctor objects in the doctorsList field.
     * @return A string representation of the doctorsList field.
     */
    private String constructDoctorString() {
        StringBuilder result = new StringBuilder();
        result.append("\t\t");
        for(Doctor doctor : this.doctorsList) {
            result.append(doctor.toString());
            result.append("\t\t");

        }
        return result.toString();
    }

    /**
     * Returns the ID of the hospital.
     * @return the ID of the hospital
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the ID of the hospital.
     * @param id the ID to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Returns the name of the hospital.
     * @return the name of the hospital
     */
    public String getHospitalName() {
        return hospitalName;
    }

    /**
     * Sets the name of the hospital.
     * @param hospitalName the name to set
     */
    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    /**
     * Returns the type of the hospital.
     * @return the type of the hospital
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the type of the hospital.
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Returns the address of the hospital.
     * @return the address of the hospital
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets the address of the hospital.
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Returns the phone number of the hospital.
     * @return the phone number of the hospital
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Sets the phone number of the hospital.
     * @param phoneNumber the phone number to set
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Returns the list of doctors associated with the hospital.
     * @return the list of doctors associated with the hospital
     */
    public List<Doctor> getDoctorsList() {
        return doctorsList;
    }

    /**
     * Sets the list of doctors associated with the hospital.
     * @param doctorsList the list of doctors to set
     */
    public void setDoctorsList(List<Doctor> doctorsList) {
        this.doctorsList = doctorsList;
    }

    /**
     * Returns the list of equipment associated with the hospital.
     * @return the list of equipment associated with the hospital
     */
    public List<Equipment> getEquipmentList() {
        return equipmentList;
    }

    /**
     * Sets the list of equipment associated with the hospital.
     * @param equipmentList the list of equipment to set
     */
    public void setEquipmentList(List<Equipment> equipmentList) {
        this.equipmentList = equipmentList;
    }
}
