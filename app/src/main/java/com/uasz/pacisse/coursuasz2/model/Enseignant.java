package com.uasz.pacisse.coursuasz2.model;

import java.io.Serializable;
import java.util.Objects;

/**
 * Créé par Dr Cissé, le 16/03/2023 à 09:43
 */
public class Enseignant implements Serializable {
    private int identifiantEnseignant;
    private String matriculeEnseignant;
    private String nomEnseignant;
    private String prenomEnseignant;

    public Enseignant() {
    }

    public Enseignant(int identifiantEnseignant, String matriculeEnseignant, String nomEnseignant, String prenomEnseignant) {
        this.identifiantEnseignant = identifiantEnseignant;
        this.matriculeEnseignant = matriculeEnseignant;
        this.nomEnseignant = nomEnseignant;
        this.prenomEnseignant = prenomEnseignant;
    }

    public Enseignant(String matriculeEnseignant, String nomEnseignant, String prenomEnseignant) {
        this.matriculeEnseignant = matriculeEnseignant;
        this.nomEnseignant = nomEnseignant;
        this.prenomEnseignant = prenomEnseignant;
    }

    public Enseignant(String nomEnseignant, String prenomEnseignant) {
        this.nomEnseignant = nomEnseignant;
        this.prenomEnseignant = prenomEnseignant;
    }

    public int getIdentifiantEnseignant() {
        return identifiantEnseignant;
    }

    public void setIdentifiantEnseignant(int identifiantEnseignant) {
        this.identifiantEnseignant = identifiantEnseignant;
    }

    public String getMatriculeEnseignant() {
        return matriculeEnseignant;
    }

    public void setMatriculeEnseignant(String matriculeEnseignant) {
        this.matriculeEnseignant = matriculeEnseignant;
    }

    public String getNomEnseignant() {
        return nomEnseignant;
    }

    public void setNomEnseignant(String nomEnseignant) {
        this.nomEnseignant = nomEnseignant;
    }

    public String getPrenomEnseignant() {
        return prenomEnseignant;
    }

    public void setPrenomEnseignant(String prenomEnseignant) {
        this.prenomEnseignant = prenomEnseignant;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Enseignant)) return false;
        Enseignant that = (Enseignant) o;
        return getIdentifiantEnseignant() == that.getIdentifiantEnseignant() && Objects.equals(getMatriculeEnseignant(), that.getMatriculeEnseignant()) && Objects.equals(getNomEnseignant(), that.getNomEnseignant()) && Objects.equals(getPrenomEnseignant(), that.getPrenomEnseignant());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdentifiantEnseignant(), getMatriculeEnseignant(), getNomEnseignant(), getPrenomEnseignant());
    }
}
