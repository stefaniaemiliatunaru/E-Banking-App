package org.poo.cb;

import java.util.ArrayList;

public class CreeazaUtilizator implements Comanda {
    private String email;
    private String nume;
    private String prenume;
    private String adresa;
    public int premium;
    private ArrayList<Utilizator> utilizatori;

    public CreeazaUtilizator(String email, String nume , String prenume, String adresa, ArrayList<Utilizator> utilizatori) {
        this.email = email;
        this.nume = nume;
        this.prenume = prenume;
        this.adresa = adresa;
        this.utilizatori = utilizatori;
    }
    public void execute() {
        int utilizatorulExista = 0;
        for (int i = 0; i < utilizatori.size(); i++) {
            if (utilizatori.get(i).email.equals(email)) {
                System.out.println("User with " + email + " already exists");
                utilizatorulExista = 1;
                break;
            }
        }
        if (utilizatorulExista == 0) {
            Utilizator utilizator = new UtilizatorBuilder()
                    .cuEmail(email)
                    .cuNume(nume)
                    .cuPrenume(prenume)
                    .cuAdresa(adresa)
                    .cuPremium()
                    .cuConturi()
                    .cuActiuni()
                    .cuPrieteni()
                        .build();
            utilizatori.add(utilizator);
        }
    }
}
