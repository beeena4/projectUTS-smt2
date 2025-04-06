package models;

public class FreshFlower extends Flower { // inheritance 
    private int dayFresh; // atribut private untuk menyimpan ketahanan bunga

    // konstruktor
    public FreshFlower(String nama, double harga, String kategori, int dayFresh) {
        super(nama, harga, kategori);
        this.dayFresh = dayFresh; // inisialisasi atribut dayFresh
    }
    // metode getter untuk dayfresh
    public int getDayFresh() {
        return dayFresh;
    }

    // metode setter untuk dayfresh
    public void setDayFresh(int dayFresh) {
        this.dayFresh = dayFresh;
    }

    // override toString untuk menampilkan informasi FreshFlower
    @Override
    public String toString() {
        return String.format("%s\n%-20s: %s\n%-20s: %d hari", super.toString(),"Kategori", "Fresh Flower","Day Fresh", dayFresh);
    }
}