package com.lab_polo_cientifico.polo.Activities.Calendar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.lab_polo_cientifico.polo.Activities.IngresoActivity;
import com.lab_polo_cientifico.polo.Activities.Menu.PrincipalActivity;
import com.lab_polo_cientifico.polo.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class HoyCalendarioActivity extends AppCompatActivity {
    ///prueba
    private static final String URL = "http://www.fgdevelopers.com/polo/emociones.php";
    private StringRequest request;
    private RequestQueue requestQueue;

    ///Declaro boton///
    private ImageButton imageButtonfeliz;
    private ImageButton imageButtonneutral;
    private ImageButton imageButtonenojado;

    private String usuario;
    private String pass;
    private int idEmocion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hoy_calendario);

        //recupero usuario y contraseña
        usuario = IngresoActivity.nombreUsuario;
        pass = IngresoActivity.passUsuario;

        // Forzar y cargar icono en el Action Bar
        getSupportActionBar().setTitle(R.string.HoyCalendarioActivity);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcherpolo);

        requestQueue = Volley.newRequestQueue(this);

        ///Construyo boton///
        imageButtonfeliz = (ImageButton) findViewById(R.id.imageButtonfeliz);
        imageButtonneutral = (ImageButton) findViewById(R.id.imageButtonneutral);
        imageButtonenojado = (ImageButton) findViewById(R.id.imageButtonenojado);

        ///Accion boton (INVISIBLE button)///
        imageButtonfeliz.setOnClickListener(new View.OnClickListener()

                                            {
                                                @Override
                                                public void onClick(View v) {
                                                    idEmocion = 1;
                                                    insertarcara();
                                                    imageButtonneutral.setVisibility(View.INVISIBLE);
                                                    imageButtonenojado.setVisibility(View.INVISIBLE);

                                                }
                                            }
        );
        imageButtonneutral.setOnClickListener(new View.OnClickListener()

                                              {
                                                  @Override
                                                  public void onClick(View v) {
                                                      idEmocion = 2;
                                                      insertarcara();
                                                      imageButtonfeliz.setVisibility(View.INVISIBLE);
                                                      imageButtonenojado.setVisibility(View.INVISIBLE);
                                                  }
                                              }
        );
        imageButtonenojado.setOnClickListener(new View.OnClickListener()

                                              {
                                                  @Override
                                                  public void onClick(View v) {
                                                      idEmocion = 3;
                                                      insertarcara();
                                                      imageButtonfeliz.setVisibility(View.INVISIBLE);
                                                      imageButtonneutral.setVisibility(View.INVISIBLE);
                                                  }
                                              }
        );


    }
    private void insertarcara(){
        request = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    if (jsonObject.names().get(0).equals("success")) {


                        //Toast.makeText(getApplicationContext(), "BIENVENIDO " + jsonObject.getString("success"), Toast.LENGTH_LONG).show();

                        startActivity(new Intent(getApplicationContext(), PrincipalActivity.class));

                        Log.i("informacion", "json bien");
                    } else {

                        Toast.makeText(getApplicationContext(), "Error" + jsonObject.getString("error"), Toast.LENGTH_LONG).show();

                    }

                } catch (JSONException e) {

                    e.printStackTrace();
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.i("informacion", "volley mal");

            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String, String> hashMap = new HashMap<String, String>();
                hashMap.put("nombreUsuario", usuario);
                hashMap.put("passUsuario", pass);
                hashMap.put("idEmocion", String.valueOf(idEmocion));
                Log.i("informacion", "problema nombre y pass");
                return hashMap;
            }
        };

        requestQueue.add(request);
        Log.i("informacion", "problema request");
    }
}

