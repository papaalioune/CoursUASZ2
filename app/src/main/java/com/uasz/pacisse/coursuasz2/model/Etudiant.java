package com.uasz.pacisse.coursuasz2.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * Créé par Dr Cissé, le 09/05/2023 à 08:49
 */
public class Etudiant implements Serializable {
    private int id;
    private String reference;
    private String sexe;
    private String prenom;
    private String nom;
    private Date dateNaissance;
    private Classe classe;
    private String email;
    private String password;

    public Etudiant() {
    }

    public Etudiant(String reference, String sexe, String prenom, String nom, Date dateNaissance, Classe classe, String email, String password) {
        this.reference = reference;
        this.sexe = sexe;
        this.prenom = prenom;
        this.nom = nom;
        this.dateNaissance = dateNaissance;
        this.classe = classe;
        this.email = email;
        this.password = password;
    }

    public Etudiant(String prenom, String nom, Classe classe, String email, String password) {
        this.prenom = prenom;
        this.nom = nom;
        this.classe = classe;
        this.email = email;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public Classe getClasse() {
        return classe;
    }

    public void setClasse(Classe classe) {
        this.classe = classe;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Etudiant{" +
                "id=" + id +
                ", reference='" + reference + '\'' +
                ", sexe='" + sexe + '\'' +
                ", prenom='" + prenom + '\'' +
                ", nom='" + nom + '\'' +
                ", dateNaissance=" + dateNaissance +
                ", classe='" + classe + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Etudiant)) return false;
        Etudiant etudiant = (Etudiant) o;
        return getId() == etudiant.getId() && Objects.equals(getReference(), etudiant.getReference()) && Objects.equals(getSexe(), etudiant.getSexe()) && Objects.equals(getPrenom(), etudiant.getPrenom()) && Objects.equals(getNom(), etudiant.getNom()) && Objects.equals(getDateNaissance(), etudiant.getDateNaissance()) && Objects.equals(getClasse(), etudiant.getClasse()) && Objects.equals(getEmail(), etudiant.getEmail()) && Objects.equals(getPassword(), etudiant.getPassword());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getReference(), getSexe(), getPrenom(), getNom(), getDateNaissance(), getClasse(), getEmail(), getPassword());
    }
}
