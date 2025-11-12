import java.util.Scanner;
@SuppressWarnings("unused")

public class DN01_63250206 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //_ Pridobivanje dveh števil za naš kvadrat
        int a = sc.nextInt();
        int b = sc.nextInt();

        int skupno_stevilo = 0; //. Tukaj se hrani število vseh kvadratov, ki jih tvori mreža a x b

        //_ Glavna zanka: izvaja se, dokler velikost kvadrata, ki ga računamo, ne presega velikost mreže a x b (torej, dokler je (a - i > 0) & (b - 1 > 0), oz. (i < a) & (i < b))
        for (int i = 1; (i < a) && (i < b); i++) {
            skupno_stevilo += (a-i) * (b-i); //. Za vsako velikost kvadratov prištejemo število kvadratov k skupno_stevilo
        }

        System.out.println(skupno_stevilo); //. Izpišemo število vseh kvadratov

        sc.close();
    }
}