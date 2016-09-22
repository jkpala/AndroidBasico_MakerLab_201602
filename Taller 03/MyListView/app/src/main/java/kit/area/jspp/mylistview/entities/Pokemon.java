package kit.area.jspp.mylistview.entities;

import java.util.UUID;

/**
 * Created by PEPE on 28/08/2016.
 */
public class Pokemon {
    private String mId;
    private String mNombre;
    private String mTipo;
    private int mImage;
    private int mColor;


    public Pokemon(String nombre, String tipo, int image,int color) {
        mId = UUID.randomUUID().toString();
        mNombre = nombre;
        mTipo = tipo;
        mImage = image;
        mColor = color;
    }

    public String getId() {
        return mId;
    }

    public void setId(String id) {
        mId = id;
    }

    public String getNombre() {
        return mNombre;
    }

    public void setNombre(String nombre) {
        mNombre = nombre;
    }

    public String getTipo() {
        return mTipo;
    }

    public void setTipo(String tipo) {
        mTipo = tipo;
    }

    public int getImage() {
        return mImage;
    }

    public void setImage(int image) {
        mImage = image;
    }

    public int getColor() {
        return mColor;
    }

    public void setColor(int color) {
        mColor = color;
    }

}
