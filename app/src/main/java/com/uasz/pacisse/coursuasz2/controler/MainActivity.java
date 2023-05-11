package com.uasz.pacisse.coursuasz2.controler;

import static com.basgeekball.awesomevalidation.ValidationStyle.COLORATION;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.uasz.pacisse.coursuasz2.R;
import com.uasz.pacisse.coursuasz2.model.AccessWS;
import com.uasz.pacisse.coursuasz2.model.Etudiant;
import com.uasz.pacisse.coursuasz2.utilitaire.Constantes;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText mEmailConnexionInput;
    private EditText mMotDePassConnexionInput;
    private Button mConnectionButton;
    private TextView mInscriptionLink;

    /* *** objet de la validation *** */
    private AwesomeValidation awesomeValidation;

    private AccessWS accessWS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        accessWS = new AccessWS();

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
                System.out.println("Clic sur le lien d'inscription");
                break;
            case R.id.activity_main_connectionButton:
                if (awesomeValidation.validate()) {
                    System.out.println("Tout est vlidé");
                }
                break;
        }
    }

    private void addValidationToViews() {
        awesomeValidation = new AwesomeValidation(COLORATION);
        awesomeValidation.setColor(Color.RED);  // optional, default color is RED if not set

        awesomeValidation.addValidation(this, R.id.activity_main_emailInput, Patterns.EMAIL_ADDRESS, R.string.erreur_email);
        awesomeValidation.addValidation(this, R.id.activity_main_motDePassInput, Constantes.Regex.REGEX_MOTDEPASSE, R.string.erreur_password);
    }
}