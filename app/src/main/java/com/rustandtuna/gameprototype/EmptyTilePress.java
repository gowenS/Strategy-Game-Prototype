package com.rustandtuna.gameprototype;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

/**
 * Created by Sean on 2/24/2016.
 */
public class EmptyTilePress extends Activity {


    TextView TV;
    TextView TVP2;
    ImageButton choose1;
    ImageButton choose2;
    ImageButton choose3;
    ImageButton choose4;
    Button choose5;
    Button choose6;
    int orientation;
    int plrTrn;
    int curOrnt;

    public String log_cat = "EmptyTilePress";
    Intent intent;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        intent = getIntent();
        plrTrn = intent.getIntExtra("PlayerTurn",0);
        curOrnt = intent.getIntExtra("curOrnt", 0);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.push_empty_btn);
        intent = new Intent();

        choose1 = (ImageButton) findViewById(R.id.rotateBtn1);
        choose2 = (ImageButton) findViewById(R.id.rotateBtn2);
        choose3 = (ImageButton) findViewById(R.id.rotateBtn3);
        choose4 = (ImageButton) findViewById(R.id.rotateBtn4);
        choose5 = (Button) findViewById(R.id.buttonCancelOrientation);
        choose6 = (Button) findViewById(R.id.buttonCancelOrientationP2);
        TV = (TextView) findViewById(R.id.emptyBtnTextView);
        TVP2 = (TextView) findViewById(R.id.emptyBtnTextViewP2);
        if (plrTrn == 2) {
            choose5.setVisibility(View.INVISIBLE);
            TV.setVisibility(View.INVISIBLE);
            choose6.setVisibility(View.VISIBLE);
            TVP2.setVisibility(View.VISIBLE);

        }
        switch (curOrnt) {
            case 1: choose1.setBackgroundResource(R.drawable.backone_cantselect);
                    break;
            case 2: choose2.setBackgroundResource(R.drawable.backtwo_cantselect);
                    break;
            case 3: choose3.setBackgroundResource(R.drawable.backthree_cantselect);
                    break;
            case 4: choose4.setBackgroundResource(R.drawable.backfour_cantselect);
                    break;
        }
        if (curOrnt != 1){
            choose1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    orientation = 1;
                    intent.putExtra("Orientation",orientation);
                    setResult(0, intent);
                    finish();
                }
            });
        }
        if (curOrnt !=2 ) {
            choose2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    orientation = 2;
                    intent.putExtra("Orientation", orientation);
                    setResult(0, intent);
                    finish();
                }
            });
        }
        if (curOrnt !=3 ) {
            choose3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    orientation = 3;
                    intent.putExtra("Orientation", orientation);
                    setResult(0,intent);
                    finish();
                }
            });
        }
        if (curOrnt !=4 ) {
            choose4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    orientation= 4;
                    intent.putExtra("Orientation",orientation);
                    setResult(0,intent);
                    finish();
                }
            });
        }

        choose5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                orientation = 5;
                intent.putExtra("Orientation", orientation);
                setResult(0, intent);
                finish();
            }
        });
        choose6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                orientation = 5;
                intent.putExtra("Orientation", orientation);
                setResult(0, intent);
                finish();
            }
        });
    }

}
