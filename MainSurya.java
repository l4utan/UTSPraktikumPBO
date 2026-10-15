import base.Musuh;
import karakter1.Karakter1;
import karakter2.Karakter2;

public class MainSurya {
    public static void main(String[] args) {
        Karakter1 k1 = new Karakter1("Surya");
        Karakter2 k2 = new Karakter2("Daniel");
        k1.setPartner(k2);

        Musuh[] musuh = { new Musuh("Goomba"), new Musuh("Koopa"), new Musuh("Boo") };

        k1.merunduk();
        k2.lari(5);
        k1.berdiri();
        k1.loncat(2);
        for (Musuh m : musuh) k2.injakMusuh(m);

        boolean menang = k1.getJumlahLoncat() >= 2
                      && k2.getMusuhDiinjak() >= 3
                      && k2.getJarakLari() >= 5;
        System.out.println(menang ? "MISI SELESAI" : "MISI GAGAL");
    }
}