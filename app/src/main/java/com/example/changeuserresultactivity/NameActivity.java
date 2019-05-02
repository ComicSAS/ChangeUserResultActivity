package com.example.changeuserresultactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import static com.example.changeuserresultactivity.MainActivity.OPEN_NAME;

public class NameActivity extends AppCompatActivity {

    EditText etInputName;

    Button btnNameSubmit;

    View.OnClickListener onNameSubmitAction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name);
        initViews();
        initListeners();
        bindListeners();
    }

    private void initViews() {
        etInputName = findViewById(R.id.etNameInput);
        btnNameSubmit = findViewById(R.id.btnNameSubmit);
    }

    private void initListeners() {
        onNameSubmitAction = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = etInputName.getText().toString();
                Intent intentName = new Intent();
                intentName.putExtra("NAME", name);
                setResult(OPEN_NAME, intentName);
                finish();
            }
        };
    }

    public void bindListeners() {
        btnNameSubmit.setOnClickListener(onNameSubmitAction);
    }
}
