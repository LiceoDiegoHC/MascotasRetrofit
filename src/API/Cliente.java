package API;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Cliente {
    private static final String BASE_URL = "http://127.0.0.1/Maestria/";
    private static Cliente cliente;
    private static Retrofit retrofit = null;
    
    private Cliente(){
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
    
    public static synchronized Cliente getInstance(){
        if(cliente == null){
            cliente = new Cliente();
        }
        return cliente;
    }
    
    public RegistroAPI getMyApi(){
        return retrofit.create(RegistroAPI.class);
    }
    
    public static Retrofit getRetrofitInstance(){
        if(retrofit == null){
            Gson gson = new GsonBuilder()
                    .setLenient()
                    .create();
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();
        }
        return retrofit;
    }
}
