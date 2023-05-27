package com.uasz.pacisse.coursuasz2.controler;

import static com.basgeekball.awesomevalidation.ValidationStyle.COLORATION;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.uasz.pacisse.coursuasz2.R;
import com.uasz.pacisse.coursuasz2.model.utilitaire.JsonToObjectConverter;
import com.uasz.pacisse.coursuasz2.model.utilitaire.Constantes;
import com.uasz.pacisse.coursuasz2.model.webservices.OperationsGEDT;
import com.uasz.pacisse.coursuasz2.model.webservices.RetoursOperationsGEDT;

import java.io.Serializable;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText mEmailConnexionInput;
    private EditText mMotDePassConnexionInput;
    private Button mConnectionButton;
    private TextView mInscriptionLink;

    /* *** objet de la validation *** */
    private AwesomeValidation awesomeValidation;


    //private ServiceInternet mServiceInternet;
    private OperationsGEDT mOperationsGEDT;
    private RetoursOperationsGEDT mRetoursOperationsGEDT;

    private JsonToObjectConverter mJsonToObjectConverter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //mServiceInternet = new ServiceInternet();
        mOperationsGEDT = new OperationsGEDT();
        mJsonToObjectConverter = new JsonToObjectConverter();

        initView();

        addValidationToViews();

    }

    private void initView() {
        mEmailConnexionInput = (EditText) findViewById(R.id.activity_main_emailInput);
        mMotDePassConnexionInput = (EditText) findViewById(R.id.activity_main_motDePassInput);
        mConnectionButton = (Button) findViewById(R.id.activity_main_connectionButton);
        mInscriptionLink = (TextView) findViewById(R.id.activity_main_inscriptionLien);

        mConnectionButton.setOnClickListener((View.OnClickListener) this);
        mInscriptionLink.setOnClickListener((View.OnClickListener) this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.activity_main_inscriptionLien:
                Intent creerCompteActivit = new Intent(MainActivity.this, CreerCompteActivity.class);
                startActivity(creerCompteActivit);
                break;
            case R.id.activity_main_connectionButton:
                if (awesomeValidation.validate()) {
                    if (mOperationsGEDT.serviceInternet.connexionDisponible(getApplicationContext())) {
                        mRetoursOperationsGEDT = mOperationsGEDT.verifier_etudiant(mEmailConnexionInput.getText().toString(), mMotDePassConnexionInput.getText().toString(), MainActivity.this);
                        if (mRetoursOperationsGEDT.getValeurRetourOperationsGEDT() == Constantes.ValeurRetourOperationsGEDT.VALEUR_SUCCESS){
                            //Redirection vers l'affichage de l'emploi du temps en passant le jsonArray à la nouvelle intend
                            Intent afficherEmploiActivity = new Intent(MainActivity.this, AfficherEmploiDuTempsActivity.class);
                            afficherEmploiActivity.putExtra("listeCours", (Serializable) mJsonToObjectConverter.liste_cours_converter(mRetoursOperationsGEDT.getDataAsArray()));
                            startActivity(afficherEmploiActivity);

                        } else{
                            Toast.makeText(MainActivity.this,
                                    mRetoursOperationsGEDT.getMessageRetourOperationsGEDT(),
                                    Toast.LENGTH_LONG).show();
                        }
                    } else{
                        Toast.makeText(MainActivity.this,
                                R.string.erreur_internet_off,
                                Toast.LENGTH_LONG).show();
                    }
                }
                break;
        }
    }

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setTitle(R.string.texte_exit)
                .setMessage(R.string.texte_confirmer_exit)
                .setPositiveButton(R.string.texte_oui, (dialog, which) -> {
                    finishAffinity();
                    System.exit(0);
                })
                .setNegativeButton(R.string.texte_non, null)
                .show();
    }

    private void addValidationToViews() {
        awesomeValidation = new AwesomeValidation(COLORATION);
        awesomeValidation.setColor(Color.RED);  // optional, default color is RED if not set

        awesomeValidation.addValidation(this, R.id.activity_main_emailInput, Patterns.EMAIL_ADDRESS, R.string.erreur_email);
        awesomeValidation.addValidation(this, R.id.activity_main_motDePassInput, Constantes.Regex.REGEX_MOTDEPASSE, R.string.erreur_password);
    }
}