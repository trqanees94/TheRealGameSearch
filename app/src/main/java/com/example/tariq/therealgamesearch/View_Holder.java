package com.example.tariq.therealgamesearch;

import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ifti on 3/31/2016.
 */
public class View_Holder extends RecyclerView.ViewHolder  {


    TextView title;
    ImageView imageView;
    CardView cardView;
    List<Game> list = new ArrayList<Game>();
    Context ctx;
    public ClipData.Item item;
    public final static String EXTRA_MESSAGE = "com.example.tariq.therealgamesearch.MESSAGE";

    public Game game;

   public View_Holder(View itemView) {
        super(itemView);

        //itemView.setOnClickListener(this);
        title = (TextView) itemView.findViewById(R.id.title);
        imageView = (ImageView) itemView.findViewById(R.id.imageView);
        cardView = (CardView) itemView.findViewById(R.id.cv);

      /*  itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             //   Intent intent = new Intent(v.getContext(), GameActivity.class);
              //  v.getContext().startActivity(intent);
                Toast.makeText(v.getContext(), "os version is: " + game.getTitle(), Toast.LENGTH_SHORT).show();

            }
        });*/
    }

//    @Override
//    public void onClick(View view){
//            int position = getAdapterPosition();
//            Game intentGameObj= list.get(position);
//        Intent intent = new Intent(ctx, GameActivity.class);
//        Bundle bundle = new Bundle();
//        bundle.putParcelable(EXTRA_MESSAGE, intentGameObj);
//        intent.putExtras(bundle);
//        this.ctx.startActivity(intent);
//    }
}