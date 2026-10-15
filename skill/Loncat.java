package skill;

import base.Karakter;
import base.Skills;

public class Loncat extends Skills {
    public Loncat() { super("Loncat"); }

    @Override
    public void gunakan(Karakter pemilik) {
        catat();
        System.out.println(pemilik + " loncat (total " + getDipakai() + ")");
        if (pemilik.getPartner() != null) pemilik.getPartner().terimaBantuan("LONCAT");
    }

    public void gunakan(Karakter pemilik, int kali) {   // overloading
        for (int i = 0; i < kali; i++) gunakan(pemilik);
    }
}