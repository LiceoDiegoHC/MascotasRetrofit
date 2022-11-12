package API;

import Interfaces.Mascotas;
import Interfaces.Respuesta;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface RegistroAPI {
    
    @FormUrlEncoded
    @POST("insertar.php")
    public Call<List<Respuesta>> NuevaMascota(
            @Field("nombre") String nombre,
            @Field("tipo") String tipo,
            @Field("edad") int edad
    );
    
    @GET("consultar.php")
    public Call<List<Mascotas>> ConsultarMascotas();
}
