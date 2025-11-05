import java.util.Scanner;
@SuppressWarnings("unused")

public class Zbor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] vojaki = new int[n];

        for (int i = 0; i < n; i++) {
            vojaki[i] = sc.nextInt();
        }

        boolean vsaj_eden = false;

        //# Vsako višino primerjamo levo in desno, če obstaja
        for (int i = 0; i < n; i++) {
            if ((i == 0 || vojaki[i - 1] <= vojaki[i]) && (i == n - 1 || vojaki[i] <= vojaki[i + 1])) {
                System.out.println(i);
                vsaj_eden = true;
            }
        }

        //# Če smo našli vsaj enega lokalno pravilnega, je !vsaj_eden == false, torej ne izpiše "NOBEDEN"
        if (!vsaj_eden) {
            System.out.println("NOBEDEN");
        }

        sc.close();
    }
}
