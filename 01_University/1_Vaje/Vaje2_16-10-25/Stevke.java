import java.util.Scanner;
@SuppressWarnings("unused")

public class Stevke {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //_ Uporabnik vnese številko
        long a = sc.nextLong();

        //_ Dokler je a večji od 0 izpisujemo števke
        while (a > 0) {
            long stevka = a % 10; //. Najprej pogledamo ostanek deljenja števila z 10, to je zadnja števka
            System.out.println(stevka); //. To števko izpišemo
            a /= 10; //. Število delimo z deset, ker sta obe celi, dobimo celo, ki je enako prejšnjemu, brez zadnje števke
        }

        sc.close();
    }
}
