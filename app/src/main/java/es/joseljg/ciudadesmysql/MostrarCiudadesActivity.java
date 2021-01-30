package es.joseljg.ciudadesmysql;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

import es.joseljg.ciudadesmysql.clases.Ciudad;
import es.joseljg.ciudadesmysql.clases.FotoCiudad;
import es.joseljg.ciudadesmysql.clases.ListaCiudadesAdapter;
import es.joseljg.ciudadesmysql.clases.Provincia;
import es.joseljg.ciudadesmysql.controladores.CiudadController;
import es.joseljg.ciudadesmysql.controladores.FotoCiudadController;
import es.joseljg.ciudadesmysql.controladores.ProvinciaController;

public class MostrarCiudadesActivity extends AppCompatActivity {

    private static final int PETICION1 = 1;
    private RecyclerView mRecyclerView;
    private ListaCiudadesAdapter mAdapter;
    private ArrayList<Ciudad> ciudades;
    private ArrayList<FotoCiudad> fotosCiudades;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_ciudades);
        //-----------------------------------------------------------
        ciudades = CiudadController.obtenerCiudades();
        fotosCiudades = FotoCiudadController.obtenerFotosCiudades();
        if(ciudades != null) {
           // mostrarToast("se ha estableciod la conexion con la base de datos");
          //  mostrarToast("el número de ciudades recuperadas es " + ciudades.size());
            //-------------------------------------------------------
            // Get a handle to the RecyclerView.
            mRecyclerView = findViewById(R.id.rv_ciudades);
            // Create an adapter and supply the data to be displayed.
            mAdapter = new ListaCiudadesAdapter(this, ciudades, fotosCiudades);
            // Connect the adapter with the RecyclerView.
            mRecyclerView.setAdapter(mAdapter);
            // Give the RecyclerView a default layout manager.
            mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        //------------------------------------------------------------
            ItemTouchHelper helper = new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT |
                ItemTouchHelper.DOWN | ItemTouchHelper.UP, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                int from = viewHolder.getAdapterPosition();
                int to = target.getAdapterPosition();
                Collections.swap(ciudades, from, to);
                mAdapter.notifyItemMoved(from, to);
                return true;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                if(direction == ItemTouchHelper.LEFT)
                {
                   mostrarToast("ha pulsado izquierda");
                  // Ciudad c = ciudades.get(viewHolder.getAdapterPosition());
                  // CiudadController.borrarCiudad(c);
                    ciudades.remove(viewHolder.getAdapterPosition());
                    mAdapter.notifyItemRemoved(viewHolder.getAdapterPosition());
                }
                if(direction == ItemTouchHelper.RIGHT)
                {
                    mostrarToast("ha pulsado derecha");
                    ciudades.remove(viewHolder.getAdapterPosition());
                    mAdapter.notifyItemRemoved(viewHolder.getAdapterPosition());
                }
            }
        });
        helper.attachToRecyclerView(mRecyclerView);
        }
        else{
            mostrarToast("no se pudo establecer la conexion con la base de datos");
        }
    }

    private void mostrarToast(String texto) {
        Toast.makeText(this,texto, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PETICION1) {
            if (resultCode == RESULT_OK) {
                Ciudad c = (Ciudad) data.getSerializableExtra(NuevaCiudadActivity.EXTRA_OBJETO_CIUDAD);
                ciudades.add(c);
                // Notify the adapter, that the data has changed.
                mRecyclerView.getAdapter().notifyItemInserted(ciudades.size());
                // Scroll to the bottom.
                mRecyclerView.smoothScrollToPosition(ciudades.size());
            }
        }
    }

    public void nuevaCiudad(View view) {
        Intent intent = new Intent(this, NuevaCiudadActivity.class);
        startActivityForResult(intent, PETICION1);
    }

    public void refrescarCiudades(View view) {
        ciudades = CiudadController.obtenerCiudades();
        if(ciudades != null) {
            mAdapter.setListaCiudades(ciudades);
            mRecyclerView.getAdapter().notifyDataSetChanged();
        }
    }

}