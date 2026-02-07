package com.svalero.komorebiandroid.contract;

import com.svalero.komorebiandroid.domain.School;

public interface RegisterSchoolContract {

    interface Model {
        interface onRegisterListener {
            void onRegisterSuccess(School school);
            void onRegisterError(String message);
        }
        void registerSchool(School school, onRegisterListener listener);
    }

    interface View {
        void showMessage(String message);
        void showError(String message);
        void showValidationError(String message);
    }

    interface Presenter {
        void registerSchool(String name, String city, int students, boolean publicSchool, String registerDate);
    }
}
