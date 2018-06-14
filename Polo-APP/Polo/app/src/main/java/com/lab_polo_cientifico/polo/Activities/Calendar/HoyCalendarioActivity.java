package com.lab_polo_cientifico.polo.Activities.Calendar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.lab_polo_cientifico.polo.R;

public class HoyCalendarioActivity extends AppCompatActivity {

    // prueba

    ///Declaro boton///
    private ImageButton imageButton2;
    private ImageButton imageButton3;
    private ImageButton imageButton4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hoy_calendario);

        // Forzar y cargar icono en el Action Bar
        getSupportActionBar().setTitle(R.string.HoyCalendarioActivity);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcherpolo);

        ///Construyo boton///
        imageButton2 = (ImageButton) findViewById(R.id.imageButton2);
        imageButton3 = (ImageButton) findViewById(R.id.imageButton3);
        imageButton4 = (ImageButton) findViewById(R.id.imageButton4);

        ///Accion boton (INVISIBLE button)///
        imageButton2.setOnClickListener(new View.OnClickListener()

                                        {
                                            @Override
                                            public void onClick(View v) {
                                                imageButton3.setVisibility(View.INVISIBLE);
                                                imageButton4.setVisibility(View.INVISIBLE);
                                            }
                                        }
        );
        imageButton3.setOnClickListener(new View.OnClickListener()

                                        {
                                            @Override
                                            public void onClick(View v) {
                                                imageButton2.setVisibility(View.INVISIBLE);
                                                imageButton4.setVisibility(View.INVISIBLE);
                                            }
                                        }
        );
        imageButton4.setOnClickListener(new View.OnClickListener()

                                        {
                                            @Override
                                            public void onClick(View v) {
                                                imageButton2.setVisibility(View.INVISIBLE);
                                                imageButton3.setVisibility(View.INVISIBLE);
                                            }
                                        }
        );
    }
}
