package com.uasz.pacisse.coursuasz2.model;

import java.util.Objects;

/**
 * Créé par Dr Cissé, le 16/03/2023 à 09:32
 */
public class Classe {
    private String niveauClasse;
    private String nomClasse;

    public Classe() {
    }

    public Classe(String niveauClasse, String nomClasse) {
        this.niveauClasse = niveauClasse;
        this.nomClasse = nomClasse;
    }

    public String getNiveauClasse() {
        return niveauClasse;
    }

    public void setNiveauClasse(String niveauClasse) {
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
