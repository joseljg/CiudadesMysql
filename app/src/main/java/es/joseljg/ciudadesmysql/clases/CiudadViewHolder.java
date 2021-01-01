package es.joseljg.ciudadesmysql.clases;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import es.joseljg.ciudadesmysql.R;

public class CiudadViewHolder extends RecyclerView.ViewHolder {

    public TextView txt_rv_nombrec = null;
    public TextView txt_rv_habitantes = null;
    public TextView txt_rv_provincia = null;
    final ListaCiudadesAdapter lcAdapter;

    public CiudadViewHolder(@NonNull View itemView, ListaCiudadesAdapter mAdapter) {
        super(itemView);

        txt_rv_nombrec = (TextView)  itemView.findViewById(R.id.txt_rv_nombrec);
        txt_rv_habitantes = (TextView)  itemView.findViewById(R.id.txt_rv_habitantes);
        txt_rv_provincia = (TextView)  itemView.findViewById(R.id.txt_rv_provincia);
        this.lcAdapter = mAdapter;
    }
}
