package com.example.a1to50;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Integer[] array1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10,
            11, 12, 13, 14, 15, 16, 17, 18, 19, 20,
            21, 22, 23, 24, 25};
    Integer[] array2 = {26, 27, 28, 29, 30,
            31, 32, 33, 34, 35, 36, 37, 38, 39, 40,
            41, 42, 43, 44, 45, 46, 47, 48, 49, 50};
    Integer target_num;
    Button buttons[] = new Button[25];
    int i;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Chronometer chronometer = (Chronometer) findViewById(R.id.chronometer);
        Button button_start = (Button) findViewById(R.id.button_start);
        Button button_stop = (Button) findViewById(R.id.button_stop);
        TextView text_target = (TextView) findViewById(R.id.now_number);

        Button button_1 = (Button) findViewById(R.id.button1);
        Button button_2 = (Button) findViewById(R.id.button2);
        Button button_3 = (Button) findViewById(R.id.button3);
        Button button_4 = (Button) findViewById(R.id.button4);
        Button button_5 = (Button) findViewById(R.id.button5);
        Button button_6 = (Button) findViewById(R.id.button6);
        Button button_7 = (Button) findViewById(R.id.button7);
        Button button_8 = (Button) findViewById(R.id.button8);
        Button button_9 = (Button) findViewById(R.id.button9);
        Button button_10 = (Button) findViewById(R.id.button10);

        Button button_11 = (Button) findViewById(R.id.button11);
        Button button_12 = (Button) findViewById(R.id.button12);
        Button button_13 = (Button) findViewById(R.id.button13);
        Button button_14 = (Button) findViewById(R.id.button14);
        Button button_15 = (Button) findViewById(R.id.button15);
        Button button_16 = (Button) findViewById(R.id.button16);
        Button button_17 = (Button) findViewById(R.id.button17);
        Button button_18 = (Button) findViewById(R.id.button18);
        Button button_19 = (Button) findViewById(R.id.button19);
        Button button_20 = (Button) findViewById(R.id.button20);

        Button button_21 = (Button) findViewById(R.id.button21);
        Button button_22 = (Button) findViewById(R.id.button22);
        Button button_23 = (Button) findViewById(R.id.button23);
        Button button_24 = (Button) findViewById(R.id.button24);
        Button button_0 = (Button) findViewById(R.id.button0);

        for (i = 0; i < 25; i++) {
            String btn_name = "button" + (Integer.toString(i));
            int resID = getResources().getIdentifier(btn_name, "id", getPackageName());
            buttons[i] = (Button) findViewById(resID);
        }

        button_start.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                chronometer.start();
                chronometer.setBase(SystemClock.elapsedRealtime());

                List<Integer> list = Arrays.asList(array1);
                Collections.shuffle(list);
                list.toArray(array1);
                list = Arrays.asList(array2);
                Collections.shuffle(list);
                list.toArray(array2);
                target_num = 1;
                text_target.setText(target_num.toString());

                for (i = 0; i < 25; i++) {
                    buttons[i].setText(array1[i].toString());
                }
            }
        });

        button_stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chronometer.stop();
                chronometer.setBase(SystemClock.elapsedRealtime());
                text_target.setText("");

                for (i = 0; i < 25; i++) {
                    buttons[i].setText("");
                }
            }
        });

        for (i = 0; i < 25; i++) {
            final Integer btn_index = i;
            buttons[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Integer value;
                    String tmpStr = buttons[btn_index].getText().toString();
                    if (tmpStr.equals("")) {
                        value = 0;
                    } else {
                        value = Integer.valueOf(tmpStr);
                    }
                    if (value == target_num) {
                        target_num += 1;
                        text_target.setText(target_num.toString());
                        if (value > 25) {
                            buttons[btn_index].setText("");
                        } else {
                            buttons[btn_index].setText(array2[btn_index].toString());
                        }
                    }

                    if (target_num == 51) {
                        success(SystemClock.elapsedRealtime() - chronometer.getBase());
                    }
                }
            });
        }
    }

    void success(long current_time) {
        Intent intent = new Intent(getApplicationContext(), SuccessActivity.class);
        long current = current_time;
        intent.putExtra("time", String.valueOf(current / 1000));
        startActivity(intent);
        finish();
    }
};