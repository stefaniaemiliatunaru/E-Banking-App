package org.poo.cb;

import java.util.ArrayList;

public class AlimenteazaCont implements Comanda {
    public String email;
    public String valuta;
    public int sumaAlimentare;
    public ArrayList<Utilizator> utilizatori;
    public AlimenteazaCont(String email, String valuta, int sumaAlimentare, ArrayList<Utilizator> utilizatori) {
        this.email = email;
        this.valuta = valuta;
        this.sumaAlimentare = sumaAlimentare;
        this.utilizatori = utilizatori;
    }
    public void execute() {
        Utilizator utilizator = null;
        for (int i = 0; i < utilizatori.size(); i++) {
            if (utilizatori.get(i).email.equals(email)) {
                utilizator = utilizatori.get(i);
                break;
            }
        }
        Valuta cont = null;
        for (int i = 0; i < utilizator.conturi.size(); i++) {
            if (utilizator.conturi.get(i).valuta.equals(valuta)) {
                cont = utilizator.conturi.get(i);
                break;
            }
        }
        cont.suma = cont.suma + sumaAlimentare;
    }
}
