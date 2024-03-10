package org.poo.cb;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        if (args == null || args.length < 3) {
            System.out.println("Running Main");
            return;
        }
        String numeDirector = "src/main/resources/";
        String fisierRateConversie = numeDirector + args[0];
        String fisierValoriActiuni = numeDirector + args[1];
        String fisierComenzi = numeDirector + args[2];
        Banca banca = Banca.Instanta();
        List<String> actiuniRecomandate = new ArrayList<>();
        List<double[]> matriceSchimb = new ArrayList<>();
        try {
            FileReader fr = new FileReader(fisierRateConversie);
            try (BufferedReader br = new BufferedReader(fr)) {
                br.readLine();
                String linieFisier = null;
                while ((linieFisier = br.readLine()) != null) {
                    String[] aux = linieFisier.split(",");
                    double[] randMatrice = new double[aux.length - 1];
                    for (int i = 1; i < aux.length; i++) {
                        randMatrice[i - 1] = Double.parseDouble(aux[i]);
                    }
                    matriceSchimb.add(randMatrice);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        List<String[]> matriceActiuni = new ArrayList<>();
        try {
            FileReader fr = new FileReader(fisierValoriActiuni);
            try (BufferedReader br = new BufferedReader(fr)) {
                br.readLine();
                String linieFisier = null;
                while ((linieFisier = br.readLine()) != null) {
                    String[] aux = linieFisier.split(",");
                    String[] randMatrice = new String[aux.length];
                    for (int i = 0; i < aux.length; i++) {
                        randMatrice[i] = aux[i];
                    }
                    matriceActiuni.add(randMatrice);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            FileReader fr = new FileReader(fisierComenzi);
            try (BufferedReader br = new BufferedReader(fr)) {
                String linieFisier = null;
                while ((linieFisier = br.readLine()) != null) {
                    String[] aux = linieFisier.split(" ");
                    String comanda = aux[0];
                    if (comanda.equals("CREATE")) {
                        String email = aux[2];
                        String nume = aux[3];
                        String prenume = aux[4];
                        String adresa = aux[5] + " ";
                        for (int i = 6; i < aux.length; i++) {
                            if (i == (aux.length - 1)) {
                                adresa = adresa + aux[i];
                            } else
                                adresa = adresa + aux[i] + " ";
                        }
                        CreeazaUtilizator creeazaUtilizator = new CreeazaUtilizator(email, nume, prenume, adresa, banca.utilizatori);
                        creeazaUtilizator.execute();
                    }
                    if (comanda.equals("ADD")) {
                        if (aux[1].equals("FRIEND")) {
                            String emailUtilizator = aux[2];
                            String emailPrieten = aux[3];
                            AdaugaPrieten adaugaPrieten = new AdaugaPrieten(emailUtilizator, emailPrieten, banca.utilizatori);
                            adaugaPrieten.execute();
                        }
                        if (aux[1].equals("ACCOUNT")) {
                            String email = aux[2];
                            String valuta = aux[3];
                            AdaugaCont adaugaCont = new AdaugaCont(email, valuta, banca.utilizatori, banca.conturi);
                            adaugaCont.execute();
                        }
                        if (aux[1].equals("MONEY")) {
                            String email = aux[2];
                            String valuta = aux[3];
                            int suma = Integer.parseInt(aux[4]);
                            AlimenteazaCont alimenteazaCont = new AlimenteazaCont(email, valuta, suma, banca.utilizatori);
                            alimenteazaCont.execute();
                        }
                    }
                    if (comanda.equals("EXCHANGE")) {
                        String email = aux[2];
                        String valutaSursa = aux[3];
                        String valutaDestinatie = aux[4];
                        int suma = Integer.parseInt(aux[5]);
                        SchimbValutar schimbValutar = new SchimbValutar(email, valutaSursa, valutaDestinatie, suma, banca.utilizatori, matriceSchimb);
                        schimbValutar.execute();
                    }
                    if (comanda.equals("TRANSFER")) {
                        String emailUtilizator = aux[2];
                        String emailPrieten = aux[3];
                        String valuta = aux[4];
                        double suma = Integer.parseInt(aux[5]);
                        TransferaBani transferaBani = new TransferaBani(emailUtilizator, emailPrieten, valuta, suma, banca.utilizatori);
                        transferaBani.execute();
                    }
                    if (comanda.equals("BUY")) {
                        if (aux[1].equals("STOCKS")) {
                            String email = aux[2];
                            String companie = aux[3];
                            int numarActiuni = Integer.parseInt(aux[4]);
                            CumparaActiuni cumparaActiuni = new CumparaActiuni(email, companie, numarActiuni, banca.utilizatori, matriceActiuni, actiuniRecomandate);
                            cumparaActiuni.execute();
                        }
                        if (aux[1].equals("PREMIUM")) {
                            String email = aux[2];
                            CumparaPremium cumparaPremium = new CumparaPremium(email, banca.utilizatori, actiuniRecomandate);
                            cumparaPremium.execute();
                        }
                    }
                    if (comanda.equals("RECOMMEND")) {
                        RecomandaActiuni recomandaActiuni = new RecomandaActiuni(banca.utilizatori, matriceActiuni,actiuniRecomandate);
                        recomandaActiuni.execute();
                    }
                    if (comanda.equals("LIST")) {
                        if (aux[1].equals("USER")) {
                            String email = aux[2];
                            AfiseazaUtilizator afiseazaUtilizator = new AfiseazaUtilizator(email, banca.utilizatori);
                            afiseazaUtilizator.execute();
                        }
                        if (aux[1].equals("PORTFOLIO")) {
                            String email = aux[2];
                            AfiseazaPortofoliu afiseazaPortofoliu = new AfiseazaPortofoliu(email, banca.utilizatori);
                            afiseazaPortofoliu.execute();
                        }
                    }
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        Banca.resetare();
    }
}
