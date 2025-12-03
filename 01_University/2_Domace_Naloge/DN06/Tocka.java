public class Tocka {
    private double x;
    private double y;

    public Tocka(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double vrniX() {
        return this.x;
    }

    public double vrniY() {
        return this.y;
    }

    public String toString() {
        return String.format(java.util.Locale.US, "(%.2f, %.2f)", x, y);
    }

    public double razdalja(Tocka t) {
        return Math.hypot(t.x - this.x, t.y - this.y);
    }

    public static Tocka izhodisce() {
        return new Tocka(0, 0);
    }

    public double razdaljaOdIzhodisca() {
        return Math.hypot(this.x, this.y);
    }
}
