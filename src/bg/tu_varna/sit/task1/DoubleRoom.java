package bg.tu_varna.sit.task1;

import com.sun.source.tree.IfTree;

public class DoubleRoom extends Room{
    private int days;
    private boolean hasChildren;

    public int getDays() {
        return days;
    }

    public boolean isHasChildren() {
        return hasChildren;
    }

    public DoubleRoom(double pricePerDay, Exposure exposure, int days, boolean hasChildren) {
        super(pricePerDay, exposure);
        this.days = days;
        this.hasChildren = hasChildren;
    }

    @Override
    public String toString() {
        return super.toString() + " Days of reservation: " + this.days +
                "\n Has Children: " + this.hasChildren;
    }

    @Override
    public double calculateStayPrice() {
        return this.days * this.getPricePerDay() + 10;
    }

    @Override
    public double discount() {
        if (this.days > 5 && hasChildren) return calculateStayPrice() * 0.15;
        else return 0;
    }
}
