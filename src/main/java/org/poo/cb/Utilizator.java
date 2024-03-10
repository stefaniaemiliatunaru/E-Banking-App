package org.poo.cb;

import java.util.ArrayList;

public class Utilizator {
    public String email;
    public String nume;
    public String prenume;
    public String adresa;
    public int premium = 0;
    public ArrayList<Valuta> conturi;
    public ArrayList<Actiune> actiuni;
    public ArrayList<Utilizator> prieteni;
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getNume() {
        return nume;
    }
    public void setNume(String nume) {
        this.nume = nume;
    }
    public String getPrenume() {
        return prenume;
    }
    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }
    public String getAdresa() {
        return adresa;
    }
    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }
    public int getPremium() {
        return premium;
    }
    public void setPremium() {
        this.premium = 0;
    }
    public ArrayList<Valuta> getConturi() {
        return conturi;
    }
    public void setConturi() {
        this.conturi = new ArrayList<Valuta>();
    }
    public ArrayList<Actiune> getActiuni() {
        return actiuni;
    }
    public void setActiuni() {
        this.actiuni = new ArrayList<Actiune>();
    }
    public ArrayList<Utilizator> getPrieteni() {
        return prieteni;
    }
    public void setPrieteni() {
        this.prieteni = new ArrayList<Utilizator>();
    }
}
