import java.util.Scanner;

public class Vsota2 {
    public static void main(String[] args) {
        Scanner vs = new Scanner(System.in);

        int a = vs.nextInt();
        int b = vs.nextInt();

        int vsota = a + b;

        System.out.println(a + " + " + b + " = " + vsota);

        vs.close();
    }
}