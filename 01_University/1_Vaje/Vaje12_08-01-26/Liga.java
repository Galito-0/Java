
import java.util.*;

@SuppressWarnings("unused")

public class Liga {

    private Collection<String> klubi;
    private Collection<Tekma> tekme;

    public Liga(Collection<String> klubi, Collection<Tekma> tekme) {
        this.klubi = klubi;
        this.tekme = tekme;
    }

    public int steviloTock(String klub) {
        int skupno = 0;
        for (Tekma tekma : this.tekme) {
            skupno += tekma.steviloTock(klub);
        }
        return skupno;
    }

    public Slovar<String, Integer> klub2tocke() {
        Slovar<String, Integer> rezultat = new Slovar<>();

        for (String klub : this.klubi) {
            int tocke = this.steviloTock(klub);
            rezultat.shrani(klub, tocke);
        }

        return rezultat;
    }

    public List<String> lestvica() {
        Slovar<String, Integer> slovar = this.klub2tocke();
        List<String> seznam = new ArrayList<>();

        for (String klub : this.klubi) {
            seznam.add(klub);
        }

        Collections.sort(seznam, new Comparator<String>() {
            @Override
            public int compare(String k1, String k2) {
                int t1 = slovar.vrni(k1);
                int t2 = slovar.vrni(k2);

                if (t1 != t2) {
                    return t2 - t1; // _ več točk je prej
                } else {
                    return k1.compareTo(k2); // _ leksikografsko
                }
            }
        });

        return seznam;
    }

    public Iterator<Tekma> poTekmah(int minGR) {
        return new Iterator<Tekma>() {
            private Iterator<Tekma> it = tekme.iterator();
            private Tekma naslednja = najdiNaslednjo();

            // poišče prvo naslednjo tekmo, ki ustreza pogoju
            private Tekma najdiNaslednjo() {
                while (it.hasNext()) {
                    Tekma t = it.next();
                    int razlika = Math.abs(t.get_goli_domacih() - t.get_goli_gostov());
                    if (razlika >= minGR) {
                        return t;
                    }
                }
                return null;
            }

            @Override
            public boolean hasNext() {
                return naslednja != null;
            }

            @Override
            public Tekma next() {
                if (naslednja == null) {
                    throw new NoSuchElementException();
                }
                Tekma trenutno = naslednja;
                naslednja = najdiNaslednjo();
                return trenutno;
            }
        };
    }
}
