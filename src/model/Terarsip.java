/*
 * UTS Praktik Pemrograman Berorientasi Objek II - SIPUSTA
 * Nama  : JONATHAN EULO GEO PARDEDE
 * Kelas : TRPL-3B
 * NIM   : 2505181112
 */
package model;

/**
 * Kemampuan untuk koleksi yang memiliki lokasi fisik di rak.
 * Hanya BukuCetak dan Majalah yang menerapkannya.
 */
public interface Terarsip {

    String nomorRak();

    String lokasiLantai();

    default String ringkasanArsip() {
        return "Rak " + nomorRak() + ", " + lokasiLantai();
    }
}
