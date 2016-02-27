package com.rustandtuna.gameprototype;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

/**
 * Created by Sean on 2/24/2016.
 */
public class EmptyTilePress extends Activity {

    ImageButton choose1;
    ImageButton choose2;
    ImageButton choose3;
    ImageButton choose4;
    int orientation;
    public static int ButtonPressed = 0;
    public String log_cat = "EmptyTilePress";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.push_empty_btn);

        choose1 = (ImageButton) findViewById(R.id.rotateBtn1);
        choose2 = (ImageButton) findViewById(R.id.rotateBtn2);
        choose3 = (ImageButton) findViewById(R.id.rotateBtn3);
        choose4 = (ImageButton) findViewById(R.id.rotateBtn4);
        choose1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EmptyTilePress.ButtonPressed = 1;
                Log.e(log_cat, "ButtonPressed = " + Integer.toString(EmptyTilePress.ButtonPressed));
                finish();
            }
        });
        choose2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EmptyTilePress.ButtonPressed = 2;
                Log.e(log_cat, "ButtonPressed = " + Integer.toString(EmptyTilePress.ButtonPressed));
                finish();
            }
        });
        choose3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EmptyTilePress.ButtonPressed = 3;
                Log.e(log_cat, "ButtonPressed = " + Integer.toString(EmptyTilePress.ButtonPressed));
                finish();
            }
        });
        choose4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EmptyTilePress.ButtonPressed = 4;
                Log.e(log_cat, "ButtonPressed = " + Integer.toString(EmptyTilePress.ButtonPressed));
                finish();
            }
        });
    }

    protected void rotateTile(int i){
        switch (i){
            case 1:
                this.orientation = 1;
                break;
            case 2:
                this.orientation = 2;
                break;
            case 3:
                this.orientation = 3;
                break;
            case 4:
                this.orientation = 4;
                break;
        }
        EmptyTilePress.ButtonPressed = this.orientation;
        finish();

    }

}
