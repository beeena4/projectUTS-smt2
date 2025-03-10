package models;
class FreshFlower extends Flower {
    private int freshnessDays; // Berapa lama bunga tetap segar

    public FreshFlower(String nama, double harga, String kategori, int freshnessDays) {
        super(nama, harga, kategori);
        this.freshnessDays = freshnessDays;
    }

    public int getFreshnessDays() {
        return freshnessDays;
    }

    public void setFreshnessDays(int freshnessDays) {
        this.freshnessDays = freshnessDays;
    }

    @Override
    public void displayInfo() {
        System.out.printf("Nama: %s | Harga: Rp %,10.2f | Kategori: %s | Freshness: %d hari%n",
                getNama(), getHarga(), getKategori(), freshnessDays);
    }
}
