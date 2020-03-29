package com.android.agenda.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.android.agenda.R;
import com.android.agenda.dao.DriverDao;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ListDriversActivity extends AppCompatActivity {

    private final DriverDao dao = new DriverDao();
    public static final String TITLE_APPBAR = "Lista de Motoristas";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_drivers);
        setTitle(TITLE_APPBAR);
        configureFabNewDriver();
    }

    private void configureFabNewDriver() {
        FloatingActionButton buttonNewDriver = findViewById(R.id.activity_listDrivers_fab_newDriver);

        buttonNewDriver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFormDriverActivity();
            }
        });
    }

    private void openFormDriverActivity() {
        startActivity(new Intent(this, FormDriverActivity.class));
    }

    @Override
    protected void onResume() {
        super.onResume();

        configureListOfDrivers();
    }

    private void configureListOfDrivers() {
        ListView listOfDrivers = findViewById(R.id.activity_listDrivers_listView);

        listOfDrivers.setAdapter(new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                dao.allDrivers()));
    }
}
