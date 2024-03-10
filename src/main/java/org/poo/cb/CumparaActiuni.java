package org.poo.cb;

import java.util.ArrayList;
import java.util.List;

public class CumparaActiuni implements Comanda {
    public String email;
    public String companie;
    public int numarActiuni;
    public ArrayList<Utilizator> utilizatori;
    List<String[]> matriceActiuni;
    List<String> actiuniRecomandate;
    public CumparaActiuni(String email, String companie, int numarActiuni, ArrayList<Utilizator> utilizatori, List<String[]> matriceActiuni, List<String> actiuniRecomandate) {
        this.email = email;
        this.companie = companie;
        this.numarActiuni = numarActiuni;
        this.utilizatori = utilizatori;
        this.matriceActiuni = matriceActiuni;
        this.actiuniRecomandate = actiuniRecomandate;
    }
    public void execute() {
        Utilizator utilizator = null;
        for (int i = 0; i < utilizatori.size(); i++) {
            if (utilizatori.get(i).email.equals(email)) {
                utilizator = utilizatori.get(i);
                break;
            }
        }
        Actiune actiune = new Actiune();
        for (int i = 0; i < matriceActiuni.size(); i++) {
            if (matriceActiuni.get(i)[0].equals(companie)) {
                actiune.nume = companie;
                actiune.valoareActiune = Double.parseDouble(matriceActiuni.get(i)[matriceActiuni.get(i).length - 1]);
                actiune.numarActiuni = numarActiuni;
                break;
            }
        }
        Valuta cont = null;
        for (int i = 0 ; i < utilizator.conturi.size(); i++) {
            if (utilizator.conturi.get(i).valuta.equals("USD")) {
                cont = utilizator.conturi.get(i);
                break;
            }
        }
        double sumaTranzactie = numarActiuni * actiune.valoareActiune;
        if (utilizator.premium == 0) {
            if (cont.suma < sumaTranzactie) {
                System.out.println("Insufficient amount in account for buying stock");
            } else {
                cont.suma = cont.suma - sumaTranzactie;
                utilizator.actiuni.add(actiune);
            }
        } else {
            if (cont.suma < sumaTranzactie) {
                System.out.println("Insufficient amount in account for buying stock");
            } else {
                int actiuneRecomandata = 0;
                for (int i = 0; i < actiuniRecomandate.size(); i++) {
                    if (actiuniRecomandate.get(i).equals(actiune.nume)) {
                        double sumaNouaTranzactie = sumaTranzactie - sumaTranzactie * 0.05;
                        cont.suma = cont.suma - sumaNouaTranzactie;
                        utilizator.actiuni.add(actiune);
                        actiuneRecomandata = 1;
                        break;
                    }
                }
                if (actiuneRecomandata == 0) {
                    cont.suma = cont.suma - sumaTranzactie;
                    utilizator.actiuni.add(actiune);
                }
            }
        }
    }
}
