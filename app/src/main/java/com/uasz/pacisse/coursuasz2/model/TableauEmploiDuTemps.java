package com.uasz.pacisse.coursuasz2.model;

import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Créé par Dr Cissé, le 16/03/2023 à 10:43
 */
public class TableauEmploiDuTemps {
    private List<CelluleTableauEmploiDuTemps> leTableauDEmploiDuTemps;

    public TableauEmploiDuTemps() {
        leTableauDEmploiDuTemps = new ArrayList<>();
    }

    public TableauEmploiDuTemps(List<CelluleTableauEmploiDuTemps> leTableauDEmploiDuTemps) {
        this.leTableauDEmploiDuTemps = leTableauDEmploiDuTemps;
    }

    public List<CelluleTableauEmploiDuTemps> getLeTableauDEmploiDuTemps() {
        return leTableauDEmploiDuTemps;
    }

    public void setLeTableauDEmploiDuTemps(List<CelluleTableauEmploiDuTemps> leTableauDEmploiDuTemps) {
        this.leTableauDEmploiDuTemps = leTableauDEmploiDuTemps;
    }

    public void ajouterCellule (String jour, int heureDebut, int heureFin, TextView affichage){
        leTableauDEmploiDuTemps.add(new CelluleTableauEmploiDuTemps(jour, heureDebut, heureFin, affichage));
    }

    public void effacerTableauEmploiDuTemps(){
        for (int i = 0; i < leTableauDEmploiDuTemps.size(); i++) {
            leTableauDEmploiDuTemps.get(i).setVide(true);
        }
    }

    public void ajouterCours(Cours cours){
        for (int i = 0; i < leTableauDEmploiDuTemps.size(); i++) {
            if (leTableauDEmploiDuTemps.get(i).getJour().equalsIgnoreCase(cours.getJour().toString()) &&
                    ((leTableauDEmploiDuTemps.get(i).getHeureDebut() >= (cours.getHeureDebut()))) &&
                    ((leTableauDEmploiDuTemps.get(i).getHeureDebut() < (cours.getHeureFin())))){
                leTableauDEmploiDuTemps.get(i).setCours(cours);
            }
        }
    }

    public Cours retrouverCoursDUneCellule (TextView textView){
        for (int i = 0; i < leTableauDEmploiDuTemps.size(); i++) {
            if (leTableauDEmploiDuTemps.get(i).getAffichage() == textView)
                if (!leTableauDEmploiDuTemps.get(i).isVide())
                    return leTableauDEmploiDuTemps.get(i).getCours();
                else
                    return null;
        }
        return null;
    }
}
