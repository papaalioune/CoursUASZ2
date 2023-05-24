package com.uasz.pacisse.coursuasz2.model.modelAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.uasz.pacisse.coursuasz2.R;
import com.uasz.pacisse.coursuasz2.model.Classe;

import java.util.List;

/**
 * Créé par Dr Cissé, le 24/05/2023 à 10:44
 */
public class DialogListeClassesAdapter extends ArrayAdapter<Classe> {
    public DialogListeClassesAdapter(Context context, List<Classe> listClasses) {
        super(context, 0, listClasses);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.row_dialog_afficher_liste_classes,parent, false);
        }

        DialogListeClassesAdapter.ClasseViewHolder viewHolder = (DialogListeClassesAdapter.ClasseViewHolder) convertView.getTag();
        if(viewHolder == null){
            viewHolder = new ClasseViewHolder();
            viewHolder.niveauClasse = convertView.findViewById(R.id.mNiveauCours);
            viewHolder.nomClasse = convertView.findViewById(R.id.mNomCours);

            convertView.setTag(viewHolder);
        }

        //getItem(position) va récupérer l'item [position] de la List<BeneficiaireClientCauri> beneficiaireClientCauriList
        final Classe classe = getItem(position);

        //il ne reste plus qu'à remplir notre vue
        viewHolder.nomClasse.setText(classe.getNomClasse());
        viewHolder.niveauClasse.setText(classe.getNiveauClasse().getCode_niveau());

        viewHolder.nomClasse.setTag(classe);
        viewHolder.niveauClasse.setTag(classe);

        return convertView;
    }

    private static class ClasseViewHolder{
        public TextView niveauClasse;
        public TextView nomClasse;
    }
}
