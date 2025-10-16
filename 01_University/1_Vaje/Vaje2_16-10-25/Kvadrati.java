import java.util.Scanner;
@SuppressWarnings("unused")

public class Kvadrati {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //_ Uporabnik vnese dve števili (b > a)
        int a = sc.nextInt();
        int b = sc.nextInt();

        //_ Dokler je a manjši ali enak b, izpisujemo kvadrate a in ga večamo za 1, dokler ni enak b
        while (a <= b) {
            System.out.println(a * a);
            a++;
        }

        sc.close();
    }
}
