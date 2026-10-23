/*
 * UTS Praktik Pemrograman Berorientasi Objek II - SIPUSTA
 * Nama  : JONATHAN EULO GEO PARDEDE
 * Kelas : TRPL-3B
 * NIM   : 2505181112
 */
package layanan;

import eksepsi.KoleksiSedangDipinjamException;
import eksepsi.KoleksiTidakLayakException;
import eksepsi.PustakaException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import model.Koleksi;

public class KatalogPerpustakaan {

    private final List<Koleksi> daftar = new ArrayList<>();

    public void tambah(Koleksi koleksi) {
        daftar.add(koleksi);
    }

    public List<Koleksi> getDaftar() {
        return Collections.unmodifiableList(daftar);
    }

    /** Memproses seluruh koleksi secara polimorfik, tanpa percabangan tipe. */
    public void cetakStatus() {
        for (Koleksi k : daftar) {
            String status = k.isSedangDipinjam() ? "SEDANG DIPINJAM"
                    : (k.layakDipinjam() ? "LAYAK PINJAM" : "TIDAK LAYAK");
            System.out.println(k.deskripsi());
            System.out.println("    Status: " + status);
        }
    }

    /** Aturan pengurutan ditentukan dari luar melalui Comparator. */
    public void urut(Comparator<? super Koleksi> pembanding) {
        daftar.sort(pembanding);
    }

    public Koleksi cari(String kode) throws PustakaException {
        for (Koleksi k : daftar) {
            if (k.getKode().equalsIgnoreCase(kode)) {
                return k;
            }
        }
        throw new PustakaException("Koleksi dengan kode " + kode
                + " tidak ditemukan. Periksa kembali kode yang Anda masukkan.");
    }

    public void pinjam(String kode) throws PustakaException {
        Koleksi k = cari(kode);
        if (k.isSedangDipinjam()) {
            throw new KoleksiSedangDipinjamException(k.getJudul());
        }
        if (!k.layakDipinjam()) {
            throw new KoleksiTidakLayakException(k.getJudul(), k.alasanTidakLayak());
        }
        k.setSedangDipinjam(true);
    }

    public void kembalikan(String kode) throws PustakaException {
        cari(kode).setSedangDipinjam(false);
    }
}
