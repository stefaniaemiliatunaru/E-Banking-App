package org.poo.cb;

import com.fasterxml.jackson.databind.util.JSONPObject;

import java.util.ArrayList;

public class AfiseazaUtilizator implements Comanda {
    public String email;
    public ArrayList<Utilizator> utilizatori;
    public AfiseazaUtilizator(String email, ArrayList<Utilizator> utilizatori) {
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
            System.out.println("User with " + email + " doesn't exist");
        } else {
            System.out.print("{\"email\":\"" + email + "\",\"firstname\":\"" + utilizator.nume + "\",\"lastname\":\"" + utilizator.prenume + "\",\"address\":\"" + utilizator.adresa + "\",\"friends\":");
            if (utilizator.prieteni.isEmpty())
                System.out.println("[]}");
            for (int i = 0; i < utilizator.prieteni.size(); i++) {
                if (i == (utilizator.prieteni.size() - 1))
                    System.out.println("[\"" + utilizator.prieteni.get(i).email + "\"]}");
                else
                    System.out.print("[\"" + utilizator.prieteni.get(i).email + "\"],");
            }
        }
    }
}
