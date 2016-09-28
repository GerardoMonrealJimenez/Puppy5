package mx.com.rteck.puppy.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import mx.com.rteck.puppy.R;
import mx.com.rteck.puppy.pojo.ConstructorPerro;
import mx.com.rteck.puppy.pojo.Perro;

/**
 * Created by Gerardo Monreal J on 22/08/2016.
 */

public class PerroAdaptador extends RecyclerView.Adapter<PerroAdaptador.PerroViewHolder> {

    public PerroAdaptador(ArrayList<Perro>perros, Activity activity)
    {
        this.perros=perros;
        this.activity=activity;
    }
    ArrayList<Perro>perros;
    Activity activity;
    @Override
    public PerroViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        // da vida al layout de la card y a su vez genera le View Holder
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_perro,parent,false);
        return new PerroViewHolder(v);
    }

    @Override
    public void onBindViewHolder(PerroViewHolder holder, int position)
    {
        // asocia los elementos de la lista con cada view
        final Perro perro = perros.get(position);
        holder.img.setImageResource(perro.getFoto());
        holder.nombre.setText(perro.getNombre());
        holder.likes.setText(perro.likes());

        holder.like.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                perro.setLikes((perro.getLikes()+1));
                ConstructorPerro constructorPerro = new ConstructorPerro(activity);
                constructorPerro.checarPerro(perro);

            }


        });

    }

    @Override
    public int getItemCount()
    {
        return perros.size();
    }

    public static class PerroViewHolder extends RecyclerView.ViewHolder{

        // aqui se maejaran los views del layout
        private ImageView img;
        private TextView nombre;
        private TextView likes;
        private ImageButton like;

        public PerroViewHolder(View itemView)
        {
            super(itemView);
            img     =   (ImageView)     itemView.findViewById(R.id.imgPerro);
            nombre  =   (TextView)      itemView.findViewById(R.id.tvNomPerro);
            likes   =   (TextView)      itemView.findViewById(R.id.tvLikes);
            like    =   (ImageButton)   itemView.findViewById(R.id.btnBoneW);
        }
    }
}
