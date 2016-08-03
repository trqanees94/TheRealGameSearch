package com.example.tariq.therealgamesearch;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

public class GameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent intent = getIntent();
        Bundle bundle= this.getIntent().getExtras();
        Game newModel;
        newModel=bundle.getParcelable(Recycler_View_Adapter.EXTRA_MESSAGE);

        String message= newModel.getTitle();
        int positionNum= newModel.getPosition();
        int playerNum = newModel.getPlayers();
        int iconID= newModel.getIconID();
        String gameSummary=newModel.getGameSummary();

        String message1 = Integer.toString(playerNum);

        TextView textView1 = (TextView) findViewById(R.id.textView1);
        TextView textView2 = (TextView) findViewById(R.id.textView2);
        ImageView imageView=(ImageView)findViewById(R.id.icon);
        TextView textView3 = (TextView) findViewById(R.id.textView3);
        Button readMoreButton= (Button) findViewById(R.id.readMoreButton);
        final LinearLayout linearLayout = (LinearLayout) findViewById(R.id.instructionLayout);
        final View topLine = (View) findViewById(R.id.topLine);
        ListView l = (ListView) findViewById(R.id.listView);

        textView1.setText(message); //displays name of game
        textView2.setText("Number of players:" + message1); // displays number of players
        imageView.setImageResource(iconID);
        textView3.setText(gameSummary);

        String[] days={"Instruction1", "Instruction2", "Instruction3", "Instruction4", "Instruction5", "Instruction6","Instruction7"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, days);
        l.setAdapter(adapter);

        readMoreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                linearLayout.setVisibility(View.VISIBLE);
                topLine.setVisibility(View.INVISIBLE);

            }
        });
    }

}
