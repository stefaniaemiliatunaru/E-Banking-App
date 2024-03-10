package org.poo.cb;

public class UtilizatorBuilder {
    private final Utilizator utilizator = new Utilizator();
    public UtilizatorBuilder cuEmail(String email) {
        utilizator.setEmail(email);
        return this;
    }
    public UtilizatorBuilder cuNume(String nume) {
        utilizator.setNume(nume);
        return this;
    }
    public UtilizatorBuilder cuPrenume(String prenume) {
        utilizator.setPrenume(prenume);
        return this;
    }
    public UtilizatorBuilder cuAdresa(String adresa) {
        utilizator.setAdresa(adresa);
        return this;
    }
    public UtilizatorBuilder cuPremium() {
        utilizator.setPremium();
        return this;
    }
    public UtilizatorBuilder cuConturi() {
        utilizator.setConturi();
        return this;
    }
    public UtilizatorBuilder cuActiuni() {
        utilizator.setActiuni();
        return this;
    }
    public UtilizatorBuilder cuPrieteni() {
        utilizator.setPrieteni();
        return this;
    }
    public Utilizator build() {
        return utilizator;
    }
}
