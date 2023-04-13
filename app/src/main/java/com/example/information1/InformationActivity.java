package com.example.information1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class InformationActivity extends AppCompatActivity {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);

        Intent it = getIntent();
        String str = it.getStringExtra("id");

        EditText editTextName = findViewById(R.id.editTextName);
        EditText editTextAge = findViewById(R.id.editTextAge);
        RadioButton radioMale = findViewById(R.id.radioMale);
        RadioButton radioFemale = findViewById(R.id.radioFemale);
        CheckBox cBInfo = findViewById(R.id.cBInfo);
        CheckBox cBAI = findViewById(R.id.cBAI);
        CheckBox cBSecurity = findViewById(R.id.cBSecurity);

        Button btnsend = findViewById(R.id.btnSend);
        btnsend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent();

                it.putExtra("name", editTextName.getText().toString());
                it.putExtra("age", editTextAge.getText().toString());

                if (radioMale.isChecked())
                    it.putExtra("sex", "남성");
                else
                    it.putExtra("sex", "여성");

                String strLicense = "";
                if (cBInfo.isChecked())
                    strLicense = strLicense + "\n    정보처리기사";
                if (cBAI.isChecked())
                    strLicense = strLicense + "\n    인공지능데이터전문가";
                if (cBSecurity.isChecked())
                    strLicense = strLicense + "\n    정보보안기사";

                it.putExtra("License", strLicense);
                setResult(RESULT_OK, it);
                finish();

            }
        });

    }
}
