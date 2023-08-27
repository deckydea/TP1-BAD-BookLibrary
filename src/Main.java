import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Buku> daftarBuku = new ArrayList<>();

        System.out.print("Jumlah buku yang ingin didata: ");
        int jumlahBuku = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < jumlahBuku; i++) {
            System.out.println("Data buku ke-" + (i + 1));
            String jenisBuku = inputJenisBuku(scanner);
            if (jenisBuku == null) {
                System.out.println("Jenis buku tidak dikenali. Silakan masukkan jenis yang valid.");
                i--;
                continue;
            }
            System.out.print("Hari pengembalian: ");
            int hariPengembalian = scanner.nextInt();
            scanner.nextLine(); // Membersihkan newline di buffer

            Buku buku = new Buku(jenisBuku, hariPengembalian);
            daftarBuku.add(buku);
        }

        System.out.println("\nBerikut adalah daftar buku beserta denda");

        for (Buku buku : daftarBuku) {
            int denda = hitungDenda(buku);
            System.out.println("Jenis: " + buku.getJenis());
            System.out.println("Hari Pengembalian: " + buku.getHariPengembalian() + " hari");
            System.out.println("Denda: Rp" + denda);
        }
    }

    public static String inputJenisBuku(Scanner scanner) {
        System.out.print("Jenis buku (pelajaran/novel/skripsi): ");
        String jenisBuku = scanner.nextLine();
        if (jenisBuku.equals("pelajaran") || jenisBuku.equals("novel") || jenisBuku.equals("skripsi")) {
            return jenisBuku;
        } else {
            return null;
        }
    }

    public static int hitungDenda(Buku buku) {
        int denda = 0;
        int hariTerlambat = buku.getHariPengembalian() - 10;

        if (hariTerlambat > 0) {
            switch (buku.getJenis()) {
                case "pelajaran":
                    denda = 2000 * hariTerlambat;
                    break;
                case "novel":
                    denda = 5000 * hariTerlambat;
                    break;
                case "skripsi":
                    denda = 10000 * hariTerlambat;
                    break;
                default:
                    denda = 0;
                    break;
            }
        }

        return denda;
    }
}
