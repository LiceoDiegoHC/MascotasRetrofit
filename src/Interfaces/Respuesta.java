package Interfaces;

import com.google.gson.annotations.SerializedName;

public class Respuesta {
    
    @SerializedName("message")
    private String respuesta;
    
    public String getRespuesta(){
        return respuesta;
    }    
    
}
