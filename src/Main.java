package utils;

import models.Flower;
import models.FreshFlower;
import models.ArtificialFlower;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static ArrayList<Flower> listFlowers = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        displayJudul(scanner);

        listFlowers.add(new FreshFlower("Calla Lily", 10000, "Fresh", 2));
        listFlowers.add(new FreshFlower("Red Rose", 5000, "Fresh", 4));
        listFlowers.add(new FreshFlower("Sun Flower", 10000, "Fresh", 1));
        listFlowers.add(new ArtificialFlower("Pink Rose", 15000, "Artificial", "Satin"));
        listFlowers.add(new ArtificialFlower("Sweet Pea", 10000, "Artificial", "Plastic"));
        listFlowers.add(new ArtificialFlower("Peruvian Lily", 10000, "Artificial", "Paper"));

        while (true) {
            try {
                displayMenu();
                int pilihan = scanner.nextInt();
                scanner.nextLine();

                switch (pilihan) {
                    case 1 -> displayDaftarBunga();
                    case 2 -> displayDaftarBerdasarHarga();
                    case 3 -> displayCariBungaBerdasarNama(scanner);
                    case 4 -> {
                        displayFooter();
                        return;
                    }
                    default -> System.out.println("\n[ERROR] | Pilihan tidak valid. Silahkan coba lagi.");
                }
            } catch (InputMismatchException e) {
                System.out.println("\n[ERROR] | INPUT HARUS ANGKA.");
                scanner.nextLine();
            }
        }
    }

    public static void displayJudul(Scanner scanner) {
        System.out.println("\n=======================================");
        System.out.println(">>            BEE FLORIST            <<");
        System.out.println("=======================================");
        System.out.print("Nama : ");
        String namaPembeli = scanner.nextLine();
        System.out.println("\nSelamat datang di BEE FLORIST, " + namaPembeli + "!");
    }

    public static void displayMenu() {
        System.out.println("\n=======================================");
        System.out.println("||>>             M E N U           <<||");
        System.out.println("=======================================");
        System.out.println("| 1. Tampilkan Daftar Bunga           |");
        System.out.println("| 2. Tampilkan Bunga Berdasarkan Harga|");
        System.out.println("| 3. Cari Bunga Berdasarkan Nama      |");
        System.out.println("| 4. Edit Bunga                       |");
        System.out.println("| 5. Pesan Bunga                      |");
        System.out.println("| 6. Keluar                           |");
        System.out.println("=======================================");
        System.out.print("Pilih menu (1-6): ");
    }

    public static void displayDaftarBunga() {
        System.out.println("\n---------------------------------------");
        System.out.printf("%-20s | %10s%n", "Nama Bunga", "Harga");
        System.out.println("---------------------------------------");
        for (Flower m : listFlowers) {
            System.out.printf("%-20s | Rp %,d%n", m.getNama(), (int) m.getHarga());
        }
    }

    public static void displayDaftarBerdasarHarga() {
        listFlowers.sort(Comparator.comparingDouble(Flower::getHarga));
        displayDaftarBunga();
    }

    public static void displayCariBungaBerdasarNama(Scanner scanner) {
        System.out.print("\nMasukkan nama bunga yang ingin dicari: ");
        String searchName = scanner.nextLine();
        for (Flower m : listFlowers) {
            if (m.getNama().equalsIgnoreCase(searchName)) {
                System.out.println("\nBunga ditemukan:");
                System.out.printf("Nama  : %s%nHarga : Rp %,d%n", m.getNama(), (int) m.getHarga());
                return;
            }
        }
        System.out.println("\n[ERROR] | Bunga tidak ditemukan!");
    }

    public static void displayFooter() {
        System.out.println("\nTerima kasih telah berbelanja!");
    }


class Flower {
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

}