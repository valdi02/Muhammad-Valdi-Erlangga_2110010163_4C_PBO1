/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bioskop;

/**
 *
 * @author valdi
 */
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Bioskop {
    private ArrayList<Movie> movies;
    private ArrayList<Ticket> tickets;
    private Scanner scanner;

    public Bioskop() {
        movies = new ArrayList<>();
        tickets = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    // Method untuk menambahkan film baru
    public void tambahFilm() {
        System.out.print("Judul film: ");
        String title = scanner.nextLine();
        System.out.print("Durasi film (dalam menit): ");
        int duration = getInputInt();
        scanner.nextLine(); // Membuang newline character
        System.out.print("Genre film: ");
        String genre = scanner.nextLine();
        System.out.print("Apakah film ini memerlukan 3D glasses? (true/false): ");
        boolean isGlassesNeeded = getInputBoolean();

        Movie newMovie;
        if (isGlassesNeeded) {
            newMovie = new Film3D(title, duration, genre, true);
        } else {
            newMovie = new Movie(title, duration, genre);
        }

        movies.add(newMovie);
        System.out.println("Film berhasil ditambahkan!");
    }

    // Method untuk menampilkan semua film yang tersedia
    public void tampilkanSemuaFilm() {
        if (movies.isEmpty()) {
            System.out.println("\nTidak ada film yang tersedia saat ini.");
            return;
        }
        System.out.println("\nDaftar film yang tersedia:");
        for (int i = 0; i < movies.size(); i++) {
            Movie movie = movies.get(i);
            System.out.println((i + 1) + ". " + movie.getTitle());
        }
    }

    // Method untuk memesan tiket
    public void pesanTiket() {
        if (movies.isEmpty()) {
            System.out.println("\nTidak ada film yang tersedia saat ini.");
            return;
        }
        System.out.println("\nDaftar film yang tersedia:");
        for (int i = 0; i < movies.size(); i++) {
            Movie movie = movies.get(i);
            System.out.println((i + 1) + ". " + movie.getTitle());
        }
        System.out.print("Pilih nomor film yang ingin dipesan tiketnya: ");
        int movieNumber = getInputInt();
        scanner.nextLine(); // Membuang newline character

        if (movieNumber < 1 || movieNumber > movies.size()) {
            System.out.println("Nomor film tidak valid.");
            return;
        }

        Movie selectedMovie = movies.get(movieNumber - 1);

        System.out.print("Nomor kursi: ");
        String seatNumber = scanner.nextLine();
        System.out.print("Harga tiket: $");
        double price = getInputDouble();
        scanner.nextLine(); // Membuang newline character

        Ticket newTicket = new Ticket(selectedMovie, seatNumber, price);
        tickets.add(newTicket);
        System.out.println("Tiket berhasil dipesan!");
    }

    // Method untuk menampilkan semua tiket yang telah dipesan
    public void tampilkanSemuaTiket() {
        if (tickets.isEmpty()) {
            System.out.println("\nBelum ada tiket yang dipesan.");
            return;
        }
        System.out.println("\nDaftar tiket yang telah dipesan:");
        for (Ticket ticket : tickets) {
            System.out.println(ticket);
            System.out.println("-------------------------");
        }
    }

    // Method untuk menampilkan menu utama
    public void tampilkanMenu() {
        System.out.println("\nMenu:");
        System.out.println("1. Tambah Film Baru");
        System.out.println("2. Tampilkan Semua Film");
        System.out.println("3. Pesan Tiket");
        System.out.println("4. Tampilkan Semua Tiket");
        System.out.println("5. Keluar");
        System.out.print("Apa yang ingin Anda lakukan? (1/2/3/4/5): ");
    }

    // Method untuk memproses pilihan menu dari pengguna
    public void prosesMenu(int choice) {
        switch (choice) {
            case 1:
                tambahFilm();
                break;
            case 2:
                tampilkanSemuaFilm();
                break;
            case 3:
                pesanTiket();
                break;
            case 4:
                tampilkanSemuaTiket();
                break;
            case 5:
                System.out.println("Terima kasih telah menggunakan Layanan Ticketing Bioskop. Sampai jumpa!");
                scanner.close();
                System.exit(0);
            default:
                System.out.println("Maaf, pilihan tidak valid. Silakan coba lagi.");
                break;
        }
    }

    // Method untuk menjalankan program Ticketing Bioskop
    public void jalankan() {
        System.out.println("Selamat datang di Layanan Ticketing Bioskop!");

        while (true) {
            tampilkanMenu();
            int choice = getInputInt();
            scanner.nextLine();

            prosesMenu(choice);
        }
    }

    // Method untuk mengambil input integer dari pengguna dengan error handling
    private int getInputInt() {
        int input;
        while (true) {
            try {
                input = scanner.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.print("Input tidak valid. Masukkan angka: ");
                scanner.next();
            }
        }
        return input;
    }

    // Method untuk mengambil input double dari pengguna dengan error handling
    private double getInputDouble() {
        double input;
        while (true) {
            try {
                input = scanner.nextDouble();
                break;
            } catch (InputMismatchException e) {
                System.out.print("Input tidak valid. Masukkan angka: ");
                scanner.next();
            }
        }
        return input;
    }

    // Method untuk mengambil input boolean dari pengguna dengan error handling
    private boolean getInputBoolean() {
        boolean input;
        while (true) {
            try {
                input = scanner.nextBoolean();
                break;
            } catch (InputMismatchException e) {
                System.out.print("Input tidak valid. Masukkan true atau false: ");
                scanner.next();
            }
        }
        return input;
    }

    public static void main(String[] args) {
        Bioskop bioskop = new Bioskop();
        bioskop.jalankan();
    }
}
