package com.lab_polo_cientifico.polo.Activities.Calendar;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.github.snowdream.android.widget.SmartImageView;
import com.lab_polo_cientifico.polo.Activities.Bar.GridComidasBarActivity;
import com.lab_polo_cientifico.polo.Activities.IngresoActivity;
import com.lab_polo_cientifico.polo.Adapters.MyAdapter;
import com.lab_polo_cientifico.polo.R;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cz.msebera.android.httpclient.Header;

public class SemanalCalendarioActivity extends AppCompatActivity {

    private List<String> names;
    private GridView gridViewDias;

    private List<String> caras;
    public GridView gridViewCaras;


    private String usuario;
    private String pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_semanal_calendario);
        //recupero usuario y contraseña


        // Forzar y cargar icono en el Action Bar
        getSupportActionBar().setTitle(R.string.SemanalCalendarioActivity);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcherpolo);


        gridViewDias = (GridView) findViewById(R.id.gridViewDias);
        gridViewCaras = (GridView) findViewById(R.id.gridViewCaras);

        // Datos a mostrar
        names = new ArrayList<String>();
        names.add("LUN");
        names.add("MART");
        names.add("MIÉRC");
        names.add("JUEV");
        names.add("VIE");

        // Datos a mostrar
        caras = new ArrayList<String>();
        caras.add("LUN");
        caras.add("MART");
        caras.add("MIÉRC");
        caras.add("JUEV");
        caras.add("VIE");

        // Adaptador, la forma visual a mostrar los datos
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.simple_list_item_1, names);
        //Enlazamos el adaptador con nuestro list view0
        gridViewDias.setAdapter(adapter);

        registerForContextMenu(gridViewDias);

        // Adaptador, la forma visual a mostrar los datos
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, R.layout.simple_list_item_1, caras);
        //Enlazamos el adaptador con nuestro list view0
        gridViewCaras.setAdapter(adapter2);

        registerForContextMenu(gridViewCaras);
    }

}
