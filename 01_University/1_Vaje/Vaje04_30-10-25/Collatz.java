import java.util.Scanner;
@SuppressWarnings("unused")

public class Collatz {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();

        collatz(a, b);

        sc.close();
    }

    public static void collatz(int a, int b) {
        int trenutna_dolzina = 0;
        int najdaljsa_dolzina = 0;
        int pravo_stevilo = 0;

        for (int i = a; i <= b; i++) {
            long trenutno_stevilo = i;
            trenutna_dolzina = 1;

            while (trenutno_stevilo != 1) {
                if (trenutno_stevilo % 2 == 0) {
                    trenutno_stevilo /= 2;
                } else {
                    trenutno_stevilo = 3 * trenutno_stevilo + 1;
                }
                trenutna_dolzina++;
            }

            if (trenutna_dolzina > najdaljsa_dolzina) {
                najdaljsa_dolzina = trenutna_dolzina;
                pravo_stevilo = i;
            }
        }

        System.out.println(pravo_stevilo);
        System.out.println(najdaljsa_dolzina);
    }
}
