package com.uasz.pacisse.coursuasz2.model;

import android.graphics.Color;
import android.widget.TextView;

import com.uasz.pacisse.coursuasz2.R;

/**
 * Créé par Dr Cissé, le 16/03/2023 à 10:15
 */
public class CelluleTableauEmploiDuTemps {
    private int identifiant;
    private String jour;
    private int heureDebut;
    private int heureFin;
    private TextView affichage;
    private Cours cours;
    private boolean vide;

    public CelluleTableauEmploiDuTemps() {
        this.vide = true;
    }

    public CelluleTableauEmploiDuTemps(String jour, int heureDebut, int heureFin, TextView element) {
        this.jour = jour;
        this.heureDebut = heureDebut;
        this.heureFin = heureFin;
        this.affichage = element;
        cours = new Cours();
        this.vide = true;
    }

    public CelluleTableauEmploiDuTemps(int identifiant, String jour, int heureDebut, int heureFin, TextView element) {
        this.identifiant = identifiant;
        this.jour = jour;
        this.heureDebut = heureDebut;
        this.heureFin = heureFin;
        this.affichage = element;
        cours = new Cours();
        this.vide = true;
    }

    public int getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(int identifiant) {
        this.identifiant = identifiant;
    }

    public String getJour() {
        return jour;
    }

    public void setJour(String jour) {
        this.jour = jour;
    }

    public int getHeureDebut() {
        return heureDebut;
    }

    public void setHeureDebut(int heureDebut) {
        this.heureDebut = heureDebut;
    }

    public int getHeureFin() {
        return heureFin;
    }

    public void setHeureFin(int heureFin) {
        this.heureFin = heureFin;
    }

    public TextView getAffichage() {
        return affichage;
    }

    public void setAffichage(TextView element) {
        this.affichage = element;
    }

    public boolean getVide() {
        return vide;
    }

    public boolean isVide() {
        return this.vide == true;
    }

    public void setVide(boolean vide) {
        this.vide = vide;
    }

    public Cours getCours() {
        return cours;
    }

    public void setCours(Cours cours) {
        this.cours = cours;
        //this.getAffichage().setText(cours.getMatiere().getCodeMatiere().substring(0, 8));
        this.getAffichage().setText(cours.getMatiere().getCodeMatiere());
        this.getAffichage().setTextSize(7);
        this.getAffichage().setBackgroundColor(Color.parseColor("#FFF895"));
        this.vide = false;
    }
}
