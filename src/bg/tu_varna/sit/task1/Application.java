package bg.tu_varna.sit.task1;

public class Application {
    public static void main(String[] args) {
        Hotel habbo = new Hotel();

        SingleRoom singleRoom1 = new SingleRoom(50.50,Exposure.PARK_VIEW, 5);
        SingleRoom singleRoom2 = new SingleRoom(47.50,Exposure.SEA_VIEW, 2);
        SingleRoom singleRoom3 = new SingleRoom(38.99,Exposure.SEA_VIEW, 7);

        DoubleRoom doubleRoom1 = new DoubleRoom(90.45,Exposure.SEA_VIEW,7,true);
        DoubleRoom doubleRoom2 = new DoubleRoom(70,Exposure.PARK_VIEW,14,true);
        DoubleRoom doubleRoom3 = new DoubleRoom(84.50,Exposure.SEA_VIEW,3,false);

        habbo.addRoom(singleRoom1);
        habbo.addRoom(singleRoom2);
        habbo.addRoom(singleRoom2);
        habbo.addRoom(singleRoom3);
        habbo.addRoom(doubleRoom1);
        habbo.addRoom(doubleRoom2);
        habbo.addRoom(doubleRoom2);
        habbo.addRoom(doubleRoom3);

        habbo.createReservation(doubleRoom1);
        habbo.createReservation(singleRoom3);
        habbo.createReservation(doubleRoom2);


        System.out.printf("Booked Rooms Discount: %.2f\n", habbo.calculateBookedRoomsDiscount());
        System.out.println();
        System.out.printf("Average price of available rooms with sea view: %.2f\n" + habbo.calculateAveragePriceOfAvailableRoomsWithSeaView());
        System.out.println();
        System.out.println("All Rooms:\n" + habbo.toString());
    }
}
