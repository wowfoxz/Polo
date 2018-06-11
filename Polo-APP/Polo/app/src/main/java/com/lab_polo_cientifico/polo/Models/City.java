package com.lab_polo_cientifico.polo.Models;



public class City {

    private int id;
    private String name;
    private String country;
    private String icon;
    private String description;
    private int temperature;
    private int pressure;
    private int humidity;
    private int temp_min;
    private int temp_max;




    public City (int id, String name, String country, String icon, String description, int temperature, int pressure,int humidity,int temp_min, int temp_max){
        this.id = id;
        this.name = name;
        this.country = country;
        this.icon = icon;
        this.description = description;
        this.temperature = temperature;
        this.pressure = pressure;
        this.humidity = humidity;
        this.temp_min = temp_min;
        this.temp_max = temp_max;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public int getPressure() {return pressure; }

    public void setPressure(int pressure) {this.pressure = pressure;}

    public int getHumidity() {return humidity; }

    public void setHumidity(int humidity) {this.humidity = humidity; }

    public int getTemp_min() {return temp_min; }

    public void setTemp_min(int temp_min) { this.temp_min = temp_min; }

    public int getTemp_max() { return temp_max; }

    public void setTemp_max(int temp_max) {this.temp_max = temp_max;}

    // "main":{"temp":6,"pressure":1020,"humidity":100,"temp_min":6,"temp_max":6},
}
