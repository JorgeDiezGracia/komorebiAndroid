package com.svalero.komorebiandroid.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.time.LocalDate;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SchoolApi {
    public static SchoolApiInterface buildInstance() {
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(LocalDate.class, new LocalDateAdapter())
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://172.17.21.92:8081/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        return retrofit.create(SchoolApiInterface.class);
    }
}
