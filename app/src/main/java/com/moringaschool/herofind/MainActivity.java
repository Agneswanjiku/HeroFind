package com.moringaschool.herofind;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import com.google.firebase.auth.FirebaseAuth;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements  View.OnClickListener{

    @BindView(R.id.herosButton) Button mFindHerosButton;
    @BindView(R.id.savedHerosButton) Button mSavedHero;
    //    @BindView(R.id.appNameTextView) TextView appName;
    @BindView(R.id.button1) Button mButton;
    @BindView(R.id.blink) ImageView mImage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        mFindHerosButton.setOnClickListener(this);
        mSavedHero.setOnClickListener(this);
        mButton.setOnClickListener(this);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_logout) {
            logout();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void logout() {
        FirebaseAuth.getInstance().signOut();
        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
    }

    @Override
    public void onClick(View view) {
        if(view == mFindHerosButton ){
            Intent intent = new Intent(MainActivity.this, HeroListActivity.class);
            startActivity(intent);
        }
        if(view == mSavedHero){
            Intent intent = new Intent(MainActivity.this, SavedHeroActivity.class);
            startActivity(intent);
        }

        if(view == mButton){
            // call a static function loadAnimation()
// of the class AnimationUtils
            Animation object
                    = AnimationUtils
                    .loadAnimation(
                            getApplicationContext(),
                            // slide file is in anim folder
                            R.anim.blinks);
// call the startAnimation method
            mImage.startAnimation(object);
        }


    }
}