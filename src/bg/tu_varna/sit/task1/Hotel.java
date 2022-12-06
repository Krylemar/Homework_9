package bg.tu_varna.sit.task1;

import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private List<Room> rooms;

    public Hotel() {
        this.rooms = new ArrayList<>();
    }

    public boolean addRoom(Room room){
        return rooms.add(room);
    }

    public boolean createReservation(Room paramRoom){
        for (Room room : rooms) {
            if (room.getClass().equals(paramRoom.getClass()) && room.isAvailable()){
                room.setAvailable(false);
                return true;
            }
        }
        return false;
    }

    public double calculateBookedRoomsDiscount(){
        double totalDiscount = 0.00d;
        for (Room room : rooms) {
            if (!room.isAvailable()){
                totalDiscount += room.discount();
            }
        }
        return totalDiscount;
    }

    public double calculateAveragePriceOfAvailableRoomsWithSeaView(){ //amen
        double totalDiscount = 0.00d;
        int count = 0;
        for (Room room : rooms) {
            if (room.isAvailable() && room.getExposure() == Exposure.SEA_VIEW){
                totalDiscount += room.calculateReservationPrice();
                count++;
            }
        }
        return totalDiscount / count;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Room room : rooms) {
            stringBuilder.append(room.toString()).append("\n\n");
        }
        return stringBuilder.toString();
    }
}
