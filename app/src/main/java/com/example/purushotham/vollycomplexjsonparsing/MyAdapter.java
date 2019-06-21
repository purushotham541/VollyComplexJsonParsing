package com.example.purushotham.vollycomplexjsonparsing;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>
{
    private List<Moviemodel> moviemodels;
    Context context;




    public MyAdapter(List<Moviemodel> moviemodels, Context context)
    {
        this.moviemodels = moviemodels;
        this.context = context;
    }

    @NonNull
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i)
    {
        LayoutInflater layoutInflater=LayoutInflater.from(viewGroup.getContext());
        View view=layoutInflater.inflate(R.layout.mydesign,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.ViewHolder viewHolder, int i)
    {
        Moviemodel moviemodel=moviemodels.get(i);
        viewHolder.name.setText(moviemodel.getMovie());
        viewHolder.duration.setText(moviemodel.getDuration());
        viewHolder.director.setText(moviemodel.getDirector());
        viewHolder.tagline.setText(moviemodel.getTagline());
        Glide.with(context)
             .load(moviemodel.getImage())
             .into(viewHolder.img);




    }

    @Override
    public int getItemCount()
    {
        return moviemodels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView name,director,tagline,duration;
        ImageView img;
        public ViewHolder(@NonNull View itemView)
        {
            super(itemView);
            name=itemView.findViewById(R.id.m_name);
            director=itemView.findViewById(R.id.m_dirctr);
            tagline=itemView.findViewById(R.id.m_tagline);
            duration=itemView.findViewById(R.id.m_duration);
            img=itemView.findViewById(R.id.iv);



        }
    }
}
