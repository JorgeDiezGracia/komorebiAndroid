package com.svalero.komorebiandroid.view;

import static com.svalero.komorebiandroid.util.DateUtil.formatFromString;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.svalero.komorebiandroid.R;
import com.svalero.komorebiandroid.domain.SchoolDTO;

public class SchoolDetailView  extends AppCompatActivity {

    private TextView tvName, tvCity, tvStudents, tvPublicSchool, tvRegisterDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_school_detail);

        tvName = findViewById(R.id.tvName);
        tvCity = findViewById(R.id.tvCity);
        tvStudents = findViewById(R.id.tvStudents);
        tvPublicSchool = findViewById(R.id.tvPublicSchool);
        tvRegisterDate = findViewById(R.id.tvRegisterDate);

        SchoolDTO dto = (SchoolDTO) getIntent().getSerializableExtra("school");
        if (dto != null) {
            tvName.setText(dto.getName());
            tvCity.setText(dto.getCity());
            tvStudents.setText(String.valueOf(dto.getStudents()));
            tvPublicSchool.setText(String.valueOf(dto.getPublicSchool()));
            tvRegisterDate.setText(formatFromString(dto.getRegisterDate(), "dd-MM-yyyy", "yyyy-MM-dd"));
        }
    }
}
