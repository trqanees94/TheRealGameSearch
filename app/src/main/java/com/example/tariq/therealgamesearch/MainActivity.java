package com.example.tariq.therealgamesearch;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SearchView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

//

    public final static String EXTRA_MESSAGE = "com.example.tariq.therealgamesearch.MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        List<Game> data, data1;
        data = fill_with_data();
        data1 = fill_with_data1();

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        Recycler_View_Adapter adapter = new Recycler_View_Adapter(data, getApplication());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        RecyclerView recyclerView1 = (RecyclerView) findViewById(R.id.recyclerview1);
        Recycler_View_Adapter adapter1 = new Recycler_View_Adapter(data1, getApplication());
        recyclerView1.setAdapter(adapter1);
        recyclerView1.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        Intent intent = getIntent();
        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            String query = intent.getStringExtra(SearchManager.QUERY);
            doMySearch(query);
        }

    }

    public void doMySearch(String query){

    }

    public List<Game> fill_with_data() {

        List<Game> game = new ArrayList<>();
        Game gameModel;

        String [] gameOBJName1={"poker", "texas holdem", "speed", "charades", "namegame", "marbles", "twotruths", "21?"};
        int[] gamePosition={1,2,3,4,5,6,7,8};
        int[] numPlayerArr={3,3,2,2,2,2,2,2};
        String [] material={"52 Card Deck", "52 Card Deck", "52 Card Deck", "No Material Required", "No Material Required", "Marbles", "No Material Required","No Material Required"  };
        int[] icons = {R.drawable.poker_image, R.drawable.texas_holdem_image, R.drawable.speed_image, R.drawable.charades_image, R.drawable.name_game_image,R.drawable.marbles_image, R.drawable.two_truths_and_a_lie_image,R.drawable.two_1_questions_image};
        int numObjects = gameOBJName1.length;
        String[] summary = new String[numObjects];
        summary[1] ="Texas Holdem Poker is a community card game generally played from anywhere between 2 to 10 people. To win in Texas Holdem Poker, you will have to make the best 5 card combination possible";

        for(int i=0; i < gameOBJName1.length; i++) {
            gameModel = new Game(gamePosition[i], gameOBJName1[i], numPlayerArr[i], material[i],icons[i], summary[i]);
            game.add(gameModel);
        }

        return game;
    }

    public List<Game> fill_with_data1() {

        List<Game> game = new ArrayList<>();
        Game gameModel;

        String [] gameOBJName1={"mafia", "chop sticks", "cops and robbers", "hide and seek", "freeze", "hopscotch", "treasure hunt", "bubbles"};
        int[] gamePosition={1,2,3,4,5,6,7,8};
        int[] numPlayerArr={4,2,2,2,3,2,3,6};
        String [] material={"No Material Required", "No Material Required", "No Material Required", "No Material Required", "No Material Required", "Chalk", "No Material Required","No Material Required"  };
        int[] icons = {R.drawable.mafia_image, R.drawable.chopsticks_image, R.drawable.copsandrobbers_image, R.drawable.hideandseek_image, R.drawable.freeze_image,R.drawable.hopscotch_image, R.drawable.treasurehunt_image,R.drawable.bubbles_image};
        int numObjects = gameOBJName1.length;
        String[] summary = new String[numObjects];
        summary[1] ="Switch between players tapping hands with fingers";

        for(int i=0; i < gameOBJName1.length; i++) {
            gameModel = new Game(gamePosition[i], gameOBJName1[i], numPlayerArr[i], material[i],icons[i], summary[i]);
            game.add(gameModel);
        }

        return game;
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);

        SearchManager searchManager =
                (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView =
                (SearchView) menu.findItem(R.id.search).getActionView();
        searchView.setSearchableInfo(
                searchManager.getSearchableInfo(getComponentName()));


        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                loadHistory(query);

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                return false;
            }


        });

        return true;
    }

    private void loadHistory(String query){
        final List<Game> list, list1;
        list=fill_with_data();
        list1=fill_with_data1();

        for (int i = 0; i < list.size(); i++) {
            if( query.equalsIgnoreCase(list.get(i).getTitle()) ){

                Game game = list.get(i);
                Bundle bundle = new Bundle();
               // Context c= this.getApplicationContext();
                Intent intent = new Intent(this, GameActivity.class);
                bundle.putParcelable(EXTRA_MESSAGE, game);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        }

        for (int i = 0; i < list1.size(); i++) {
            if(query.equalsIgnoreCase( list1.get(i).getTitle()) ){

            }
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
