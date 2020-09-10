package com.prevezene.refrofit.service;

import com.prevezene.refrofit.model.CryptoModel;

import java.util.List;
import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;

public interface CryptoAPI {

    @GET("prices?key=2187154b76945f2373394aa34f7dc98a")
    Call<List<CryptoModel>> getData();


}
