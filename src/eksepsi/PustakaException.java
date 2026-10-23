/*
 * UTS Praktik Pemrograman Berorientasi Objek II - SIPUSTA
 * Nama  : JONATHAN EULO GEO PARDEDE
 * Kelas : TRPL-3B
 * NIM   : 2505181112
 */
package eksepsi;

/** Induk seluruh kesalahan pada sistem SIPUSTA. */
public class PustakaException extends Exception {

    public PustakaException(String pesan) {
        super(pesan);
    }
}
