
import java.util.*;
@SuppressWarnings("unused")

public class Tekma {

    private String domaci;
    private String gostje;
    private int goliDomacih;
    private int goliGostov;

    public Tekma(String domaci, String gostje, int goliDomacih, int goliGostov) {
        this.domaci = domaci;
        this.gostje = gostje;
        this.goliDomacih = goliDomacih;
        this.goliGostov = goliGostov;
    }

    public int steviloTock(String klub) {
        //_ če klub ni nastopal
        if (!klub.equals(this.domaci) && !klub.equals(this.gostje)) {
            return 0;
        }

        //_ remi
        if (this.goliDomacih == this.goliGostov) {
            return 1;
        }

        //_ zmaga domačih
        if (this.goliDomacih > this.goliGostov) {
            return klub.equals(this.domaci) ? 3 : 0;
        }

        //_ zmaga gostov
        return klub.equals(this.gostje) ? 3 : 0;
    }

    @Override
    public String toString() {
        return String.format("%s %d : %d %s", this.domaci, this.goliDomacih,
                this.goliGostov, this.gostje);
    }

    public int get_goli_domacih() {
        return goliDomacih;
    }

    public int get_goli_gostov() {
        return goliGostov;
    }
}
