package bg.tu_varna.sit.task4;

import java.util.Objects;

public class Apartment extends Property{
    private int floorNumber;
    private int numberOfRooms;
    private Exposition exposition;
    private boolean hasParkingSpace;

    public Apartment(double area, double basePrice, PropertyType propertyType, int floorNumber, int numberOfRooms, Exposition exposition, boolean hasParkingSpace) {
        super(area, basePrice, propertyType);
        this.floorNumber = floorNumber;
        this.numberOfRooms = numberOfRooms;
        this.exposition = exposition;
        this.hasParkingSpace = hasParkingSpace;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public Exposition getExposition() {
        return exposition;
    }

    public boolean hasParkingSpace() {
        return hasParkingSpace;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Apartment apartment = (Apartment) o;
        return getFloorNumber() == apartment.getFloorNumber() && getNumberOfRooms() == apartment.getNumberOfRooms() && hasParkingSpace() == apartment.hasParkingSpace() && getExposition() == apartment.getExposition();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getFloorNumber(), getNumberOfRooms(), getExposition(), hasParkingSpace());
    }

    @Override
    public String toString() {
        return super.toString() +
                "\n Floor Number: " + floorNumber +
                "\n Number Of Rooms: " + numberOfRooms +
                "\n Exposition: " + exposition +
                "\n Parking Space: " + hasParkingSpace;
    }

    @Override
    public double calculate() {
        if (this.getPropertyType() == PropertyType.NEW && (this.exposition == Exposition.SOUTH || this.exposition == Exposition.WEST || this.exposition == Exposition.SOUTHWEST)){
            if (this.getArea() > 50 && this.hasParkingSpace)
                return this.getBasePrice() + this.getBasePrice() * 0.25;
            else return this.getBasePrice() + this.getBasePrice() * 0.2;
        }
        if (this.getPropertyType() == PropertyType.NEW) return this.getBasePrice() + this.getBasePrice() * 0.15;
        if (this.getPropertyType() == PropertyType.OLD && hasParkingSpace) return this.getBasePrice() + this.getBasePrice() * 0.18;
        return this.getBasePrice() + this.getBasePrice() * 0.12;
    }
}
