import java.util.Scanner;
@SuppressWarnings("unused")

public class Zgoscenke {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int st_zgoscenk = sc.nextInt();
        int prostor = sc.nextInt();

        int trenutna_zgoscenka = 1;
        int trenutni_prostor = 0;

        while (sc.hasNextInt() && trenutna_zgoscenka <= st_zgoscenk) {
            int velikost_dat = sc.nextInt();

            if (velikost_dat <= (prostor - trenutni_prostor)) {
                trenutni_prostor += velikost_dat;
                System.out.println(velikost_dat + " EP" + " -> " + "zgoscenka " + trenutna_zgoscenka + " (" + trenutni_prostor + " EP)");

            } else {
                trenutna_zgoscenka++;
                if (trenutna_zgoscenka <= st_zgoscenk) {
                    System.out.println(velikost_dat + " EP" + " -> " + "zgoscenka " + trenutna_zgoscenka + " (" + velikost_dat + " EP)");
                }
                trenutni_prostor = velikost_dat;
            }
        }

        sc.close();
    }
}