package bg.tu_varna.sit.task1;

public abstract class Room implements PriceCalculator{
    private double pricePerDay;
    private Exposure exposure;
    private boolean available;

    public Room(double pricePerDay, Exposure exposure) {
        this.pricePerDay = pricePerDay;
        this.exposure = exposure;
        this.available = true;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public double getPricePerDay() {
        return pricePerDay;
    }

    public Exposure getExposure() {
        return exposure;
    }

    @Override
    public double calculateReservationPrice() {
        return calculateStayPrice() - discount();
    }

    @Override
    public String toString() {
        return "Room: \n Price Per Day: " + this.pricePerDay +
                "\n Exposure: " + this.exposure.toString() +
                "\n Availability: " + this.available + "\n";
    }
}
