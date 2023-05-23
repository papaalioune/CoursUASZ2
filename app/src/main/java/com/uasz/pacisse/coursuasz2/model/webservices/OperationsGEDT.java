package com.uasz.pacisse.coursuasz2.model.webservices;

import android.app.Activity;
import android.os.AsyncTask;

import com.uasz.pacisse.coursuasz2.model.Classe;
import com.uasz.pacisse.coursuasz2.model.Cours;
import com.uasz.pacisse.coursuasz2.model.Enseignant;
import com.uasz.pacisse.coursuasz2.model.Etudiant;
import com.uasz.pacisse.coursuasz2.model.Matiere;
import com.uasz.pacisse.coursuasz2.model.SalleDeClasse;
import com.uasz.pacisse.coursuasz2.utilitaire.Constantes;

import org.json.JSONArray;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Créé par Dr Cissé, le 22/05/2023 à 02:12
 */
public class OperationsGEDT {
    private Activity mActivity;

    private String mailEtudiant;
    private String pwdEtudiant;
    /*private Etudiant mEtudiant;
    private Matiere mMatiere;
    private Classe mClasse;
    private Enseignant mEnseignant;
    private SalleDeClasse mSalleDeClasse;
    private List<Cours> mCours;*/

    private RetoursOperationsGEDT mRetoursOperationsGEDT;

    public RetoursOperationsGEDT verifier_etudiant(String mail, String pwd, Activity activity){
        this.mailEtudiant = mail;
        this.pwdEtudiant = pwd;
        this.mActivity = activity;
        new VerifierEtudiantAsyncTask().execute();
        while (this.mRetoursOperationsGEDT==null){
            //On attend jusqua la fin de l'opération de vérification par GEDT. Penser à afficher un message ici
        }
        return this.mRetoursOperationsGEDT;
    }

    /*
    gettes and setters
    */
    public Activity getmActivity() {
        return mActivity;
    }

    public void setmActivity(Activity mActivity) {
        this.mActivity = mActivity;
    }

    public String getMailEtudiant() {
        return mailEtudiant;
    }

    public void setMailEtudiant(String mailEtudiant) {
        this.mailEtudiant = mailEtudiant;
    }

    public String getPwdEtudiant() {
        return pwdEtudiant;
    }

    public void setPwdEtudiant(String pwdEtudiant) {
        this.pwdEtudiant = pwdEtudiant;
    }
    /*
    public Etudiant getmEtudiant() {
        return mEtudiant;
    }

    public void setmEtudiant(Etudiant mEtudiant) {
        this.mEtudiant = mEtudiant;
    }

    public Matiere getmMatiere() {
        return mMatiere;
    }

    public void setmMatiere(Matiere mMatiere) {
        this.mMatiere = mMatiere;
    }

    public Classe getmClasse() {
        return mClasse;
    }

    public void setmClasse(Classe mClasse) {
        this.mClasse = mClasse;
    }

    public Enseignant getmEnseignant() {
        return mEnseignant;
    }

    public void setmEnseignant(Enseignant mEnseignant) {
        this.mEnseignant = mEnseignant;
    }

    public SalleDeClasse getmSalleDeClasse() {
        return mSalleDeClasse;
    }

    public void setmSalleDeClasse(SalleDeClasse mSalleDeClasse) {
        this.mSalleDeClasse = mSalleDeClasse;
    }

    public List<Cours> getmCours() {
        return mCours;
    }

    public void setmCours(List<Cours> mCours) {
        this.mCours = mCours;
    }
    */
    public RetoursOperationsGEDT getmRetoursOperationsGEDT() {
        return mRetoursOperationsGEDT;
    }

    public void setmRetoursOperationsGEDT(RetoursOperationsGEDT mRetoursOperationsGEDT) {
        this.mRetoursOperationsGEDT = mRetoursOperationsGEDT;
    }


     /*
    Classes gérant les tâches (asynchrones) d'accès à l'API GEDT
     */
    private class VerifierEtudiantAsyncTask extends AsyncTask<String, String, String> {

         @Override
         protected String doInBackground(String... strings) {
             ServiceInternet serviceInternet = new ServiceInternet();
             Map<String, String> httpParams = new HashMap<>();
             //Populating request parameters
             httpParams.put(Constantes.NomsParametresGEDT.PRAM_MAIL_ETUDIANT, mailEtudiant);
             httpParams.put(Constantes.NomsParametresGEDT.PRAM_PWD_ETUDIANT, pwdEtudiant);

             RetoursOperationsGEDT retoursOperationsGEDT = serviceInternet.requetteHttp(Constantes.UrlMappingGEDT.WS_VERIFIER_ETUDIANT, "POST", httpParams);
             if (retoursOperationsGEDT.getValeurRetourOperationsGEDT() == Constantes.ValeurRetourOperationsGEDT.VALEUR_ECHEC){
                 mRetoursOperationsGEDT = new RetoursOperationsGEDT(Constantes.ValeurRetourOperationsGEDT.VALEUR_ECHEC, Constantes.MessageRetourOperationsGEDT.MESSAGE_ECHEC, null);
             } else{
                 if (retoursOperationsGEDT.getValeurRetourOperationsGEDT() == Constantes.ValeurRetourOperationsGEDT.VALEUR_NO_DATA){
                     mRetoursOperationsGEDT = new RetoursOperationsGEDT(Constantes.ValeurRetourOperationsGEDT.VALEUR_NO_DATA, Constantes.MessageRetourOperationsGEDT.MESSAGE_NO_DATA, null);
                 }else{
                     mRetoursOperationsGEDT = new RetoursOperationsGEDT(Constantes.ValeurRetourOperationsGEDT.VALEUR_SUCCESS, Constantes.MessageRetourOperationsGEDT.MESSAGE_SUCCES, retoursOperationsGEDT.getDataAsArray());;
                 }
             }
             return null;
         }
     }
}
