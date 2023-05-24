package com.uasz.pacisse.coursuasz2.controler;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.basgeekball.awesomevalidation.utility.RegexTemplate;
import com.uasz.pacisse.coursuasz2.R;
import com.uasz.pacisse.coursuasz2.model.Classe;
import com.uasz.pacisse.coursuasz2.model.Etudiant;
import com.uasz.pacisse.coursuasz2.model.modelAdapter.DialogListeClassesAdapter;
import com.uasz.pacisse.coursuasz2.model.utilitaire.Constantes;
import com.uasz.pacisse.coursuasz2.model.utilitaire.DataConverter;
import com.uasz.pacisse.coursuasz2.model.webservices.OperationsGEDT;
import com.uasz.pacisse.coursuasz2.model.webservices.RetoursOperationsGEDT;
import com.uasz.pacisse.coursuasz2.model.utilitaire.JsonToObjectConverter;

import java.util.Calendar;

public class CreerCompteActivity extends AppCompatActivity implements View.OnClickListener{
    /* *** Références des éléments graphiques de l'écran d'accueil dans l'activité *** */
    private EditText mPrenomInput;
    private EditText mNomInput;
    private EditText mReferenceInput;
    private EditText mDateNaissanceInput;
    private EditText mClasseInput;
    private EditText mEmailConnexionInput;
    private EditText mMotDePassConnexionInput;
    private Button mCreerCompteButton;
    private ImageView mCreerCompteRetour;
    private RadioGroup mSexe;
    private RadioButton mHomme;
    private RadioButton mFemme;

    private AwesomeValidation awesomeValidation;
    //************ Pour la date : calendrier ***********//
    private DatePickerDialog datePickerDialog;

    Etudiant etudiant ;

    //
    private OperationsGEDT mOperationsGEDT;
    private RetoursOperationsGEDT mRetoursOperationsGEDT;

