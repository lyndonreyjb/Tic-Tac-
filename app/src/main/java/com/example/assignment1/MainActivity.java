package com.example.assignment1;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    // Button for the play again and grid buttons
    private Button play_btn, btn_winner;
    // Button array for all 9 buttons
    private Button[] btn = new Button[9];
    // Counter for each player and turn
    int Counter = 0;
    // 2D array for the winning combinations
    int[][] winningComb = {
            {0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {0, 4, 8}, {2, 4, 6}, {0, 3, 6}, {1, 4, 7}, {2, 5, 8}
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Get the id of the play again button
        play_btn = findViewById(R.id.play_btn);

        // Play again button click
        play_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Reset all the counter animation and empty the buttons
                Counter = 0;
                btn_winner.setVisibility(findViewById(R.id.btn_winner).INVISIBLE);
                for(int i = 0; i < 9; i++){
                    btn[i].setText("");
                    btn[i].animate()
                            .rotation(0)
                            .setDuration(0);
                }

                btn_winner.animate()
                        .scaleX(0)
                        .scaleY(0)
                        .setDuration(0);
            }
        });

        // The pop up button to display the winner
        btn_winner = findViewById(R.id.btn_winner);

        // To get the buttons ID
        btn[0] = findViewById(R.id.btn_1);
        btn[1] = findViewById(R.id.btn_2);
        btn[2] = findViewById(R.id.btn_3);
        btn[3] = findViewById(R.id.btn_4);
        btn[4] = findViewById(R.id.btn_5);
        btn[5] = findViewById(R.id.btn_6);
        btn[6] = findViewById(R.id.btn_7);
        btn[7] = findViewById(R.id.btn_8);
        btn[8] = findViewById(R.id.btn_9);

        // For the on click buttons
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

    @Override
    public void onClick(View view) {
        // Get the id of the buttons
        String btnId = view.getResources().getResourceEntryName(view.getId());
        int num = Integer.parseInt(btnId.substring(btnId.length() - 1, btnId.length()));
        // Animation for the buttons
        btn[num - 1].animate().rotation(360).setDuration(3000);
        // statement to check if button is empty or not
        // then change the text to either x or o depending on whose turn
        if (btn[num - 1].getText() == "") {
            Counter++;
            if (Counter % 2 == 0) {
                btn[num - 1].setText("O");
            } else {
                btn[num - 1].setText("X");
            }
        }
        // Check Win Method
        CheckWin();
    }

    public void CheckWin() {
        // animation winner pop up
        btn_winner.animate()
                .scaleX(1.4f)
                .scaleY(1.4f)
                .setDuration(2000);
        // For loop to check winning combination
        for (int i = 0; i < winningComb.length; i++) {
            if (btn[winningComb[i][0]].getText() == "X" && btn[winningComb[i][1]].getText() == "X" && btn[winningComb[i][2]].getText() == "X") {
                btn_winner.setVisibility(findViewById(R.id.btn_winner).VISIBLE);
                btn_winner.setText("Player X Wins!");

            }  else if (btn[winningComb[i][0]].getText() == "O" && btn[winningComb[i][1]].getText() == "O" && btn[winningComb[i][2]].getText() == "O") {
                btn_winner.setVisibility(findViewById(R.id.btn_winner).VISIBLE);
                btn_winner.setText("Player O Wins!");
            }
        }
        // Checking for a tie
        if(Counter == 9){
            btn_winner.setVisibility(findViewById(R.id.btn_winner).VISIBLE);
            btn_winner.setText("It is a Draw!");
        }
    }
}






