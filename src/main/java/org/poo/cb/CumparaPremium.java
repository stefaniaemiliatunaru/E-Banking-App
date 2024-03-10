package org.poo.cb;

import java.util.ArrayList;
import java.util.List;

public class CumparaPremium implements Comanda {
    private String email;
    private ArrayList<Utilizator> utilizatori;
    private List<String> actiuniRecomandate;
    public CumparaPremium(String email, ArrayList<Utilizator> utilizatori, List<String> actiuniRecomandate) {
        this.email = email;
        this.utilizatori = utilizatori;
        this.actiuniRecomandate = actiuniRecomandate;
    }
    public void execute() {
        int utilizatorExista = 0;
        Utilizator utilizator = null;
        for (int i = 0; i < utilizatori.size(); i++) {
            if (utilizatori.get(i).email.equals(email)) {
                utilizator = utilizatori.get(i);
                utilizatorExista = 1;
                break;
            }
        }
        if (utilizatorExista == 0) {
            System.out.println("User with " + email + " doesn't exist");
        } else {
            Valuta cont = null;
            for (int i = 0 ; i < utilizator.conturi.size(); i++) {
                if (utilizator.conturi.get(i).valuta.equals("USD")) {
                    cont = utilizator.conturi.get(i);
                    break;
                }
            }
            if (cont.suma < 100) {
                System.out.println("Insufficient amount in account for buying premium option");
            } else {
                cont.suma = cont.suma - 100;
                utilizator.premium = 1;
            }
        }
    }
}
