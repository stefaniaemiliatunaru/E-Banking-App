package org.poo.cb;

public class Cont {

    public String valuta;
    public Valuta creeazaContValuta(String valuta)
    {
        switch (valuta) {
            case "USD": {
                Valuta valutaUsd = new ValutaUsd();
                valutaUsd.valuta = "USD";
                return valutaUsd;
            }
            case "EUR":
                Valuta valutaEur = new ValutaEur();
                valutaEur.valuta = "EUR";
                return valutaEur;
            case "GBP":
                Valuta valutaGbp = new ValutaGbp();
                valutaGbp.valuta = "GBP";
                return valutaGbp;
            case "JPY":
                Valuta valutaJpy = new ValutaJpy();
                valutaJpy.valuta = "JPY";
                return valutaJpy;
            case "CAD":
                Valuta valutaCad = new ValutaCad();
                valutaCad.valuta = "CAD";
                return valutaCad;
            default:
                return null;
        }
    }
}
