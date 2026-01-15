
import java.util.*;

public class Glavni {

    public static void urediPoLetuInNaslovu(List<Clanek> clanki) {
        clanki.sort((c1, c2) -> {
            if (c1.get_leto() != c2.get_leto()) {
                return Integer.compare(c2.get_leto(), c1.get_leto()); //_ padajoče
            }
            return c1.get_naslov().compareTo(c2.get_naslov()); //_ leksikografsko
        });
    }

    public static Set<Avtor> vsiAvtorji(Collection<Clanek> clanki) {
        Set<Avtor> rezultat = new HashSet<>();

        for (Clanek c : clanki) {
            rezultat.addAll(c.get_avtorji());
        }
        return rezultat;
    }

    public static Map<Avtor, List<Clanek>> clankiPoAvtorjih(Collection<Clanek> clanki) {
        Map<Avtor, List<Clanek>> mapa = new HashMap<>();

        for (Clanek c : clanki) {
            for (Avtor a : c.get_avtorji()) {
                mapa.computeIfAbsent(a, k -> new ArrayList<>()).add(c);
            }
        }

        // ureditev seznamov
        for (List<Clanek> seznam : mapa.values()) {
            seznam.sort((c1, c2) -> {
                if (c1.get_leto() != c2.get_leto()) {
                    return Integer.compare(c2.get_leto(), c1.get_leto());
                }
                return c1.get_naslov().compareTo(c2.get_naslov());
            });
        }

        return mapa;
    }

    public static Avtor najplodnejsiAvtor(Collection<Clanek> clanki) {
        Map<Avtor, Integer> stevec = new HashMap<>();

        for (Clanek c : clanki) {
            for (Avtor a : c.get_avtorji()) {
                stevec.put(a, stevec.getOrDefault(a, 0) + 1);
            }
        }
        
        return Collections.max(stevec.entrySet(), (e1, e2) -> Integer.compare(e1.getValue(), e2.getValue())).getKey();
    }
}
