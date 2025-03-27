package models;

public class FreshFlower extends Flower {
    private int dayFresh; // atribut private

    public FreshFlower(String nama, double harga, String kategori, int dayFresh) {
        super(nama, harga, kategori);
        this.dayFresh = dayFresh;
    }
    // metode getter untuk dayfresh
    public int getDayFresh() {
        return dayFresh;
    }

    // metode setter untuk dayfresh
    public void setDayFresh(int dayFresh) {
        this.dayFresh = dayFresh;
    }

    @Override
    public String toString() {
        return String.format("%s\n%-12s: %s\n%-12s: %d hari", super.toString(),"Kategori", "Fresh Flower","Day Fresh", dayFresh);
    }
}