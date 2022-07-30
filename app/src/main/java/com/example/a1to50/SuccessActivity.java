package com.example.a1to50;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SuccessActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success_activity);

        TextView time_text = (TextView) findViewById(R.id.textView_time);
        Button button_ok = (Button) findViewById(R.id.button_ok);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String time = bundle.getString("time");

        time_text.setText(time);

        button_ok.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}