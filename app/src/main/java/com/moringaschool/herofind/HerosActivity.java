package com.moringaschool.herofind;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import butterknife.BindView;

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
    }
}