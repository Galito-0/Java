@SuppressWarnings("unused")

public class Oseba {
    private String ime;
    private String priimek;
    private char spol;
    private int letoRojstva;
    private Oseba oce;
    private Oseba mati;

    public Oseba(String ime, String priimek, char spol, int letoRojstva, Oseba oce, Oseba mati) {
        this.ime = ime;
        this.priimek = priimek;
        this.spol = spol;
        this.letoRojstva = letoRojstva;
        this.oce = oce;
        this.mati = mati;
    }

    public String vrniIme() {
        return this.ime;
    }

    public String toString() {
        return this.ime + " " + this.priimek + " (" + this.spol + "), " + this.letoRojstva;
    }

    public int starost(int leto) {
        //# Izračunamo starost osebe
        return leto - this.letoRojstva;
    }

    public boolean jeStarejsaOd(Oseba os) {
        //# Preverimo, če je oseba this starejša od osebe os in vrnemo boolean
        return this.letoRojstva < os.letoRojstva;
    }

    public static Oseba starejsa(Oseba a, Oseba b) {
        // if (a.letoRojstva < b.letoRojstva) {
        //     return a;
        // } else if (b.letoRojstva < a.letoRojstva) {
        //     return b;
        // } else {
        //     return null;
        // }

        //# Preverimo, katera od oseb a in b je starejša, ali če sta enako stari
        return (a.letoRojstva < b.letoRojstva) ? a : (b.letoRojstva < a.letoRojstva) ? b : null;
    }

    public String imeOceta() {
        // if (oce != null) {
        //     return oce.ime;
        // } else {
        //     return null;
        // }
        
        //# Če oče ni "null", vrne ime očeta
        return (oce != null) ? oce.ime : null;
    }

    public boolean jeBratAliSestraOd(Oseba os) {
        //# Vrnemo true samo, ko oseba this != osebi os, ter če imata osebi istega očeta in isto mater
        return this != os && this.oce == os.oce && this.mati == os.mati;
    }

    public boolean jeSestraOd(Oseba os) {
        //# Vrnemo true samo, ko oseba this != osebi os, če imata osebi istega očeta in isto mater, ter če je oseba this ženska
        return this != os && this.oce == os.oce && this.mati == os.mati && this.spol == 'Z'; 
    }

    public boolean jeTetaOd(Oseba os) {
        //# Vrnemo true samo, ko je oseba this ženska IN je sestra od ali očeta osebe os (če obstaja) ali matere osebe os (če obstaja)
        return this.spol == 'Z' && (os.oce != null && this.jeSestraOd(os.oce) || os.mati != null && this.jeSestraOd(os.mati));
    }

    public boolean jeOcetovskiPrednikOd(Oseba os) {
        //# Začnemo z očetom osebe os
        Oseba trenutni_oce = os.oce;

        //# Gremo skozi verigo očetov
        while (trenutni_oce != null) {
            // Vrnemo true, če najdemo osebo this, ki je očetovski prednik osebe os
            if (trenutni_oce == this) {
                return true;
            }

            // Premaknemo se na očeta trenutnega očeta, in tako dalje ...
            trenutni_oce = trenutni_oce.oce;
        }

        //# Če smo prišli do konca in nismo našli osebe this, potem this ni očetovski prednik osebe os
        return false;
    }
}
