package com.moringaschool.herofind;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements  View.OnClickListener{
    @BindView(R.id.findHerosButton) Button mFindHerosButton;
    @BindView(R.id.locationEditText) EditText mLocationEditText;
    @BindView(R.id.appNameTextView) TextView mAppNameTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);




        mFindHerosButton.setOnClickListener(this);
    }
    @Override
    public void onClick(View v){
        if(v == mFindHerosButton) {
            Intent intent = new Intent(MainActivity.this, HeroListActivity.class);
            String location = mLocationEditText.getText().toString();
//            if(!(location).equals("")) {
//                addToSharedPreferences(location);
//            }
            intent.putExtra("location", location);
            startActivity(intent);
        }
    }

}
