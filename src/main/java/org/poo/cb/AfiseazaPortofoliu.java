package org.poo.cb;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class AfiseazaPortofoliu implements Comanda {
    public String email;
    public ArrayList<Utilizator> utilizatori;

    public AfiseazaPortofoliu(String email, ArrayList<Utilizator> utilizatori) {
        this.email = email;
        this.utilizatori = utilizatori;
    }
    public void execute() {
        int existaUtilizatorul = 0;
        Utilizator utilizator = null;
        for (int i = 0; i < utilizatori.size(); i++) {
            if (utilizatori.get(i).email.equals(email)) {
                utilizator = utilizatori.get(i);
                existaUtilizatorul = 1;
                break;
            }
        }
        if (existaUtilizatorul == 0) {
            System.out.println("User with " + email + "doesn't exist");
        } else {
            System.out.print("{\"stocks\":");
            if (utilizator.actiuni.isEmpty()) {
                System.out.print("[],");
            } else {
                System.out.print("[");
                for (int i = 0; i < utilizator.actiuni.size(); i++) {
                    if (i == (utilizator.actiuni.size() - 1))
                        System.out.print("{\"stockName\":\"" + utilizator.actiuni.get(i).nume + "\",\"amount\":" + utilizator.actiuni.get(i).numarActiuni + "}],");
                    else
                        System.out.print("{\"stockName\":\"" + utilizator.actiuni.get(i).nume + "\",\"amount\":" + utilizator.actiuni.get(i).numarActiuni + "},");
                }
            }
            System.out.print("\"accounts\":[");
            for (int i = 0; i < utilizator.conturi.size(); i++) {
                String sumaCont = String.format("%.2f", utilizator.conturi.get(i).suma);
                if (i == (utilizator.conturi.size() - 1))
                    System.out.println("{\"currencyName\":\"" + utilizator.conturi.get(i).valuta + "\",\"amount\":\"" + sumaCont + "\"}]}");
                else
                    System.out.print("{\"currencyName\":\"" + utilizator.conturi.get(i).valuta + "\",\"amount\":\"" + sumaCont + "\"},");
            }
        }
    }
}

