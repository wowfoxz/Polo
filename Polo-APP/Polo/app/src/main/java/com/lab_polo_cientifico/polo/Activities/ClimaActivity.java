package com.lab_polo_cientifico.polo.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.lab_polo_cientifico.polo.API.API;
import com.lab_polo_cientifico.polo.R;
import com.lab_polo_cientifico.polo.API.APIServices.WeatherService;
import com.lab_polo_cientifico.polo.Models.City;
import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ClimaActivity extends AppCompatActivity {

    private TextView textViewcity;
    private TextView textViewDescri;
    private TextView textViewTemp;
    private TextView textViewPressure;
    private TextView textViewHumidity;
    private TextView textViewTemp_min;
    private TextView textViewTemp_max;
    private ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clima);

        // Forzar y cargar icono en el Action Bar
        getSupportActionBar().setTitle(R.string.ClimaActivity);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcherpolo);

        ///declaro vistas de informacion
        textViewcity = (TextView) findViewById(R.id.textViewCity);
        textViewDescri = (TextView) findViewById(R.id.textViewDescri);
        textViewTemp = (TextView) findViewById(R.id.textViewTemp);
        textViewPressure = (TextView) findViewById(R.id.textViewPressure);
        textViewHumidity = (TextView) findViewById(R.id.textViewHumidity);
        textViewTemp_min = (TextView) findViewById(R.id.textViewTemp_min);
        textViewTemp_max = (TextView) findViewById(R.id.textViewTemp_max);
        img = (ImageView) findViewById(R.id.imageViewIcon);


///Instancia al servicio
        WeatherService service = API.getApi().create(WeatherService.class);

//praparo peticion
        Call<City> cityCall = service.getCityCelsius("Formosa,AR", API.APPKEY, "metric", "es");

//ejecucion
        cityCall.enqueue(new Callback<City>() {
            @Override
            public void onResponse(Call<City> call, Response<City> response) {
                //parseado con Json
                City city = response.body();
                setResult(city);

            }

            @Override
            public void onFailure(Call<City> call, Throwable t) {
                Toast.makeText(ClimaActivity.this, "Falla en servicio del Clima", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setResult(City city) {
        textViewcity.setText(city.getName() + ", " + city.getCountry());
        textViewDescri.setText(city.getDescription());
        textViewTemp.setText(city.getTemperature() + "ºC");
        textViewPressure.setText(" Presión atmosferica:  " + city.getPressure() + " hpa ");
        textViewHumidity.setText(" Humedad:  " + city.getHumidity() + " %  ");
        textViewTemp_min.setText(" Temperatura Minima:  " + city.getTemp_min() + " ºC  ");
        textViewTemp_max.setText(" Temperatura Maxima:  " + city.getTemp_max() + " ºC  ");

        Picasso.with(this).load(API.BASE_ICONS + city.getIcon() + API.EXTENSION_ICONS).into(img);
    }
}
