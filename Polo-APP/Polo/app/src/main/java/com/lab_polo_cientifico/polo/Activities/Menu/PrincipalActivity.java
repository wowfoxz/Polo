package com.lab_polo_cientifico.polo.Activities.Menu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.lab_polo_cientifico.polo.Activities.ClimaActivity;
import com.lab_polo_cientifico.polo.Activities.NoticiasActivity;
import com.lab_polo_cientifico.polo.R;

public class PrincipalActivity extends AppCompatActivity {

    ///Declaro boton///
    private Button buttonCalendarioNN;
    private Button buttonBuffet;
    private Button buttonNoticias;
    private Button buttonClima;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        // Forzar y cargar icono en el Action Bar
        getSupportActionBar().setTitle(R.string.PrincipalActivity);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcherpolo);

        ///Construyo boton///
        buttonCalendarioNN = (Button) findViewById(R.id.buttonCalendarioNN);
        buttonBuffet = (Button) findViewById(R.id.buttonBuffet);
        buttonNoticias = (Button) findViewById(R.id.buttonNoticias);
        buttonClima = (Button) findViewById(R.id.buttonClima);

        ///Accion boton (Abrir nueva ventana)///
        buttonCalendarioNN.setOnClickListener(new View.OnClickListener()

                                              {
                                                  @Override
                                                  public void onClick(View v) {
                                                      Intent nuevo = new Intent(PrincipalActivity.this, CalendarioMenuActivity.class);
                                                      startActivity(nuevo);
                                                  }
                                              }
        );

        buttonBuffet.setOnClickListener(new View.OnClickListener()

                                        {
                                            @Override
                                            public void onClick(View v) {
                                                Intent nuevo = new Intent(PrincipalActivity.this, BuffetMenuActivity.class);
                                                startActivity(nuevo);
                                            }
                                        }
        );
        buttonNoticias.setOnClickListener(new View.OnClickListener()

                                        {
                                            @Override
                                            public void onClick(View v) {
                                                Intent nuevo = new Intent(PrincipalActivity.this, NoticiasActivity.class);
                                                startActivity(nuevo);
                                            }
                                        }
        );
        buttonClima.setOnClickListener(new View.OnClickListener()

                                          {
                                              @Override
                                              public void onClick(View v) {
                                                  Intent nuevo = new Intent(PrincipalActivity.this, ClimaActivity.class);
                                                  startActivity(nuevo);
                                              }
                                          }
        );
    }
}
