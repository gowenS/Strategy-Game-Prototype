package com.rustandtuna.gameprototype;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

/**
 * Created by Sean on 2/24/2016.
 */
public class EmptyTilePress extends Activity {

    ImageButton choose1;
    ImageButton choose2;
    ImageButton choose3;
    ImageButton choose4;
    Button choose5;
    int orientation;

//    public static int ButtonPressed = 0;
    public String log_cat = "EmptyTilePress";
    Intent intent;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.push_empty_btn);
        intent = new Intent();

        choose1 = (ImageButton) findViewById(R.id.rotateBtn1);
        choose2 = (ImageButton) findViewById(R.id.rotateBtn2);
        choose3 = (ImageButton) findViewById(R.id.rotateBtn3);
        choose4 = (ImageButton) findViewById(R.id.rotateBtn4);
        choose5 = (Button) findViewById(R.id.buttonCancelOrientation);
        choose1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                orientation = 1;
//                Log.e(log_cat, "ButtonPressed = 1");
                intent.putExtra("Orientation",orientation);
                setResult(0, intent);
                finish();
            }
        });
        choose2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                orientation = 2;
//                Log.e(log_cat, "ButtonPressed = 2");
                intent.putExtra("Orientation", orientation);
                setResult(0, intent);
                finish();
            }
        });
        choose3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                orientation = 3;
//                Log.e(log_cat, "ButtonPressed = 3");
                intent.putExtra("Orientation", orientation);
                setResult(0,intent);
                finish();
            }
        });
        choose4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                orientation= 4;
//                Log.e(log_cat, "ButtonPressed = 4");
                intent.putExtra("Orientation",orientation);
                setResult(0,intent);
                finish();
            }
        });
        choose5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                orientation= 5;
//                Log.e(log_cat, "ButtonPressed = Cancel");
                intent.putExtra("Orientation",orientation);
                setResult(0,intent);
                finish();
            }
        });
    }

//    protected void rotateTile(int i){
//        switch (i){
//            case 1:
//                this.orientation = 1;
//                break;
//            case 2:
//                this.orientation = 2;
//                break;
//            case 3:
//                this.orientation = 3;
//                break;
//            case 4:
//                this.orientation = 4;
//                break;
//        }
//        EmptyTilePress.ButtonPressed = this.orientation;
//        finish();
//
//    }

}
