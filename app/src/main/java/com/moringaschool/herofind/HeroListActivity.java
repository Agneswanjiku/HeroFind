package com.moringaschool.herofind;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.moringaschool.herofind.adapters.HeroListAdapter;
import com.moringaschool.herofind.model.Hero;
import com.moringaschool.herofind.model.Result;
import com.moringaschool.herofind.network.HeroApi;
import com.moringaschool.herofind.network.HeroClient;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HeroListActivity extends AppCompatActivity {

    private static final  String TAG = " ";

    @BindView(R.id.errorTextView) TextView mError;
    @BindView(R.id.progressBar) ProgressBar mProgressBar;

    @BindView(R.id.recyclerView) RecyclerView mRecyclerView;
    private HeroListAdapter mAdapter;

    List<Hero> heroes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hero_list);
        ButterKnife.bind(this);




        HeroApi client = HeroClient.getClient();
        Call<Hero> call = client.getHero();

        call.enqueue(new Callback<Hero>() {
            @Override
            public void onResponse(Call<Hero> call, Response<Hero> response) {
                hideProgressBar();
                Log.d(TAG, "onResponse: Successful");
                if(response.isSuccessful()){
                    List<Result> heroes = response.body().getResults();

                    heroes = response.body().getResults();
                    mAdapter = new HeroListAdapter(HeroListActivity.this, heroes);
                    mRecyclerView.setAdapter(mAdapter);
                    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(HeroListActivity.this);
                    mRecyclerView.setLayoutManager(layoutManager);
                    mRecyclerView.setHasFixedSize(true);

                    showHero();


                }else{
                    showUnsuccessfulMessage();
                }
            }

            @Override
            public void onFailure(Call<Hero> call, Throwable t) {
                Log.d(TAG, "onFailure: failed");
                hideProgressBar();
                showFailureMessage();
            }
        });
    }

    private void showFailureMessage() {
        mError.setText("Something went wrong. Please check your Internet connection and try again!");
        mError.setVisibility(View.VISIBLE);
    }
    private void showUnsuccessfulMessage() {
        mError.setText("Something went wrong. Please try again later");
        mError.setVisibility(View.VISIBLE);
    }
    private void showHero() {
        mRecyclerView.setVisibility(View.VISIBLE);
    }
    private void hideProgressBar() {
        mProgressBar.setVisibility(View.GONE);
    }

}