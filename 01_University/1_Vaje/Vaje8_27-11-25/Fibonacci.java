import java.util.*;
@SuppressWarnings("unused")

public class Fibonacci {
    private int prejsnji;
    private int trenutni;

    public Fibonacci(int a, int b) {
        this.prejsnji = a;
        this.trenutni = b;
    }

    public int naslednji() {
        int naslednji = prejsnji + trenutni;
        prejsnji = trenutni;
        trenutni = naslednji;
        return naslednji;
    }
}
