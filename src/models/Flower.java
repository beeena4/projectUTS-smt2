package models;

public class Flower {
    private String namaPembeli; // atribut private
    private String nama; // atribut private
    private double harga; // atribut private
    private String kategori; // atribut private

    // konstruktor
    public Flower(String nama, double harga, String kategori){
            this.nama = nama;
            this.harga = harga;
            this.kategori = kategori;
    }

    // metode getter untuk nama pembeli
    public String getNamaPembeli() {
        return namaPembeli;
    }
    // metode setter untuk nama pembeli
    public void setNamaPembeli(String namaPembeli) {
        this.namaPembeli = namaPembeli;
    }
    // metode getter untuk nama bunga
    public String getNama() {
        return nama;
    }
    // metode setter untuk nama bunga
    public void setNama(String nama) {
        this.nama = nama;
    }
    // metode getter untuk harga
    public double getHarga() {
        return harga;
    }
    // metode setter untuk harga
    public void setHarga(double harga) {
        if (harga >= 0) {
            this.harga = harga;
        } else {
            System.out.println("[ERROR] Harga yang dimasukkan tidak valid");
        }
    }
    // metode getter untuk kategori
    public String getKategori() {
        return kategori;
    }
    // metode setter untuk kategori
    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    // Inner class untuk menyimpan informasi lengkap bunga
    public class FlowerInfo {
    public String getFullInfo() {
        return "Nama: " + nama + " | Harga: Rp " + harga + " | Kategori: " + kategori;
    }
}
}
   
