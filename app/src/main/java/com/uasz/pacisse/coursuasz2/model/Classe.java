package com.uasz.pacisse.coursuasz2.model;

import java.io.Serializable;
import java.util.Objects;

/**
 * Créé par Dr Cissé, le 16/03/2023 à 09:32
 */
public class Classe implements Serializable {
    private NiveauDeClasse niveauClasse;
    private String nomClasse;
    private String codeClasse;

    public Classe() {
    }

    public Classe(NiveauDeClasse niveauClasse, String nomClasse) {
        this.niveauClasse = niveauClasse;
        this.nomClasse = nomClasse;
    }

    public Classe(NiveauDeClasse niveauClasse, String nomClasse, String codeClasse) {
        this.niveauClasse = niveauClasse;
        this.nomClasse = nomClasse;
        this.codeClasse = codeClasse;
    }

    public String getCodeClasse() {
        return codeClasse;
    }

    public void setCodeClasse(String codeClasse) {
        this.codeClasse = codeClasse;
    }

    public NiveauDeClasse getNiveauClasse() {
        return niveauClasse;
    }

    public void setNiveauClasse(NiveauDeClasse niveauClasse) {
        this.niveauClasse = niveauClasse;
    }

    public String getNomClasse() {
        return nomClasse;
    }

    public void setNomClasse(String nomClasse) {
        this.nomClasse = nomClasse;
    }

    @Override
    public String toString() {
        return "Classe{" +
                "niveauClasse='" + niveauClasse + '\'' +
                ", nomClasse='" + nomClasse + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Classe)) return false;
        Classe classe = (Classe) o;
        return Objects.equals(getNiveauClasse(), classe.getNiveauClasse()) && Objects.equals(getNomClasse(), classe.getNomClasse());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNiveauClasse(), getNomClasse());
    }
}
