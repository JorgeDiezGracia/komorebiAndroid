package com.svalero.komorebiandroid.view;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;
import com.svalero.komorebiandroid.R;
import com.svalero.komorebiandroid.contract.RegisterSchoolContract;
import com.svalero.komorebiandroid.presenter.RegisterSchoolPresenter;
import com.svalero.komorebiandroid.util.DateUtil;

import java.time.LocalDate;

public class RegisterSchoolView extends AppCompatActivity implements RegisterSchoolContract.View{

    private RegisterSchoolContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_school);

        presenter = new RegisterSchoolPresenter(this);
    }

    public void registerSchool(View view) {

        String name = ((EditText) findViewById(R.id.school_name))
                .getText().toString();

        String city = ((EditText) findViewById(R.id.school_city))
                .getText().toString();

        int students = Integer.parseInt(
                ((EditText) findViewById(R.id.school_students))
                        .getText().toString()
        );

        boolean publicSchool = ((CheckBox) findViewById(R.id.school_public_school))
                .isChecked();

        String registerDate = ((EditText) findViewById(R.id.school_register_date))
                .getText().toString();

        presenter.registerSchool(name, city, students, publicSchool, registerDate);
    }


    @Override
    public void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();

    }

    @Override
    public void showError(String message) {

        Snackbar.make(findViewById(android.R.id.content),
                message,
                Snackbar.LENGTH_LONG).show();

        //Snackbar.make(this.getCurrentFocus(), message, Snackbar.LENGTH_LONG);

    }

    @Override
    public void showValidationError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
}
