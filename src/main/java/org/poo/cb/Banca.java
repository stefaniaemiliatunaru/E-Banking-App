package org.poo.cb;

import java.util.ArrayList;

// utilizez design pattern-ul Singleton pentru a ma asigura ca exista o singura instanta a bancii
public class Banca {
    private static Banca banca;
    public ArrayList<Utilizator> utilizatori;
    public ArrayList<Valuta> conturi;
    private Banca() {
        this.utilizatori = new ArrayList<>();
        this.conturi = new ArrayList<>();
    }
    public static Banca Instanta() {
        if (banca == null) {
            banca = new Banca();
        }
        return banca;
    }
    public static void resetare() {
        banca = null;
    }
}
