package app;

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

        // Menambahkan bunga ke daftar
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
                    case 3 -> displayBungaBerdasarKategori();
                    case 4 -> displayCariBungaBerdasarNama(scanner);
                    case 5 -> editBunga(scanner);
                    case 6 -> displayProsesPesanBunga(scanner);
                    case 7 -> {
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
        System.out.println("\n================================================================");
        System.out.println("|>>                       Selamat Datang di                  <<|");
        System.out.println("|>                          'BEE FLORIST'                     <|");
        System.out.println("|>>   Rangkai bunga terbaik untuk setiap moment spesial! ;)  <<|");
        System.out.println("================================================================");
        System.out.print("Nama : ");
        String namaPembeli = scanner.nextLine();
        System.out.println("\nHallo, " + namaPembeli + "!");
        System.out.println("Kami memiliki beberapa pilihan menu ;)");
    }

    public static void displayMenu() {
        System.out.println("\n================================================================");
        System.out.println("||>>                          M E N U                       <<||");
        System.out.println("================================================================");
        System.out.println("| 1. Tampilkan Daftar Bunga                                    |");
        System.out.println("| 2. Tampilkan Bunga Berdasarkan Harga                         |");
        System.out.println("| 3. Tampilkan Bunga Berdasarkan Kategori                      |");
        System.out.println("| 4. Cari Bunga Berdasarkan Nama                               |");
        System.out.println("| 5. Edit Bunga                                                |");
        System.out.println("| 6. Pesan Bunga                                               |");
        System.out.println("| 7. Keluar                                                    |");
        System.out.println("================================================================");
        System.out.print("Pilih menu (1-7): ");
    }

    public static void displayDaftarBunga() {
        System.out.println("\n----------------------------------------------------------------");
        System.out.printf("| %-3s | %-20s | %-5s %-10s | %-12s |%n", "No", "Nama Bunga", "Rp", "Harga", "Kategori");
        System.out.println("----------------------------------------------------------------");
        
        int no = 1;
        for (Flower m : listFlowers) {
            System.out.printf("| %-3d | %-20s | %-5s %,10d | %-12s |%n", no++, m.getNama(), "Rp", (int) m.getHarga(), m.getKategori());
        }
    
        System.out.println("----------------------------------------------------------------");
    }
    
    public static void displayDaftarBerdasarHarga() {
        listFlowers.sort(Comparator.comparingDouble(Flower::getHarga));
        displayDaftarBunga();
    }

    public static void displayBungaBerdasarKategori() {
        System.out.println("\n================================================================");
        System.out.println(">>              DAFTAR BUNGA BERDASARKAN KATEGORI             <<");
        System.out.println("================================================================");
    
        // menampilkan Fresh Flower
        System.out.println("\nFRESH FLOWER :");
        System.out.println("----------------------------------------------------------------");
        System.out.printf("| %-3s | %-20s | %-5s %-10s | %-12s |\n", "No", "Nama Bunga", "Rp", "Harga", "Day Fresh");
        System.out.println("----------------------------------------------------------------");
        int no = 1;
        for (Flower flower : listFlowers) {
            if (flower instanceof FreshFlower freshFlower) {
                System.out.printf("| %-3d | %-20s | %-5s %,10d | %-12s |\n",
                    no++, freshFlower.getNama(), "Rp", (int) freshFlower.getHarga(), freshFlower.getDayFresh());
            }
        }
        System.out.println("----------------------------------------------------------------");
    
        // menampilkan Artificial Flower
        System.out.println("\nARTIFICIAL FLOWER :");
        System.out.println("----------------------------------------------------------------");
        System.out.printf("| %-3s | %-20s | %-5s %-10s | %-12s |\n", "No", "Nama Bunga", "Rp", "Harga", "Material");
        System.out.println("----------------------------------------------------------------");
        no = 1;
        for (Flower flower : listFlowers) {
            if (flower instanceof ArtificialFlower artificialFlower) {
                System.out.printf("| %-3d | %-20s | %-5s %,10d | %-12s |\n",
                    no++, artificialFlower.getNama(), "Rp", (int) artificialFlower.getHarga(), artificialFlower.getMaterial());
            }
        }
        System.out.println("----------------------------------------------------------------");
    }
    
    public static void displayCariBungaBerdasarNama(Scanner scanner) {
        // menu pencarian bunga berdasarkan nama
        System.out.print("\nMasukkan nama bunga yang ingin dicari: ");
        String searchName = scanner.nextLine();
        boolean found = false;

        for (Flower m : listFlowers) {
            if (m.getNama().equalsIgnoreCase(searchName)) {
                // menampilkan informasi bunga yang dicari
                System.out.println("\nBunga ditemukan:");
                System.out.println("----------------------------------------------------------------");
                System.out.println(m.toString()); // memanggil toString() yang sudah di override
                System.out.println("----------------------------------------------------------------");
                found = true;
                break;
            }
        }
        if (!found) {
            // menampilkan ERROR jika bunga tidak ditemukan
            System.out.println("\n╔══════════════════════════════════════════════════════════════╗");
            System.out.println("║               [ERROR] | Bunga Tidak Ditemukan!!!             ║");
            System.out.println("╚══════════════════════════════════════════════════════════════╝");
        }
    }

    public static void editBunga(Scanner scanner) {
        System.out.print("\nMasukkan nama bunga yang ingin diedit: ");
        String namaBunga = scanner.nextLine();
        boolean found = false;
    
        for (Flower flower : listFlowers) {
            if (flower.getNama().equalsIgnoreCase(namaBunga)) {
                System.out.println("----------------------------------------------------------------");
                System.out.print("Masukkan nama baru    : "); // input nama baru
                String newName = scanner.nextLine();
                System.out.print("Masukkan harga baru   : Rp "); // input harga baru
                double newPrice = scanner.nextDouble();
                scanner.nextLine(); 
    
                flower.setNama(newName);
                flower.setHarga(newPrice);
                System.out.println("\n╔══════════════════════════════════════════════════════════════╗");
                System.out.println("║              [SUCCES] | Data Berhasil Diperbarui             ║");
                System.out.println("╚══════════════════════════════════════════════════════════════╝");
                found = true;
                break;
            }
        }
    
        if (!found) {
            System.out.println("\n╔══════════════════════════════════════════════════════════════╗");
            System.out.println("║               [ERROR] | Bunga Tidak Ditemukan!!!             ║");
            System.out.println("╚══════════════════════════════════════════════════════════════╝");
        } else {
            // menampilkan daftar bunga yang telah diperbarui
            displayDaftarBunga();
        }
    }

    public static void displayProsesPesanBunga(Scanner scanner) {
        boolean beliLagi;
        do {
            System.out.print("\nMasukkan nama bunga   : "); // input nama bunga yang dipesan
            String orderName = scanner.nextLine();
            System.out.print("Masukkan jumlah bunga : "); // input jumlah bunga yang dipesan
            int jumlah = scanner.nextInt();
            scanner.nextLine();

            boolean ordered = false;
            for (Flower m : listFlowers) {
                if (m.getNama().equalsIgnoreCase(orderName)) {
                    // membuat objek inner class Order
                    Flower.Order order = m.new Order(jumlah);
                    order.displayOrder(); // menampilkan detail pesanan
                    
                    
                    // memasukkan pembayaran dari pelanggan
                    double pembayaran;
                    while (true) {
                        System.out.print("TUNAI                 : Rp ");
                        pembayaran = scanner.nextDouble();
                        scanner.nextLine();
                        if (pembayaran >= order.getTotalPembayaran()) {
                            break;
                        } else {
                            double kekurangan = order.getTotalPembayaran() - pembayaran;
                            System.out.println("\n╔══════════════════════════════════════════════════════════════╗");
                            System.out.println("║            [ERROR] | Uang Pembayaran Tidak Cukup!!.          ║");
                            System.out.println("╚══════════════════════════════════════════════════════════════╝");
                            System.out.printf("\nKEKURANGAN            : Rp %,10.2f%n", kekurangan);
                        }
                    }

                    // menghitung jumlah kembalian
                    double kembalian = pembayaran - order.getTotalPembayaran();
                    System.out.printf("KEMBALIAN             : Rp %,10.2f%n", kembalian);
                    System.out.println("----------------------------------------------------------------");

                    ordered = true;
                    break;
                }
            }

            if (!ordered) {
                System.out.println("\n╔══════════════════════════════════════════════════════════════╗");
                System.out.println("║               [ERROR] | Bunga tidak ditemukan!!.             ║");
                System.out.println("╚══════════════════════════════════════════════════════════════╝");
            }

            // konfirmasi apakah ingin beli lagi
            System.out.print("\nApakah ingin membeli lagi? (Y/N): ");
            String pilihanLagi;
            while (true) {
                pilihanLagi = scanner.nextLine().trim().toUpperCase();
                if (pilihanLagi.equals("Y")) {
                    beliLagi = true;
                    break;
                } else if (pilihanLagi.equals("N")) {
                    System.out.println("\nTerima kasih telah berbelanja!!");
                    System.out.println("Selamat menikmati moment spesial Anda!");
                    return;
                } else {
                    System.out.print("Input tidak valid! Masukkan (Y/N): ");
                }
            }
        } while (beliLagi);
    }

    public static void displayFooter() {
        System.out.println("\n================================================================");
        System.out.println(">>               TERIMA KASIH ATAS KUNJUNGAN ANDA             <<");
        System.out.println(">                     by : FEBRIANA NUR AINI                   <");
        System.out.println(">>                24111814006 / INFORMATIKA2024A              <<");
        System.out.println("================================================================");
    }
}
