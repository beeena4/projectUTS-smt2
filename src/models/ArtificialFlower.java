package models;

public class ArtificialFlower extends Flower { // inheritance
    private String material; // atribut private untuk menyimpan material bunga

    // konstruktor
    public ArtificialFlower(String nama, double harga, String kategori, String material) {
        super(nama, harga, kategori);
        this.material = material; // inisialisasi atribut material
    }

    // metode getter untuk material
    public String getMaterial() {
        return material;
    }
    // metode setter untuk material
    public void setMaterial(String material) {
        this.material = material;
    }

    // override toString untuk menampilkan informasi ArtificialFlower
    @Override
    public String toString() {
        return String.format("%s\n%-20s: %s\n%-20s: %s",super.toString(),"Kategori", "Artificial Flower","Material", material);
    }
}