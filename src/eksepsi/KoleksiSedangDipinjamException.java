/*
 * UTS Praktik Pemrograman Berorientasi Objek II - SIPUSTA
 * Nama  : JONATHAN EULO GEO PARDEDE
 * Kelas : TRPL-3B
 * NIM   : 2505181112
 */
package eksepsi;

public class KoleksiSedangDipinjamException extends PustakaException {

    public KoleksiSedangDipinjamException(String judul) {
        super("Maaf, \"" + judul + "\" sedang dipinjam oleh pengguna lain. "
                + "Silakan coba lagi setelah koleksi dikembalikan.");
    }
}
