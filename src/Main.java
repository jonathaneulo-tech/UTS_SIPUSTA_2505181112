/*
 * UTS Praktik Pemrograman Berorientasi Objek II - SIPUSTA
 * Nama  : JONATHAN EULO GEO PARDEDE
 * Kelas : TRPL-3B
 * NIM   : 2505181112
 */
import berkas.EksporKatalog;
import eksepsi.PustakaException;
import java.io.IOException;
import layanan.KatalogPerpustakaan;
import layanan.UrutLayakLaluJudul;
import model.BerkasDigital;
import model.BukuCetak;
import model.Majalah;
import model.Terarsip;

public class Main {

    public static void main(String[] args) {
        KatalogPerpustakaan katalog = new KatalogPerpustakaan();

        BukuCetak bk1 = new BukuCetak("BK-001", "Java How to Program", 2022, 620, "A-12", "Lantai 1", false);
        BukuCetak bk2 = new BukuCetak("BK-002", "Basis Data Relasional", 2021, 410, "B-04", "Lantai 1", true);
        Majalah mj1 = new Majalah("MJ-001", "Info Teknologi Edisi 88", 2026, 88, "Agustus", true, "M-01", "Lantai 2");
        Majalah mj2 = new Majalah("MJ-002", "Info Teknologi Edisi 87", 2026, 87, "Juli", false, "M-02", "Lantai 2");
        BerkasDigital bd1 = new BerkasDigital("BD-001", "Panduan Pemrograman Java", 2024, 15, "unduh.polmed.ac.id/bd001");
        BerkasDigital bd2 = new BerkasDigital("BD-002", "Jurnal Rekayasa Perangkat", 2025, 8, "unduh.polmed.ac.id/bd002");

        katalog.tambah(bk1);
        katalog.tambah(bk2);
        katalog.tambah(mj1);
        katalog.tambah(mj2);
        katalog.tambah(bd1);
        katalog.tambah(bd2);

        System.out.println("=== SOAL 1 & 2: Deskripsi dan ringkasan arsip ===");
        Terarsip[] arsip = {bk1, bk2, mj1, mj2};
        for (Terarsip t : arsip) {
            System.out.println(t.ringkasanArsip());
        }

        System.out.println("\n=== SOAL 3: cetakStatus (polimorfik) ===");
        katalog.cetakStatus();

        System.out.println("\n=== SOAL 4: urut dengan UrutLayakLaluJudul ===");
        katalog.urut(new UrutLayakLaluJudul());
        katalog.cetakStatus();

        System.out.println("\n=== SOAL 5: pinjam dan eksepsi ===");
        String[] percobaan = {"BK-001", "BK-001", "BK-002", "MJ-001", "MJ-002", "BD-001", "XX-999"};
        for (String kode : percobaan) {
            try {
                katalog.pinjam(kode);
                System.out.println("Berhasil meminjam " + kode);
            } catch (PustakaException e) {
                System.out.println("Gagal meminjam " + kode + ": " + e.getMessage());
            }
        }

        System.out.println("\n=== SOAL 6: ekspor ke katalog.txt ===");
        try {
            new EksporKatalog().ekspor(katalog, "katalog.txt");
            System.out.println("Ka talog berhasil ditulis ke katalog.txt");
        } catch (IOException e) {
            System.out.println("Gagal menulis berkas: " + e.getMessage());
        }
    }
}
