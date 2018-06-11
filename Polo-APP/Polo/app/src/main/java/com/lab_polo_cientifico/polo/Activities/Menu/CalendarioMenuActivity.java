package com.lab_polo_cientifico.polo.Activities.Menu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.lab_polo_cientifico.polo.Activities.Calendar.HoyCalendarioActivity;
import com.lab_polo_cientifico.polo.Activities.Calendar.MensualCalendarioActivity;
import com.lab_polo_cientifico.polo.Activities.Calendar.SemanalCalendarioActivity;
import com.lab_polo_cientifico.polo.R;

public class CalendarioMenuActivity extends AppCompatActivity {

    ///Declaro boton///
    private Button buttonCalendarioHoy;
    private Button buttonCalendarioSemanal;
    private Button buttonCalendarioMesual;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendario_menu);

        // Forzar y cargar icono en el Action Bar
        getSupportActionBar().setTitle(R.string.CalendarioMenuActivity);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcherpolo);

        ///Construyo boton///
        buttonCalendarioHoy = (Button) findViewById(R.id.buttonCalendarioHoy);
        buttonCalendarioSemanal = (Button) findViewById(R.id.buttonCalendarioSemanal);
        buttonCalendarioMesual = (Button) findViewById(R.id.buttonCalendarioMesual);

        ///Accion boton (Abrir nueva ventana)///
        buttonCalendarioHoy.setOnClickListener(new View.OnClickListener()

                                               {
                                                   @Override
                                                   public void onClick(View v) {
                                                       Intent nuevo = new Intent(CalendarioMenuActivity.this, HoyCalendarioActivity.class);
                                                       startActivity(nuevo);
                                                   }
                                               }
        );

        ///Accion boton (Abrir nueva ventana)///
        buttonCalendarioSemanal.setOnClickListener(new View.OnClickListener()

                                                   {
                                                       @Override
                                                       public void onClick(View v) {
                                                           Intent nuevo = new Intent(CalendarioMenuActivity.this, SemanalCalendarioActivity.class);
                                                           startActivity(nuevo);
                                                       }
                                                   }
        );

        ///Accion boton (Abrir nueva ventana)///
        buttonCalendarioMesual.setOnClickListener(new View.OnClickListener()

                                                  {
                                                      @Override
                                                      public void onClick(View v) {
                                                          Intent nuevo = new Intent(CalendarioMenuActivity.this, MensualCalendarioActivity.class);
                                                          startActivity(nuevo);
                                                      }
                                                  }
        );
    }
}
