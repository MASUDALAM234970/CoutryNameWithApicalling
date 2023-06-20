package com.error41.coutryname.service;

import com.error41.coutryname.model.Result;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetCountryDataService {

    //   Retrofit Interface

    @GET("countries")
    Call<Result> getResult();


}
