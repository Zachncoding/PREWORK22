package com.example.prework1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class EditActivity extends AppCompatActivity {

    EditText etitem;
    Button btnSave;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        etitem = findViewById(R.id.etitem);
        btnSave = findViewById(R.id.btnSave);

        getSupportActionBar().setTitle("Edit item");
    }
}