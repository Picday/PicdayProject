package com.example.bertadomingo.picday;

/**
 * Created by berta.domingo on 27/11/2017.
 */

public class Foto {
    private String nombre;
    private int idDrawable;

    public Foto(String nombre, int idDrawable) {
        this.nombre = nombre;
        this.idDrawable = idDrawable;
    }

    public String getNombre() {
        return nombre;
    }

    public int getIdDrawable() {
        return idDrawable;
    }

    public int getId() {
        return nombre.hashCode();
    }

    public static Foto[] ITEMS = {
        new Foto("Imagen1", R.mipmap.ic_launcher),
        new Foto("Imagen2", R.mipmap.ic_launcher_round),
        new Foto("Imagen3", R.mipmap.ic_launcher),
        new Foto("Imagen4", R.mipmap.ic_launcher),
        new Foto("Imagen5", R.mipmap.ic_launcher),
    };

    public Foto getItem(int id) {
        for (Foto item : ITEMS) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

}
