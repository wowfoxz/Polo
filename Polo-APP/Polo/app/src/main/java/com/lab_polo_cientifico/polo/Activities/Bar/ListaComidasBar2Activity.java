package com.lab_polo_cientifico.polo.Activities.Bar;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;

import com.github.snowdream.android.widget.SmartImageView;
import com.lab_polo_cientifico.polo.R;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class ListaComidasBar2Activity extends AppCompatActivity {

    // Variables
    private int counter = 0;
    private final int SWITCH_TO_LIST_VIEW = 0;
    private final int SWITCH_TO_GRID_VIEW = 1;

    public ListView listViewBar2;
    public GridView gridViewBar;
    // Items en el option menu
    private MenuItem itemListView;
    private MenuItem itemGridView;

    ///prueba lista web
    ArrayList camida_descripcion =new ArrayList();
    ArrayList camida_imagen =new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_comidas_bar2);


        // Forzar y cargar icono en el Action Bar
        getSupportActionBar().setTitle(R.string.ListaComidasBarActivity);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcherpolo);

        //declaro la lista
        this.listViewBar2 = (ListView) findViewById(R.id.listViewBar2);
        this.gridViewBar = (GridView) findViewById(R.id.gridViewBar);

        // Registrar el context menu para ambos
        registerForContextMenu(this.listViewBar2);
        registerForContextMenu(this.gridViewBar);

        ///prueba lista web
        descargarImagenList();
        descargarImagenGrid();


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflamos el option menu con nuestro layout
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.option_menu, menu);
        // Después de inflar, recogemos las referencias a los botones que nos interesan
        this.itemListView = menu.findItem(R.id.listViewBar2);
        this.itemGridView = menu.findItem(R.id.gridViewBar);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Eventos para los clicks en los botones del options menu
        switch (item.getItemId()) {

            case R.id.listViewBar2:
                this.switchListGridView(this.SWITCH_TO_LIST_VIEW);
                return true;
            case R.id.gridViewBar:
                this.switchListGridView(this.SWITCH_TO_GRID_VIEW);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }


    private void switchListGridView(int option) {
        // Método para cambiar entre Grid/List view
        if (option == SWITCH_TO_LIST_VIEW) {
            // Si queremos cambiar a list view, y el list view está en modo invisible...
            if (this.listViewBar2.getVisibility() == View.INVISIBLE) {
                // ... escondemos el grid view, y enseñamos su botón en el menú de opciones
                this.gridViewBar.setVisibility(View.INVISIBLE);
                this.itemGridView.setVisible(true);
                // no olvidamos enseñar el list view, y esconder su botón en el menú de opciones
                this.listViewBar2.setVisibility(View.VISIBLE);
                this.itemListView.setVisible(false);
            }
        } else if (option == SWITCH_TO_GRID_VIEW) {
            // Si queremos cambiar a grid view, y el grid view está en modo invisible...
            if (this.gridViewBar.getVisibility() == View.INVISIBLE) {
                // ... escondemos el list view, y enseñamos su botón en el menú de opciones
                this.listViewBar2.setVisibility(View.INVISIBLE);
                this.itemListView.setVisible(true);
                // no olvidamos enseñar el grid view, y esconder su botón en el menú de opciones
                this.gridViewBar.setVisibility(View.VISIBLE);
                this.itemGridView.setVisible(false);
            }
        }
    }


    ///prueba lista web
    private void descargarImagenList() {
        camida_descripcion.clear();
        camida_imagen.clear();

        final ProgressDialog progressDialog=new ProgressDialog(ListaComidasBar2Activity.this);
        progressDialog.setMessage("CARGANDO...");
        progressDialog.show();

        AsyncHttpClient client = new AsyncHttpClient();
        client.get("http://www.fgdevelopers.com/polo/comidas2.php", new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                if (statusCode==200){
                    progressDialog.dismiss();
                    try {
                        JSONArray jsonArray =new JSONArray(new String(responseBody));
                        for (int i=0;i<jsonArray.length();i++){
                            camida_descripcion.add(jsonArray.getJSONObject(i).getString("comida_descripcion"));
                            camida_imagen.add(jsonArray.getJSONObject(i).getString("comida_imagen"));
                        }
                        listViewBar2.setAdapter(new ImagenAdapterList(getApplicationContext()));

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

            }
        });

    }
    private class  ImagenAdapterList extends BaseAdapter{
        Context ctx;
        LayoutInflater layoutInflater;
        SmartImageView smartImageView;
        TextView tvdescripcion;
        public ImagenAdapterList(Context applicationContext) {
            this.ctx=applicationContext;
            layoutInflater=(LayoutInflater)ctx.getSystemService(LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public int getCount() {

            return camida_imagen.size();
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            ViewGroup viewGroup=(ViewGroup)layoutInflater.inflate(R.layout.list_item_bar2, null);
            smartImageView=(SmartImageView)viewGroup.findViewById(R.id.imagen);
            tvdescripcion=(TextView) viewGroup.findViewById(R.id.tvDescripcion);

            String urlfinal="http://www.fgdevelopers.com/polo/comidas_imagenes/"+camida_imagen.get(position).toString();
            Rect rect =new Rect(smartImageView.getLeft(),smartImageView.getTop(),smartImageView.getRight(),smartImageView.getBottom());
            smartImageView.setImageUrl(urlfinal, rect);

            tvdescripcion.setText(camida_descripcion.get(position).toString());
            return viewGroup;
        }
    }

    ///prueba grid web
    private void descargarImagenGrid() {
        camida_descripcion.clear();
        camida_imagen.clear();

        final ProgressDialog progressDialog=new ProgressDialog(ListaComidasBar2Activity.this);
        progressDialog.setMessage("CARGANDO...");
        progressDialog.show();

        AsyncHttpClient client = new AsyncHttpClient();
        client.get("http://www.fgdevelopers.com/polo/comidas2.php", new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                if (statusCode==200){
                    progressDialog.dismiss();
                    try {
                        JSONArray jsonArray =new JSONArray(new String(responseBody));
                        for (int i=0;i<jsonArray.length();i++){
                            camida_descripcion.add(jsonArray.getJSONObject(i).getString("comida_descripcion"));
                            camida_imagen.add(jsonArray.getJSONObject(i).getString("comida_imagen"));
                        }
                        gridViewBar.setAdapter(new ListaComidasBar2Activity.ImagenAdapterGrid(getApplicationContext()));

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

            }
        });

    }
    private class  ImagenAdapterGrid extends BaseAdapter {
        Context ctx;
        LayoutInflater layoutInflater;
        SmartImageView smartImageView;
        TextView tvdescripcion;
        public ImagenAdapterGrid(Context applicationContext) {
            this.ctx=applicationContext;
            layoutInflater=(LayoutInflater)ctx.getSystemService(LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public int getCount() {

            return camida_imagen.size();
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            ViewGroup viewGroup=(ViewGroup)layoutInflater.inflate(R.layout.grid_item_bar, null);
            smartImageView=(SmartImageView)viewGroup.findViewById(R.id.imagen);
            tvdescripcion=(TextView) viewGroup.findViewById(R.id.tvDescripcion);

            String urlfinal="http://www.fgdevelopers.com/polo/comidas_imagenes/"+camida_imagen.get(position).toString();
            Rect rect =new Rect(smartImageView.getLeft(),smartImageView.getTop(),smartImageView.getRight(),smartImageView.getBottom());
            smartImageView.setImageUrl(urlfinal, rect);

            tvdescripcion.setText(camida_descripcion.get(position).toString());
            return viewGroup;
        }
    }
}
