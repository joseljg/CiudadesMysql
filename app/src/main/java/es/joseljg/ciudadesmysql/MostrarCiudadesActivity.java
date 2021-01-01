package es.joseljg.ciudadesmysql;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

import es.joseljg.ciudadesmysql.clases.Ciudad;
import es.joseljg.ciudadesmysql.clases.ListaCiudadesAdapter;

public class MostrarCiudadesActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private ListaCiudadesAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_ciudades);
        //-------------------------------------------------------
        ArrayList<Ciudad> ciudades = new ArrayList<Ciudad>();
        ciudades.add(new Ciudad("ciudad1", 234,6 ));
        ciudades.add(new Ciudad("ciudad2", 235,8 ));
        ciudades.add(new Ciudad("ciudad3", 2344,6 ));
        //-------------------------------------------------------
        // Get a handle to the RecyclerView.
        mRecyclerView = findViewById(R.id.rv_ciudades);
        // Create an adapter and supply the data to be displayed.
        mAdapter = new ListaCiudadesAdapter(this, ciudades);
        // Connect the adapter with the RecyclerView.
        mRecyclerView.setAdapter(mAdapter);
        // Give the RecyclerView a default layout manager.
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
}