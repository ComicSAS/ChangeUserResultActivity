package com.example.changeuserresultactivity;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    public static final int OPEN_NAME = 1;
    public static final int OPEN_SURNAME = 2;
    public static final int OPEN_AGE = 3;
    public static final int OPEN_OTHER = 4;

    TextView mTvName;
    TextView mTvChangeName;
    TextView mTvSurname;
    TextView mTvChangeSurname;
    TextView mTvAge;
    TextView mTvChangeAge;
    TextView mTvOther;
    TextView mTvChangeOther;

    Button mBtnSave;

    View.OnClickListener onChangeNameAction;
    View.OnClickListener onChangeSurnameAction;
    View.OnClickListener onChangeAgeAction;
    View.OnClickListener onChangeOtherAction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        initListeners();
        bindListeners();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case OPEN_NAME:
                if (data != null) {
                    String name = data.getStringExtra("NAME");
                    mTvName.setText(name);
                }
                break;
            case OPEN_SURNAME:
                if (data != null) {
                    String surname = data.getStringExtra("SURNAME");
                    mTvSurname.setText(surname);
                }
                break;
            case OPEN_AGE:
                if (data != null) {
                    String age = data.getStringExtra("AGE");
                    mTvAge.setText(age);
                }
                break;
            case OPEN_OTHER:
                if (data != null) {
                    String other = data.getStringExtra("OTHER");
                    mTvOther.setText(other);
                }
                break;
        }
    }

    private void initViews() {
        mTvName = findViewById(R.id.tvMainName);
        mTvChangeName = findViewById(R.id.tvMainChangeName);
        mTvSurname = findViewById(R.id.tvMainSurname);
        mTvChangeSurname = findViewById(R.id.tvMainChangeSurname);
        mTvAge = findViewById(R.id.tvMainAge);
        mTvChangeAge = findViewById(R.id.tvMainChangeAge);
        mTvOther = findViewById(R.id.tvMainOther);
        mTvChangeOther = findViewById(R.id.tvMainChangeOther);
        mBtnSave = findViewById(R.id.btnMainSave);
    }

    private void openName() {
        Intent intentGetName = new Intent(MainActivity.this, NameActivity.class);
        startActivityForResult(intentGetName, OPEN_NAME);
    }

    private void openSurname() {
        Intent intentGetSurname = new Intent(MainActivity.this, SurnameActivity.class);
        startActivityForResult(intentGetSurname, OPEN_SURNAME);
    }

    private void openAge() {
        Intent intentGetAge = new Intent(MainActivity.this, AgeActivity.class);
        startActivityForResult(intentGetAge, OPEN_AGE);
    }

    private void openOther() {
        Intent intentGetOther = new Intent(MainActivity.this, OtherActivity.class);
        startActivityForResult(intentGetOther, OPEN_OTHER);
    }

    private void initListeners() {
        onChangeNameAction = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openName();
            }
        };
        onChangeSurnameAction = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSurname();
            }
        };
        onChangeAgeAction = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAge();
            }
        };
        onChangeOtherAction = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openOther();
            }
        };
    }

    private void bindListeners() {
        mTvChangeName.setOnClickListener(onChangeNameAction);
        mTvChangeSurname.setOnClickListener(onChangeSurnameAction);
        mTvChangeAge.setOnClickListener(onChangeAgeAction);
        mTvChangeOther.setOnClickListener(onChangeOtherAction);
    }
}
