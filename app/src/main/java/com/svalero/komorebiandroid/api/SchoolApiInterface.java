package com.svalero.komorebiandroid.api;

import com.svalero.komorebiandroid.domain.School;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface SchoolApiInterface {

    @GET("schools")
    Call<List<School>> getSchools();

    @POST("schools")
    Call<School> registerSchool(@Body School school);

    @GET("schools/{id}")
    Call<School> getSchool(@Path("id") long id);
}

