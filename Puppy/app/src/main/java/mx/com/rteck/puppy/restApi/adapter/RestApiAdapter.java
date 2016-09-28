package mx.com.rteck.puppy.restApi.adapter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import mx.com.rteck.puppy.restApi.ConstantesRestApi;
import mx.com.rteck.puppy.restApi.EndPoints;
import mx.com.rteck.puppy.restApi.deserializador.FotosDeserializador;
import mx.com.rteck.puppy.restApi.deserializador.MiperroDeserializador;
import mx.com.rteck.puppy.restApi.model.FotosRespones;
import mx.com.rteck.puppy.restApi.model.MiperroResponse;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Gerardo Monreal J on 15/09/2016.
 */

public class RestApiAdapter {

    public EndPoints establecerConexionRestApiInstagram(Gson gson)
    {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ConstantesRestApi.URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        return retrofit.create(EndPoints.class);
    }

    public Gson construyeGsonDeserializadorFotos()
    {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(FotosRespones.class,new FotosDeserializador());
        return gsonBuilder.create();
    }

    public Gson construyeGsonDeserializadorPerfil()
    {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(MiperroResponse.class,new MiperroDeserializador());

        return gsonBuilder.create();
    }

}
