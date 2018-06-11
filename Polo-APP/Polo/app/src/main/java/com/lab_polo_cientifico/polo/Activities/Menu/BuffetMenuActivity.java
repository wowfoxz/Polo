package com.lab_polo_cientifico.polo.Activities.Menu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.lab_polo_cientifico.polo.Activities.Bar.ListaComidasBar2Activity;
import com.lab_polo_cientifico.polo.R;

public class BuffetMenuActivity extends AppCompatActivity {

    private Button buttonListViewComidas;
   // private Button buttonGridViewComidas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buffet_menu);

        // Forzar y cargar icono en el Action Bar
        getSupportActionBar().setTitle(R.string.BuffetMenuActivity);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcherpolo);

        ///Construyo boton///
        buttonListViewComidas = (Button) findViewById(R.id.buttonListViewComidas);
       // buttonGridViewComidas = (Button) findViewById(R.id.buttonGridViewComidas);

        ///Accion boton (Abrir nueva ventana)///
        buttonListViewComidas.setOnClickListener(new View.OnClickListener()

                                               {
                                                   @Override
                                                   public void onClick(View v) {
                                                       Intent nuevo = new Intent(BuffetMenuActivity.this, ListaComidasBar2Activity.class);
                                                       startActivity(nuevo);
                                                   }
                                               }
        );

        /*///Accion boton (Abrir nueva ventana)///
        buttonGridViewComidas.setOnClickListener(new View.OnClickListener()

                                                   {
                                                       @Override
                                                       public void onClick(View v) {
                                                           Intent nuevo = new Intent(BuffetMenuActivity.this, GridComidasBarActivity.class);
                                                           startActivity(nuevo);
                                                       }
                                                   }
        );*/
    }
}

