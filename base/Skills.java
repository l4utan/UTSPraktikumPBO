package base;

public abstract class Skills {
    private String nama;
    private int dipakai;

    public Skills(String nama) { this.nama = nama; }

    public String getNama() { return nama; }
    public int getDipakai() { return dipakai; }
    protected void catat() { dipakai++; }

    public abstract void gunakan(Karakter pemilik);
}