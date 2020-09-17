package com.example.firsttest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Arrays;

/*
0-X
1-O
 */
public class MainActivity extends AppCompatActivity {
    boolean active = true;
    int[][] winPositions = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8},
                            {0, 3, 6}, {1, 4, 7}, {2, 5, 8},
                            {0, 4, 8}, {2, 4, 6}};
    int[] gridEntry = {2, 2, 2, 2, 2, 2, 2, 2, 2};
    int player = 0;

    public void playerTap(View view) {
        ImageView img = (ImageView) view;
        int tappedImage = Integer.parseInt(img.getTag().toString());
        if (!active) {
            gameReset(view);
        }
        if (gridEntry[tappedImage] == 2) {
            gridEntry[tappedImage] = player;
            TextView status = findViewById(R.id.status);
            if (player == 0) {
                status.setText("O's Turn - Tap to play");
                img.setImageResource(R.drawable.x);
                player = 1;
            } else {
                status.setText("X's Turn - Tap to play");
                img.setImageResource(R.drawable.o);
                player = 0;
            }
        }
        String winnerStr;
        for (int[] win : winPositions) {
            if ((gridEntry[win[0]] == gridEntry[win[1]] && gridEntry[win[1]] == gridEntry[win[2]]) && gridEntry[win[0]] != 2) {
                active = false;
                if (gridEntry[win[0]] == 0) {
                    winnerStr = "X has won";
                } else {
                    winnerStr = "O has won";
                }
                TextView status = findViewById(R.id.status);
                status.setText(winnerStr);
            }

        }
        int count = 0;
        for (int element : gridEntry) {
            if (element == 2) {
                count++;
            }
        }
        if (count==0){
            active=false;
        }

}

    public void gameReset(View view) {
        player = 0;
        for(int i=0; i<gridEntry.length; i++){
            gridEntry[i] = 2;
        }
        ((ImageView)findViewById(R.id.imageView0)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView1)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView2)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView8)).setImageResource(0);
        active = true;
        TextView status = findViewById(R.id.status);
        status.setText("X's Turn - Tap to play");

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}

