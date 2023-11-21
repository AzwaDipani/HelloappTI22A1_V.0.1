package com.hello;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class scrollActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrollmovie);

        Button buttonMoveToOtherActivity = findViewById(R.id.buttonMoveToOtherActivity);
        buttonMoveToOtherActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(scrollActivity.this, pertamaActivity.class);
                startActivity(intent);
            }
        });
    }
}
