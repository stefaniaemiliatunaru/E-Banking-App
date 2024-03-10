package org.poo.cb;

import java.util.ArrayList;
import java.util.List;

public class SchimbValutar implements Comanda {
    public String email;
    public String valutaSursa;
    public String valutaDestinatie;
    public double sumaTranzactie;
    public ArrayList<Utilizator> utilizatori;
    List<double[]> matriceSchimb;
    public SchimbValutar(String email, String valutaSursa, String valutaDestinatie, int sumaTranzactie, ArrayList<Utilizator> utilizatori, List<double[]> matriceSchimb) {
        this.email = email;
        this.valutaSursa = valutaSursa;
        this.valutaDestinatie = valutaDestinatie;
        this.sumaTranzactie = sumaTranzactie;
        this.utilizatori = utilizatori;
        this.matriceSchimb = matriceSchimb;
    }
    public void execute() {
        Utilizator utilizator = null;
        for (int i = 0; i < utilizatori.size(); i++) {
            if (utilizatori.get(i).email.equals(email)) {
                utilizator = utilizatori.get(i);
                break;
            }
        }
        Valuta contSursa = null;
        for (int i = 0; i < utilizator.conturi.size(); i++) {
            if (utilizator.conturi.get(i).valuta.equals(valutaSursa)) {
                contSursa = utilizator.conturi.get(i);
                break;
            }
        }
        Valuta contDestinatie = null;
        for (int i = 0; i < utilizator.conturi.size(); i++) {
            if (utilizator.conturi.get(i).valuta.equals(valutaDestinatie)) {
                contDestinatie = utilizator.conturi.get(i);
                break;
            }
        }
        if (sumaTranzactie > contSursa.suma) {
            System.out.println("Insufficient amount in account " + valutaSursa + " for exchange");
            return;
        }
        double rataSchimb = 0;
        if (valutaSursa.equals("EUR")) {
            if (valutaDestinatie.equals("GBP"))
                rataSchimb = matriceSchimb.get(1)[0];
            if (valutaDestinatie.equals("JPY"))
                rataSchimb = matriceSchimb.get(2)[0];
            if (valutaDestinatie.equals("CAD"))
                rataSchimb = matriceSchimb.get(3)[0];
            if (valutaDestinatie.equals("USD"))
                rataSchimb = matriceSchimb.get(4)[0];
        }
        if (valutaSursa.equals("GBP")) {
            if (valutaDestinatie.equals("EUR"))
                rataSchimb = matriceSchimb.get(0)[1];
            if (valutaDestinatie.equals("JPY"))
                rataSchimb = matriceSchimb.get(2)[1];
            if (valutaDestinatie.equals("CAD"))
                rataSchimb = matriceSchimb.get(3)[1];
            if (valutaDestinatie.equals("USD"))
                rataSchimb = matriceSchimb.get(4)[1];
        }
        if (valutaSursa.equals("JPY")) {
            if (valutaDestinatie.equals("EUR"))
                rataSchimb = matriceSchimb.get(0)[2];
            if (valutaDestinatie.equals("GBP"))
                rataSchimb = matriceSchimb.get(1)[2];
            if (valutaDestinatie.equals("CAD"))
                rataSchimb = matriceSchimb.get(3)[2];
            if (valutaDestinatie.equals("USD"))
                rataSchimb = matriceSchimb.get(4)[2];
        }
        if (valutaSursa.equals("CAD")) {
            if (valutaDestinatie.equals("EUR"))
                rataSchimb = matriceSchimb.get(0)[3];
            if (valutaDestinatie.equals("GBP"))
                rataSchimb = matriceSchimb.get(1)[3];
            if (valutaDestinatie.equals("JPY"))
                rataSchimb = matriceSchimb.get(2)[3];
            if (valutaDestinatie.equals("USD"))
                rataSchimb = matriceSchimb.get(4)[3];
        }
        if (valutaSursa.equals("USD")) {
            if (valutaDestinatie.equals("EUR"))
                rataSchimb = matriceSchimb.get(0)[4];
            if (valutaDestinatie.equals("GBP"))
                rataSchimb = matriceSchimb.get(1)[4];
            if (valutaDestinatie.equals("JPY"))
                rataSchimb = matriceSchimb.get(2)[4];
            if (valutaDestinatie.equals("CAD"))
                rataSchimb = matriceSchimb.get(3)[4];
        }
        if (utilizator.premium == 0) {
            if ((sumaTranzactie * rataSchimb) > (contSursa.suma / 2)) {
                double comision = 0.01 * sumaTranzactie * rataSchimb;
                contSursa.suma = contSursa.suma - (sumaTranzactie * rataSchimb + comision);
            } else {
                contSursa.suma = contSursa.suma - sumaTranzactie * rataSchimb;
            }
            contDestinatie.suma = contDestinatie.suma + sumaTranzactie;
        } else {
            contSursa.suma = contSursa.suma - sumaTranzactie * rataSchimb;
            contDestinatie.suma = contDestinatie.suma + sumaTranzactie;
        }
    }
}
