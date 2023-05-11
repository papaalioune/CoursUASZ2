package com.uasz.pacisse.coursuasz2.utilitaire;

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
}
