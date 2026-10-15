package skill;

import base.Karakter;
import base.Musuh;
import base.Skills;

public class InjakMusuh extends Skills {
    public InjakMusuh() { super("InjakMusuh"); }

    @Override
    public void gunakan(Karakter pemilik) {
        System.out.println(pemilik + " butuh target musuh");
    }

    public void gunakan(Karakter pemilik, Musuh m) {    // overloading
        m.kalah();
        catat();
        System.out.println(pemilik + " injak " + m.getNama() + " (total " + getDipakai() + ")");
        if (pemilik.getPartner() != null) pemilik.getPartner().terimaBantuan("INJAK");
    }
}