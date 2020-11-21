package com.moringaschool.herofind.adapters;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.moringaschool.herofind.HeroDetailFragment;
import com.moringaschool.herofind.model.Result;

import java.util.ArrayList;

public class HeroPagerAdapter  extends FragmentPagerAdapter {
    private static final String TAG = " ";
    private ArrayList<Result> heroResults;

    public HeroPagerAdapter(FragmentManager fm, int behavior, ArrayList<Result> heroes){
        super(fm, behavior);
        heroResults = heroes;
    }


    @NonNull
    @Override
    public Fragment getItem(int position) {
        return HeroDetailFragment.newInstance(heroResults.get(position));
    }

    @Override
    public int getCount() {
        Log.d(TAG, "getCount: "+ heroResults);
        return heroResults.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return heroResults.get(position).getName();
    }
}


