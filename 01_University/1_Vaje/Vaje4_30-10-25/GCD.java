import java.util.Scanner;
@SuppressWarnings("unused")

public class GCD {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int g = sc.nextInt();

        for (int i = 1; i <= n / g; i++) {
            for (int j = i; j <= n / g; j++) {
                if (gcd(i, j) == 1) {
                    System.out.println("(" + (g * i) +", " + (g * j) + ")");
                }
            }
        }

        sc.close();
    }

    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}

// import java.util.Scanner;
// @SuppressWarnings("unused")

// public class GCD {
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);

//         int n = sc.nextInt();
//         int g = sc.nextInt();

//         for (int i = 1; i <= n; i++) {
//             for (int j = i; j <= n; j++) {
//                 if (gcd(i, j) == g) {
//                     System.out.println("(" + i +", " + j + ")");
//                 }
//             }
//         }

//         sc.close();
//     }

//     public static int gcd(int a, int b) {
//         if (b == 0) {
//             return a;
//         }
//         return gcd(b, a % b);
//     }
// }