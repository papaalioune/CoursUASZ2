package com.uasz.pacisse.coursuasz2.model;

import com.uasz.pacisse.coursuasz2.utilitaire.Constantes;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Créé par Dr Cissé, le 22/05/2023 à 18:02
 */
public class JsonToObjectConverter {
    public List<Cours> liste_cours_converter(JSONArray listeCoursAsJSonArray){
        List<Cours> coursList = new ArrayList<>();
        for (int i = 0 ; i < listeCoursAsJSonArray.length() ; i++){
            try {
                JSONObject unCours = listeCoursAsJSonArray.getJSONObject(i);
                JSONObject typeDuCours = unCours.getJSONObject(Constantes.NomsParametresGEDT.PRAM_TYPE_COURS);
                JSONObject classeDuCours = unCours.getJSONObject(Constantes.NomsParametresGEDT.PRAM_CLASSE_COURS);
                JSONObject matiereDuCours = unCours.getJSONObject(Constantes.NomsParametresGEDT.PRAM_MATIERE_COURS);
                JSONObject enseignantDuCours = unCours.getJSONObject(Constantes.NomsParametresGEDT.PRAM_ENSEIGNANT_COURS);
                JSONObject salleDuCours = unCours.getJSONObject(Constantes.NomsParametresGEDT.PRAM_SALLE_COURS);
                JSONObject debutDuCours = unCours.getJSONObject(Constantes.NomsParametresGEDT.PRAM_DEBUT_COURS);
                JSONObject finDuCours = unCours.getJSONObject(Constantes.NomsParametresGEDT.PRAM_FIN_COURS);
                String jourDuCours = unCours.getString(Constantes.NomsParametresGEDT.PRAM_JOUR_COURS);

                Matiere matiere = new Matiere(matiereDuCours.getString(Constantes.NomsParametresGEDT.PRAM_CODE_MATIRE), matiereDuCours.getString(Constantes.NomsParametresGEDT.PRAM_INTITULE_MATIRE));
                SalleDeClasse salle = new SalleDeClasse(salleDuCours.getString(Constantes.NomsParametresGEDT.PRAM_NOM_SALLE));
                HeureDeCours debut = new HeureDeCours(Integer.parseInt(debutDuCours.getString((Constantes.NomsParametresGEDT.PRAM_HEURE_COURS))), Integer.parseInt(debutDuCours.getString(Constantes.NomsParametresGEDT.PRAM_MINUTE_COURS)));
                HeureDeCours fin = new HeureDeCours(Integer.parseInt(finDuCours.getString((Constantes.NomsParametresGEDT.PRAM_HEURE_COURS))), Integer.parseInt(finDuCours.getString(Constantes.NomsParametresGEDT.PRAM_MINUTE_COURS)));
                Enseignant enseignant = new Enseignant(enseignantDuCours.getString(Constantes.NomsParametresGEDT.PRAM_NOM_ENSEIGNANT), enseignantDuCours.getString(Constantes.NomsParametresGEDT.PRAM_PRENOM_ENSEIGNANT));
                Constantes.Jours jour = Constantes.Jours.valueOf(jourDuCours.toUpperCase());
                TypeDeCours typeDeCours = new TypeDeCours(typeDuCours.getString(Constantes.NomsParametresGEDT.PRAM_CODE_TYPE_COURS), typeDuCours.getString(Constantes.NomsParametresGEDT.PRAM_LIBELLE_TYPE_COURS));

                coursList.add(new Cours(jour, debut, fin, salle, enseignant, matiere, typeDeCours));

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return coursList;
    }
}
