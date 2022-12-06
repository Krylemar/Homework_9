package bg.tu_varna.sit.task4;

import java.util.Objects;

public class House extends Property{
    private int numberOfFloors;
    private boolean hasGarden;

    public House(double area, double basePrice, PropertyType propertyType, int numberOfFloors, boolean hasGarden) {
        super(area, basePrice, propertyType);
        this.numberOfFloors = numberOfFloors;
        this.hasGarden = hasGarden;
    }

    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    public boolean isHasGarden() {
        return hasGarden;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        House house = (House) o;
        return getNumberOfFloors() == house.getNumberOfFloors() && isHasGarden() == house.isHasGarden();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getNumberOfFloors(), isHasGarden());
    }

    @Override
    public String toString() {
        return super.toString() +
                "\n Number of Floors: " + this.numberOfFloors+
                "\n Has Garden: " +this.hasGarden;
    }

    @Override
    public double calculate() {
        if (this.getPropertyType() == PropertyType.NEW && hasGarden && numberOfFloors > 1) return this.getBasePrice() + getBasePrice() * 0.2;
        if (hasGarden) return this.getBasePrice() + getBasePrice() * 0.1;
        return this.getBasePrice() + getBasePrice() * 0.07;
    }
}
