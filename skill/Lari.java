package skill;

import base.Karakter;
import base.Skill;

public class Lari extends Skill {
    private int jarak;

    public Lari() { super("Lari"); }

    public int getJarak() { return jarak; }

    @Override
    public void gunakan(Karakter pemilik) { gunakan(pemilik, 1); }

    public void gunakan(Karakter pemilik, int meter) {  // overloading
        catat();
        jarak += meter;
        System.out.println(pemilik + " lari " + meter + "m (total " + jarak + "m)");
    }
}

