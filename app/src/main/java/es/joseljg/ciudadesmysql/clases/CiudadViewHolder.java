package es.joseljg.ciudadesmysql.clases;

import android.content.Intent;
import android.graphics.Bitmap;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import es.joseljg.ciudadesmysql.MostrarDetalleCiudadActivity;
import es.joseljg.ciudadesmysql.R;

import static es.joseljg.ciudadesmysql.NuevaCiudadActivity.EXTRA_OBJETO_CIUDAD;

public class CiudadViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public TextView txt_rv_nombrec = null;
    public TextView txt_rv_habitantes = null;
    public TextView txt_rv_provincia = null;
    public ImageView img_ciudad = null;

    final ListaCiudadesAdapter lcAdapter;

    public CiudadViewHolder(@NonNull View itemView, ListaCiudadesAdapter mAdapter) {
        super(itemView);
        txt_rv_nombrec = (TextView)  itemView.findViewById(R.id.txt_rv_nombrec);
        txt_rv_habitantes = (TextView)  itemView.findViewById(R.id.txt_rv_habitantes);
        txt_rv_provincia = (TextView)  itemView.findViewById(R.id.txt_rv_provincia);
        img_ciudad = (ImageView)  itemView.findViewById(R.id.img_ciudad);
        this.lcAdapter = mAdapter;
        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        // Get the position of the item that was clicked.
        int mPosition = getLayoutPosition();
        // Use that to access the affected item in mWordList.
        Ciudad ciudad = this.lcAdapter.getListaCiudades().get(mPosition);
        // Change the word in the mWordList.
        // Log.i("ciudad","has seleccionado: " + ciudad.toString());
        //  Toast.makeText(lcAdapter.getC(), "has seleccionado: " + ciudad.toString(),Toast.LENGTH_SHORT).show();
        // Notify the adapter, that the data has changed so it can
        // update the RecyclerView to display the data.
        lcAdapter.notifyDataSetChanged();
        Intent intent = new Intent(lcAdapter.getC(), MostrarDetalleCiudadActivity.class);
       // ArrayList<FotoCiudad>  listaFotosCiudades = this.lcAdapter.getListaFotosCiudades();
        intent.putExtra(EXTRA_OBJETO_CIUDAD, ciudad);
        lcAdapter.getC().startActivity(intent);
    }
}
