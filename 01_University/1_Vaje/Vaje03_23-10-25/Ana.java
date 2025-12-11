import java.util.Scanner;
@SuppressWarnings("unused")

public class Ana {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int d = sc.nextInt();

        int kombinacij = 0;

        //_ Teče, dokler a ni enak 10 (začnemo z a = 1, vsakič povečamo za 2, ker je lih)
        for (int a = 1; a <= 9; a += 2) {
            //_ Teče, dokler b ni enak 10 (začnemo z b = m + 1, ker je b večji kot m, vsakič povečamo za 1)
            for (int b = m + 1; b <= 9; b++) {
                //_ Teče, dokler c ni enak 10 (začnemo z 0, ker je 0 deljivo z vsemi števkami, potem pa preverimo za vsak c+1)
                for (int c = 0; c <= 9; c++) {
                    if (c % d == 0) {
                        System.out.println(a + "-" + b + "-" + c);
                        kombinacij++;
                    }
                }
            }
        }

        System.out.println(kombinacij); //. Na koncu izpišemo število kombinacij

        sc.close();
    }
}