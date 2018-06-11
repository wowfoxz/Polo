package com.lab_polo_cientifico.polo.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.lab_polo_cientifico.polo.R;
import com.lab_polo_cientifico.polo.Models.Noticia;
import com.squareup.picasso.Picasso;
import java.util.List;

/**
 * Created by wowfoxz2 on 05/06/2018.
 */

public class MyAdapterNoticia extends RecyclerView.Adapter<MyAdapterNoticia.ViewHolder> {

    private List<Noticia> noticia;
    private int layout;
    private OnItemClickListener itemClickListener;

    private Context context;


    public MyAdapterNoticia(List<Noticia> noticia, int layout, OnItemClickListener listener) {
        this.noticia = noticia;
        this.layout = layout;
        this.itemClickListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Inflamos el layout y se lo pasamos al constructor del ViewHolder, donde manejaremos
        // toda la lógica como extraer los datos, referencias...
        View v = LayoutInflater.from(parent.getContext()).inflate(layout, parent, false);
        context = parent.getContext();
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // Llamamos al método Bind del ViewHolder pasándole objeto y listener
        holder.bind(noticia.get(position), itemClickListener);
    }

    @Override
    public int getItemCount() {
        return noticia.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        // Elementos UI a rellenar
        public TextView textViewTitle;
        public TextView textViewDescri;
        public TextView textViewEti;
        public ImageView imageViewPoster;

        public ViewHolder(View itemView) {
            // Recibe la View completa. La pasa al constructor padre y enlazamos referencias UI
            // con nuestras propiedades ViewHolder declaradas justo arriba.
            super(itemView);
            textViewTitle = (TextView) itemView.findViewById(R.id.textViewTitle);
            textViewDescri = (TextView) itemView.findViewById(R.id.textViewDescri);
            textViewEti = (TextView) itemView.findViewById(R.id.textViewEti);
            imageViewPoster = (ImageView) itemView.findViewById(R.id.imageViewPoster);
        }

        public void bind(final Noticia noticia, final OnItemClickListener listener) {
            // Procesamos los datos a renderizar
            textViewTitle.setText(noticia.getName());
            textViewDescri.setText(noticia.getDescri());
            textViewEti.setText(noticia.getEti());
            Picasso.with(context).load(noticia.getPoster()).fit().into(imageViewPoster);
            // imageViewPoster.setImageResource(movie.getPoster());
            // Definimos que por cada elemento de nuestro recycler view, tenemos un click listener
            // que se comporta de la siguiente manera...
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onItemClick(noticia, getAdapterPosition());
                }
            });
        }
    }

    // Declaramos nuestra interfaz con el/los método/s a implementar
    public interface OnItemClickListener {
        void onItemClick(Noticia noticia, int position);
    }


}
