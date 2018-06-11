package com.lab_polo_cientifico.polo.Models;

/**
 * Created by wowfoxz2 on 05/06/2018.
 */

public class Noticia {

    public String title;
    public String descri;
    public String eti;
    public int poster;

    public Noticia() {

    }

    public Noticia(String title,String descri,String eti, int poster) {
        this.title = title;
        this.descri = descri;
        this.eti = eti;
        this.poster = poster;
    }

    public String getName() {

        return title;

    }
    public String getDescri() {

        return descri;

    }
    public String getEti() {

        return eti;

    }

    public void setName(String title) {

        this.title = title;
    }
    public void setDescri(String descri) {

        this.descri = descri;
    }
    public void setEti(String eti) {

        this.eti = eti;
    }

    public int getPoster() {

        return poster;
    }

    public void setPoster(int poster) {

        this.poster = poster;
    }

}
