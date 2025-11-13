import java.util.Scanner;
@SuppressWarnings("unused")

public class Ploscicar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int h = sc.nextInt();
        int w = sc.nextInt();
        int k = sc.nextInt();

        System.out.println(Stevilo_Ploscic(h, w, k));

        sc.close();
    }

    public static long Stevilo_Ploscic(int h, int w, int k) {

        //# Če je ena od dimenzij 0, ne potrebujemo ploščic
        //# Prepreči neskončno klicanje funkcije
        if (h == 0 || w == 0) {
            return 0;
        }

        //# Največja potenca 2, ki se prilega obema dimenzijama
        int max_velikost = (int) Math.pow(2, k);
        
        //# Preverja, kako dolgo je ploščica 2^k prevelika za našo steno
        //# in ga zmanjšuje, dokler ne "paše" ploščica noter. Če je k negativen,
        //# ne obstaja več ploščica, ki bi se prilegala steni -> vrnemo 0
        while (max_velikost > Math.min(h, w)) {
            k--;
            if (k < 0) {
                return 0;
            }
            max_velikost = (int) Math.pow(2, k);
        }

        //# Koliko takih ploščic gre po širini in po višini
        int po_sirini = w / max_velikost;
        int po_dolzini = h / max_velikost;

        //# Število ploščic
        long st_ploscic = (long) po_sirini * po_dolzini;

        //# Ostanki
        int ostanek_w = w % max_velikost; //_ ostanek desno
        int ostanek_h = h % max_velikost; //_ ostanek spodaj

        //# Za vsak ostanek spet izračunamo, koliko ploščic gre v novo steno
        //# in vsakič enkrat odštejemo kot spodaj desno, ker je dodan dvakrat
        st_ploscic += Stevilo_Ploscic(h, ostanek_w, k); //_ ostanek desno, enako visok (h), širok samo ostanek_w
        st_ploscic += Stevilo_Ploscic(ostanek_h, w, k); //_ ostanek spodaj, enako širok (w), visok samo ostanek_h
        st_ploscic -= Stevilo_Ploscic(ostanek_h, ostanek_w, k); //_ ostanek desno spodaj, visok ostanek_h, širok ostanek_w, upoštevan je 2x -> enkrat odštejeom

        return st_ploscic;
    }
}
