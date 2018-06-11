package com.lab_polo_cientifico.polo.Activities.Bar;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;

import com.github.snowdream.android.widget.SmartImageView;
import com.lab_polo_cientifico.polo.R;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class GridComidasBarActivity extends AppCompatActivity {

    public GridView gridViewBar;

    ///prueba lista web
    ArrayList camida_descripcion =new ArrayList();
    ArrayList camida_imagen =new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_comidas_bar);

        // Forzar y cargar icono en el Action Bar
        getSupportActionBar().setTitle(R.string.GridComidasBarActivity);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcherpolo);


        //declaro la lista
        gridViewBar = (GridView) findViewById(R.id.gridViewBar);
        ///prueba lista web
        descargarImagen();
    }

    ///prueba lista web
    private void descargarImagen() {
        camida_descripcion.clear();
        camida_imagen.clear();

        final ProgressDialog progressDialog=new ProgressDialog(GridComidasBarActivity.this);
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
                        gridViewBar.setAdapter(new GridComidasBarActivity.ImagenAdapter(getApplicationContext()));

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
    private class  ImagenAdapter extends BaseAdapter {
        Context ctx;
        LayoutInflater layoutInflater;
        SmartImageView smartImageView;
        TextView tvdescripcion;
        public ImagenAdapter(Context applicationContext) {
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
