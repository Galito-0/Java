public class Avtor {
    private String ime;
    private String priimek;

    public Avtor(String ime, String priimek) {
        this.ime = ime;
        this.priimek = priimek;
    }

    public String get_ime() {
        return ime;
    }

    public String get_priimek() {
        return priimek;
    }

    @Override
    public String toString() {
        return this.ime + " " + this.priimek;
    }
}
