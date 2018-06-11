package com.lab_polo_cientifico.polo.API.APIServices;

import com.lab_polo_cientifico.polo.Models.City;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherService {

    @GET("weather")
    Call<City> getCity(@Query("q") String city, @Query("appid") String key);
    @GET("weather")
    Call<City> getCityCelsius(@Query("q") String city, @Query("appid") String key,@Query("units") String value,@Query("lang") String lang);

}
