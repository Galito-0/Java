import java.util.Scanner;

public class Vsota1 {
    public static void main(String[] args) {
        Scanner vs = new Scanner(System.in);

        int a = vs.nextInt();
        int b = vs.nextInt();

        System.out.println(a + b);

        vs.close();
    }
}