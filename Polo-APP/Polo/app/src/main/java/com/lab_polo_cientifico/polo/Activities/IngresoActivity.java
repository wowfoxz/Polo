package com.lab_polo_cientifico.polo.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.lab_polo_cientifico.polo.Activities.Menu.PrincipalActivity;
import com.lab_polo_cientifico.polo.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class IngresoActivity extends AppCompatActivity {

    ///Declaro cosas///
    private EditText editTextUsuario;
    private EditText editTextContraseña;
    private Button buttonIngresar;
    private ImageView imageViewLOCK;
    private ImageView imageViewUNLOCK;
    private RequestQueue requestQueue;
    private static final String URL = "http://www.fgdevelopers.com/polo/user_control.php";
    private StringRequest request;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingreso);

        // Forzar y cargar icono en el Action Bar
        getSupportActionBar().setTitle(R.string.IngresoActivity);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcherpolo);

        ///Construyo boton///
        buttonIngresar = (Button) findViewById(R.id.buttonIngresar);
        ///construyo imagen////
        imageViewLOCK = (ImageView) findViewById(R.id.imageViewLOCK);
        imageViewUNLOCK = (ImageView) findViewById(R.id.imageViewUNLOCK);
        ///construyo editext///
        editTextUsuario = (EditText) findViewById(R.id.editTextUsuario);
        editTextContraseña = (EditText) findViewById(R.id.editTextContraseña);

        requestQueue = Volley.newRequestQueue(this);

        ///Accion boton (Abrir nueva ventana)///
        buttonIngresar.setOnClickListener(new View.OnClickListener()

                                          {
                                              @Override
                                              public void onClick(View v) {

                                                  imageViewLOCK.setVisibility(View.INVISIBLE);



                                              /*Intent nuevo = new Intent(IngresoActivity.this,PrincipalActivity.class);
                                              startActivity(nuevo);*/

                                                  ///Esperar 5 segundos////
                                              /*try {
                                                  Thread.sleep(5000);
                                              } catch (InterruptedException e) {
                                                  e.printStackTrace();
                                              }*/

                                                  request = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
                                                      @Override
                                                      public void onResponse(String response) {
                                                          try {
                                                              JSONObject jsonObject = new JSONObject(response);
                                                              if (jsonObject.names().get(0).equals("success")) {
                                                                  imageViewUNLOCK.setVisibility(View.INVISIBLE);

                                                                  Toast.makeText(getApplicationContext(), "SUCCESS " + jsonObject.getString("success"), Toast.LENGTH_LONG).show();
                                                                  startActivity(new Intent(getApplicationContext(), PrincipalActivity.class));
                                                                  Log.i("informacion", "json bien");
                                                              } else {
                                                                  imageViewLOCK.setVisibility(View.VISIBLE);
                                                                  Toast.makeText(getApplicationContext(), "Error" + jsonObject.getString("error"), Toast.LENGTH_LONG).show();

                                                              }

                                                          } catch (JSONException e) {
                                                              imageViewLOCK.setVisibility(View.VISIBLE);
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
                                                          hashMap.put("nombreUsuario", editTextUsuario.getText().toString());
                                                          hashMap.put("passUsuario", editTextContraseña.getText().toString());
                                                          Log.i("informacion", "problema nombre y pass");
                                                          return hashMap;
                                                      }
                                                  };

                                                  requestQueue.add(request);
                                                  Log.i("informacion", "problema request");
                                              }
                                          }
        );
    }
}
