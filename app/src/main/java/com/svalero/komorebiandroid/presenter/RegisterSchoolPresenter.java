package com.svalero.komorebiandroid.presenter;

import com.svalero.komorebiandroid.contract.RegisterSchoolContract;
import com.svalero.komorebiandroid.domain.School;
import com.svalero.komorebiandroid.model.RegisterSchoolModel;

import java.time.LocalDate;

public class RegisterSchoolPresenter implements RegisterSchoolContract.Presenter,
            RegisterSchoolContract.Model.onRegisterListener{

    private RegisterSchoolContract.Model model;
    private RegisterSchoolContract.View view;

    public RegisterSchoolPresenter(RegisterSchoolContract.View view) {
        model = new RegisterSchoolModel();
        this.view = view;
    }

    @Override
    public void registerSchool(String name, String city, int students, boolean publicSchool, String registerDate) {
        // TODO Validar correctamente
        if (name.isEmpty()) {
            view.showValidationError("Name is mandatory");
        }

        School school = School.builder()
                .name(name)
                .city(city)
                .students(students)
                .publicSchool(publicSchool)
                .registerDate(registerDate)
                .build();


        model.registerSchool(school, this);
    }

    @Override
    public void onRegisterSuccess(School school) {
        view.showMessage("School registered successfully");
    }

    @Override
    public void onRegisterError(String message) {
        view.showError(message);

    }
}
