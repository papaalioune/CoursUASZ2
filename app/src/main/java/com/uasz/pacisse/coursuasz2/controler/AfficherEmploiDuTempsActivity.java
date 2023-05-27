package com.uasz.pacisse.coursuasz2.controler;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.uasz.pacisse.coursuasz2.R;
import com.uasz.pacisse.coursuasz2.model.Cours;
import com.uasz.pacisse.coursuasz2.model.TableauEmploiDuTemps;
import com.uasz.pacisse.coursuasz2.model.webservices.RetoursOperationsGEDT;

import org.json.JSONArray;

import java.util.List;

public class AfficherEmploiDuTempsActivity extends AppCompatActivity implements View.OnClickListener{
    private List<Cours> listeCours ;

    /* *** Références des éléments graphiques (les différentes cellules de l'emploi du temps) dans l'activité *** */
    private TextView lundi_8_9, lundi_9_10, lundi_10_11, lundi_11_12, lundi_12_13, lundi_15_16, lundi_16_17,
            lundi_17_18, lundi_18_19, lundi_19_20;
    private TextView mardi_8_9, mardi_9_10, mardi_10_11, mardi_11_12, mardi_12_13, mardi_15_16, mardi_16_17,
            mardi_17_18, mardi_18_19, mardi_19_20;
    private TextView mercredi_8_9, mercredi_9_10, mercredi_10_11, mercredi_11_12, mercredi_12_13, mercredi_15_16,
            mercredi_16_17, mercredi_17_18, mercredi_18_19, mercredi_19_20;
    private TextView jeudi_8_9, jeudi_9_10, jeudi_10_11, jeudi_11_12, jeudi_12_13, jeudi_15_16, jeudi_16_17,
            jeudi_17_18, jeudi_18_19, jeudi_19_20;
    private TextView vendredi_8_9, vendredi_9_10, vendredi_10_11, vendredi_11_12, vendredi_12_13, vendredi_15_16,
            vendredi_16_17, vendredi_17_18, vendredi_18_19, vendredi_19_20;
    private TextView samedi_8_9, samedi_9_10, samedi_10_11, samedi_11_12, samedi_12_13, samedi_15_16, samedi_16_17,
            samedi_17_18, samedi_18_19, samedi_19_20;

