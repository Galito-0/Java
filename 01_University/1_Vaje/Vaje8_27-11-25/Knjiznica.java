import java.util.*;
@SuppressWarnings("unused")

public class Knjiznica {
    private int st_clanov;
    private int st_naslovov;
    private int st_izvodov_na_naslov;

    //_ koliko izvodov ima vsak član izposojenih od posameznega naslova
    private int[][] izposoje;

    //_ koliko izvodov posameznega naslova je trenutno posojenih
    private int[] posojeni_izvodi;

    //_ kolikokrat je bil posamezen naslov izposojen v celotni zgodovini
    private int[] statistika_izposoj;

    public Knjiznica(int st_clanov, int st_naslovov, int st_izvodov_na_naslov) {
        this.st_clanov = st_clanov;
        this.st_naslovov = st_naslovov;
        this.st_izvodov_na_naslov = st_izvodov_na_naslov;

        this.izposoje = new int[st_clanov][st_naslovov];
        this.posojeni_izvodi = new int[st_naslovov];
        this.statistika_izposoj = new int[st_naslovov];
    }

    public boolean posodi(int clan, int naslov) {
        //# Preverimo, če je izvod še na volju IN če član clan še nima tega naslova
        if (posojeni_izvodi[naslov] < st_izvodov_na_naslov && izposoje[clan][naslov] == 0) {
            posojeni_izvodi[naslov]++; //_ en manj na voljo
            izposoje[clan][naslov] = 1; //_ clan ima zdaj en izvod
            statistika_izposoj[naslov]++; //_ povečamo število izposoj za ta naslov
            return true;
        }

        return false;
    }

    public void clanVrne(int clan) {
        for (int naslov = 0; naslov < st_naslovov; naslov++) {
            if (izposoje[clan][naslov] == 1) {
                posojeni_izvodi[naslov]--; //_ član clan vrne en izvod naslova
                izposoje[clan][naslov] = 0;
            }
        }
    }

    public int posojeni(int naslov) {
        return posojeni_izvodi[naslov];
    }

    public int priClanu(int clan) {
        int vsota = 0;
        for (int naslov = 0; naslov < st_naslovov; naslov++) {
            vsota += izposoje[clan][naslov];
        }

        return vsota;
    }

    public int najNaslov() {
        int index = 0;
        for (int i = 1; i < st_naslovov; i++) {
            if (statistika_izposoj[i] > statistika_izposoj[index]) {
                index = i;
            }
        }

        return index;
    }
}
