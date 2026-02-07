package com.svalero.komorebiandroid.model;

import com.svalero.komorebiandroid.api.SchoolApi;
import com.svalero.komorebiandroid.api.SchoolApiInterface;
import com.svalero.komorebiandroid.contract.RegisterSchoolContract;
import com.svalero.komorebiandroid.domain.School;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterSchoolModel implements RegisterSchoolContract.Model {

    @Override
    public void registerSchool(School school, onRegisterListener listener) {
        SchoolApiInterface api = SchoolApi.buildInstance();
        Call<School> postSchoolsCall = api.registerSchool(school);
        postSchoolsCall.enqueue(new Callback<School>() {
            @Override
            public void onResponse(Call<School> call, Response<School> response) {
                if (response.code() == 201) {
                    listener.onRegisterSuccess(response.body());
                } else if (response.code() == 400) {
                    //TODO Parsear el cuerpo de la respuesta para indicar los errores concretos
                    listener.onRegisterError("Validation Errors");
                }
            }

            @Override
            public void onFailure(Call<School> call, Throwable t) {
                listener.onRegisterError("Unable to connect the server");
            }
        });
    }
}
