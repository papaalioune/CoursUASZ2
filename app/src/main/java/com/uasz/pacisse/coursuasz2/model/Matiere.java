package com.uasz.pacisse.coursuasz2.model;

import java.io.Serializable;
import java.util.Objects;

/**
 * Créé par Dr Cissé, le 16/03/2023 à 09:53
 */
public class Matiere implements Serializable {
    private int identifiantMatiere;
    private String codeMatiere;
    private String libelleMatiere;

    public Matiere() {
    }

    public Matiere(int identifiantMatiere, String codeMatiere, String libelleMatiere) {
        this.identifiantMatiere = identifiantMatiere;
        this.codeMatiere = codeMatiere;
        this.libelleMatiere = libelleMatiere;
    }

    public Matiere(String codeMatiere, String libelleMatiere) {
        this.codeMatiere = codeMatiere;
        this.libelleMatiere = libelleMatiere;
    }

    public int getIdentifiantMatiere() {
        return identifiantMatiere;
    }

    public void setIdentifiantMatiere(int identifiantMatiere) {
        this.identifiantMatiere = identifiantMatiere;
    }

    public String getCodeMatiere() {
        return codeMatiere;
    }

    public void setCodeMatiere(String codeMatiere) {
        this.codeMatiere = codeMatiere;
    }

    public String getLibelleMatiere() {
        return libelleMatiere;
    }

    public void setLibelleMatiere(String libelleMatiere) {
        this.libelleMatiere = libelleMatiere;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Matiere)) return false;
        Matiere matiere = (Matiere) o;
        return getIdentifiantMatiere() == matiere.getIdentifiantMatiere() && getCodeMatiere().equals(matiere.getCodeMatiere()) && getLibelleMatiere().equals(matiere.getLibelleMatiere());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdentifiantMatiere(), getCodeMatiere(), getLibelleMatiere());
    }
}
