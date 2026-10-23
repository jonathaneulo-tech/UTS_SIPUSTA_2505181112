/*
 * UTS Praktik Pemrograman Berorientasi Objek II - SIPUSTA
 * Nama  : JONATHAN EULO GEO PARDEDE
 * Kelas : TRPL-3B
 * NIM   : 2505181112
 */
package model;

/** Berkas digital tidak memiliki lokasi fisik, sehingga tidak menerapkan Terarsip. */
public class BerkasDigital extends Koleksi {

    private final int ukuranMB;
    private final String tautanUnduh;

    public BerkasDigital(String kode, String judul, int tahunTerbit, int ukuranMB, String tautanUnduh) {
        super(kode, judul, tahunTerbit);
        this.ukuranMB = ukuranMB;
        this.tautanUnduh = tautanUnduh;
    }

    @Override
    public boolean layakDipinjam() {
        return true;
    }

    @Override
    public String deskripsi() {
        return super.deskripsi() + " | Berkas Digital, " + ukuranMB + " MB, " + tautanUnduh;
    }

    public int getUkuranMB() {
        return ukuranMB;
    }

    public String getTautanUnduh() {
        return tautanUnduh;
    }
}
