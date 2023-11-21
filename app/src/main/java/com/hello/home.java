package com.hello;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

public class home extends AppCompatActivity {
    private Button btnMove;
    private int geoLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        btnMove = findViewById(R.id.button_move_count);

        btnMove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(home.this, countActiviy.class);
                startActivity(i);
            }
        });

        Button buttonMovehallo = findViewById(R.id.button_move_hallo);
        buttonMovehallo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(home.this, MainActivity.class);
                startActivity(intent);
            }
        });

        Button buttonMoveToScroll = findViewById(R.id.button_move_to_other_scroll);
        buttonMoveToScroll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(home.this, scrollActivity.class);
                startActivity(intent);
            }
        });

        Button buttonMoveToOtherActivity = findViewById(R.id.buttonMoveToOtherActivity);
        buttonMoveToOtherActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(home.this, pertamaActivity.class);
                startActivity(intent);
            }
        });

        Button buttonMoveToalarm = findViewById(R.id.button_move_to_alarm);
        buttonMoveToalarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(home.this, SetAlarm.class);
                startActivity(intent);
            }
        });
    }
    public void showMap(Uri geoLocation){
        Intent intent = new Intent(Intent.ACTION.View);
        intent.setData(geoLocation);
        if (intent.resolveActivity(getPackageManager()) != null){
            startActivity(intent);
        }
    }
}
}
