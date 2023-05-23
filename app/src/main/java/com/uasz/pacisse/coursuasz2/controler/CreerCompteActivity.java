package com.uasz.pacisse.coursuasz2.controler;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.uasz.pacisse.coursuasz2.R;
import com.uasz.pacisse.coursuasz2.model.webservices.OperationsGEDT;
import com.uasz.pacisse.coursuasz2.model.webservices.RetoursOperationsGEDT;
import com.uasz.pacisse.coursuasz2.model.utilitaire.JsonToObjectConverter;

public class CreerCompteActivity extends AppCompatActivity {
    //private ServiceInternet mServiceInternet;
    private OperationsGEDT mOperationsGEDT;
    private RetoursOperationsGEDT mRetoursOperationsGEDT;

    private JsonToObjectConverter mJsonToObjectConverter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creer_compte);

        //mServiceInternet = new ServiceInternet();
        mOperationsGEDT = new OperationsGEDT();
        mJsonToObjectConverter = new JsonToObjectConverter();
        mRetoursOperationsGEDT = mOperationsGEDT.recuperer_liste_classes(CreerCompteActivity.this);
        System.out.println(mRetoursOperationsGEDT.getDataAsArray());
        System.out.println(mJsonToObjectConverter.liste_classes_converter(mRetoursOperationsGEDT.getDataAsArray()));
    }
}