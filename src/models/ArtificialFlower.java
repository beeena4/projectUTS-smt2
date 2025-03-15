package models;

public class ArtificialFlower extends Flower {
    private String material; // atribut private

    public ArtificialFlower(String nama, double harga, String kategori, String material) {
        super(nama, harga, kategori);
        this.material = material;
    }

    // metode getter untuk material
    public String getMaterial() {
        return material;
    }
    // metode setter untuk material
    public void setMaterial(String material) {
        this.material = material;
    }

}
