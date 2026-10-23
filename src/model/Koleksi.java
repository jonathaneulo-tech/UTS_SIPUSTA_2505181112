/*
 * UTS Praktik Pemrograman Berorientasi Objek II - SIPUSTA
 * Nama  : JONATHAN EULO GEO PARDEDE
 * Kelas : TRPL-3B
 * NIM   : 2505181112
 */
package model;

/**
 * Kelas induk abstract untuk seluruh koleksi perpustakaan SIPUSTA.
 */
public abstract class Koleksi {

    private final String kode;
    private final String judul;
    private final int tahunTerbit;
    private boolean sedangDipinjam;

    protected Koleksi(String kode, String judul, int tahunTerbit) {
        this.kode = kode;
        this.judul = judul;
        this.tahunTerbit = tahunTerbit;
        this.sedangDipinjam = false;
    }

    /** Aturan kelayakan pinjam, ditentukan oleh masing-masing turunan. */
    public abstract boolean layakDipinjam();

    /** Alasan koleksi tidak layak dipinjam, dalam bahasa yang mudah dipahami. */
    public String alasanTidakLayak() {
        return "koleksi ini sedang tidak memenuhi syarat peminjaman";
    }

    /** Deskripsi dasar yang akan diperluas oleh setiap turunan memakai super. */
    public String deskripsi() {
        return "[" + kode + "] " + judul + " (" + tahunTerbit + ")";
    }

    public String getKode() {
        return kode;
    }

    public String getJudul() {
        return judul;
    }

    public int getTahunTerbit() {
        return tahunTerbit;
    }

    public boolean isSedangDipinjam() {
        return sedangDipinjam;
    }

    public void setSedangDipinjam(boolean sedangDipinjam) {
        this.sedangDipinjam = sedangDipinjam;
    }
}
