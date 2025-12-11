import java.util.Scanner;
@SuppressWarnings("unused")

public class Piramida {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {

            //_ Za vsako vrstico potrebujemo n - i presledkov, da zvezde centriramo (v prvi n - 1, v drugi n -2, ...)
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }

            //_ Vsaka vrstica ima 2 * i - 1 zvezd (v prvi 2 * 1 - 1 = 1, v drugi 2 * 2 - 1 = 3, ...)
            for (int j = 1; j <= 2 * i - 1; j++) {
                System.out.print("*");
            }
            
            System.out.println(); //. Premaknemo se v novo vrstico
        }

        sc.close();
    }
}