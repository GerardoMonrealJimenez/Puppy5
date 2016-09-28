package mx.com.rteck.puppy.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import mx.com.rteck.puppy.R;
import mx.com.rteck.puppy.pojo.FotosMiPerro;
import mx.com.rteck.puppy.pojo.MiPerro;

/**
 * Created by Gerardo Monreal J on 23/08/2016.
 */

public class MiPerroAdaptador  extends RecyclerView.Adapter<MiPerroAdaptador.MiPerroViewHolder>{
    public MiPerroAdaptador(ArrayList<FotosMiPerro> fotos, Activity activity) {
        this.fotos = fotos;
        this.activity = activity;
    }

    ArrayList<FotosMiPerro>fotos;
    Activity activity;

    @Override
    public MiPerroViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_miperro,parent,false);
        return new MiPerroViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MiPerroViewHolder holder, int position) {
        final FotosMiPerro foto=fotos.get(position);
        /*holder.img.setImageResource(miperro.getFoto());
        holder.likes.setText(miperro.Likes());*/

        Picasso.with(activity)
                .load(foto.getUrl())
                .placeholder(R.drawable.bonec)
                .into(holder.img);

        holder.likes.setText(String.valueOf(foto.getLikes()));

    }

    @Override
    public int getItemCount() {
        return fotos.size();
    }

    public static class MiPerroViewHolder extends RecyclerView.ViewHolder{

        private ImageView img;
        private TextView likes;

        public MiPerroViewHolder(View itemView) {
            super(itemView);
            img     =   (ImageView) itemView.findViewById(R.id.imgMiPerro);
            likes   =   (TextView)  itemView.findViewById(R.id.tvLikesMP);
        }
    }
}
