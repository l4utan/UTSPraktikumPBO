package base;

public abstract class Karakter {
    private String nama;
    private Karakter partner;

    public Karakter(String nama) { this.nama = nama; }

    public String getNama() { return nama; }
    public Karakter getPartner() { return partner; }

    public void setPartner(Karakter p) {
        this.partner = p;
        if (p.partner != this) p.setPartner(this);
    }

    public abstract void terimaBantuan(String jenis);

    @Override
    public String toString() { return "[" + nama + "]"; }
}