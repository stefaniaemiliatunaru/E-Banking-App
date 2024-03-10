package org.poo.cb;

import java.util.ArrayList;

public class AdaugaCont implements Comanda {
    private String email;
    private String valuta;
    private ArrayList<Utilizator> utilizatori;
    private ArrayList<Valuta> conturi;
    public AdaugaCont(String email, String valuta, ArrayList<Utilizator> utilizatori, ArrayList<Valuta> conturi) {
        this.email = email;
        this.valuta = valuta;
        this.utilizatori = utilizatori;
        this.conturi = conturi;
    }
    public void execute() {
        Utilizator utilizator = null;
        for (int i = 0; i < utilizatori.size(); i++) {
            if (utilizatori.get(i).email.equals(email)) {
                utilizator = utilizatori.get(i);
                break;
            }
        }
        int contValutaExistent = 0;
        for (int i = 0; i < utilizator.conturi.size(); i++) {
            if (utilizator.conturi.get(i).valuta.equals(valuta)) {
                contValutaExistent = 1;
                break;
            }
        }
        if (contValutaExistent == 1) {
            System.out.println("Account in currency " + valuta + " already exists for user");
        } else {
            Valuta cont = new Cont().creeazaContValuta(valuta);
            utilizator.conturi.add(cont);
            conturi.add(cont);
        }
    }
}
