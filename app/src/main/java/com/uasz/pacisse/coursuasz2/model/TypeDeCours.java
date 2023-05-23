package com.uasz.pacisse.coursuasz2.model;

import java.io.Serializable;
import java.util.Objects;

/**
 * Créé par Dr Cissé, le 23/05/2023 à 11:05
 */
public class TypeDeCours implements Serializable {
    private String code;
    private String libelle;

    public TypeDeCours() {
    }

    public TypeDeCours(String code, String libelle) {
        this.code = code;
        this.libelle = libelle;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    @Override
    public String toString() {
        return "TypeDeCours{" +
                "code='" + code + '\'' +
                ", libelle='" + libelle + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TypeDeCours)) return false;
        TypeDeCours that = (TypeDeCours) o;
        return Objects.equals(getCode(), that.getCode()) && Objects.equals(getLibelle(), that.getLibelle());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCode(), getLibelle());
    }
}
