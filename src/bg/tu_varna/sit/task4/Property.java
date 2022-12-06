package bg.tu_varna.sit.task4;

import java.util.Objects;

public abstract class Property implements PriceCalculator, Comparable<Property>{
    private double area;
    private double basePrice;
    private PropertyType propertyType;

    public Property(double area, double basePrice, PropertyType propertyType) {
        this.area = area;
        this.basePrice = basePrice;
        this.propertyType = propertyType;
    }

    public double getArea() {
        return area;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public PropertyType getPropertyType() {
        return propertyType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Property property = (Property) o;
        return Double.compare(property.getArea(), getArea()) == 0 && Double.compare(property.getBasePrice(), getBasePrice()) == 0 && getPropertyType() == property.getPropertyType();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getArea(), getBasePrice(), getPropertyType());
    }

    @Override
    public String toString() {
        return "Property: " +
                "\n Area: " + area +
                "\n Base Price: " + basePrice +
                "\n Property Type: " + propertyType;
    }

    @Override
    public double calculate() {
        return basePrice*area;
    }

    @Override
    public int compareTo(Property o) {
        return (int) (this.area - o.getArea());
    }
}
