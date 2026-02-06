package com.svalero.komorebiandroid.presenter;

import com.svalero.komorebiandroid.contract.SchoolListContract;
import com.svalero.komorebiandroid.domain.School;
import com.svalero.komorebiandroid.model.SchoolListModel;

import java.util.List;

public class SchoolListPresenter implements SchoolListContract.Presenter, SchoolListContract.Model.OnLoadListener {

    private SchoolListContract.Model model;
    private SchoolListContract.View view;

    public SchoolListPresenter(SchoolListContract.View view) {
        this.model = new SchoolListModel();
        this.view = view;

    }

    @Override
    public void loadSchools() {
        model.loadSchools(this);
    }

    @Override
    public void onLoadSuccess(List<School> schools) {
        view.showSchools(schools);
        view.showMessage("Schools loaded successfully");
    }

    @Override
    public void onLoadError(String message) {
        view.showError(message);
    }
}
