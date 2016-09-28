package mx.com.rteck.puppy.restApi.deserializador;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.util.ArrayList;

import mx.com.rteck.puppy.pojo.FotosMiPerro;
import mx.com.rteck.puppy.restApi.JsonKeys;
import mx.com.rteck.puppy.restApi.model.FotosRespones;

/**
 * Created by Gerardo Monreal J on 15/09/2016.
 */

public class FotosDeserializador implements JsonDeserializer<FotosRespones> {
    @Override
    public FotosRespones deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        Gson gson = new Gson();
        FotosRespones fotosRespones = gson.fromJson(json,FotosRespones.class);
        JsonArray fotosResponseData = json.getAsJsonObject().getAsJsonArray(JsonKeys.MEDIA_RESPONSE_ARRAY);
        fotosRespones.setFotos(deserializadorFotosJson(fotosResponseData));

        return fotosRespones;
    }

    private ArrayList<FotosMiPerro> deserializadorFotosJson(JsonArray fotosResponseData)
    {
        ArrayList<FotosMiPerro> fotos = new ArrayList<>();

        for (int i=0;i<fotosResponseData.size();i++)
        {
            JsonObject fotosResponseDataObject= fotosResponseData.get(i).getAsJsonObject();// objeto data

            JsonObject imagen= fotosResponseDataObject.get(JsonKeys.MEDIA_IMAGES).getAsJsonObject(); // objeto de la imagen
            JsonObject standar = imagen.get(JsonKeys.MEDIA_STANDAR_RESOLUTIN).getAsJsonObject();
            String url = standar.get(JsonKeys.MEDIA_URL).getAsString();


            JsonObject likesJson = fotosResponseDataObject.get(JsonKeys.LIKES).getAsJsonObject();// objeto likes
            int likes = likesJson.get(JsonKeys.MEDIA_LIKES).getAsInt();

            FotosMiPerro foto = new FotosMiPerro();
            foto.setLikes(likes);
            foto.setUrl(url);

            fotos.add(foto);
        }

        return fotos;

    }
}
