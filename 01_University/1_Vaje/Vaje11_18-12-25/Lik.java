
import java.util.*;

public abstract class Lik implements Comparable<Lik> {

    public abstract int ploscina();

    public abstract int obseg();

    protected abstract int tip();

    public String toString() {
        return String.format("%s [%s]", this.vrsta(), this.podatki());
    }

    // Vrne vrsto lika <this> (npr. "pravokotnik").
    public abstract String vrsta();

    // Vrne niz s podatki o liku <this>
    // (npr. "širina = 3.0, višina = 4.0").
    public abstract String podatki();

    public static void izpisi(Vektor<Lik> vektor) {
        int stElementov = vektor.steviloElementov();
        for (int i = 0; i < stElementov; i++) {
            Lik lik = vektor.vrni(i);
            System.out.printf("%s | p = %d | o = %d%n",
                    lik.toString(), lik.ploscina(), lik.obseg());
        }
    }

    //! compareTo
    @Override
    public int compareTo(Lik other) {
        return Integer.compare(this.ploscina(), other.ploscina());
    }

    //! poObsegu
    public static Comparator<Lik> poObsegu() {
        return new Comparator<Lik>() {
            @Override
            public int compare(Lik a, Lik b) {
                return Integer.compare(a.obseg(), b.obseg());
            }
        };
    }

    //! poTipu
    public static Comparator<Lik> poTipu() {
        return new Comparator<Lik>() {
            @Override
            public int compare(Lik a, Lik b) {
                return Integer.compare(a.tip(), b.tip());
            }
        };
    }

    //! urediPoTipuInObsegu
    public static void urediPoTipuInObsegu(Vektor<Lik> vektor) {
        Comparator<Lik> primerjalnik = Skupno.kompozitum(Lik.poTipu(), Lik.poObsegu());
        Skupno.uredi(vektor, primerjalnik);
    }
}