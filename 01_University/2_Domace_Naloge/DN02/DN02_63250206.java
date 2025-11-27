import java.util.Scanner;
@SuppressWarnings("unused")

public class DN02_63250206 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int b = sc.nextInt(); //_ vrsta tipkovnice
        int d = sc.nextInt(); //_ velikost tipkovnice
        int n = sc.nextInt(); //_ število tipk
        int[] tipke = new int[n]; //_ tabela tipk, ki jih želimo doseči

        //- long startTime = System.currentTimeMillis();

        for (int i = 0; i < n; i++) {
            tipke[i] = sc.nextInt();
        }

        if (b == 1) {
            System.out.println(Ravnovrstnica(d, n, tipke));
        } else if (b == 2) {
            System.out.println(Kvadratnica(d, n, tipke));
        } else if (b == 3) {
            System.out.println(Piramidnica(d, n, tipke));
        } else if (b == 4) {
            System.out.println(Spiralnica(d, n, tipke));
        }

        sc.close();

        //- long endTime = System.currentTimeMillis();
        //- System.out.println("Čas: " + (endTime - startTime) + " ms");
    }

    public static int Ravnovrstnica(int d, int n, int[] tipke) {
        int dolzina_poti = 0;

        for (int i = 0; i < n - 1; i++) {
            dolzina_poti += Math.abs(tipke[i + 1] - tipke[i]);
        }

        return dolzina_poti;
    }

    public static int Kvadratnica(int d, int n, int[] tipke) {
        int dolzina_poti = 0;

        for (int i = 0; i < n - 1; i++) {
            dolzina_poti += Math.abs((tipke[i + 1] % d) - (tipke[i] % d)) + Math.abs((tipke[i + 1] / d) - (tipke[i] / d));
        }

        return dolzina_poti;
    }

    public static int Piramidnica(int d, int n, int[] tipke) {
        int dolzina_poti = 0;
        
        int prej_vrsta = -1;
        int prej_stolpec = -1;

        for (int i = 0; i < n; i++) {
            int vsota_stevk = 0;
            int vrsta = 0;

            //#Izračunamo vrsto, v kateri se nahaja tipka
            for (vrsta = 0; vrsta < d; vrsta++) {
                int stevilk_v_vrsti = 2 * vrsta + 1;
                if (tipke[i] < vsota_stevk + stevilk_v_vrsti) {
                    break;
                }

                vsota_stevk += stevilk_v_vrsti;
            }

            //# Izračunamo stolpec, v kateri se nahaja tipka
            int stolpec = tipke[i] - vsota_stevk;
            stolpec += (d - 1 - vrsta);

            //# Prištevamo dolžine poti med dvema številkama
            if (i > 0) {
                dolzina_poti += Math.abs(vrsta - prej_vrsta) + Math.abs(stolpec - prej_stolpec);
            }

            prej_vrsta = vrsta;
            prej_stolpec = stolpec;
        }

        return dolzina_poti;
    }

    public static int Spiralnica(int d, int n, int[] tipke) {
        //# Če je d == 0, je tipkovnica samo 1 kvadrat (0, 0) => vse razdalje so 0.
        if (d == 1) {
            return 0;
        }
        
        int dolzina_poti = 0;

        //# Defininiranje tabele spirala, postavitev števila 0 v center (s koordinatami centra (d / 2))
        int[][] spirala = new int[d][d]; //_ Ustvarimo 2D tabelo (array). Vsak element je sestavljen iz koordinate y (navpična - vrste) in koordinate x (vodoravna - stolpci), torej vsak element predstavlja eno število (točko)
        int center = d / 2; //_ Najdemo center spirale, ki je vedno d / 2 (vedno dobimo celo število (7 / 2 == 3))
        int y = center, x = center; //_ Začnemo z koordinatama y in x = center, torej prva točka je v centru spirale
        int stevilo = 0; //_ Število, ki je v nekem kvadratku spirale (najprej 0 - v centru je vedno 0)
        spirala[y][x] = stevilo++; //_ Element (x, y), ki je trenutno torej (center, center (središče spirale)) ima najprej vrednost 0 (stevilo == 0), torej je center spirale število 0. y so vrstice (vertikalna koordinata) (y++ => navzdol, y-- => navzgor), x so stolpci (vodoravna koordinata x++ => desno, x-- => levo)

        int korakov = 2; //_ Najprej 2 koraka desno, dol, levo in 1 gor, nato +2, ...

        //# Originalen premik diagonalno levo gor (pripišemo število 1)
        x--;
        y--;
        spirala[y][x] = stevilo++;

        //# Izrisujemo spiralo (premiki desno, dol, levo, gor)
        while (stevilo < d * d) {
            for (int i = 1; i <= korakov && stevilo < d * d; i++) {
                x++;
                spirala[y][x] = stevilo++;
            }

            for (int i = 1; i <= korakov && stevilo < d * d; i++) {
                y++;
                spirala[y][x] = stevilo++;
            }

            for (int i = 1; i <= korakov && stevilo < d * d; i++) {
                x--;
                spirala[y][x] = stevilo++;
            }

            for (int i = 1; i < korakov && stevilo < d * d; i++) {
                y--;
                spirala[y][x] = stevilo++;
            }

            //_ Premik levo za 1, gor za 2 (premik v nov "ovoj" spiralnice)
            if (stevilo < d * d) {
                x--;
                y -= 2;
                spirala[y][x] = stevilo++;
            }

            korakov += 2; //_ Vsak nov "ovoj" ima 2 števili več, kot prejšnji
        }

        //# Iščemo koordinate števil (vrsto in stolpec), ki jih je uporabnik vnesel, in računamo Manhattanske razdalje med njimi
        for (int i = 0; i < n - 1; i++) {
            int a = tipke[i]; //_ Vzamemo število iz tabele (najprej 1. (indeks i = 0))
            int b = tipke[i + 1]; //_ Vzamemo naslednje število iz tabele

            boolean nasli_stevili = false; //_ Ko najdemo obe števili (torej sta poznani koordinati ay || ax && by || bx), lahko prekinemo glavno for zanko

            int ay = -1, ax = -1, by = -1, bx = -1;
            for (int vrsta = 0; vrsta < d && !nasli_stevili; vrsta++) {
                for (int stolpec = 0; stolpec < d; stolpec++) {
                    if (spirala[vrsta][stolpec] == a) { 
                        ay = vrsta; 
                        ax = stolpec; 
                    }

                    if (spirala[vrsta][stolpec] == b) { 
                        by = vrsta; 
                        bx = stolpec; 
                    }

                    if (ay != -1 && by != -1) {
                        nasli_stevili = true;
                        break;
                    }
                }
            }

            dolzina_poti += Math.abs(by - ay) + Math.abs(bx - ax); //_ Izračunamo in prištevamo dolžine poti med številkami
        }

        return dolzina_poti;
    }
}
