package com.uasz.pacisse.coursuasz2.controler;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.uasz.pacisse.coursuasz2.R;
import com.uasz.pacisse.coursuasz2.model.Cours;
import com.uasz.pacisse.coursuasz2.model.webservices.RetoursOperationsGEDT;

import org.json.JSONArray;

import java.util.List;

public class AfficherEmploiDuTempsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_afficher_emploi_du_temps);

        Intent intent = getIntent();
        List<Cours> listeCours = (List<Cours>) intent.getSerializableExtra("listeCours");
        System.out.println(listeCours.toString());
    }
}