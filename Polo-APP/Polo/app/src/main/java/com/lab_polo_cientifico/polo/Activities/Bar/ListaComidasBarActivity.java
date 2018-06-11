package com.lab_polo_cientifico.polo.Activities.Bar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.lab_polo_cientifico.polo.R;
import com.lab_polo_cientifico.polo.Adapters.MyAdapter;

import java.util.ArrayList;
import java.util.List;

public class ListaComidasBarActivity extends AppCompatActivity {

    private ListView listViewBar;
    private List<String> comidas;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_comidas_bar);

        // Forzar y cargar icono en el Action Bar
        getSupportActionBar().setTitle(R.string.ListaComidasBarActivity);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcherpolo);

        //declaro la lista
        listViewBar = (ListView) findViewById(R.id.listViewBar);

        // Datos a mostrar
        comidas = new ArrayList<String>();
        comidas.add("TORTA");
        comidas.add("CAFÉ");
        comidas.add("TÉ");
        comidas.add("MEDIA LUNAS");
        comidas.add("CEREALES");
        comidas.add("JUGOS");
        // Adaptador, la forma visual a mostrar los datos
        // ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, comidas);
        //Enlazamos el adaptador con nuestro list view
        //listViewBar.setAdapter(adapter);

        // Evento click Item
        listViewBar.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Toast.makeText(ListaComidasBarActivity.this, "click: " + comidas.get(position), Toast.LENGTH_SHORT).show();
            }
        });


        // Enlazamos con nuestro adaptador personalizado
        MyAdapter myAdapter = new MyAdapter(this, R.layout.list_item_bar, comidas);
        listViewBar.setAdapter(myAdapter);
    }

}
