package com.lab_polo_cientifico.polo.API;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.lab_polo_cientifico.polo.API.Deserializers.MyDeserializer;
import com.lab_polo_cientifico.polo.Models.City;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class API {
    public static final String APPKEY ="b290ea6fab3f9a157e64d18bfb64a73d";
    public static final String BASE_URL = "http://api.openweathermap.org/data/2.5/";
    public static final String BASE_ICONS = "http://openweathermap.org/img/w/";
    public static final String EXTENSION_ICONS = ".png";
    private static Retrofit retrofit = null;

    /// tengo retrofit para la API
    public static Retrofit getApi(){
        if (retrofit == null){

            GsonBuilder builder = new GsonBuilder();
            builder.registerTypeAdapter(City.class, new MyDeserializer());

            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(builder.create()))
                    .build();
        }
        return retrofit;
    }
}
