/*
 * UTS Praktik Pemrograman Berorientasi Objek II - SIPUSTA
 * Nama  : JONATHAN EULO GEO PARDEDE
 * Kelas : TRPL-3B
 * NIM   : 2505181112
 */
package berkas;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import layanan.KatalogPerpustakaan;
import model.Koleksi;

public class EksporKatalog {

    private static final String FORMAT = "%-8s %-15s %-30s %-6s %-12s%n";

    public void ekspor(KatalogPerpustakaan katalog, String namaBerkas) throws IOException {
        try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(namaBerkas)))) {
            out.printf(FORMAT, "KODE", "JENIS", "JUDUL", "TAHUN", "STATUS");
            out.println("-".repeat(75));
            for (Koleksi k : katalog.getDaftar()) {
                String status = k.isSedangDipinjam() ? "DIPINJAM"
                        : (k.layakDipinjam() ? "LAYAK" : "TIDAK LAYAK");
                out.printf(FORMAT, k.getKode(), k.getClass().getSimpleName(),
                        k.getJudul(), k.getTahunTerbit(), status);
            }
        }
    }
}
