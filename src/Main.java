import java.util.ArrayList;
import java.util.Scanner;

// Kelas untuk mendefinisikan Obat
class Obat {
    String nama;
    String kategori;
    int stok;

    // Constructor untuk membuat objek Obat
    public Obat(String nama, String kategori, int stok) {
        this.nama = nama;
        this.kategori = kategori;
        this.stok = stok;
    }

    // Method untuk menampilkan informasi obat
    public void tampilkanInfo() {
        System.out.println("Nama Obat: " + nama);
        System.out.println("Kategori: " + kategori);
        System.out.println("Stok: " + stok);
        System.out.println("---------------------------");
    }

    // Method untuk mengupdate stok obat
    public void updateStok(int stokBaru) {
        this.stok = stokBaru;
    }
}

// Kelas utama untuk manajemen inventaris apotek
    public class Main {
    // ArrayList untuk menyimpan daftar obat
    private ArrayList<Obat> inventaris;

    // Constructor
    public Main() {
        inventaris = new ArrayList<>();
    }

    // Method untuk menambahkan obat ke dalam inventaris (Non-return type)
    public void tambahObat(String nama, String kategori, int stok) {
        Obat obatBaru = new Obat(nama, kategori, stok);
        inventaris.add(obatBaru);
        System.out.println("Obat '" + nama + "' berhasil ditambahkan!");
    }

    // Method untuk menampilkan seluruh inventaris obat (Non-return type)
    public void tampilkanInventaris() {
        if (inventaris.isEmpty()) {
            System.out.println("Inventaris kosong.");
        } else {
            for (Obat obat : inventaris) {
                obat.tampilkanInfo();
            }
        }
    }

    // Method untuk mencari obat berdasarkan nama (Return type)
    public Obat cariObat(String nama) {
        for (Obat obat : inventaris) {
            if (obat.nama.equalsIgnoreCase(nama)) {
                return obat;
            }
        }
        return null;
    }

    // Method untuk memperbarui stok obat (Non-return type)
    public void updateStokObat(String nama, int stokBaru) {
        Obat obat = cariObat(nama);
        if (obat != null) {
            obat.updateStok(stokBaru);
            System.out.println("Stok obat '" + nama + "' telah diperbarui menjadi " + stokBaru);
        } else {
            System.out.println("Obat '" + nama + "' tidak ditemukan.");
        }
    }

    // Fungsi untuk menampilkan menu (Non-return type)
    public static void tampilkanMenu() {
        System.out.println("\n===== Inventaris Apotek Kelompok 6 =====");
        System.out.println("1. Tambah Obat");
        System.out.println("2. Tampilkan Inventaris Obat");
        System.out.println("3. Cari Obat");
        System.out.println("4. Update Stok Obat");
        System.out.println("5. Keluar");
        System.out.println("==============================================");
    }

    // Fungsi untuk memilih menu (Return type)
    public static int pilihMenu() {
        Scanner input = new Scanner(System.in);
        int pilihan = 0;
        try {
            System.out.print("Pilih menu (1-5): ");
            pilihan = input.nextInt();
            if (pilihan < 1 || pilihan > 5) {
                System.out.println("Pilihan tidak valid, masukkan angka antara 1 hingga 5.");
            }
        } catch (Exception e) {
            System.out.println("Input tidak valid, masukkan angka.");
            input.next(); // Clear buffer
        }
        return pilihan;
    }

    // Fungsi utama untuk menjalankan program (Non-return type)
    public static void main(String[] args) {
        Main apotek = new Main();
        Scanner scanner = new Scanner(System.in);
        boolean selesai = false;

        while (!selesai) {
            tampilkanMenu();
            int pilihan = pilihMenu();

            switch (pilihan) {
                case 1:
                    // Tambah Obat
                    System.out.print("Masukkan nama obat: ");
                    String nama = scanner.next();
                    System.out.print("Masukkan kategori obat: ");
                    String kategori = scanner.next();
                    System.out.print("Masukkan jumlah stok: ");
                    int stok = scanner.nextInt();
                    apotek.tambahObat(nama, kategori, stok);
                    break;

                case 2:
                    // Tampilkan Inventaris
                    apotek.tampilkanInventaris();
                    break;

                case 3:
                    // Cari Obat
                    System.out.print("Masukkan nama obat yang dicari: ");
                    String namaCari = scanner.next();
                    Obat obatDitemukan = apotek.cariObat(namaCari);
                    if (obatDitemukan != null) {
                        obatDitemukan.tampilkanInfo();
                    } else {
                        System.out.println("Obat '" + namaCari + "' tidak ditemukan.");
                    }
                    break;

                case 4:
                    // Update Stok Obat
                    System.out.print("Masukkan nama obat yang ingin diupdate stoknya: ");
                    String namaUpdate = scanner.next();
                    System.out.print("Masukkan stok baru: ");
                    int stokBaru = scanner.nextInt();
                    apotek.updateStokObat(namaUpdate, stokBaru);
                    break;

                case 5:
                    // Keluar
                    selesai = true;
                    System.out.println("Terima kasih telah menggunakan sistem manajemen inventaris apotek!");
                    break;

                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }

        scanner.close();
    }
}
