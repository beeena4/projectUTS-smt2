package models;

public class ArtificialFlower extends Flower {
    private String material;

    public ArtificialFlower(String nama, double harga, String kategori, String material) {
        super(nama, harga, kategori);
        this.material = material;
    }

    @Override
    public void displayInfo() {
        System.out.printf("Nama: %s | Harga: Rp %,10.2f | Material: %s%n",
                getNama(), getHarga(), material);
    }
}
