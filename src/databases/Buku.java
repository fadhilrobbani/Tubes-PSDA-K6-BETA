package databases;

public class Buku {
    int id;
    String judul;
    String pengarang;
    String penerbit;
    int tahun;

    public Buku(int id, String judul, String pengarang, String penerbit,int tahun) {
        this.id = id;
        this.judul = judul;
        this.pengarang = pengarang;
        this.penerbit = penerbit;
        this.tahun = tahun;
    }
}
