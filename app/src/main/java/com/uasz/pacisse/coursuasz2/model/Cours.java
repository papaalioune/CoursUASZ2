package com.uasz.pacisse.coursuasz2.model;

import com.uasz.pacisse.coursuasz2.utilitaire.Constantes;

import java.io.Serializable;
import java.util.Objects;

/**
 * Créé par Dr Cissé, le 16/03/2023 à 10:04
 */
public class Cours implements Serializable {
    private Constantes.Jours jour;
    private HeureDeCours HeureDebut;
    private HeureDeCours HeureFin;
    private SalleDeClasse salle;
    private Enseignant enseignant;
    private Classe classe;
    private Matiere matiere;
    private TypeDeCours typeDeCours;

    public Cours() {
    }

    public Cours(Constantes.Jours jour, HeureDeCours heureDebut, HeureDeCours heureFin, SalleDeClasse salle, Enseignant enseignant, Classe classe, Matiere matiere) {
        this.jour = jour;
        HeureDebut = heureDebut;
        HeureFin = heureFin;
        this.salle = salle;
        this.enseignant = enseignant;
        this.classe = classe;
        this.matiere = matiere;
    }

    public Cours(Constantes.Jours jour, HeureDeCours heureDebut, HeureDeCours heureFin, SalleDeClasse salle, Enseignant enseignant, Matiere matiere, TypeDeCours typeDeCours) {
        this.jour = jour;
        HeureDebut = heureDebut;
        HeureFin = heureFin;
        this.salle = salle;
        this.enseignant = enseignant;
        this.matiere = matiere;
        this.typeDeCours = typeDeCours;
    }

    public TypeDeCours getTypeDeCours() {
        return typeDeCours;
    }

    public void setTypeDeCours(TypeDeCours typeDeCours) {
        this.typeDeCours = typeDeCours;
    }

    public Constantes.Jours getJour() {
        return jour;
    }

    public void setJour(Constantes.Jours jour) {
        this.jour = jour;
    }

    public HeureDeCours getHeureDebut() {
        return HeureDebut;
    }

    public void setHeureDebut(HeureDeCours heureDebut) {
        HeureDebut = heureDebut;
    }

    public HeureDeCours getHeureFin() {
        return HeureFin;
    }

    public void setHeureFin(HeureDeCours heureFin) {
        HeureFin = heureFin;
    }

    public SalleDeClasse getSalle() {
        return salle;
    }

    public void setSalle(SalleDeClasse salle) {
        this.salle = salle;
    }

    public Enseignant getEnseignant() {
        return enseignant;
    }

    public void setEnseignant(Enseignant enseignant) {
        this.enseignant = enseignant;
    }

    public Classe getClasse() {
        return classe;
    }

    public void setClasse(Classe classe) {
        this.classe = classe;
    }

    public Matiere getMatiere() {
        return matiere;
    }

    public void setMatiere(Matiere matiere) {
        this.matiere = matiere;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cours)) return false;
        Cours cours = (Cours) o;
        return getHeureDebut() == cours.getHeureDebut() && getHeureFin() == cours.getHeureFin() && getJour() == cours.getJour() && Objects.equals(getSalle(), cours.getSalle()) && Objects.equals(getEnseignant(), cours.getEnseignant()) && Objects.equals(getClasse(), cours.getClasse()) && Objects.equals(getMatiere(), cours.getMatiere());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getJour(), getHeureDebut(), getHeureFin(), getSalle(), getEnseignant(), getClasse(), getMatiere());
    }


}
