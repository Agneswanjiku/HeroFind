package com.moringaschool.herofind;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.moringaschool.herofind.adapters.HeroPagerAdapter;
import com.moringaschool.herofind.model.Result;

import org.parceler.Parcels;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HeroDetailActivity extends AppCompatActivity {

    @BindView(R.id.viewPager)
    ViewPager mPager;

    private HeroPagerAdapter mAdapter;

    ArrayList<Result> heroes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hero_detail);

        ButterKnife.bind(this);

        heroes = Parcels.unwrap(getIntent().getParcelableExtra("heroes"));
        int startingPosition = getIntent().getIntExtra("position", 0);
        mAdapter = new HeroPagerAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT, heroes);
        mPager.setAdapter(mAdapter);
        mPager.setCurrentItem(startingPosition);


    }
}