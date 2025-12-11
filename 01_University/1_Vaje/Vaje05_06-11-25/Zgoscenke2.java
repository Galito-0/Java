import java.util.Arrays;
import java.util.Scanner;
@SuppressWarnings("unused")

public class Zgoscenke2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int st_zgoscenk = sc.nextInt();
        int velikost_zgoscenk = sc.nextInt();

        int[] datoteke = new int[st_zgoscenk];

        while (sc.hasNextInt()) {
            int velikost_dat = sc.nextInt();

            int index_max_prostora = -1; //_ Indeks zgoščenke z največ prostora
            int max_prostora = -1; //_ Koliko je največ prostora

            for (int i = 0; i < st_zgoscenk; i++) {
                int preostali_prostor = velikost_zgoscenk - datoteke[i]; //_ Preostali prostor na zgoščenki je velikost zgoščenke - velikost datoteke

                if (preostali_prostor >= velikost_dat) { //_ Preverimo, če je sploh še prostor na tem disku za to datoteko
                    if (preostali_prostor > max_prostora) { //_ Preverimo, če je preostali prostor na tem disku večji kot na prejšnjih
                        max_prostora = preostali_prostor; //_ Nov "najbolj prost" prostor
                        index_max_prostora = i; //_ Indeks tega diska
                    }
                }
            }

            if (index_max_prostora == -1) { //_ Če je indeks še vedno == -1, potem datoteka ne more iti na noben disk
                break;
            }

            datoteke[index_max_prostora] += velikost_dat;

            System.out.println(velikost_dat + " EP -> zgoscenka " + (index_max_prostora + 1) + " " + Arrays.toString(datoteke));
        }

        sc.close();
    }
}
