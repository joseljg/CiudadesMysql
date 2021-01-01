package es.joseljg.ciudadesmysql.clases;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import es.joseljg.ciudadesmysql.R;

public class ListaCiudadesAdapter extends RecyclerView.Adapter<CiudadViewHolder> {

    private Context c;
    private  ArrayList<Ciudad> listaCiudades;
    private LayoutInflater mInflater;

    public ListaCiudadesAdapter(Context c, ArrayList<Ciudad> listaCiudades) {
        this.c = c;
        this.listaCiudades = listaCiudades;
        mInflater = LayoutInflater.from(c);
    }

    @NonNull
    @Override
    public CiudadViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mItemView = mInflater.inflate(R.layout.item_recyclerview_ciudad, parent, false);
        return new CiudadViewHolder(mItemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull CiudadViewHolder holder, int position) {
        Ciudad ciudadActual = listaCiudades.get(position);
        holder.txt_rv_nombrec.setText("Ciudad: " + ciudadActual.getNombre());
        holder.txt_rv_habitantes.setText(String.valueOf("habitantes: " + ciudadActual.getHabitantes()));
        holder.txt_rv_provincia.setText(String.valueOf("idprovincia: " + ciudadActual.getIdprovincia()));
    }

    @Override
    public int getItemCount() {
        return listaCiudades.size();
    }
}