/*
 * UTS Praktik Pemrograman Berorientasi Objek II - SIPUSTA
 * Nama  : JONATHAN EULO GEO PARDEDE
 * Kelas : TRPL-3B
 * NIM   : 2505181112
 */
package layanan;

import java.util.Comparator;
import model.Koleksi;

/** Koleksi layak pinjam tampil lebih dulu, lalu diurutkan menurut judul (A-Z). */
public class UrutLayakLaluJudul implements Comparator<Koleksi> {

    @Override
    public int compare(Koleksi a, Koleksi b) {
        int hasil = Boolean.compare(b.layakDipinjam(), a.layakDipinjam());
        if (hasil != 0) {
            return hasil;
        }
        return a.getJudul().compareToIgnoreCase(b.getJudul());
    }
}
