package com.lab_polo_cientifico.polo.API.Deserializers;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.lab_polo_cientifico.polo.Models.City;

import java.lang.reflect.Type;

public class MyDeserializer implements JsonDeserializer<City>{

    @Override
    public City deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        int id = json.getAsJsonObject().get("id").getAsInt();
        String name = json.getAsJsonObject().get("name").getAsString();
        String country = json.getAsJsonObject().get("sys").getAsJsonObject().get("country").getAsString();
        String icon = json.getAsJsonObject().get("weather").getAsJsonArray().get(0).getAsJsonObject().get("icon").getAsString();
        String description = json.getAsJsonObject().get("weather").getAsJsonArray().get(0).getAsJsonObject().get("description").getAsString();
        int temp = json.getAsJsonObject().get("main").getAsJsonObject().get("temp").getAsInt();
        int pressure = json.getAsJsonObject().get("main").getAsJsonObject().get("pressure").getAsInt();
        int humidity = json.getAsJsonObject().get("main").getAsJsonObject().get("humidity").getAsInt();
        int temp_min = json.getAsJsonObject().get("main").getAsJsonObject().get("temp_min").getAsInt();
        int temp_max = json.getAsJsonObject().get("main").getAsJsonObject().get("temp_max").getAsInt();

        City city = new City(id,name,country,icon,description,temp,pressure,humidity,temp_min,temp_max);
        return city;

    }
}
