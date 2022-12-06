package bg.tu_varna.sit.task1;

public class SingleRoom extends Room{
    private int days;

    public SingleRoom(double pricePerDay, Exposure exposure, int days) {
        super(pricePerDay, exposure);
        this.days = days;
    }

    public int getDays() {
        return days;
    }

    @Override
    public String toString() {
        return super.toString() + " Days of reservation: " + this.days;
    }

    @Override
    public double calculateStayPrice() {
        return days* this.getPricePerDay();
    }

    @Override
    public double discount() {
        if (days > 3){
            return calculateStayPrice() * 0.1;
        }
        else return 0;
    }
}
