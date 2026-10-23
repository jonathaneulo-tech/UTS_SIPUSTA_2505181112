/*
 * UTS Praktik Pemrograman Berorientasi Objek II - SIPUSTA
 * Nama  : JONATHAN EULO GEO PARDEDE
 * Kelas : TRPL-3B
 * NIM   : 2505181112
 */
package model;

public class BukuCetak extends Koleksi implements Terarsip {

    private final int jumlahHalaman;
    private final String nomorRak;
    private final String lantai;
    private final boolean sedangDiperbaiki;

    public BukuCetak(String kode, String judul, int tahunTerbit, int jumlahHalaman,
                     String nomorRak, String lantai, boolean sedangDiperbaiki) {
        super(kode, judul, tahunTerbit);
        this.jumlahHalaman = jumlahHalaman;
        this.nomorRak = nomorRak;
        this.lantai = lantai;
        this.sedangDiperbaiki = sedangDiperbaiki;
    }

    @Override
    public boolean layakDipinjam() {
        return !sedangDiperbaiki;
    }

    @Override
    public String alasanTidakLayak() {
        return "buku ini sedang diperbaiki";
    }

    @Override
    public String deskripsi() {
        return super.deskripsi() + " | Buku Cetak, " + jumlahHalaman + " halaman, "
                + ringkasanArsip() + (sedangDiperbaiki ? ", sedang diperbaiki" : "");
    }

    @Override
    public String nomorRak() {
        return nomorRak;
    }

    @Override
    public String lokasiLantai() {
        return lantai;
    }

    public int getJumlahHalaman() {
        return jumlahHalaman;
    }

    public boolean isSedangDiperbaiki() {
        return sedangDiperbaiki;
    }
}
