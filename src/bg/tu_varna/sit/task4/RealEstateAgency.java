package bg.tu_varna.sit.task4;

import java.util.*;

public class RealEstateAgency {
    private List<Property> properties;

    public RealEstateAgency(Collection<Property> properties) {
        this.properties = new ArrayList<>();
        this.properties.addAll(properties);
    }

    public boolean addProperty(Property prop){
        return properties.add(prop);
    }

    public double calculatePriceOfAllProperties(){
        double totalPrice = 0.0d;
        for (Property property : properties) {
            if (property != null) {
                totalPrice += property.calculate();
            }
        }
        return totalPrice;
    }

    public List<Property> sortPropertiesByArea(){
        List<Property> temp = new ArrayList<>(properties);
        temp.sort(Comparator.comparing(Property::getArea));
        return temp;
    }

    public List<Property> sortPropertiesByPrice(){
        List<Property> temp = new ArrayList<>(properties);
        temp.sort(Comparator.comparingDouble(Property::calculate));
        return temp;
    }

    public int getNumberOfPropertiesByType(PropertyType propertyType){
        int count = 0;
        for (Property property : properties) {
            if (property != null) {
                if (property.getPropertyType() == propertyType) count++;
            }
        }
        return count;
    }

    public int getNumberOfAvailableHouses(){
        int count = 0;
        for (Property property : properties) {
            if (property instanceof House) count ++;
        }
        return count;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Property property : properties) {
            stringBuilder.append(property.toString()).append("\n\n");
        }
        return stringBuilder.toString();
    }
}
