package lt.viko.eif.svyrydenko.d.hospital.Models;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import javax.persistence.*;
/**
 * An entity class representing a hospital room.
 * This class is mapped to a database table named "hospital_room".
 * It contains fields for room number, type, capacity, and floor.
 */
@Entity
@Table(name="hospital_room")
@XmlAccessorType(XmlAccessType.FIELD)
public class HospitalRoom {
    /**
     * The id of the hospital room.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    /**
     * The room number of the hospital room.
     */
    private int roomNumber;

    /**
     * The type of the hospital room.
     */
    private String type;

    /**
     * The maximum capacity of the hospital room.
     */
    private int capacity;

    /**
     * The floor where the hospital room is located.
     */
    private int floor;

    /**
     * Default constructor for HospitalRoom class.
     */
    public HospitalRoom() {
    }

    /**
     * Constructor for HospitalRoom class.
     * @param roomNumber The room number of the hospital room.
     * @param type The type of the hospital room.
     * @param capacity The maximum capacity of the hospital room.
     * @param floor The floor where the hospital room is located.
     */
    public HospitalRoom(int roomNumber, String type, int capacity, int floor) {
        this.roomNumber = roomNumber;
        this.type = type;
        this.capacity = capacity;
        this.floor = floor;
    }

    /**
     * Constructor for HospitalRoom class.
     * @param id The id of the hospital room.
     * @param roomNumber The room number of the hospital room.
     * @param type The type of the hospital room.
     * @param capacity The maximum capacity of the hospital room.
     * @param floor The floor where the hospital room is located.
     */
    public HospitalRoom(int id, int roomNumber, String type, int capacity, int floor) {
        this.id = id;
        this.roomNumber = roomNumber;
        this.type = type;
        this.capacity = capacity;
        this.floor = floor;
    }

    /**
     * Returns a string representation of the HospitalRoom object.
     */
    @Override
    public String toString() {
        return String.format("""
            Patient's hospital room:
            \t\t\t\t\tRoom number: %d,
            \t\t\t\t\tType: %s,
            \t\t\t\t\tCapacity: %d,
            \t\t\t\t\tFloor: %d;""", this.roomNumber, this.type, this.capacity, this.floor);
    }

    /**
     * Returns the unique identifier of the object.
     * @return the unique identifier of the object.
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the unique identifier of the object.
     * @param id the new unique identifier of the object.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Returns the room number of the object.
     * @return the room number of the object.
     */
    public int getRoomNumber() {
        return roomNumber;
    }

    /**
     * Sets the room number of the object.
     * @param roomNumber the new room number of the object.
     */
    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    /**
     * Returns the type of the object.
     * @return the type of the object.
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the type of the object.
     * @param type the new type of the object.
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Returns the capacity of the object.
     * @return the capacity of the object.
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * Sets the capacity of the object.
     * @param capacity the new capacity of the object.
     */
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    /**
     * Returns the floor of the object.
     * @return the floor of the object.
     */
    public int getFloor() {
        return floor;
    }

    /**
     * Sets the floor of the object.
     * @param floor the new floor of the object.
     */
    public void setFloor(int floor) {
        this.floor = floor;
    }
}
