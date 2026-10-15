package skill;

import base.Karakter;
import base.Skills;

public class Merunduk extends Skills {
    public Merunduk() { super("Merunduk"); }

    @Override
    public void gunakan(Karakter pemilik) {
        catat();
        System.out.println(pemilik + " merunduk");
        if (pemilik.getPartner() != null) pemilik.getPartner().terimaBantuan("RUNDUK");
    }
}