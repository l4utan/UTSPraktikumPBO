import base.Musuh;
import karakter1.Karakter1;
import karakter2.Karakter2;

public class MainDaniel {
    public static void main(String[] args) {
        Karakter1 k1 = new Karakter1("Laut");
        Karakter2 k2 = new Karakter2("Daniel");
        k1.setPartner(k2);

        Musuh[] musuh = { new Musuh("Slime"), new Musuh("Bat") };

        k1.merunduk();
        k2.lari(3);
        k1.berdiri();
        k1.loncat(3);
        for (Musuh m : musuh) k2.injakMusuh(m);

        boolean menang = k1.getJumlahLoncat() >= 3
                      && k2.getMusuhDiinjak() >= 2
                      && k2.getJarakLari() >= 3;
        System.out.println(menang ? "MISI SELESAI" : "MISI GAGAL");
    }
}
