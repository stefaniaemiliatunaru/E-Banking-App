package org.poo.cb;

import java.util.ArrayList;

public class TransferaBani implements Comanda {
    public String emailUtilizator;
    public String emailPrieten;
    public String valuta;
    public double sumaTransfer;
    public ArrayList<Utilizator> utilizatori;
    public TransferaBani(String emailUtilizator, String emailPrieten, String valuta, double sumaTransfer, ArrayList<Utilizator> utilizatori) {
        this.emailUtilizator = emailUtilizator;
        this.emailPrieten = emailPrieten;
        this.valuta = valuta;
        this.sumaTransfer = sumaTransfer;
        this.utilizatori = utilizatori;
    }
    public void execute() {
        Utilizator utilizator = null;
        for (int i = 0; i < utilizatori.size(); i++) {
            if (utilizatori.get(i).email.equals(emailUtilizator)) {
                utilizator = utilizatori.get(i);
                break;
            }
        }
        Utilizator prieten = null;
        for (int i = 0; i < utilizatori.size(); i++) {
            if (utilizatori.get(i).email.equals(emailPrieten)) {
                prieten = utilizatori.get(i);
                break;
            }
        }
        Valuta contUtilizator = null;
        for (int i = 0; i < utilizator.conturi.size(); i++) {
            if (utilizator.conturi.get(i).valuta.equals(valuta)) {
                contUtilizator = utilizator.conturi.get(i);
                break;
            }
        }
        Valuta contPrieten = null;
        for (int i = 0; i < prieten.conturi.size(); i++) {
            if (prieten.conturi.get(i).valuta.equals(valuta)) {
                contPrieten = prieten.conturi.get(i);
                break;
            }
        }
        if (sumaTransfer > contUtilizator.suma) {
            System.out.println("Insufficient amount in account " + valuta + " for transfer");
            return;
        }
        int suntPrieteni = 0;
        for (int i = 0; i < utilizator.prieteni.size(); i++) {
            if (utilizator.prieteni.get(i) == prieten) {
                suntPrieteni = 1;
                break;
            }
        }
        if (suntPrieteni == 0) {
            System.out.println("You are not allowed to transfer money to " + emailPrieten);
        } else {
            contUtilizator.suma = contUtilizator.suma - sumaTransfer;
            contPrieten.suma = contPrieten.suma + sumaTransfer;
        }
    }
}
