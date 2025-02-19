/**
 * Bicycle class models the information about a bike.
 * Data includes bike ID, owner’s name, type, serial number, brake type, and wheel size.
 * It has setters to enable altering of bike attributes and getters for comparisons.
 */
public class Bicycle {
    // data fields
    private int bikeID;
    private String owner;
    private int wheelSize;
    private String brakeType;
    private String type;
    private String serialNum;

    // constructor
    public Bicycle(int bikeID, String owner, int wheelSize, String type, String serialNum, String brakeType) {
        this.bikeID = bikeID;
        this.owner = owner;
        this.wheelSize = wheelSize;
        this.type = type;
        this.serialNum = serialNum;
        this.brakeType = brakeType;
    }

    // setters
    public void setOwner(String owner) {
        this.owner = owner;
    }

    public void setWheelSize(int wheelSize) {
        this.wheelSize = wheelSize;
    }

    public void setBrakeType(String brakeType) {
        this.brakeType = brakeType;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setSerialNum(String serialNum) {
        this.serialNum = serialNum;
    }

    // getters
    public int getBikeID() {
        return bikeID;
    }

    public String getOwner() {
        return owner;
    }

    public int getWheelSize() {
        return wheelSize;
    }

    public String getBrakeType() {
        return brakeType;
    }

    public String getType() {
        return type;
    }

    public String getSerialNum() {
        return serialNum;
    }


}
