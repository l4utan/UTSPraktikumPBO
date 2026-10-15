package karakter1;

import base.Karakter;
import skill.Loncat;
import skill.Merunduk;

public class Karakter1 extends Karakter {
    private Loncat skillLoncat = new Loncat();
    private Merunduk skillMerunduk = new Merunduk();
    private boolean sedangMerunduk;

    public Karakter1(String nama) { super(nama); }

    public void loncat() {
        if (sedangMerunduk) { System.out.println(this + " masih merunduk"); return; }
        skillLoncat.gunakan(this);
    }

    public void loncat(int kali) {
        for (int i = 0; i < kali; i++) loncat();
    }

    public void merunduk() { sedangMerunduk = true; skillMerunduk.gunakan(this); }
    public void berdiri()  { sedangMerunduk = false; System.out.println(this + " berdiri"); }

    public int getJumlahLoncat() { return skillLoncat.getDipakai(); }

    @Override
    public void terimaBantuan(String jenis) {
        if (jenis.equals("INJAK"))
            System.out.println(this + " lega, musuh berhasil diinjak partner");
    }

    @Override
    public String toString() { return "[Karakter1:" + getNama() + "]"; }
}