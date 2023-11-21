package com.hello;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;


public class countActiviy extends AppCompatActivity {
    private TextView show_count;
    private int count = 1;
    private long fibNMinus1 = 1;
    private long fibNMinus2 = 0;
    private int limit = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tos);

        show_count =findViewById(R.id.show_count);

        Button buttonMoveToOtherActivity = findViewById(R.id.button_move_to_other_activity);
        buttonMoveToOtherActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(countActiviy.this, scrollActivity.class);
                startActivity(intent);
            }
        });

    }

    public void countUp(View view) {
        if (count == 0) {
            show_count.setText("1");
        }
        else if (count == 1) {
            show_count.setText("1");
        }
        else {
            if (limit != -1 && count > limit) {
                count = 1;
                fibNMinus1 = 0;
                fibNMinus2 = 1;
                show_count.setText(getString(R.string.count_initial_value));
            }
            else {
                long fibCurrent = fibNMinus1 + fibNMinus2;
                fibNMinus2 = fibNMinus1;
                fibNMinus1 = fibCurrent;

                int colorResId = R.color.orange;
                switch (count % 11) {
                    case 1:
                        colorResId = R.color.orange;
                        break;
                    case 2:
                        colorResId = R.color.hijaumuda;
                        break;
                    case 3:
                        colorResId = R.color.purple;
                        break;
                    case 4:
                        colorResId = R.color.salem;
                        break;
                    case 5:
                        colorResId = R.color.birumuda;
                        break;
                    case 6 :
                        colorResId = R.color.kuning;
                        break;
                    case 7:
                        colorResId = R.color.hijau;
                        break;
                    case 8:
                        colorResId = R.color.cream;
                        break;
                    case 9:
                        colorResId = R.color.Pink;
                        break;
                    case 10:
                        colorResId = R.color.biru;
                        break;
                    case 11:
                        colorResId = R.color.colorAccent;
                        break;
                }
                show_count.setTextColor(getResources().getColor(colorResId));
                show_count.setText(String.valueOf(fibCurrent));
                show_count.setBackgroundColor(Color.DKGRAY);
            }
        }

        count++;
    }

    public void Reset(View view) {
        count = 1;
        fibNMinus1 = 1;
        fibNMinus2 = 0;
        show_count.setText(getString(R.string.count_initial_value));
    }

    public void setLimit(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Set Limit");

        final EditText input = new EditText(this);
        input.setInputType(android.text.InputType.TYPE_CLASS_NUMBER);
        builder.setView(input);

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String limitStr = input.getText().toString();
                limit = Integer.parseInt(limitStr);
            }
        });

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        builder.show();
    }

}

