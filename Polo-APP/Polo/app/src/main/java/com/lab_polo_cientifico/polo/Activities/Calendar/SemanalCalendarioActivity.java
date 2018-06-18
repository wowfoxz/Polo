package com.lab_polo_cientifico.polo.Activities.Calendar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.GridView;

import com.lab_polo_cientifico.polo.Adapters.MyAdapter;
import com.lab_polo_cientifico.polo.R;

import java.util.ArrayList;
import java.util.List;

public class SemanalCalendarioActivity extends AppCompatActivity {

    private List<String> names;
    private GridView gridView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_semanal_calendario);

        // Forzar y cargar icono en el Action Bar
        getSupportActionBar().setTitle(R.string.SemanalCalendarioActivity);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcherpolo);

        gridView = (GridView) findViewById(R.id.gridViewDias);

        // Datos a mostrar
        names = new ArrayList<String>();
        names.add("LUN");
        names.add("MART");
        names.add("MIÉRC");
        names.add("JUEV");
        names.add("VIE");

        // Adaptador, la forma visual a mostrar los datos
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.simple_list_item_1, names);
        //Enlazamos el adaptador con nuestro list view0
        gridView.setAdapter(adapter);

        registerForContextMenu(gridView);

    }
}