    private TextView detailsCours;
    /* *** /Références des éléments graphiques (les différentes cellules de l'emploi du temps) dans l'activité *** */
    private TableauEmploiDuTemps tableau_emploi_du_temps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_afficher_emploi_du_temps);

        Intent intent = getIntent();
        listeCours = (List<Cours>) intent.getSerializableExtra("listeCours");

        initView();

        remplirEmploiDuTemps();

    }

    @Override
    public void onClick(View view) {
        Cours coursAAfficher = tableau_emploi_du_temps.retrouverCoursDUneCellule((TextView) view);
        if (coursAAfficher!=null){
            detailsCours.setText(coursAAfficher.getMatiere().getLibelleMatiere() + "\n" +
                    coursAAfficher.getJour() + " " + getResources().getString(R.string.texte_de) + " " + coursAAfficher.getHeureDebut() + " " + getResources().getString(R.string.texte_a) + " " + coursAAfficher.getHeureFin() + "\n" +
                    getResources().getString(R.string.texte_avec) + " " + coursAAfficher.getEnseignant() + "\n"+
                    getResources().getString(R.string.texte_salle) + " " + coursAAfficher.getSalle().getNomSalleDeClasse());
        }
        else{
            detailsCours.setText("Pas de cours");
        }
    }

    private void remplirEmploiDuTemps(){
        for (int i = 0; i < listeCours.size(); i++) {
            System.out.println(listeCours.get(i));
            tableau_emploi_du_temps.ajouterCours(listeCours.get(i));
        }
    }

    private void initView() {
        //emploi_du_temps = new EmploiDuTemps();
        tableau_emploi_du_temps = new TableauEmploiDuTemps();
        lundi_8_9 = (TextView) findViewById(R.id.emploi_lundi_8h_9h);
        tableau_emploi_du_temps.ajouterCellule("LUNDI", 8, 9, lundi_8_9);
        lundi_8_9.setOnClickListener((View.OnClickListener) this);
        lundi_9_10 = (TextView) findViewById(R.id.emploi_lundi_9h_10h);
        tableau_emploi_du_temps.ajouterCellule("LUNDI", 9, 10, lundi_9_10);
        lundi_9_10.setOnClickListener((View.OnClickListener) this);
        lundi_10_11 = (TextView) findViewById(R.id.emploi_lundi_10h_11h);
        tableau_emploi_du_temps.ajouterCellule("LUNDI", 10, 11, lundi_10_11);
        lundi_10_11.setOnClickListener((View.OnClickListener) this);
        lundi_11_12 = (TextView) findViewById(R.id.emploi_lundi_11h_12h);
        tableau_emploi_du_temps.ajouterCellule("LUNDI", 11, 12, lundi_11_12);
        lundi_11_12.setOnClickListener((View.OnClickListener) this);
        lundi_12_13 = (TextView) findViewById(R.id.emploi_lundi_12h_13h);
        tableau_emploi_du_temps.ajouterCellule("LUNDI", 12, 13, lundi_12_13);
        lundi_12_13.setOnClickListener((View.OnClickListener) this);
        lundi_15_16 = (TextView) findViewById(R.id.emploi_lundi_15h_16h);
        tableau_emploi_du_temps.ajouterCellule("LUNDI", 15, 16, lundi_15_16);
        lundi_15_16.setOnClickListener((View.OnClickListener) this);
        lundi_16_17 = (TextView) findViewById(R.id.emploi_lundi_16h_17h);
        tableau_emploi_du_temps.ajouterCellule("LUNDI", 16, 17, lundi_16_17);
        lundi_16_17.setOnClickListener((View.OnClickListener) this);
        lundi_17_18 = (TextView) findViewById(R.id.emploi_lundi_17h_18h);
        tableau_emploi_du_temps.ajouterCellule("LUNDI", 17, 18, lundi_17_18);
        lundi_17_18.setOnClickListener((View.OnClickListener) this);
        lundi_18_19 = (TextView) findViewById(R.id.emploi_lundi_18h_19h);
        tableau_emploi_du_temps.ajouterCellule("LUNDI", 18, 19, lundi_18_19);
        lundi_18_19.setOnClickListener((View.OnClickListener) this);
        lundi_19_20 = (TextView) findViewById(R.id.emploi_lundi_19h_20h);
        tableau_emploi_du_temps.ajouterCellule("LUNDI", 19, 20, lundi_19_20);
        lundi_19_20.setOnClickListener((View.OnClickListener) this);

        mardi_8_9 = (TextView) findViewById(R.id.emploi_mardi_8h_9h);
        tableau_emploi_du_temps.ajouterCellule("MARDI", 8, 9, mardi_8_9);
        mardi_8_9.setOnClickListener((View.OnClickListener) this);
        mardi_9_10 = (TextView) findViewById(R.id.emploi_mardi_9h_10h);
        tableau_emploi_du_temps.ajouterCellule("MARDI", 9, 10, mardi_9_10);
        mardi_9_10.setOnClickListener((View.OnClickListener) this);
        mardi_10_11 = (TextView) findViewById(R.id.emploi_mardi_10h_11h);
        tableau_emploi_du_temps.ajouterCellule("MARDI", 10, 11, mardi_10_11);
        mardi_10_11.setOnClickListener((View.OnClickListener) this);
        mardi_11_12 = (TextView) findViewById(R.id.emploi_mardi_11h_12h);
        tableau_emploi_du_temps.ajouterCellule("MARDI", 11, 12, mardi_11_12);
        mardi_11_12.setOnClickListener((View.OnClickListener) this);
        mardi_12_13 = (TextView) findViewById(R.id.emploi_mardi_12h_13h);
        tableau_emploi_du_temps.ajouterCellule("MARDI", 12, 13, mardi_12_13);
        mardi_12_13.setOnClickListener((View.OnClickListener) this);
        mardi_15_16 = (TextView) findViewById(R.id.emploi_mardi_15h_16h);
        tableau_emploi_du_temps.ajouterCellule("MARDI", 15, 16, mardi_15_16);
        mardi_15_16.setOnClickListener((View.OnClickListener) this);
        mardi_16_17 = (TextView) findViewById(R.id.emploi_mardi_16h_17h);
        tableau_emploi_du_temps.ajouterCellule("MARDI", 16, 17, mardi_16_17);
        mardi_16_17.setOnClickListener((View.OnClickListener) this);
        mardi_17_18 = (TextView) findViewById(R.id.emploi_mardi_17h_18h);
        tableau_emploi_du_temps.ajouterCellule("MARDI", 17, 18, mardi_17_18);
        mardi_17_18.setOnClickListener((View.OnClickListener) this);
        mardi_18_19 = (TextView) findViewById(R.id.emploi_mardi_18h_19h);
        tableau_emploi_du_temps.ajouterCellule("MARDI", 18, 19, mardi_18_19);
        mardi_18_19.setOnClickListener((View.OnClickListener) this);
        mardi_19_20 = (TextView) findViewById(R.id.emploi_mardi_19h_20h);
        tableau_emploi_du_temps.ajouterCellule("MARDI", 19, 20, mardi_19_20);
        mardi_19_20.setOnClickListener((View.OnClickListener) this);

        mercredi_8_9 = (TextView) findViewById(R.id.emploi_mercredi_8h_9h);
        tableau_emploi_du_temps.ajouterCellule("MERCREDI", 8, 9, mercredi_8_9);
        mercredi_8_9.setOnClickListener((View.OnClickListener) this);
        mercredi_9_10 = (TextView) findViewById(R.id.emploi_mercredi_9h_10h);
        tableau_emploi_du_temps.ajouterCellule("MERCREDI", 9, 10, mercredi_9_10);
        mercredi_9_10.setOnClickListener((View.OnClickListener) this);
        mercredi_10_11 = (TextView) findViewById(R.id.emploi_mercredi_10h_11h);
        tableau_emploi_du_temps.ajouterCellule("MERCREDI", 10, 11, mercredi_10_11);
        mercredi_10_11.setOnClickListener((View.OnClickListener) this);
        mercredi_11_12 = (TextView) findViewById(R.id.emploi_mercredi_11h_12h);
        tableau_emploi_du_temps.ajouterCellule("MERCREDI", 11, 12, mercredi_11_12);
        mercredi_11_12.setOnClickListener((View.OnClickListener) this);
        mercredi_12_13 = (TextView) findViewById(R.id.emploi_mercredi_12h_13h);
        tableau_emploi_du_temps.ajouterCellule("MERCREDI", 12, 13, mercredi_12_13);
        mercredi_12_13.setOnClickListener((View.OnClickListener) this);
        mercredi_15_16 = (TextView) findViewById(R.id.emploi_mercredi_15h_16h);
        tableau_emploi_du_temps.ajouterCellule("MERCREDI", 15, 16, mercredi_15_16);
        mercredi_15_16.setOnClickListener((View.OnClickListener) this);
        mercredi_16_17 = (TextView) findViewById(R.id.emploi_mercredi_16h_17h);
        tableau_emploi_du_temps.ajouterCellule("MERCREDI", 16, 17, mercredi_16_17);
        mercredi_16_17.setOnClickListener((View.OnClickListener) this);
        mercredi_17_18 = (TextView) findViewById(R.id.emploi_mercredi_17h_18h);
        tableau_emploi_du_temps.ajouterCellule("MERCREDI", 17, 18, mercredi_17_18);
        mercredi_17_18.setOnClickListener((View.OnClickListener) this);
        mercredi_18_19 = (TextView) findViewById(R.id.emploi_mercredi_18h_19h);
        tableau_emploi_du_temps.ajouterCellule("MERCREDI", 18, 19, mercredi_18_19);
        mercredi_18_19.setOnClickListener((View.OnClickListener) this);
        mercredi_19_20 = (TextView) findViewById(R.id.emploi_mercredi_19h_20h);
        tableau_emploi_du_temps.ajouterCellule("MERCREDI", 19, 20, mercredi_19_20);
        mercredi_19_20.setOnClickListener((View.OnClickListener) this);

        jeudi_8_9 = (TextView) findViewById(R.id.emploi_jeudi_8h_9h);
        tableau_emploi_du_temps.ajouterCellule("JEUDI", 8, 9, jeudi_8_9);
        jeudi_8_9.setOnClickListener((View.OnClickListener) this);
        jeudi_9_10 = (TextView) findViewById(R.id.emploi_jeudi_9h_10h);
        tableau_emploi_du_temps.ajouterCellule("JEUDI", 9, 10, jeudi_9_10);
        jeudi_9_10.setOnClickListener((View.OnClickListener) this);
        jeudi_10_11 = (TextView) findViewById(R.id.emploi_jeudi_10h_11h);
        tableau_emploi_du_temps.ajouterCellule("JEUDI", 10, 11, jeudi_10_11);
        jeudi_10_11.setOnClickListener((View.OnClickListener) this);
        jeudi_11_12 = (TextView) findViewById(R.id.emploi_jeudi_11h_12h);
        tableau_emploi_du_temps.ajouterCellule("JEUDI", 11, 12, jeudi_11_12);
        jeudi_11_12.setOnClickListener((View.OnClickListener) this);
        jeudi_12_13 = (TextView) findViewById(R.id.emploi_jeudi_12h_13h);
        tableau_emploi_du_temps.ajouterCellule("JEUDI", 12, 13, jeudi_12_13);
        jeudi_12_13.setOnClickListener((View.OnClickListener) this);
        jeudi_15_16 = (TextView) findViewById(R.id.emploi_jeudi_15h_16h);
        tableau_emploi_du_temps.ajouterCellule("JEUDI", 15, 16, jeudi_15_16);
        jeudi_15_16.setOnClickListener((View.OnClickListener) this);
        jeudi_16_17 = (TextView) findViewById(R.id.emploi_jeudi_16h_17h);
        tableau_emploi_du_temps.ajouterCellule("JEUDI", 16, 17, jeudi_16_17);
        jeudi_16_17.setOnClickListener((View.OnClickListener) this);
        jeudi_17_18 = (TextView) findViewById(R.id.emploi_jeudi_17h_18h);
        tableau_emploi_du_temps.ajouterCellule("JEUDI", 17, 18, jeudi_17_18);
        jeudi_17_18.setOnClickListener((View.OnClickListener) this);
        jeudi_18_19 = (TextView) findViewById(R.id.emploi_jeudi_18h_19h);
        tableau_emploi_du_temps.ajouterCellule("JEUDI", 18, 19, jeudi_18_19);
        jeudi_18_19.setOnClickListener((View.OnClickListener) this);
        jeudi_19_20 = (TextView) findViewById(R.id.emploi_jeudi_19h_20h);
        tableau_emploi_du_temps.ajouterCellule("JEUDI", 19, 20, jeudi_19_20);
        jeudi_19_20.setOnClickListener((View.OnClickListener) this);

        vendredi_8_9 = (TextView) findViewById(R.id.emploi_vendredi_8h_9h);
        tableau_emploi_du_temps.ajouterCellule("VENDREDI", 8, 9, vendredi_8_9);
        vendredi_8_9.setOnClickListener((View.OnClickListener) this);
        vendredi_9_10 = (TextView) findViewById(R.id.emploi_vendredi_9h_10h);
        tableau_emploi_du_temps.ajouterCellule("VENDREDI", 9, 10, vendredi_9_10);
        vendredi_9_10.setOnClickListener((View.OnClickListener) this);
        vendredi_10_11 = (TextView) findViewById(R.id.emploi_vendredi_10h_11h);
        tableau_emploi_du_temps.ajouterCellule("VENDREDI", 10, 11, vendredi_10_11);
        vendredi_10_11.setOnClickListener((View.OnClickListener) this);
        vendredi_11_12 = (TextView) findViewById(R.id.emploi_vendredi_11h_12h);
        tableau_emploi_du_temps.ajouterCellule("VENDREDI", 11, 12, vendredi_11_12);
        vendredi_11_12.setOnClickListener((View.OnClickListener) this);
        vendredi_12_13 = (TextView) findViewById(R.id.emploi_vendredi_12h_13h);
        tableau_emploi_du_temps.ajouterCellule("VENDREDI", 12, 13, vendredi_12_13);
        vendredi_12_13.setOnClickListener((View.OnClickListener) this);
        vendredi_15_16 = (TextView) findViewById(R.id.emploi_vendredi_15h_16h);
        tableau_emploi_du_temps.ajouterCellule("VENDREDI", 15, 16, vendredi_15_16);
        vendredi_15_16.setOnClickListener((View.OnClickListener) this);
        vendredi_16_17 = (TextView) findViewById(R.id.emploi_vendredi_16h_17h);
        tableau_emploi_du_temps.ajouterCellule("VENDREDI", 16, 17, vendredi_16_17);
        vendredi_16_17.setOnClickListener((View.OnClickListener) this);
        vendredi_17_18 = (TextView) findViewById(R.id.emploi_vendredi_17h_18h);
        tableau_emploi_du_temps.ajouterCellule("VENDREDI", 17, 18, vendredi_17_18);
        vendredi_17_18.setOnClickListener((View.OnClickListener) this);
        vendredi_18_19 = (TextView) findViewById(R.id.emploi_vendredi_18h_19h);
        tableau_emploi_du_temps.ajouterCellule("VENDREDI", 18, 19, vendredi_18_19);
        vendredi_18_19.setOnClickListener((View.OnClickListener) this);
        vendredi_19_20 = (TextView) findViewById(R.id.emploi_vendredi_19h_20h);
        tableau_emploi_du_temps.ajouterCellule("VENDREDI", 19, 20, vendredi_19_20);
        vendredi_19_20.setOnClickListener((View.OnClickListener) this);

        samedi_8_9 = (TextView) findViewById(R.id.emploi_samedi_8h_9h);
        tableau_emploi_du_temps.ajouterCellule("SAMEDI", 8, 9, samedi_8_9);
        samedi_8_9.setOnClickListener((View.OnClickListener) this);
        samedi_9_10 = (TextView) findViewById(R.id.emploi_samedi_9h_10h);
        tableau_emploi_du_temps.ajouterCellule("SAMEDI", 9, 10, samedi_9_10);
        samedi_9_10.setOnClickListener((View.OnClickListener) this);
        samedi_10_11 = (TextView) findViewById(R.id.emploi_samedi_10h_11h);
        tableau_emploi_du_temps.ajouterCellule("SAMEDI", 10, 11, samedi_10_11);
        samedi_10_11.setOnClickListener((View.OnClickListener) this);
        samedi_11_12 = (TextView) findViewById(R.id.emploi_samedi_11h_12h);
        tableau_emploi_du_temps.ajouterCellule("SAMEDI", 11, 12, samedi_11_12);
        samedi_11_12.setOnClickListener((View.OnClickListener) this);
        samedi_12_13 = (TextView) findViewById(R.id.emploi_samedi_12h_13h);
        tableau_emploi_du_temps.ajouterCellule("SAMEDI", 12, 13, samedi_12_13);
        samedi_12_13.setOnClickListener((View.OnClickListener) this);
        samedi_15_16 = (TextView) findViewById(R.id.emploi_samedi_15h_16h);
        tableau_emploi_du_temps.ajouterCellule("SAMEDI", 15, 16, samedi_15_16);
        samedi_15_16.setOnClickListener((View.OnClickListener) this);
        samedi_16_17 = (TextView) findViewById(R.id.emploi_samedi_16h_17h);
        tableau_emploi_du_temps.ajouterCellule("SAMEDI", 16, 17, samedi_16_17);
        samedi_16_17.setOnClickListener((View.OnClickListener) this);
        samedi_17_18 = (TextView) findViewById(R.id.emploi_samedi_17h_18h);
        tableau_emploi_du_temps.ajouterCellule("SAMEDI", 17, 18, samedi_17_18);
        samedi_17_18.setOnClickListener((View.OnClickListener) this);
        samedi_18_19 = (TextView) findViewById(R.id.emploi_samedi_18h_19h);
        tableau_emploi_du_temps.ajouterCellule("SAMEDI", 18, 19, samedi_18_19);
        samedi_18_19.setOnClickListener((View.OnClickListener) this);
        samedi_19_20 = (TextView) findViewById(R.id.emploi_samedi_19h_20h);
        tableau_emploi_du_temps.ajouterCellule("SAMEDI", 19, 20, samedi_19_20);
        samedi_19_20.setOnClickListener((View.OnClickListener) this);

        detailsCours = (TextView) findViewById(R.id.details_cours_selectionne);
    }


}