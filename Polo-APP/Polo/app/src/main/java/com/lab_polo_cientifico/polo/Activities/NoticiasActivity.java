package com.lab_polo_cientifico.polo.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.lab_polo_cientifico.polo.R;
import com.lab_polo_cientifico.polo.Adapters.MyAdapterNoticia;
import com.lab_polo_cientifico.polo.Models.Noticia;

import java.util.ArrayList;
import java.util.List;

public class NoticiasActivity extends AppCompatActivity {
    private List<Noticia> noticia;
    private RecyclerView mRecyclerView;
    // Puede ser declarado como 'RecyclerView.Adapter' o como nuetra clase adaptador 'MyAdapter'
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_noticias);

        // Forzar y cargar icono en el Action Bar
        getSupportActionBar().setTitle(R.string.NoticiasActivity);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcherpolo);

        noticia = this.getAllMovies();

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mLayoutManager = new LinearLayoutManager(this);

        // 1 linea de dif. acabo de build y error en interfaz xk pojo. esto y luego xml con card, textview image

        // Implementamos nuestro OnItemClickListener propio, sobreescribiendo el método que nosotros
        // definimos en el adaptador, y recibiendo los parámetros que necesitamos
        mAdapter = new MyAdapterNoticia(noticia, R.layout.recycler_view_item, new MyAdapterNoticia.OnItemClickListener() {
            @Override
            public void onItemClick(Noticia movie, int position) {
                //Toast.makeText(MainActivity.this, name + " - " + position, Toast.LENGTH_LONG).show();
                removeMovie(position);
            }
        });

        // Lo usamos en caso de que sepamos que el layout no va a cambiar de tamaño, mejorando la performance
        mRecyclerView.setHasFixedSize(true);
        // Añade un efecto por defecto, si le pasamos null lo desactivamos por completo
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());

        // Enlazamos el layout manager y adaptor directamente al recycler view
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.noticia_menu, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add_name:
                this.addMovie(0);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private List<Noticia> getAllMovies() {
        return new ArrayList<Noticia>() {{
            add(new Noticia("Titulo de noticia 1","Descripcion de noticia 1","★ Laboratorio", R.drawable.cnn_international));
            add(new Noticia("Impuestos municipales: 20% de descuento por pago anual","Para brindar mayor oportunidad de regularizar la situación impositiva de los vecinos","★ General ★ Local", R.drawable.prorrogan));
            add(new Noticia("Titulo de noticia 3","Descripcion de noticia 3","★ Tecnologia", R.drawable.cnn_international));
            add(new Noticia("Titulo de noticia 4","Descripcion de noticia 4","★ General", R.drawable.cnn_international));
        }};
    }

    private void addMovie(int position) {
        noticia.add(position, new Noticia("Titulo Nueva Noticia " + (++counter),"Descripcion Nueva Noticia " + (++counter),"★ Nueva Etiqueta " + (++counter), R.drawable.cnn_international));
        // Notificamos de un nuevo item insertado en nuestra colección
        mAdapter.notifyItemInserted(position);
        // Hacemos scroll hacia lo posición donde el nuevo elemento se aloja
        mLayoutManager.scrollToPosition(position);
    }

    private void removeMovie(int position) {
        noticia.remove(position);
        // Notificamos de un item borrado en nuestra colección
        mAdapter.notifyItemRemoved(position);
    }
}
