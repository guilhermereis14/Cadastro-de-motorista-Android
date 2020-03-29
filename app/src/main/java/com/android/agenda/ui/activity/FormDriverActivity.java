package com.android.agenda.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.agenda.R;
import com.android.agenda.dao.DriverDao;
import com.android.agenda.model.CreateDriver;

public class FormDriverActivity extends AppCompatActivity {

    public static final String TITLE_APPBAR = "Cadastrar Motorista";
    private EditText fieldName;
    private EditText fieldPhone;
    private EditText fieldEmail;
    private final DriverDao dao = new DriverDao();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_driver);
        setTitle(TITLE_APPBAR);
        fieldsInitialization();
        fieldsInitialization();
        configureSaveButton();

    }

    private void configureSaveButton() {
        Button buttonSave = findViewById(R.id.activity_form_driver_buttonSave);

        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CreateDriver driver = createDriver();
                saveDriver(driver);
            }
        });
    }

    private void fieldsInitialization() {
        fieldName = findViewById(R.id.activity_form_driver_name);
        fieldPhone = findViewById(R.id.activity_form_driver_phone);
        fieldEmail = findViewById(R.id.activity_form_driver_email);
    }

    private void saveDriver(CreateDriver driver) {
        dao.saveDriver(driver);
        finish();
    }

    private CreateDriver createDriver() {
        String name = fieldName.getText().toString();
        String phone = fieldPhone.getText().toString();
        String email = fieldEmail.getText().toString();

        return new CreateDriver(name, phone, email);
    }

}
