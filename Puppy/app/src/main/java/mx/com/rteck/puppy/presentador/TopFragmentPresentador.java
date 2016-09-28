package mx.com.rteck.puppy.presentador;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;

import mx.com.rteck.puppy.fragments.ITopFragment;
import mx.com.rteck.puppy.pojo.MiPerro;
import mx.com.rteck.puppy.restApi.ConstantesRestApi;
import mx.com.rteck.puppy.restApi.EndPoints;
import mx.com.rteck.puppy.restApi.adapter.RestApiAdapter;
import mx.com.rteck.puppy.restApi.model.FotosRespones;
import mx.com.rteck.puppy.restApi.model.MiperroResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Gerardo Monreal J on 15/09/2016.
 */

public class TopFragmentPresentador implements ITopFragmentPresentador {

    private ITopFragment iTopFragment;
    private Context context;
    private MiPerro miPerro;

    public TopFragmentPresentador(ITopFragment iTopFragment,Context context)
    {
        this.iTopFragment = iTopFragment;
        this.context=context;
        miPerro = new MiPerro();
        obtenerMiPerro();

    }


    @Override
    public void obtenerMiPerro() {
    // llenar mi perfil
        SharedPreferences miPreferencia= context.getSharedPreferences("Cuenta",context.MODE_PRIVATE);
        String cuenta= miPreferencia.getString("cuenta","0");
        if(cuenta !="0")
        {
            RestApiAdapter restApiAdapter = new RestApiAdapter();
            Gson perfil = restApiAdapter.construyeGsonDeserializadorPerfil();
            EndPoints endPoints = restApiAdapter.establecerConexionRestApiInstagram(perfil);
            Call<MiperroResponse> MiperroResponseCall=endPoints.getPerfil(cuenta, ConstantesRestApi.ACCES_TOKEN);

            MiperroResponseCall.enqueue(new Callback<MiperroResponse>() {
                @Override
                public void onResponse(Call<MiperroResponse> call, Response<MiperroResponse> response) {
                        MiperroResponse miperroResponse=response.body();
                        miPerro.setMiPerfil(miperroResponse.getMiPerfil());// problema
                        obtenerFotos(miPerro.getMiPerfil().getId());
                }

                @Override
                public void onFailure(Call<MiperroResponse> call, Throwable t) {
                    Toast.makeText(context,"Algo paso en la conexion",Toast.LENGTH_LONG);
                    Log.e("Fallo la conexion",t.toString());
                }
            });
        }
        else
        {
            Toast.makeText(context,"No hay cuenta dada de alta en la aplicación",Toast.LENGTH_SHORT);
        }


    }

    @Override
    public void mostrarFotosRV() {

        iTopFragment.inicializarAdaptarodRV(iTopFragment.crearAdaptador(miPerro.getFotos()));
        iTopFragment.generarGridLayout();
    }

    @Override
    public void mostrarPerfil() {

        iTopFragment.inicializarPerfil(miPerro.getMiPerfil().getNombre(),miPerro.getMiPerfil().getUrlFotoPerfil());

    }

    @Override
    public void obtenerFotos(long id) {

        RestApiAdapter restApiAdapter = new RestApiAdapter();
        Gson fotos = restApiAdapter.construyeGsonDeserializadorFotos();
        EndPoints endPoints = restApiAdapter.establecerConexionRestApiInstagram(fotos);
        final Call<FotosRespones> fotosResponesCall = endPoints.getFotos(id);

        fotosResponesCall.enqueue(new Callback<FotosRespones>() {
            @Override
            public void onResponse(Call<FotosRespones> call, Response<FotosRespones> response) {
                FotosRespones fotosRespones = response.body();
                miPerro.setFotos(fotosRespones.getFotos());
                mostrarPerfil();
                mostrarFotosRV();
            }

            @Override
            public void onFailure(Call<FotosRespones> call, Throwable t) {

                Toast.makeText(context,"Algo paso en la conexion",Toast.LENGTH_LONG);
                Log.e("Fallo la conexion",t.toString());
            }
        });
    }


}
