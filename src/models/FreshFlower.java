package models;

public class FreshFlower extends Flower {
    private int dayFresh;

    public FreshFlower(String nama, double harga, String kategori, int dayFresh) {
        super(nama, harga, kategori);
        this.dayFresh = dayFresh;
    }

    public int getDayFresh() {
        return dayFresh;
    }

    public void setDayFresh(int dayFresh) {
        this.dayFresh = dayFresh;
    }

    @Override
    public String toString() {
        return super.toString() + ", Day Fresh: " + dayFresh + " hari";
    }
}
