package com.uasz.pacisse.coursuasz2.model.utilitaire;

/**
 * Créé par Dr Cissé, le 09/05/2023 à 08:58
 */
public class Constantes {
    /**
     * Classe pour es expressions régulières pour validation de champs
     */
    public static final class Regex {
        public static final String REGEX_MOTDEPASSE = ".{8,}";


        public static final String SHORT_DATE_FORMAT = "dd-MM-yyyy";
        public static final String LONG_DATE_FORMAT = "dd-MM-yyyy HH:mm:ss";

        public static final String SHORT_DATE_FORMAT_ = "yyyy-MM-dd";
        public static final String LONG_DATE_FORMAT_ = "yyyy-MM-dd HH:mm:ss";
    }

    public enum Jours{
        LUNDI, MARDI, MERCREDI, JEUDI, VENDREDI, SAMEDI
    }

    public static final class DataBase {
        public static final String DataBaseName = "cours_uasz_db";
        public static final int DB_VERSION = 1;

        public static final String EtudiantTableName = "etudiants";

        public static final String EtudiantTableName_ID = "id";
        public static final String EtudiantTableName_Prenom = "prenom";
        public static final String EtudiantTableName_nom = "nom";
        public static final String EtudiantTableName_Email = "email";
        public static final String EtudiantTableName_MotDePass = "password";
        public static final String EtudiantTableName_Reference = "reference";
        public static final String EtudiantTableName_Classe = "classe";
        public static final String EtudiantTableName_Naissance = "naissance";
        public static final String EtudiantTableName_Sexe = "sexe";
    }

    public static final class UrlMappingGEDT {
        private static final String SERVER_GEDT = "https://papaaliounecisse.herokuapp.com/gedt/api/";
        public static final String WS_AJOUT_ETUDIANT = SERVER_GEDT + "add_etudiant/";
        public static final String WS_VERIFIER_ETUDIANT = SERVER_GEDT + "verifier_etudiant/";
        public static final String WS_LISTE_CLASSES = SERVER_GEDT + "classes/";
    }

    public static final class NomsParametresGEDT {
        public static final String PRAM_CODE_TYPE_COURS = "code";
        public static final String PRAM_LIBELLE_TYPE_COURS = "libelle";
        public static final String PRAM_CODE_MATIRE = "code_matiere";
        public static final String PRAM_INTITULE_MATIRE = "intitule_matiere";
        public static final String PRAM_CODE_NIVEAU = "code_niveau";
        public static final String PRAM_NOM_NIVEAU = "nom_niveau";
        public static final String PRAM_CODE_CLASSE = "code_classe";
        public static final String PRAM_NOM_CLASSE = "nom_classe";
        public static final String PRAM_NIVEAU_CLASSE = "niveau_classe";
        public static final String PRAM_NOM_SALLE = "nom_salle";
        public static final String PRAM_NOM_ENSEIGNANT = "nom";
        public static final String PRAM_PRENOM_ENSEIGNANT = "prenom";
        public static final String PRAM_NOM_ETUDIANT = "nom";
        public static final String PRAM_PRENOM_ETUDIANT = "prenom";
        public static final String PRAM_MAIL_ETUDIANT = "mail";
        public static final String PRAM_PWD_ETUDIANT = "pwd";
        public static final String PRAM_CLASSE_ETUDIANT = "classe";
        public static final String PRAM_HEURE_COURS = "heure";
        public static final String PRAM_MINUTE_COURS = "minute";
        public static final String PRAM_TYPE_COURS = "type";
        public static final String PRAM_CLASSE_COURS = "classe";
        public static final String PRAM_MATIERE_COURS = "matiere";
        public static final String PRAM_ENSEIGNANT_COURS = "enseignant";
        public static final String PRAM_SALLE_COURS = "salle";
        public static final String PRAM_JOUR_COURS = "jour";
        public static final String PRAM_DEBUT_COURS = "debut";
        public static final String PRAM_FIN_COURS = "fin";
    }

    public static final class ValeurRetourOperationsGEDT {
        public static final int VALEUR_SUCCESS = 200;
        public static final int VALEUR_CREATED = 201;
        public static final int VALEUR_ECHEC = 400;
        public static final int VALEUR_NO_DATA = 204;
        public static final int VALEUR_ECHEC_TRAITEMENT = 400;

    }


    public static final class MessageRetourOperationsGEDT {
        public static final String MESSAGE_ECHEC_TRAITEMENT = "Erreur dans le traitement de votre demande. Reesayez plus tard";
        public static final String MESSAGE_SUCCES = "SUCCES";
        public static final String MESSAGE_ECHEC = "ECHEC";
        public static final String MESSAGE_NO_DATA = "AUCUNE DONNEES";

    }
}
