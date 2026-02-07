package com.svalero.komorebiandroid.model;

import com.svalero.komorebiandroid.api.SchoolApi;
import com.svalero.komorebiandroid.api.SchoolApiInterface;
import com.svalero.komorebiandroid.contract.SchoolListContract;
import com.svalero.komorebiandroid.domain.School;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SchoolListModel implements SchoolListContract.Model {
    @Override
    public void loadSchools(SchoolListContract.Model.OnLoadListener listener) {
        SchoolApiInterface schoolApi = SchoolApi.buildInstance();
        Call<List<School>> getSchoolsCall = schoolApi.getSchools();
        getSchoolsCall.enqueue(new Callback<>() {
            @Override
            public void onResponse(Call<List<School>> call, Response<List<School>> response) {
                if (response.code() == 200) {
                    List<School>schools = (response.body());
                    listener.onLoadSuccess(schools);
                } else if (response.code() == 500) {
                    listener.onLoadError("Internal Server Error");
                }
            }

            @Override
            public void onFailure(Call<List<School>> call, Throwable t) {
                listener.onLoadError("Couldn't connect with server");
            }
        });
    }
}
