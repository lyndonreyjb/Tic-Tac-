package com.example.assignment1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView x_score, o_score;
    private Button play_btn;
    private Button [] btn = new Button[9];

    int Counter = 0;

    int[][] winningComb = {
            {0,1,2},{3,4,5},{6,7,8},{0,4,8},{2,4,6},{0,3,6},{1,4,7},{2,5,8}
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        o_score = findViewById(R.id.o_score);
        x_score = findViewById(R.id.x_score);
        play_btn = findViewById(R.id.play_btn);


        btn[0] = findViewById(R.id.btn_1);
        btn[1] = findViewById(R.id.btn_2);
        btn[2] = findViewById(R.id.btn_3);
        btn[3] = findViewById(R.id.btn_4);
        btn[4] = findViewById(R.id.btn_5);
        btn[5] = findViewById(R.id.btn_6);
        btn[6] = findViewById(R.id.btn_7);
        btn[7] = findViewById(R.id.btn_8);
        btn[8] = findViewById(R.id.btn_9);

        btn[0].setOnClickListener(this);
        btn[1].setOnClickListener(this);
        btn[2].setOnClickListener(this);
        btn[3].setOnClickListener(this);
        btn[4].setOnClickListener(this);
        btn[5].setOnClickListener(this);
        btn[6].setOnClickListener(this);
        btn[7].setOnClickListener(this);
        btn[8].setOnClickListener(this);

    }

    public void onClick(View view){

        int count = Counter++;

        for(int i = 0; i < btn.length; i++){

            if(view.getId() == R.id.name){
                if(count % 2 == 0) {
                    btn[0].setText("O");
                }else{
                    btn[0].setText("X");
                }
            }

        }

    }

}
