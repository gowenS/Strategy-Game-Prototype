package com.rustandtuna.gameprototype;

import android.app.Activity;
import android.os.Bundle;
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
                rotateTile(1);
            }
        });
        choose2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rotateTile(2);
            }
        });
        choose3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rotateTile(3);
            }
        });
        choose4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rotateTile(4);
            }
        });
    }

    public void rotateTile(int i){
        switch (i){
            case 1:
                orientation = 1;
                break;
            case 2:
                orientation = 2;
                break;
            case 3:
                orientation = 3;
                break;
            case 4:
                orientation = 4;
                break;
        }
        exit(orientation);
        finish();

    }
    public int exit(int orientation){
        return orientation;
    }
}
