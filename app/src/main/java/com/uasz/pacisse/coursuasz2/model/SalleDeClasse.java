package com.uasz.pacisse.coursuasz2.model;

import java.io.Serializable;
import java.util.Objects;

/**
 * Créé par Dr Cissé, le 16/03/2023 à 09:58
 */
public class SalleDeClasse implements Serializable {
    private int identifiantSalleDeClasse;
    private String codeSalleDeClasse;
    private String nomSalleDeClasse;

    public SalleDeClasse() {
    }

    public SalleDeClasse(int identifiantSalleDeClasse, String codeSalleDeClasse, String nomSalleDeClasse) {
        this.identifiantSalleDeClasse = identifiantSalleDeClasse;
        this.codeSalleDeClasse = codeSalleDeClasse;
        this.nomSalleDeClasse = nomSalleDeClasse;
    }

    public SalleDeClasse(String codeSalleDeClasse, String nomSalleDeClasse) {
        this.codeSalleDeClasse = codeSalleDeClasse;
        this.nomSalleDeClasse = nomSalleDeClasse;
    }

    public SalleDeClasse(String nomSalleDeClasse) {
        this.nomSalleDeClasse = nomSalleDeClasse;
    }

    public int getIdentifiantSalleDeClasse() {
        return identifiantSalleDeClasse;
    }

    public void setIdentifiantSalleDeClasse(int identifiantSalleDeClasse) {
        this.identifiantSalleDeClasse = identifiantSalleDeClasse;
    }

    public String getCodeSalleDeClasse() {
        return codeSalleDeClasse;
    }

    public void setCodeSalleDeClasse(String codeSalleDeClasse) {
        this.codeSalleDeClasse = codeSalleDeClasse;
    }

    public String getNomSalleDeClasse() {
        return nomSalleDeClasse;
    }

    public void setNomSalleDeClasse(String nomSalleDeClasse) {
        this.nomSalleDeClasse = nomSalleDeClasse;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SalleDeClasse)) return false;
        SalleDeClasse that = (SalleDeClasse) o;
        return getIdentifiantSalleDeClasse() == that.getIdentifiantSalleDeClasse() && getCodeSalleDeClasse().equals(that.getCodeSalleDeClasse()) && getNomSalleDeClasse().equals(that.getNomSalleDeClasse());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdentifiantSalleDeClasse(), getCodeSalleDeClasse(), getNomSalleDeClasse());
    }
}
