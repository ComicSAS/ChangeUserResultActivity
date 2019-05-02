package com.example.changeuserresultactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import static com.example.changeuserresultactivity.MainActivity.OPEN_NAME;
import static com.example.changeuserresultactivity.MainActivity.OPEN_SURNAME;

public class SurnameActivity extends AppCompatActivity {

    EditText etInputSurname;

    Button btnSurnameSubmit;

    View.OnClickListener onSurnameSubmitAction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_surname);
        initViews();
        initListeners();
        bindListeners();
    }

    private void initViews() {
        etInputSurname = findViewById(R.id.etSurnameInput);
        btnSurnameSubmit = findViewById(R.id.btnSurnameSubmit);
    }

    private void initListeners() {
        onSurnameSubmitAction = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String surname = etInputSurname.getText().toString();
                Intent intentSurname = new Intent();
                intentSurname.putExtra("SURNAME", surname);
                setResult(OPEN_SURNAME, intentSurname);
                finish();
            }
        };
    }

    public void bindListeners() {
        btnSurnameSubmit.setOnClickListener(onSurnameSubmitAction);
    }
}
