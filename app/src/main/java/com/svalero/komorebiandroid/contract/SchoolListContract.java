package com.svalero.komorebiandroid.contract;

import com.svalero.komorebiandroid.domain.School;

import java.util.List;

public interface SchoolListContract {
    interface Model {
        interface OnLoadListener {
            void onLoadSuccess(List<School> schools);
            void onLoadError(String message);
        }

        void loadSchools(OnLoadListener listener);
    }

    interface View {
        void showSchools(List<School> schools);
        void showMessage(String message);
        void showError(String message);
    }
    interface Presenter {
        void loadSchools();
    }

}
