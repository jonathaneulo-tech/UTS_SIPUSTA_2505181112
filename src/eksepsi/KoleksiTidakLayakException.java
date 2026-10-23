/*
 * UTS Praktik Pemrograman Berorientasi Objek II - SIPUSTA
 * Nama  : JONATHAN EULO GEO PARDEDE
 * Kelas : TRPL-3B
 * NIM   : 2505181112
 */
package eksepsi;

public class KoleksiTidakLayakException extends PustakaException {

    public KoleksiTidakLayakException(String judul, String alasan) {
        super("Maaf, \"" + judul + "\" belum dapat dipinjam saat ini karena " + alasan + ".");
    }
}
