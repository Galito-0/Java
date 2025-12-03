public class Premica {

    private double k;
    private double n;

    public Premica(double k, double n) {
        this.k = k;
        this.n = n;
    }

    public double vrniK() {
        return this.k;
    }

    public double vrniN() {
        return this.n;
    }

    public String toString() {
        return String.format(java.util.Locale.US, "y = %.2f x + %.2f", k, n);
    }

    public Tocka tockaPriX(double x) {
        return new Tocka(x, k * x + n);
    }

    public static Premica skoziTocko(double k, Tocka t) {
        double x = t.vrniX();
        double y = t.vrniY();
        return new Premica(k, y - k * x);
    }

    public Premica vzporednica(Tocka t) {
        double x = t.vrniX();
        double y = t.vrniY();
        return new Premica(this.k, y - k * x);
    }

    public Premica pravokotnica(Tocka t) {
        double x = t.vrniX();
        double y = t.vrniY();

        double k_p = -1 / this.k;
        return new Premica(k_p, y - k_p * x);
    }

    public Tocka presecisce(Premica p, double epsilon) {
        double x = (p.n - n)/(k - p.k);
        double y = k * x + n;

        return (Math.abs(k - p.k) < epsilon) ? null : new Tocka(x, y);
    }

    public Tocka projekcija(Tocka t) {
        double x = t.vrniX();
        double y = t.vrniY();

        double x_p = (x + k * y - k * n) / (k * k + 1);
        double y_p = k * x_p + n;

        return new Tocka(x_p, y_p);
    }

    public double razdalja(Tocka t) {
        Tocka p = projekcija(t);

        double dx = t.vrniX() - p.vrniX();
        double dy = t.vrniY() - p.vrniY();

        return Math.hypot(dx, dy);
    }

    public double razdaljaOdIzhodisca() {
        return razdalja(Tocka.izhodisce());
    }

    public double razdalja(double n) {
        return Math.abs(n - this.n) / Math.sqrt(1 + k * k);
    }
}
