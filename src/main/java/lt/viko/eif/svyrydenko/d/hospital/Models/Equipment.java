package lt.viko.eif.svyrydenko.d.hospital.Models;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import javax.persistence.*;

/**
 * This class represents equipment that can be used in various facilities.
 * The class contains properties such as name, model number, manufacturer, type, and location.
 * Each equipment is uniquely identified by its ID.
 **/
@Entity
@Table(name="equipment")
@XmlAccessorType(XmlAccessType.FIELD)
public class Equipment {
    /**
     * The unique identifier for the equipment.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    /**
     * The name of the equipment.
     */
    private String name;

    /**
     * The model number of the equipment.
     */
    private int modelNumber;

    /**
     * The manufacturer of the equipment.
     */
    private String manufacturer;

    /**
     * The type of the equipment.
     */
    private String type;

    /**
     * The location of the equipment.
     */
    private String location;

    /**
     * Default constructor for the equipment class.
     */
    public Equipment() {

    }

    /**
     * Creates a new instance of Equipment with the given values.
     * @param name The name of the equipment.
     * @param modelNumber The model number of the equipment.
     * @param manufacturer The manufacturer of the equipment.
     * @param type The type of the equipment.
     * @param location The location of the equipment.
     */
    public Equipment(String name, int modelNumber, String manufacturer, String type, String location) {
        this.name = name;
        this.modelNumber = modelNumber;
        this.manufacturer = manufacturer;
        this.type = type;
        this.location = location;
    }

    /**
     * Creates a new instance of Equipment with the given values.
     * @param id The unique identifier for the equipment.
     * @param name The name of the equipment.
     * @param modelNumber The model number of the equipment.
     * @param manufacturer The manufacturer of the equipment.
     * @param type The type of the equipment.
     * @param location The location of the equipment.
     */
    public Equipment(int id, String name, int modelNumber, String manufacturer, String type, String location) {
        this.id = id;
        this.name = name;
        this.modelNumber = modelNumber;
        this.manufacturer = manufacturer;
        this.type = type;
        this.location = location;
    }

    /**
     * Returns a string representation of the Equipment object.
     * @return a formatted string representation of the object's fields.
     */
    @Override
    public String toString() {
        return String.format("""
                Equipment name: %s,
                \t\tModel number: %d,
                \t\tManufacturer: %s,
                \t\tType: %s,
                \t\tLocation: %s;
                """, this.name, this.modelNumber, this.manufacturer, this.type, this.location);
    }

    /**
     * Returns the ID of the equipment object.
     * @return the ID of the equipment object.
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the ID of the equipment object.
     * @param id the new ID to set.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Returns the name of the equipment object.
     * @return the name of the equipment object.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the equipment object.
     * @param name the new name to set.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the model number of the equipment object.
     * @return the model number of the equipment object.
     */
    public int getModelNumber() {
        return modelNumber;
    }

    /**
     * Sets the model number of the equipment object.
     * @param modelNumber the new model number to set.
     */
    public void setModelNumber(int modelNumber) {
        this.modelNumber = modelNumber;
    }

    /**
     * Returns the manufacturer of the equipment object.
     * @return the manufacturer of the equipment object.
     */
    public String getManufacturer() {
        return manufacturer;
    }

    /**
     * Sets the manufacturer of the equipment object.
     * @param manufacturer the new manufacturer to set.
     */
    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    /**
     * Returns the type of this equipment.
     * @return the type of this equipment.
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the type of this equipment.
     * @param type the new type of this equipment.
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Returns the location of this equipment.
     * @return the location of this equipment.
     */
    public String getLocation() {
        return location;
    }

    /**
     * Sets the location of this equipment.
     * @param location the new location of this equipment.
     */
    public void setLocation(String location) {
        this.location = location;
    }
}
