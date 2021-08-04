package com.example.sharingyuk.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;

import com.example.sharingyuk.R;
import com.example.sharingyuk.adapter.CardAdapter;
import com.example.sharingyuk.model.DataMentor;
import com.example.sharingyuk.model.Mentor;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    CardView cardView;
    Adapter adapter;

    private ArrayList<Mentor> mentors = new ArrayList<>();
  private String tittle = "Daftar Mentor";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setActionBar(tittle);

        recyclerView = findViewById(R.id.recyclee);
        recyclerView.setHasFixedSize(true);


//        cardView = (CardView) findViewById(R.id.cardview);
//        cardView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this,DetailActivity.class);
//                startActivity(intent);
//            }
//        });

        mentors.addAll(DataMentor.getlist());
        showCard();

    }

    private void showCard() {

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        CardAdapter cardAdapter = new CardAdapter(mentors, MainActivity.this);
        recyclerView.setAdapter(cardAdapter);
    }



    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        setmode(item.getItemId());
        return super.onOptionsItemSelected(item);
    }


    private void setmode(int itemId) {
        switch (itemId){
            case R.id.about:
            showAbout();
            break;
        }
        setActionBar(tittle);
    }

    private void setActionBar(String tittle) {
        if (getSupportActionBar()!=null){
            getSupportActionBar().setTitle(tittle);
        }
    }

    private void showAbout() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        Intent intent = new Intent(MainActivity.this, AboutActivity.class);
        startActivity(intent);
    }
}