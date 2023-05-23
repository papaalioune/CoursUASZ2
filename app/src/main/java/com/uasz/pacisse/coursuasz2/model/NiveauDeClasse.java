package com.uasz.pacisse.coursuasz2.model;

import java.io.Serializable;
import java.util.Objects;

/**
 * Créé par Dr Cissé, le 23/05/2023 à 13:25
 */
public class NiveauDeClasse implements Serializable {
    private String code_niveau;
    private String nom_niveau;

    public NiveauDeClasse(String code_niveau, String nom_niveau) {
        this.code_niveau = code_niveau;
        this.nom_niveau = nom_niveau;
    }

    public String getCode_niveau() {
        return code_niveau;
    }

    public void setCode_niveau(String code_niveau) {
        this.code_niveau = code_niveau;
    }

    public String getNom_niveau() {
        return nom_niveau;
    }

    public void setNom_niveau(String nom_niveau) {
        this.nom_niveau = nom_niveau;
    }

    @Override
    public String toString() {
        return "NiveauDeClasse{" +
                "code_niveau='" + code_niveau + '\'' +
                ", nom_niveau='" + nom_niveau + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NiveauDeClasse)) return false;
        NiveauDeClasse that = (NiveauDeClasse) o;
        return Objects.equals(getCode_niveau(), that.getCode_niveau()) && Objects.equals(getNom_niveau(), that.getNom_niveau());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCode_niveau(), getNom_niveau());
    }
}
