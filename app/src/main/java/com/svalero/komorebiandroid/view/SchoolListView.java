package com.svalero.komorebiandroid.view;

import static androidx.core.content.ContextCompat.startActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.appbar.MaterialToolbar;
import com.svalero.komorebiandroid.R;
import com.svalero.komorebiandroid.adapter.SchoolAdapter;
import com.svalero.komorebiandroid.contract.SchoolListContract;
import com.svalero.komorebiandroid.domain.School;
import com.svalero.komorebiandroid.presenter.SchoolListPresenter;

import java.util.ArrayList;
import java.util.List;

public class SchoolListView extends AppCompatActivity implements SchoolListContract.View {

    private SchoolAdapter schoolAdapter;
    private List<School> schoolList;
    private SchoolListPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Configurar Toolbar como ActionBar
        MaterialToolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        presenter = new SchoolListPresenter(this);
        presenter.loadSchools();

        schoolList = new ArrayList<>();

        RecyclerView recyclerView = findViewById(R.id.school_list);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        schoolAdapter = new SchoolAdapter(schoolList, schoolDTO -> {
            Intent intent = new Intent(SchoolListView.this, SchoolDetailView.class);
            intent.putExtra("school", schoolDTO);
            startActivity(intent);
        });

        recyclerView.setAdapter(schoolAdapter);
    }

    // Inflar menú
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.actionbar, menu);
        return true;
    }

    // Manejar click en + del ActionBar
//    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//        if (item.getItemId() == R.id.action_register_school) {
//           Intent intent = new Intent(this, RegisterSchoolView.class);
//            startActivity(intent);
//            return true;
//        }
//        return super.onOptionsItemSelected(item);
//    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.loadSchools();
    }

    @Override
    public void showSchools(List<School> schools) {
        schoolList.clear();
        schoolList.addAll(schools);
        schoolAdapter.notifyDataSetChanged();
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
