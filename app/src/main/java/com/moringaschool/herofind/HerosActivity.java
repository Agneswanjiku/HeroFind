package com.moringaschool.herofind;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HerosActivity extends AppCompatActivity {

    @BindView(R.id.locationTextView) TextView mLocationTextView;
    @BindView(R.id.listView) ListView mListView;


    private String[] cultureherosmythology = new String[]{"Abenak", "Ainu",
            "Ausralian Abronigical", "Armenian", "Ashanti", "Aztec",
            "Banks Islads", "Buddhist", "Carolline Islads", "Lakota",
            "Maya", "Indian", "Norse",
            "Navanjo", "Ojibwe"};
    private String[] heros = new String[]{"  Ant Man", "Aqualman", "Asterix",
            "The Atom", "The Avengers", "Batgirl", "Batman", "Batwoman", "Black Panary",
            "Black Panther", "Captain America", "Captain Marvel", "Hellboy", "Doc savage", "Green arrow", "Wonder Woman"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_heros);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        String location = intent.getStringExtra("location");
        MyHerosArrayAdapter adapter = new MyHerosArrayAdapter(this, android.R.layout.simple_list_item_1, parks, animals);
        mListView.setAdapter(adapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l){
                String parks = ((TextView)view).getText().toString();
                Toast.makeText(HerosActivity.this, parks, Toast.LENGTH_LONG).show();
            }
        });
        mLocationTextView.setText("Here are all the parks near: " + location);
    }


}