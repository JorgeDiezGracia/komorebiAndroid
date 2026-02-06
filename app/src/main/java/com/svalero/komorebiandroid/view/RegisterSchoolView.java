//package com.svalero.komorebiandroid.view;
//
//import android.os.Bundle;
//import android.view.View;
//import android.widget.EditText;
//import android.widget.Toast;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import com.google.android.material.snackbar.Snackbar;
//import com.svalero.komorebiandroid.R;
//
//import java.time.LocalDate;
//
//public class RegisterSchoolView extends AppCompatActivity implements RegisterSchoolContract.View{
//
//    private RegisterSchoolContract.Presenter presenter;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_register_school);
//
//        presenter = new RegisterSchoolPresenter(this);
//    }
//
//    public void registerSchool(View view) {
//        String name = ((EditText) findViewById(R.id.school_name)).getText().toString();
//        String city = ((EditText) findViewById(R.id.school_city)).getText().toString();
//        double longitude = Double.parseDouble(((EditText) findViewById(R.id.club_longitude)).getText().toString());
//        double latitude = Double.parseDouble(((EditText)findViewById(R.id.club_latitude)).getText().toString());
//        LocalDate fundationDate = DateUtil.parseDate(((EditText) findViewById(R.id.club_fundation_date)).getText().toString());
//
//        presenter.registerClub(name, email, longitude, latitude, fundationDate);
//
//    }
//
//    @Override
//    public void showMessage(String message) {
//        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
//
//    }
//
//    @Override
//    public void showError(String message) {
//        Snackbar.make(this.getCurrentFocus(), message, Snackbar.LENGTH_LONG);
//
//    }
//
//    @Override
//    public void showValidationError(String message) {
//        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
//    }
//}
