abstract class Datoteka {

    protected String ime;

    public Datoteka(String ime) {
        this.ime = ime;
    }

    public String vrniIme() {
        return this.ime;
    }

    public abstract int velikost();

    @Override
    public abstract String toString();
}


//+ =======================================================
//+ BesedilnaDatoteka
//+ =======================================================

class BesedilnaDatoteka extends Datoteka {

    private int stZnakov;

    public BesedilnaDatoteka(String ime, int stZnakov) {
        super(ime);
        this.stZnakov = stZnakov;
    }

    @Override
    public int velikost() {
        return this.stZnakov;
    }

    @Override
    public String toString() {
        return String.format("%s [b %d]", this.ime, this.stZnakov);
    }
}


//+ =======================================================
//+ SlikovnaDatoteka
//+ =======================================================

class SlikovnaDatoteka extends Datoteka {

    private int sirina;
    private int visina;

    public SlikovnaDatoteka(String ime, int sirina, int visina) {
        super(ime);
        this.sirina = sirina;
        this.visina = visina;
    }

    @Override
    public int velikost() {
        return 3 * this.sirina * this.visina + 54;
    }

    public int getSirina() {
        return sirina;
    }

    public int getVisina() {
        return visina;
    }

    @Override
    public String toString() {
        return String.format("%s [s %d x %d]", this.ime, this.sirina, this.visina);
    }
}


//+ =======================================================
//+ Imenik
//+ =======================================================

class Imenik extends Datoteka {

    private Datoteka[] datoteke;

    public Imenik(String ime, Datoteka[] datoteke) {
        super(ime);
        this.datoteke = datoteke;
    }

    @Override
    public int velikost() {
        int vsota = 256;  //_ lastna velikost imenika
        for (Datoteka d : datoteke) { //_ gre skozi vse datoteke in prišteva velikosti
            vsota += d.velikost();
        }
        return vsota;
    }

    @Override
    public String toString() {
        return String.format("%s [i %d]", this.ime, this.datoteke.length);
    }

    public int steviloVecjihSlik(int prag) {
        int stevec = 0;
        for (Datoteka d : datoteke) {
            if (d instanceof SlikovnaDatoteka sd) {
                if (sd.getSirina() >= prag && sd.getVisina() >= prag) {
                    stevec++;
                }
            }
        }
        return stevec;
    }

    public String poisci(String ime) {
        return poisci(".", ime);
    }

    private String poisci(String pot, String ime) {

        // najprej preverimo neposredno v imeniku
        for (Datoteka d : datoteke) {
            if (d.vrniIme().equals(ime)) {
                return pot + "/" + ime;
            }
        }

        // nato preiščemo podimenike
        for (Datoteka d : datoteke) {
            if (d instanceof Imenik im) { //_ poiščemo podimenike in poimenujemo "im"
                String najdeno = im.poisci(pot + "/" + im.vrniIme(), ime);
                if (najdeno != null) {
                    return najdeno;
                }
            }
        }

        return null;
    }
}
