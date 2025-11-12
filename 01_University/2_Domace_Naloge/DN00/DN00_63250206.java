import java.util.Scanner;

public class DN00_63250206 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int st_bonbonov = sc.nextInt(); //. Uporabnik vnese število bonbonov.
        int st_prijateljev = sc.nextInt(); //. Uporabnik vnese število prijateljev.

        int vsak = st_bonbonov / st_prijateljev; // . Izračunamo, koliko bonbonov dobi vsak od prijateljev. Deljenje celega števila z celim da celo število.
        int ostanek = st_bonbonov % st_prijateljev; //. Izračunamo, koliko bonbonov ostane, z ostankom.

        System.out.println(vsak); //. Izpišemo število bonbonov, ki jih dobi vsak od prijateljev.
        System.out.println(ostanek); //. Izpišemo, koliko bonbonov ostane.

        sc.close();
    }
}