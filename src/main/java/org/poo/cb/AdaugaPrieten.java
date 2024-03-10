package org.poo.cb;

import java.util.ArrayList;

public class AdaugaPrieten implements Comanda {
    private String emailUtilizator;
    private String emailPrieten;
    private ArrayList<Utilizator> utilizatori;
    public AdaugaPrieten(String emailUtilizator, String emailPrieten, ArrayList<Utilizator> utilizatori) {
        this.emailUtilizator = emailUtilizator;
        this.emailPrieten = emailPrieten;
        this.utilizatori = utilizatori;
    }
    public void execute() {
        int utilizatorExista = 0;
        Utilizator utilizator = null;
        for (int i = 0; i < utilizatori.size(); i++) {
            if (utilizatori.get(i).email.equals(emailUtilizator)) {
                utilizator = utilizatori.get(i);
                utilizatorExista = 1;
                break;
            }
        }
        if (utilizatorExista == 0) {
            System.out.println("User with " + emailUtilizator + " doesn't exist");
            return;
        }
        int prietenExista = 0;
        Utilizator prieten = null;
        for (int i = 0; i < utilizatori.size(); i++) {
            if (utilizatori.get(i).email.equals(emailPrieten)) {
                prieten = utilizatori.get(i);
                prietenExista = 1;
                break;
            }
        }
        if (prietenExista == 0) {
            System.out.println("User with " + emailPrieten + " doesn't exist");
            return;
        }
        int suntPrieteni = 0;
        for (int i = 0; i < utilizator.prieteni.size(); i++) {
            if (utilizator.prieteni.get(i) == prieten) {
                suntPrieteni = 1;
                break;
            }
        }
        if (suntPrieteni == 1)
            System.out.println("User " + emailPrieten + " is already a friend");
        else {
            utilizator.prieteni.add(prieten);
            prieten.prieteni.add(utilizator);
        }
    }
}
