package org.poo.cb;

import java.util.ArrayList;
import java.util.List;

public class RecomandaActiuni implements Comanda {
    public ArrayList<Utilizator> utilizatori;
    List<String[]> matriceActiuni;
    List<String> actiuniRecomandate;
    public RecomandaActiuni(ArrayList<Utilizator> utilizatori, List<String[]> matriceActiuni, List<String> actiuniRecomandate) {
        this.utilizatori = utilizatori;
        this.matriceActiuni = matriceActiuni;
        this.actiuniRecomandate = actiuniRecomandate;
    }
    public void execute() {
        int actiuneRecomandata = 0;
        System.out.print("{\"stocksToBuy\":[");
        for (int i = 0; i < matriceActiuni.size(); i++) {
            double medieUltimeleCinci = 0;
            for (int j = 6; j <= 10; j++)
                medieUltimeleCinci = medieUltimeleCinci + Double.parseDouble(matriceActiuni.get(i)[j]);
            medieUltimeleCinci = medieUltimeleCinci / 5;
            double medieUltimeleZece = 0;
            for (int j = 1; j <= 10; j++)
                medieUltimeleZece = medieUltimeleZece + Double.parseDouble(matriceActiuni.get(i)[j]);
            medieUltimeleZece = medieUltimeleZece / 10;
            if (medieUltimeleCinci > medieUltimeleZece) {
                if (actiuneRecomandata > 0)
                    System.out.print(",");
                System.out.print("\"" + matriceActiuni.get(i)[0] + "\"");
                actiuniRecomandate.add(matriceActiuni.get(i)[0]);
                actiuneRecomandata++;
            }
        }
        System.out.println("]}");
    }
}
