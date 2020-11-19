package com.moringaschool.herofind.network;

import com.moringaschool.herofind.model.Hero;

import retrofit2.Call;
import retrofit2.http.GET;

public interface HeroApi {
    @GET("search/flash")
    Call<Hero> getHero(
    );

}
