package API;

import Interfaces.Mascotas;
import Interfaces.Productos;
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
    
    @FormUrlEncoded
    @POST("actualizar.php")
    public Call<List<Respuesta>> ModificarMascota(
            @Field("idM") int id,
            @Field("nombreM") String nombre,
            @Field("tipoM") String tipo,
            @Field("edadM") int edad
    );
    
    @FormUrlEncoded
    @POST("eliminar.php")
    public Call<List<Respuesta>> EliminarMascota(
            @Field("idM") int id
    );
    
    @FormUrlEncoded
    @POST("ConsultarProducto.php")
    public Call<List<Productos>> VerProducto(
            @Field("idP") int id
    );
    
    @FormUrlEncoded
    @POST("compras.php")
    public Call<List<Respuesta>> NuevaCompra(
            @Field("idM") int idm,
            @Field("idP") int idp,
            @Field("total") double total
    );
}
