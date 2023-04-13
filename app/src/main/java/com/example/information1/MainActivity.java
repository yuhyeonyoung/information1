package com.example.information1;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    final int REQUEST_INFO = 1;
    TextView tVResult, tVResultLabel;
    String str;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnReq = findViewById(R.id.btnRequest);
        Button btnEnd = findViewById(R.id.btnEnd);
        tVResult = findViewById(R.id.tVResult);
        tVResultLabel = findViewById(R.id.tVResultLabel);
        EditText editTextID = findViewById(R.id.editTextID);
        btnReq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(getApplicationContext(), InformationActivity.class);
                str = editTextID.getText().toString();
                it.putExtra("id", str);
                startActivityForResult(it, REQUEST_INFO);
            }
        });
        btnEnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                finish();
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if ((requestCode == REQUEST_INFO) && (resultCode == RESULT_OK)){
            str = "아이디: " + str;
            str = str + "\n이름: " + data.getStringExtra("name");
            str = str + "\n나이: " + data.getStringExtra("age");
            str = str + "\n성별: " + data.getStringExtra("sex");
            str = str + "\n자격증: " + data.getStringExtra("License");

            tVResultLabel.setText("전송\n정보\n출력");
            tVResult.setText(str);
        }
    }
}