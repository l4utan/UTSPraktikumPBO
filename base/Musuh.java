package base;

public class Musuh {
    private String nama;
    private boolean kalah;

    public Musuh(String nama) { this.nama = nama; }

    public void kalah() { kalah = true; }
    public boolean isKalah() { return kalah; }
    public String getNama() { return nama; }
}