    private JsonToObjectConverter mJsonToObjectConverter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creer_compte);

        mOperationsGEDT = new OperationsGEDT();
        mJsonToObjectConverter = new JsonToObjectConverter();

        mRetoursOperationsGEDT = mOperationsGEDT.recuperer_liste_classes(CreerCompteActivity.this);
        System.out.println(mRetoursOperationsGEDT.getDataAsArray());
        System.out.println(mJsonToObjectConverter.liste_classes_converter(mRetoursOperationsGEDT.getDataAsArray()));

        etudiant = new Etudiant();

        initView();

        //********** Date calendrier ************//
        setDateTimeField();
        //********** Date calendrier ************//

        addValidationToViews();
    }

    private void initView() {
        mEmailConnexionInput = (EditText) findViewById(R.id.activity_creer_compte_emailInput);
        mMotDePassConnexionInput = (EditText) findViewById(R.id.activity_creer_compte_motDePassInput);
        mCreerCompteButton = (Button) findViewById(R.id.activity_creer_compte_Button);
        mPrenomInput = (EditText) findViewById(R.id.activity_creer_compte_prenomInput);
        mNomInput = (EditText) findViewById(R.id.activity_creer_compte_nomInput);
        mDateNaissanceInput = (EditText) findViewById(R.id.activity_creer_compte_date_naissanceInput);
        mReferenceInput = (EditText) findViewById(R.id.activity_creer_compte_referenceInput);
        mClasseInput = (EditText) findViewById(R.id.activity_creer_compte_classeInput);
        mSexe = (RadioGroup) findViewById(R.id.activity_creer_compte_sexe);
        mHomme = (RadioButton) findViewById(R.id.activity_creer_compte_homme);
        mFemme = (RadioButton) findViewById(R.id.activity_creer_compte_femme);

        mCreerCompteRetour = (ImageView) findViewById(R.id.creer_compte_retour);

        mCreerCompteButton.setOnClickListener((View.OnClickListener) this);
        mClasseInput.setOnClickListener((View.OnClickListener) this);
        mCreerCompteRetour.setOnClickListener((View.OnClickListener) this);
        mDateNaissanceInput.setOnClickListener((View.OnClickListener) this);
        /*mSexe.setOnCheckedChangeListener((RadioGroup.OnCheckedChangeListener) this);
        mHomme.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener) this);
        mFemme.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener) this);*/
    }

    private void setDateTimeField() {
        Calendar newCalendar = Calendar.getInstance();
        //newCalendar.
        datePickerDialog = new DatePickerDialog(this, R.style.DatePickerDialogTheme, (view, year, monthOfYear, dayOfMonth) -> {
            Calendar newDate = Calendar.getInstance();
            newDate.set(year, monthOfYear, dayOfMonth);
            mDateNaissanceInput.setText(DataConverter.toString(newDate.getTime(),DataConverter.DateType.SHORT));
        },newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));
    }

    private void addValidationToViews() {
        awesomeValidation = new AwesomeValidation(ValidationStyle.COLORATION);
        awesomeValidation.setColor(Color.RED);  // optional, default color is RED if not set
        awesomeValidation.addValidation(this, R.id.activity_creer_compte_prenomInput, RegexTemplate.NOT_EMPTY, R.string.erreur_prenom);
        awesomeValidation.addValidation(this, R.id.activity_creer_compte_nomInput, RegexTemplate.NOT_EMPTY, R.string.erreur_nom);
        awesomeValidation.addValidation(this, R.id.activity_creer_compte_referenceInput, RegexTemplate.NOT_EMPTY, R.string.erreur_reference);
        awesomeValidation.addValidation(this, R.id.activity_creer_compte_date_naissanceInput, RegexTemplate.NOT_EMPTY, R.string.erreur_date_naissance);
        awesomeValidation.addValidation(this, R.id.activity_creer_compte_classeInput, RegexTemplate.NOT_EMPTY, R.string.erreur_classe);
        awesomeValidation.addValidation(this, R.id.activity_creer_compte_emailInput, Patterns.EMAIL_ADDRESS, R.string.erreur_email);
        awesomeValidation.addValidation(this, R.id.activity_creer_compte_motDePassInput, Constantes.Regex.REGEX_MOTDEPASSE, R.string.erreur_password);
    }

    //*********** Dialog des classes *******************//
    public void afficherDialogListeClasses(Activity activity){
        final Dialog dialogListeClasses = new Dialog(activity);
        // dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialogListeClasses.setCancelable(false);
        dialogListeClasses.setContentView(R.layout.dialog_afficher_liste_classes);

        Button cancelButton = dialogListeClasses.findViewById(R.id.dialog_liste_classes_cancelButton);
        cancelButton.setOnClickListener(v -> dialogListeClasses.dismiss());

        ListView listClassesView = dialogListeClasses.findViewById(R.id.dialog_list_classesView);
        DialogListeClassesAdapter adapter = new DialogListeClassesAdapter(this, mJsonToObjectConverter.liste_classes_converter(mRetoursOperationsGEDT.getDataAsArray()));
        listClassesView.setAdapter(adapter);

        listClassesView.setOnItemClickListener((parent, view, position, id) -> {
            Classe classe = mJsonToObjectConverter.liste_classes_converter(mRetoursOperationsGEDT.getDataAsArray()).get(position);
            //mClasseInput.setText(classe.getNomClasse() + " - " + classe.getNiveauClasse());
            mClasseInput.setText(classe.getNomClasse());
            dialogListeClasses.dismiss();
        });
        dialogListeClasses.show();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.activity_creer_compte_classeInput:
                afficherDialogListeClasses(CreerCompteActivity.this);
                break;
            case R.id.activity_creer_compte_date_naissanceInput:
                datePickerDialog.show();
                break;
            case R.id.creer_compte_retour:
                Intent accueil = new Intent(CreerCompteActivity.this, MainActivity.class);
                startActivity(accueil);
            case R.id.activity_creer_compte_Button:
                if (awesomeValidation.validate()) {
                    if (mOperationsGEDT.serviceInternet.connexionDisponible(getApplicationContext())) {

                    } else{
                        Toast.makeText(CreerCompteActivity.this,
                                R.string.erreur_internet_off,
                                Toast.LENGTH_LONG).show();
                    }
                }
                break;
        }
    }
}