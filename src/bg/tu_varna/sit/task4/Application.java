package bg.tu_varna.sit.task4;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<Property> properties = new ArrayList<Property>();
        properties.add(new House(80,90000,PropertyType.NEW,2,true));
        properties.add(new House(90,125000,PropertyType.OLD,1,false));
        properties.add(new Apartment(65, 100000,PropertyType.NEW,7,5,Exposition.SOUTHWEST,false));
        properties.add(new Apartment(80,130000,PropertyType.OLD,5, 7,Exposition.NORTH,true));
        properties.add(new Apartment(70, 120000,PropertyType.OLD,3,4,Exposition.WEST,true));
        House house = new House(40,70000,PropertyType.NEW ,3,true);

        RealEstateAgency realEstateAgency = new RealEstateAgency(properties);
        realEstateAgency.addProperty(house);

        System.out.printf("Price of all properties: %.2f \n", realEstateAgency.calculatePriceOfAllProperties());
        System.out.println();
        List<Property> propertyList = realEstateAgency.sortPropertiesByArea();
        System.out.println("Properties, sorted by area: ");
        for (Property property : propertyList) {
            System.out.println(property.toString()+"\n");
        }
        propertyList = realEstateAgency.sortPropertiesByPrice();
        System.out.println("Properties, sorted by price: ");
        for (Property property : propertyList) {
            System.out.println(property.toString()+"\n");
        }
        System.out.println();
        System.out.println("Number of properties by type New: "+ realEstateAgency.getNumberOfPropertiesByType(PropertyType.NEW));
        System.out.println();
        System.out.println("Number of available houses: "+realEstateAgency.getNumberOfAvailableHouses());
        System.out.println();
        System.out.println("All properties: \n" + realEstateAgency.toString());
    }
}
