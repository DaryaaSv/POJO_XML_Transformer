package lt.viko.eif.svyrydenko.d.hospital.Models;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import javax.persistence.*;

/**
 * The Illness class represents an illness object, which contains information about a particular illness such as
 * its name, diagnosis, details and remarks. The class is marked with the @Entity annotation,
 * which indicates that it is an entity and will be mapped to a database table.
 * The @Table annotation is used to specify the name of the table to which the entity is mapped.
 * An instance of this class corresponds to a row in the "illness" table in the database.
 * The class has several fields that represent the attributes of an illness.
 */
@Entity
@Table(name="illness")
@XmlAccessorType(XmlAccessType.FIELD)
public class Illness {

    /**
     *The unique identifier of the illness.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    /**
     * The name of the illness.
     */
    private String name;

    /**
     * The diagnosis of the illness.
     */
    private String diagnose;

    /**
     * Additional details about the illness.
     */
    private String details;

    /**
     * Remarks about the illness.
     */
    private String remarks;

    /**
     * Creates a new instance of Illness with default values for its fields.
     */
    public Illness() {
    }

    /**
     * Creates a new instance of Illness with the specified values for its fields.
     * @param name The name of the illness.
     * @param diagnose The diagnosis of the illness.
     * @param details Additional details about the illness.
     * @param remarks Remarks about the illness.
     */
    public Illness(String name, String diagnose, String details, String remarks) {
        this.diagnose = diagnose;
        this.name = name;
        this.details = details;
        this.remarks = remarks;
    }

    /**
     * Creates a new instance of Illness with the specified values for its fields, including its unique identifier.
     * @param id The unique identifier of the illness.
     * @param name The name of the illness.
     * @param diagnose The diagnosis of the illness.
     * @param details Additional details about the illness.
     * @param remarks Remarks about the illness.
     */
    public Illness(int id, String name, String diagnose, String details, String remarks) {
        this.id = id;
        this.name = name;
        this.diagnose = diagnose;
        this.details = details;
        this.remarks = remarks;
    }

    /**
     * Returns a string representation of this Illness instance which contains all information.
     * @return A string representation of this Illness instance.
     */
    @Override
    public String toString() {
        return String.format("""
            \n\t\t\t\t\t\tName of the illness: %s,
            \t\t\t\t\t\tDiagnose: %s,
            \t\t\t\t\t\tDetails: %s,
            \t\t\t\t\t\tRemarks: %s;""", this.name, this.diagnose, this.details, this.remarks);
    }

    /**
     * Returns the name of the illness.
     * @return The name of the illness.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the illness.
     * @param name The new name of the illness.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the unique identifier of the illness.
     * @return The unique identifier of the illness.
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the unique identifier of the illness.
     * @param id The new unique identifier of the illness.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Returns the diagnosis of the illness.
     * @return The diagnosis of the illness.
     */
    public String getDiagnose() {
        return diagnose;
    }

    /**
     * Sets the diagnosis of the illness.
     * @param diagnose The diagnosis of the illness.
     */
    public void setDiagnose(String diagnose) {
        this.diagnose = diagnose;
    }

    /**
     * Gets the details of the illness.
     * @return The details of the illness.
     */
    public String getDetails() {
        return details;
    }

    /**
     * Sets the details of the illness.
     * @param details The details of the illness.
     */
    public void setDetails(String details) {
        this.details = details;
    }

    /**
     * Gets the remarks of the illness.
     * @return The remarks of the illness.
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * Sets the remarks of the illness.
     * @param remarks The remarks of the illness.
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}