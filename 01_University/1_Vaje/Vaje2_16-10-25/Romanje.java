import java.util.Scanner;
@SuppressWarnings("unused")

public class Romanje {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int d = sc.nextInt();
        int p = sc.nextInt();
        int z = sc.nextInt();

        int preostanek = d;
        int danes_pot = p;

        //_ Glavna zanka: izvaja se, dokler še ima pot za prehoditi (preostanek > 0) oz. še ni preveč utrujen (danes_pot > 0)
        for (int i = 1; (preostanek > 0) && (danes_pot > 0); i++) {
            int zacetek_dneva = preostanek; //. Toliko še ima za prehoditi vsak naslednji dan

            //_ Preverimo, če danes prehodi več kot je še preostalo; potem prehodi samo toliko, koliko je še preostalo.
            if (danes_pot > preostanek) {
                danes_pot = preostanek;
            }

            preostanek -= danes_pot; //. Preostanek njegovi poti se zmanjša za toliko, kolikor je danes prehodil

            System.out.println(i + ": " + zacetek_dneva + " -> " + preostanek);

            danes_pot -= z; //. Naslednji dan bo lahko prehodil manj, ker izgublja energijo (z)
        }

        sc.close();
    }
}
