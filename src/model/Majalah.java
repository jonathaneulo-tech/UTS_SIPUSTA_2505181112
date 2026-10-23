/*
 * UTS Praktik Pemrograman Berorientasi Objek II - SIPUSTA
 * Nama  : JONATHAN EULO GEO PARDEDE
 * Kelas : TRPL-3B
 * NIM   : 2505181112
 */
package model;

public class Majalah extends Koleksi implements Terarsip {

    private final int edisi;
    private final String bulanTerbit;
    private final boolean edisiTerbaru;
    private final String nomorRak;
    private final String lantai;

    public Majalah(String kode, String judul, int tahunTerbit, int edisi, String bulanTerbit,
                   boolean edisiTerbaru, String nomorRak, String lantai) {
        super(kode, judul, tahunTerbit);
        this.edisi = edisi;
        this.bulanTerbit = bulanTerbit;
        this.edisiTerbaru = edisiTerbaru;
        this.nomorRak = nomorRak;
        this.lantai = lantai;
    }

    @Override
    public boolean layakDipinjam() {
        return !edisiTerbaru;
    }

    @Override
    public String alasanTidakLayak() {
        return "ini adalah edisi terbaru yang hanya boleh dibaca di tempat";
    }

    @Override
    public String deskripsi() {
        return super.deskripsi() + " | Majalah, edisi " + edisi + " (" + bulanTerbit + "), "
                + ringkasanArsip() + (edisiTerbaru ? ", edisi terbaru" : "");
    }

    @Override
    public String nomorRak() {
        return nomorRak;
    }

    @Override
    public String lokasiLantai() {
        return lantai;
    }

    public int getEdisi() {
        return edisi;
    }

    public String getBulanTerbit() {
        return bulanTerbit;
    }

    public boolean isEdisiTerbaru() {
        return edisiTerbaru;
    }
}
