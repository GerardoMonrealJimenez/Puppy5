package mx.com.rteck.puppy.restApi.deserializador;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

import mx.com.rteck.puppy.pojo.Perfil;
import mx.com.rteck.puppy.restApi.JsonKeys;
import mx.com.rteck.puppy.restApi.model.MiperroResponse;

/**
 * Created by Gerardo Monreal J on 15/09/2016.
 */

public class MiperroDeserializador implements JsonDeserializer<MiperroResponse> {
    @Override
    public MiperroResponse deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        Gson gson = new Gson();
         MiperroResponse miperroResponse = gson.fromJson(json,MiperroResponse.class);
        JsonArray miPerroResponseData = json.getAsJsonObject().getAsJsonArray(JsonKeys.MEDIA_RESPONSE_ARRAY);
        miperroResponse.setMiPerfil(deserializadorPerfilJson(miPerroResponseData));
        return miperroResponse;
    }

    private Perfil deserializadorPerfilJson(JsonArray perfilResponseData)
    {
        Perfil miPerfil = new Perfil();
        JsonObject PerfilResponseDataObject= perfilResponseData.get(0).getAsJsonObject();
        String nombre = PerfilResponseDataObject.get(JsonKeys.USER_NAME).getAsString();
        String urlFotoPerfil = PerfilResponseDataObject.get(JsonKeys.USER_PORFILE_PICTURE).getAsString();
        long id = PerfilResponseDataObject.get(JsonKeys.USER_ID).getAsLong();

        miPerfil.setId(id);
        miPerfil.setNombre(nombre);
        miPerfil.setUrlFotoPerfil(urlFotoPerfil);

        return miPerfil;

    }


}
