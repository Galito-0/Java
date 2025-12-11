import java.util.Scanner;
@SuppressWarnings("unused")

public class Volitve {
    public static int steviloGlasov(int[][][] t, int leto, int stranka) {
        int vsota_glasov = 0;

        //# Leto in stranka sta podana, zato gremo skozi vsa volišča in seštevamo,
        //# koliko glasov je dana stranka v danem letu dobila v vsakem volišču.
        for (int volisce = 0; volisce < t[0][0].length; volisce++) {
            vsota_glasov += t[leto][stranka][volisce];
        }

        return vsota_glasov;
    }

    public static int[][] glasovi(int[][][] t) {
        int L = t.length; //_ število let
        int S = t[0].length; //_ število strank
        int V = t[0][0].length; //_ število volišč

        int[][] rezultat = new int[L][S];

        //# Gremo skozi vsa leta za in skozi vse stranke v tem letu, ter
        //# vsaki pripiše skupno število glasov (skozi vsa volišča)
        for (int leto = 0; leto < L; leto++) {
            for (int stranka = 0; stranka < S; stranka++) {
                int vsota_glasov = 0;
                for (int volisce = 0; volisce < V; volisce++) {
                    vsota_glasov += t[leto][stranka][volisce];
                }
                rezultat[leto][stranka] = vsota_glasov;
            }
        }

        return rezultat;
    }

    public static int najVolisce(int[][][] t, int stranka) {
        int L = t.length; //_ število let
        int V = t[0][0].length; //_ število volišč

        int max_glasov = 0; //_ trenutno največje število glasov
        int index_volisca = -1; //_ index volišča

        //# Podano imamo stranko. Najprej gremo skozi vsako volišče in seštejemo skupno
        //# vsoto glasov, ki jih je dana stranka dobila na tem volišču skozi vsa leta. 
        //# Nato preverimo, če je vsota večja od trenutne max vsote, če je, jo priredimo
        //# max_glasov, in priredimo index tega volišča index_volisca
        for (int volisce = 0; volisce < V; volisce++) {
            int vsota_glasov = 0;

            for (int leto = 0; leto < L; leto++) {
                vsota_glasov += t[leto][stranka][volisce];
            }

            if (vsota_glasov > max_glasov) {
                max_glasov = vsota_glasov;
                index_volisca = volisce;
            }
        }

        return index_volisca;
    }

    public static int vsotaUvrstitev(int[][][] t, int stranka, int volisce) {
        int L = t.length; //_ število let
        int S = t[0].length; //_ število strank
        
        int vsota = 0; //_ začetna vsota uvrstitev
        
        //# Za vsako leto najprej pogledamo vsoto glasov dane stranke na danem volišču,
        //# nato pa za vsako stranko preverimo, če ima več glasov kot "naša", če ima,
        //# povečamo uvrstitev za 1 (npr. gre iz 1. na 2. mesto ...)
        for (int leto = 0; leto < L; leto++) {
            int uvrstitev = 1; //_ začetna uvrstitev v vsakem letu
            int vsota_glasov = t[leto][stranka][volisce]; //_ vsota glasov dane stranke na danem volišču v tem letu

            // Gremo skozi vsako stranko (vključno z dano) in preverimo, če ima
            // *strogo* več glasov kot "naša" ("naša" nima strogo več kot "naša")
            for (int s = 0; s < S; s++) {
                if (t[leto][s][volisce] > vsota_glasov) {
                    uvrstitev++;
                }
            }

            vsota += uvrstitev; //_ prištevamo uvrstitve skozi leta
        }
        
        return vsota;
    }
}
