package com.example.tariq.therealgamesearch;

import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.Collections;
import java.util.List;

/**
 * Created by ifti on 3/31/2016.
 */
public class Recycler_View_Adapter extends RecyclerView.Adapter<View_Holder> {

   public List<Game> list = Collections.emptyList();
    Context context;
    public final static String EXTRA_MESSAGE = "com.example.tariq.therealgamesearch.MESSAGE";


    public Recycler_View_Adapter(List<Game> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public View_Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        //Inflate the layout, initialize the View Holder
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_layout, parent, false);
        View_Holder holder = new View_Holder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(final View_Holder holder, final int position) {

        //Use the provided View Holder on the onCreateViewHolder method to populate the current row on the RecyclerView
        final Game game=list.get(position);
        holder.title.setText(list.get(position).title);
        holder.imageView.setImageResource(list.get(position).iconID);
        holder.game=game;

        holder.cardView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                //notice I implemented onClickListener here
                // so I can associate this click with final Item item
                //Game game =  this.list.get(position);
                Bundle bundle = new Bundle();
                Context c = view.getContext();
                Intent intent = new Intent(c, GameActivity.class);

                bundle.putParcelable(EXTRA_MESSAGE, game);
                intent.putExtras(bundle);

                String text = game.getTitle();
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
                 c.startActivity(intent);
            }
        });
        //animate(holder);

    }

    @Override
    public int getItemCount() {
        //returns the number of elements the RecyclerView will display
        return list.size();
    }


    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    // Insert a new item to the RecyclerView on a predefined position
    public void insert(int position, Game game) {
        list.add(position, game);
        notifyItemInserted(position);
    }

    // Remove a RecyclerView item containing a specified Game object
    public void remove(Game game) {
        int position = list.indexOf(game);
        list.remove(position);
        notifyItemRemoved(position);
    }



}
