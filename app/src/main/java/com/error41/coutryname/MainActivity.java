package com.error41.coutryname;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.error41.coutryname.adapter.CountryAdapter;
import com.error41.coutryname.model.Result;
import com.error41.coutryname.model.Result__1;
import com.error41.coutryname.service.GetCountryDataService;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    ArrayList<Result__1> countries;
    private RecyclerView recyclerView;
    private CountryAdapter countryAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        getCountries();
    }

    public void getCountries() {

        GetCountryDataService getCountryDataService = RetrofitInstance.getService();
        Call<Result> call = getCountryDataService.getResult();

        call.enqueue(new Callback<Result>() {
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {
                Result result = response.body();

                if (result != null && result.getResult() != null) {
                    countries = (ArrayList<Result__1>) result.getResult();
                    countryAdapter = new CountryAdapter(countries);
                    recyclerView.setAdapter(countryAdapter);
                }
            }

            @Override
            public void onFailure(Call<Result> call, Throwable t) {
                // Handle failure here
            }
        });

    }
}
