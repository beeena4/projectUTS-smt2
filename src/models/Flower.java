package models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Flower {
    private String namaPembeli; // atribut private nama pembeli
    private String nama; // atribut private nama bunga
    private double harga; // atribut private harga bunga
    private String kategori; // atribut private kategori

    // konstruktor
    public Flower(String nama, double harga, String kategori){
            this.nama = nama;
            this.harga = harga;
            this.kategori = kategori;
    }

    // INNER CLASS ORDER - untuk pemesanan bunga
    public class Order {
        private int jumlah; // jumlah bunga yang dipesan
        private double totalHarga; // total harga sebelum diskon
        private double diskon; // diskon yang didapatkan
        private double totalPembayaran; // total harga setelah diskon
        private LocalDateTime tanggalPemesanan; // waktu pemesanan bunga

        // konstruktor order
        public Order(int jumlah) {
            this.jumlah = jumlah;
            this.totalHarga = harga * jumlah;
            this.diskon = hitungDiskon(); // hitung diskon berdasarkan jumlah pembelian
            this.totalPembayaran = totalHarga - diskon;
            this.tanggalPemesanan = LocalDateTime.now(); 
        }

        // metode untuk menghitung diskon berdasarkan jumlah pembelian
        private double hitungDiskon() {
            if (jumlah > 10) return 0.20 * totalHarga; // Diskon 20% jika beli lebih dari 10
            if (jumlah > 5) return 0.10 * totalHarga;  // Diskon 10% jika beli lebih dari 5
            return 0;
        }

        // 
        public void displayOrder() {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy, HH:mm:ss");
            String formattedDate = tanggalPemesanan.format(formatter);
            String infoToko = "BEE florist | Jl. Flamboyan Raya No. 05"; // informasi toko

            System.out.println("\nPesanan berhasil!");
            System.out.println("================================================================");
            System.out.println(">>                      INFORMASI PESANAN                     <<");
            System.out.println("================================================================");
            System.out.printf("%-63s %n", infoToko); 
            System.out.printf("%-63s %n", formattedDate);  
            System.out.println("----------------------------------------------------------------");
            System.out.printf("Nama                  : %s%n", nama);
            System.out.printf("Jumlah                : %d%n", jumlah);
            System.out.printf("Total Harga           : Rp %,10.2f%n", totalHarga);
            System.out.printf("Diskon                : Rp %,10.2f%n", diskon);
            System.out.printf("Total Pembayaran      : Rp %,10.2f%n", totalPembayaran);
            System.out.println("----------------------------------------------------------------");
        }

        public double getTotalPembayaran() {
            return totalPembayaran;
        }
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

    // override toString untuk menampilkan informasi bunga
    @Override
    public String toString() {
        return String.format("%-20s: %s\n%-20s: Rp %,10.2f", "Nama", nama,"Harga", harga);
    }   
}