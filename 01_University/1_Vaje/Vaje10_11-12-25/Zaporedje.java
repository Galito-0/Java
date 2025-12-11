public abstract class Zaporedje {

    public abstract Integer y(int x);

    public String vNiz(Interval interval) {
        StringBuilder sb = new StringBuilder("[");
        int zacetek = interval.vrniZacetek();
        int konec = interval.vrniKonec();
        boolean prvic = true;
        for (int x = zacetek; x <= konec; x++) {
            Integer y = this.y(x);
            if (y != null) {
                if (!prvic) {
                    sb.append(", ");
                }
                prvic = false;
                sb.append(String.format("%d -> %d", x, y));
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public Interval minMax(Interval interval) {
        Integer min = null;
        Integer max = null;

        for (int x = interval.vrniZacetek(); x <= interval.vrniKonec(); x++) {
            Integer y = this.y(x);
            if (y != null) {
                if (min == null || y < min)
                    min = y;
                if (max == null || y > max)
                    max = y;
            }
        }

        return new Interval(min, max);
    }

    public boolean jeMonotono(Interval interval) {
        Integer prejsnja = null;
        Boolean narascajoce = null;

        for (int x = interval.vrniZacetek(); x <= interval.vrniKonec(); x++) {
            Integer y = this.y(x);
            if (y == null)
                continue;

            if (prejsnja != null) {
                if (narascajoce == null) {
                    if (y > prejsnja)
                        narascajoce = true;
                    else if (y < prejsnja)
                        narascajoce = false;
                    else {
                        return false;
                    }
                } else {
                    if ((narascajoce && y <= prejsnja) || (!narascajoce && y >= prejsnja)) {
                        return false; // kršitev
                    }
                }
            }
            prejsnja = y;
        }

        // Če ni definirana nobena vrednost, ali vse preverjene so strogo monotone
        return true;
    }

    public Zaporedje vsota(Zaporedje drugo) {
        // Podrazred, ki predstavlja vsoto dveh zaporedij
        class Vsota extends Zaporedje {
            private Zaporedje a;
            private Zaporedje b;

            public Vsota(Zaporedje a, Zaporedje b) {
                this.a = a;
                this.b = b;
            }

            @Override
            public Integer y(int x) {
                Integer ya = a.y(x);
                Integer yb = b.y(x);
                if (ya != null && yb != null) {
                    return ya + yb;
                } else {
                    return null;
                }
            }
        }

        return new Vsota(this, drugo);
    }

    public Zaporedje inverz(Interval interval) {
        if (!this.jeMonotono(interval)) {
            return null;
        }

        class Inverz extends Zaporedje {
            private Zaporedje original;
            private Interval inter;

            public Inverz(Zaporedje original, Interval inter) {
                this.original = original;
                this.inter = inter;
            }

            @Override
            public Integer y(int x) {
                for (int y = inter.vrniZacetek(); y <= inter.vrniKonec(); y++) {
                    Integer fy = original.y(y);
                    if (fy != null && fy == x) {
                        return y;
                    }
                }
                return null;
            }
        }

        return new Inverz(this, interval);
    }
}
