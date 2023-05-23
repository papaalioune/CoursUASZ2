package com.uasz.pacisse.coursuasz2.model;

import com.uasz.pacisse.coursuasz2.utilitaire.DataConverter;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Créé par Dr Cissé, le 09/05/2023 à 08:46
 */

public class AccessWS {/*
    private List<Cours> quelquesCours;
    private List<SalleDeClasse> quelquesSallesDeClasses;
    private List<Enseignant> quelquesEnseignants;
    private List<Matiere> quelquesMatieres;
    private List<Classe> quelquesClasses;
    private List<Etudiant> quelquesEtudiants;

    public AccessWS() {
        ajouterQuelquesDonneesDeTest();
    }

    public void ajouterQuelquesDonneesDeTest(){
        quelquesClasses = new ArrayList<>();
        quelquesEnseignants = new ArrayList<>();
        quelquesMatieres = new ArrayList<>();
        quelquesSallesDeClasses = new ArrayList<>();
        quelquesCours = new ArrayList<>();
        quelquesEtudiants = new ArrayList<>();

        Classe classe1 = new Classe("Master 2", " M2 Génie Logiciel");
        Classe classe2 = new Classe("Licence 3", "L3 Informatique");
        quelquesClasses.add(classe1);
        quelquesClasses.add(classe2);

        Date date_naissance = new Date();
        try {
            date_naissance = DataConverter.toDate("01-01-2000", DataConverter.DateType.SHORT);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Etudiant etudiant = new Etudiant("2019-47", "Masculin", "Someone", "SomeName", date_naissance, classe1, "papaaliounecisse@yahoo.fr","12345678");
        quelquesEtudiants.add(etudiant);

        SalleDeClasse salle1 = new SalleDeClasse("BP06", "BP 06");
        SalleDeClasse salle2 = new SalleDeClasse("INF3", "Info 3");
        quelquesSallesDeClasses.add(salle1);
        quelquesSallesDeClasses.add(salle2);

        Matiere matiere1 = new Matiere("ALGO1", "Algo 1");
        Matiere matiere2 = new Matiere("ALGO2", "Algo 2");
        Matiere matiere3 = new Matiere("DEV-MOBILE", "Développement mobile");
        quelquesMatieres.add(matiere1);
        quelquesMatieres.add(matiere2);
        quelquesMatieres.add(matiere3);

        Enseignant enseignant1 = new Enseignant("123", "CISSE", "Papa Alioune");
        Enseignant enseignant2 = new Enseignant("456", "DIOP", "Ibrahima");
        quelquesEnseignants.add(enseignant1);
        quelquesEnseignants.add(enseignant2);

        Cours c1 = new Cours(Cours.Jours.LUNDI, 8, 9, salle1, enseignant1, classe1, matiere1);
        Cours c2 = new Cours(Cours.Jours.LUNDI, 9, 10, salle1, enseignant1, classe1, matiere1);
        Cours c3 = new Cours(Cours.Jours.LUNDI, 15, 16, salle1, enseignant1, classe1, matiere2);
        Cours c4 = new Cours(Cours.Jours.LUNDI, 16, 17, salle1, enseignant1, classe1, matiere2);
        Cours c5 = new Cours(Cours.Jours.LUNDI, 8, 9, salle2, enseignant2, classe2, matiere1);
        Cours c6 = new Cours(Cours.Jours.MARDI, 9, 10, salle2, enseignant2, classe2, matiere1);
        Cours c8 = new Cours(Cours.Jours.MERCREDI, 8, 9, salle1, enseignant2, classe2, matiere1);
        Cours c9 = new Cours(Cours.Jours.MERCREDI, 8, 9, salle1, enseignant2, classe2, matiere1);
        Cours c10 = new Cours(Cours.Jours.SAMEDI, 10, 11, salle1, enseignant1, classe1, matiere2);
        Cours c11 = new Cours(Cours.Jours.SAMEDI, 11, 12, salle1, enseignant1, classe1, matiere2);
        quelquesCours.add(c1); quelquesCours.add(c2); quelquesCours.add(c3); quelquesCours.add(c4);
        quelquesCours.add(c5); quelquesCours.add(c6); quelquesCours.add(c8); quelquesCours.add(c9);
        quelquesCours.add(c10); quelquesCours.add(c11);
    }

    public List<Etudiant> getQuelquesEtudiants() {
        return quelquesEtudiants;
    }

    public void setQuelquesEtudiants(List<Etudiant> quelquesEtudiants) {
        this.quelquesEtudiants = quelquesEtudiants;
    }

    public List<Cours> getQuelquesCours() {
        return quelquesCours;
    }

    public void setQuelquesCours(List<Cours> quelquesCours) {
        this.quelquesCours = quelquesCours;
    }

    public List<SalleDeClasse> getQuelquesSallesDeClasses() {
        return quelquesSallesDeClasses;
    }

    public void setQuelquesSallesDeClasses(List<SalleDeClasse> quelquesSallesDeClasses) {
        this.quelquesSallesDeClasses = quelquesSallesDeClasses;
    }

    public List<Enseignant> getQuelquesEnseignants() {
        return quelquesEnseignants;
    }

    public void setQuelquesEnseignants(List<Enseignant> quelquesEnseignants) {
        this.quelquesEnseignants = quelquesEnseignants;
    }

    public List<Matiere> getQuelquesMatieres() {
        return quelquesMatieres;
    }

    public void setQuelquesMatieres(List<Matiere> quelquesMatieres) {
        this.quelquesMatieres = quelquesMatieres;
    }

    public List<Classe> getQuelquesClasses() {
        return quelquesClasses;
    }

    public void setQuelquesClasses(List<Classe> quelquesClasses) {
        this.quelquesClasses = quelquesClasses;
    }

    public Etudiant validerEtudiant(java.lang.String email, java.lang.String motDePass){
        for (int i=0; i < this.quelquesEtudiants.size(); i++)
            if (this.quelquesEtudiants.get(i).getEmail().equals(email) & this.quelquesEtudiants.get(i).getPassword().equals(motDePass))
                return this.quelquesEtudiants.get(i);
        return null;
    }


    public boolean compteExisteDeja(Etudiant etudiant){
        for (int i=0; i < this.quelquesEtudiants.size(); i++)
            if (this.quelquesEtudiants.get(i).getReference().equals(etudiant.getReference()) ||
                    this.quelquesEtudiants.get(i).getEmail().equals(etudiant.getEmail()))
                return true;
        return false;
    }

    public List<Cours> coursDeLaClasseDUnEtudiant(Etudiant etudiant){
        List<Cours> cours = new ArrayList<>();
        for (int i=0; i < quelquesCours.size(); i++)
            if (quelquesCours.get(i).getClasse().getNomClasse().equals(etudiant.getClasse().getNomClasse()))
                cours.add(quelquesCours.get(i));
        return cours;
    }*/
}
