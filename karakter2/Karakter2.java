package karakter2;

import base.Karakter;
import base.Musuh;
import skill.InjakMusuh;
import skill.Lari;

public class Karakter2 extends Karakter {
    private Lari skillLari = new Lari();
    private InjakMusuh skillInjak = new InjakMusuh();
    private boolean jalurTerbuka;
    private boolean bisaInjak;

    public Karakter2(String nama) { super(nama); }

    public void lari() { lari(1); }

    public void lari(int meter) {
        if (!jalurTerbuka) { System.out.println(this + " lari gagal, Karakter1 harus merunduk"); return; }
        skillLari.gunakan(this, meter);
    }

    public void injakMusuh(Musuh m) {
        if (!bisaInjak) { System.out.println(this + " gagal injak, Karakter1 harus loncat dulu"); return; }
        skillInjak.gunakan(this, m);
    }

    public int getJarakLari() { return skillLari.getJarak(); }
    public int getMusuhDiinjak() { return skillInjak.getDipakai(); }

    @Override
    public void terimaBantuan(String jenis) {
        if (jenis.equals("RUNDUK")) { jalurTerbuka = true;  bisaInjak = false; }
        if (jenis.equals("LONCAT")) { bisaInjak = true;     jalurTerbuka = false; }
    }

    @Override
    public String toString() { return "[Karakter2:" + getNama() + "]"; }
}