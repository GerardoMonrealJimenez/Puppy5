package mx.com.rteck.puppy.restApi;

import android.content.Context;

import mx.com.rteck.puppy.restApi.model.FotosRespones;
import mx.com.rteck.puppy.restApi.model.MiperroResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Gerardo Monreal J on 15/09/2016.
 */

public interface EndPoints {
    @GET(ConstantesRestApi.KEY_GET_SEARCH_USER)
    Call<MiperroResponse> getPerfil(@Query("q") String user,@Query("access_token") String access_token);

    @GET(ConstantesRestApi.URL_MEDIA_USER)
    Call<FotosRespones> getFotos(@Path("id") long id);

}
