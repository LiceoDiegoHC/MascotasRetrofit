package Interfaces;

import com.google.gson.annotations.SerializedName;

public class Mascotas {
    
    @SerializedName("id")
    private int id;
    @SerializedName("nombre")
    private String nombre;
    @SerializedName("tipo")
    private String tipo;
    @SerializedName("edad")
    private int edad;

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @return the edad
     */
    public int getEdad() {
        return edad;
    }
    
}
