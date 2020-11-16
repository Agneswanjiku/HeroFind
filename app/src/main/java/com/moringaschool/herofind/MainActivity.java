package com.moringaschool.herofind;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

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
    public void onClick(View v) {
        if (v == mFindHerosButton) {
            String location = mLocationEditText.getText().toString();
            Intent intent = new Intent(MainActivity.this, HerosActivity.class);
            intent.putExtra("location", location);
            startActivity(intent);
        }
    }
}