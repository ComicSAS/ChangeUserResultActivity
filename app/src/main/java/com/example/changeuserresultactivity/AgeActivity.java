package com.example.changeuserresultactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import static com.example.changeuserresultactivity.MainActivity.OPEN_AGE;
import static com.example.changeuserresultactivity.MainActivity.OPEN_NAME;

public class AgeActivity extends AppCompatActivity {

    EditText etInputAge;

    Button btnAgeSubmit;

    View.OnClickListener onAgeSubmitAction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_age);
        initViews();
        initListeners();
        bindListeners();
    }

    private void initViews() {
        etInputAge = findViewById(R.id.etAgeInput);
        btnAgeSubmit = findViewById(R.id.btnAgeSubmit);
    }

    private void initListeners() {
        onAgeSubmitAction = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String age = etInputAge.getText().toString();
                Intent intentAge = new Intent();
                intentAge.putExtra("AGE", age);
                setResult(OPEN_AGE, intentAge);
                finish();
            }
        };
    }

    public void bindListeners() {
        btnAgeSubmit.setOnClickListener(onAgeSubmitAction);
    }
}
