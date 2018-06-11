package com.lab_polo_cientifico.polo.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.lab_polo_cientifico.polo.R;

import java.util.List;

public class MyAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private List<String> comidas;

    public MyAdapter(Context context, int layout, List<String> comidas) {
        this.context = context;
        this.layout = layout;
        this.comidas = comidas;
    }

    @Override
    //cuantas veces hay iteracion .... numero de item
    public int getCount() {
        return this.comidas.size();
    }

    @Override
    //un item de la coleccion
    public Object getItem(int position) {
        return this.comidas.get(position);
    }

    //ID de la coleccion
    @Override
    public long getItemId(int position) {
        return 0;
    }

    //agarra el item y lo dibuja
    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        // View Holder Pattern
        ViewHolder holder;
        if (convertView == null) {
            //Inflamos la vista que nos ha llegado con nuestro layout personalizado
            LayoutInflater layoutInflater = LayoutInflater.from(this.context);
            convertView = layoutInflater.inflate(R.layout.list_item_bar, null);
            holder = new ViewHolder();
            //Referenciamos el elemento a modificar y lo rellenamos
            holder.comidasTextView = (TextView) convertView.findViewById(R.id.textViewBar);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        //Nos traemos el valor actual dependiendo de la posicion
        String currentComidas = comidas.get(position);
        //currentComidas = (String) getItem(position);

        //Referenciamos el elemento a modificar y lo rellenamos
        holder.comidasTextView.setText(currentComidas);

        //devolvemos la vista inflada y modificada con nuestros datos
        return convertView;

    }

    static class ViewHolder {
        private TextView comidasTextView;

    }
}
