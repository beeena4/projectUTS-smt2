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

                    default -> {
                        System.out.println("\n╔══════════════════════════════════════════════════════════════╗");
                        System.out.println("║      [ERROR] | Pilihan tidak valid. Silahkan coba lagi.      ║");
                        System.out.println("╚══════════════════════════════════════════════════════════════╝");
                    }
                }

            } catch (InputMismatchException e) {
                System.out.println("\n╔══════════════════════════════════════════════════════════════╗");
                System.out.println("║                [ERROR] | INPUT HARUS ANGKA !!                ║");
                System.out.println("╚══════════════════════════════════════════════════════════════╝");
                scanner.nextLine();
            }
        }
    }

    public static void displayJudul(Scanner scanner) {
        System.out.println("\n╔══════════════════════════════════════════════════════════════╗");
        System.out.println("║ +----------------------------------------------------------+ ║");
        System.out.println("║ | >>         << Selamat Datang di BEE Florist >>        << | ║");
        System.out.println("║ | >  Rangkai bunga terbaik untuk setiap moment spesial!  < | ║");
        System.out.println("║ +----------------------------------------------------------+ ║");
        System.out.println("╚══════════════════════════════════════════════════════════════╝");
        System.out.print("Nama : ");
        String namaPembeli = scanner.nextLine();
        System.out.println("\nHallo, " + namaPembeli + "!");
        System.out.print("Kami memiliki beberapa pilihan menu");
        loadingEffect(3);  // loading effect
    }

    public static void loadingEffect(int duration) {
        try {
            for (int i = 0; i < duration; i++) {
                System.out.print(".");
                Thread.sleep(500); // Delay 500ms per titik
            }
            System.out.println(".");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    // menampilkan menu utama aplikasi
    public static void displayMenu() {
        System.out.println("\n================================================================");
        System.out.println("||>>                        M  E  N  U                      <<||");
        System.out.println("+ ============================================================ +");
        System.out.println("| 1. | Tampilkan Daftar Bunga                                  |");
        System.out.println("| 2. | Tampilkan Bunga Berdasarkan Harga                       |");
        System.out.println("| 3. | Tampilkan Bunga Berdasarkan Kategori                    |");
        System.out.println("| 4. | Cari Bunga Berdasarkan Nama                             |");
        System.out.println("| 5. | Edit Bunga                                              |");
        System.out.println("| 6. | Pesan Bunga                                             |");
        System.out.println("| 7. | Keluar                                                  |");
        System.out.println("================================================================");
        System.out.print("Pilih menu (1-7): ");
    }

    // menampilkan daftar bunga-
    public static void displayDaftarBunga() {
        System.out.println("\n----------------------------------------------------------------");
        System.out.printf("| %-2s | %-20s | %-5s %-10s | %-13s |%n", "No", "Nama Bunga", "Rp", "Harga", "Kategori");
        System.out.println("---- + -------------------- + ---------------- + ---------------");
        
        int no = 1;
        for (Flower m : listFlowers) {
            System.out.printf("| %-2d | %-20s | %-5s %,10d | %-13s |%n", no++, m.getNama(), "Rp", (int) m.getHarga(), m.getKategori());
        }
    
        System.out.println("----------------------------------------------------------------");
    }
    
    // menampilkan bunga berdasarkan harga terendah
    public static void displayDaftarBerdasarHarga() {
        System.out.print("\nMemproses daftar bunga berdasarkan harga terendah");
        loadingEffect(3); // loading effect
        listFlowers.sort(Comparator.comparingDouble(Flower::getHarga));
        displayDaftarBunga();
    }

    // menampilkan bunga berdasarkan kategori
    public static void displayBungaBerdasarKategori() {
        System.out.print("\nMemproses bunga berdasarkan kategori ");
        loadingEffect(3); // loading effect
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

    // Pencarian bunga berdasarkan nama
    public static void displayCariBungaBerdasarNama(Scanner scanner) {
        while (true) {  // Loop agar pengguna bisa mencari bunga berulang kali
            // Menu pencarian bunga berdasarkan nama
            System.out.print("\nMasukkan nama bunga yang ingin dicari: ");
            String searchName = scanner.nextLine();
            boolean found = false;
    
            for (Flower m : listFlowers) {
                if (m.getNama().equalsIgnoreCase(searchName)) {
                    System.out.print("Memproses pencarian");
                    loadingEffect(5);  // loading effect
    
                    // Menampilkan informasi bunga yang ditemukan
                    System.out.println("\n╔══════════════════════════════════════════════════════════════╗");
                    System.out.println("║                  <<   Bunga Ditemukan!!!   >>                ║");
                    System.out.println("╚══════════════════════════════════════════════════════════════╝");
                    System.out.println("----------------------------------------------------------------");
                    System.out.println(m.toString()); // Memanggil toString() yang sudah di override
                    System.out.println("----------------------------------------------------------------");
                    found = true;
                    break;
                }
            }
    
            if (!found) {
                // Menampilkan ERROR jika bunga tidak ditemukan
                System.out.println("\n╔══════════════════════════════════════════════════════════════╗");
                System.out.println("║              [ERROR] | Bunga Tidak Ditemukan !!!             ║");
                System.out.println("╚══════════════════════════════════════════════════════════════╝");
            }
    
            // Konfirmasi apakah ingin mencari bunga lagi
            System.out.print("\nApakah Anda ingin mencari bunga lagi? (Y/N): ");
            String ulangi = scanner.nextLine().trim().toUpperCase();
    
            if (!ulangi.equals("Y")) {
                break;  // Keluar dari loop jika pengguna tidak ingin mencari lagi
            }
        }
    }

    // edit bunga
    public static void editBunga(Scanner scanner) {
        boolean repeat = true;

        while (repeat) {
            System.out.print("\nMasukkan nama bunga yang ingin diedit: ");
            String namaBunga = scanner.nextLine();
            boolean found = false;

            for (Flower flower : listFlowers) {
                if (flower.getNama().equalsIgnoreCase(namaBunga)) {
                    System.out.println("----------------------------------------------------------------");
                    System.out.print("Masukkan nama baru    : ");
                    String newName = scanner.nextLine();
                    System.out.print("Masukkan harga baru   : Rp ");
                    double newPrice = scanner.nextDouble();
                    scanner.nextLine(); // buang newline

                    flower.setNama(newName);
                    flower.setHarga(newPrice);
                    System.out.print("Memperbarui data bunga");
                    loadingEffect(3);
                    
                    System.out.println("\n╔══════════════════════════════════════════════════════════════╗");
                    System.out.println("║             [SUCCESS] | Data Berhasil Diperbarui !           ║");
                    System.out.println("╚══════════════════════════════════════════════════════════════╝");
                    found = true;

                    // tampilkan daftar bunga terbaru
                    displayDaftarBunga();
                    repeat = false; // selesai, keluar dari loop
                    break;
                }
            }

            if (!found) {
                System.out.println("\n╔══════════════════════════════════════════════════════════════╗");
                System.out.println("║               [ERROR] | Bunga Tidak Ditemukan!!!             ║");
                System.out.println("╚══════════════════════════════════════════════════════════════╝");

                // konfirmasi apakah ingin coba lagi
                System.out.print("\nApakah Anda ingin mencoba mengedit bunga lain? (Y/N): ");
                String jawab = scanner.nextLine();
                if (!jawab.equalsIgnoreCase("Y")) {
                    repeat = false; // keluar dari loop
                }
            }
        }
    }

    // memproses dan menampilkan pemesanan bunga
    public static void displayProsesPesanBunga(Scanner scanner) {
        boolean beliLagi;
        do {
            System.out.print("\nMasukkan nama bunga   : "); // input nama bunga yang dipesan
            String orderName = scanner.nextLine();

            boolean ordered = false;
            for (Flower m : listFlowers) {
                if (m.getNama().equalsIgnoreCase(orderName)) {
                    System.out.print("Masukkan jumlah bunga : "); // input jumlah bunga yang dipesan
                    int jumlah = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Memproses pesanan");
                    loadingEffect(5);  // loading effect

                    // membuat objek inner class Order
                    Flower.Order order = m.new Order(jumlah);
                    order.displayOrder(); // menampilkan detail pesanan
                    
                    double totalPembayaran = order.getTotalPembayaran();
                    double pembayaran = 0;

                    // Loop pembayaran
                    while (pembayaran < totalPembayaran) {
                        System.out.print("TUNAI                 : Rp ");
                        double tambahan = scanner.nextDouble();
                        scanner.nextLine();
                        
                        pembayaran += tambahan;

                        // Jika uang pembayaran kurang
                        if (pembayaran < totalPembayaran) {
                            double kekurangan = totalPembayaran - pembayaran;
                            System.out.println("\n╔══════════════════════════════════════════════════════════════╗");
                            System.out.println("║            [ INFO ] Uang Pembayaran Tidak Cukup!!            ║");
                            System.out.println("║                Silahkan Melanjutkan Pembayaran               ║");
                            System.out.println("╚══════════════════════════════════════════════════════════════╝");
                            System.out.printf("\nKEKURANGAN            : Rp %,10.2f%n", kekurangan);
                        }
                    }
                    // menghitung jumlah kembalian
                    double kembalian = pembayaran - order.getTotalPembayaran();
                    System.out.printf("KEMBALIAN             : Rp %,10.2f%n", kembalian);
                    System.out.println("================================================================");

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
                    System.out.println("\n╔══════════════════════════════════════════════════════════════╗");
                    System.out.println("║             << Terima kasih telah berbelanja!! >>            ║");
                    System.out.println("║         << Selamat menikmati momment spesial Anda! >>        ║");
                    System.out.println("╚══════════════════════════════════════════════════════════════╝");
                    return;
                } else {
                    System.out.println("\n╔══════════════════════════════════════════════════════════════╗");
                    System.out.println("║                          [ E R R O R ]                       ║");
                    System.out.println("╚══════════════════════════════════════════════════════════════╝");
                    System.out.print("\nInput tidak valid! Masukan (Y/N): ");
                }
            }
        } while (beliLagi);
    }

    // menampilkan footer
    public static void displayFooter() {
        System.out.println("\n╔══════════════════════════════════════════════════════════════╗");
        System.out.println("║ +----------------------------------------------------------+ ║");
        System.out.println("║ |>>            TERIMA KASIH ATAS KUNJUNGAN ANDA          <<| ║");
        System.out.println("║ |>                  by : FEBRIANA NUR AINI                <| ║");
        System.out.println("║ |>>             24111814006 / INFORMATIKA2024A           <<| ║");
        System.out.println("║ +----------------------------------------------------------+ ║");
        System.out.println("╚══════════════════════════════════════════════════════════════╝");
    }
}