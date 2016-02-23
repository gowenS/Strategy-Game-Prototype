package com.rustandtuna.gameprototype;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    public String log_cat = "MainActivity";

    //git test line

    gridButton a1Butt;
    gridButton a2Butt;
    gridButton a3Butt;
    gridButton a4Butt;

    gridButton b1Butt;
    gridButton b2Butt;
    gridButton b3Butt;
    gridButton b4Butt;

    gridButton c1Butt;
    gridButton c2Butt;
    gridButton c3Butt;
    gridButton c4Butt;

    gridButton d1Butt;
    gridButton d2Butt;
    gridButton d3Butt;
    gridButton d4Butt;

    gridButton e1Butt;
    gridButton e2Butt;
    gridButton e3Butt;
    gridButton e4Butt;

    gridButton f1Butt;
    gridButton f2Butt;
    gridButton f3Butt;
    gridButton f4Butt;

    gridButton g1Butt;
    gridButton g2Butt;
    gridButton g3Butt;
    gridButton g4Butt;

    gridButton h1Butt;
    gridButton h2Butt;
    gridButton h3Butt;
    gridButton h4Butt;

    gridButton[] gameGrid = new gridButton[32] ;
    GameState thisGame;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //gameGrid sorts the items from left to right so that row one is {1,2,3,4,5...}

//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//        for(int i = 0; i< 50; i++){
//            gameGrid[i] = new gridCell();
//        }


        a1Butt = (gridButton) findViewById(R.id.a1Button);
        gameGrid[0] = a1Butt;
        a1Butt.setBackgroundResource(R.drawable.backone);
        a1Butt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                thisGame.buttonPress(0);
            }
        });
        a2Butt = (gridButton) findViewById(R.id.a2Button);
        gameGrid[1] = a2Butt;
        a2Butt.setBackgroundResource(R.drawable.backone);
        a2Butt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                thisGame.buttonPress(1);
            }
        });
        a3Butt = (gridButton) findViewById(R.id.a3Button);
        gameGrid[2] = a3Butt;
        a3Butt.setBackgroundResource(R.drawable.backone);
        a3Butt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                thisGame.buttonPress(2);
            }
        });
        a4Butt = (gridButton) findViewById(R.id.a4Button);
        gameGrid[3] = a4Butt;
        a4Butt.setBackgroundResource(R.drawable.backone);
        a4Butt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                thisGame.buttonPress(3);
            }
        });
        b1Butt = (gridButton) findViewById(R.id.b1Button);
        gameGrid[4] = b1Butt;
        b1Butt.setBackgroundResource(R.drawable.backone);
        b1Butt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                thisGame.buttonPress(4);
            }
        });
        b2Butt = (gridButton) findViewById(R.id.b2Button);
        gameGrid[5] = b2Butt;
        b2Butt.setBackgroundResource(R.drawable.backone);
        b2Butt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                thisGame.buttonPress(5);
            }
        });
        b3Butt = (gridButton) findViewById(R.id.b3Button);
        gameGrid[6] = b3Butt;
        b3Butt.setBackgroundResource(R.drawable.backone);
        b3Butt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                thisGame.buttonPress(6);
            }
        });
        b4Butt = (gridButton) findViewById(R.id.b4Button);
        gameGrid[7] = b4Butt;
        b4Butt.setBackgroundResource(R.drawable.backone);
        b4Butt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                thisGame.buttonPress(7);
            }
        });
        c1Butt = (gridButton) findViewById(R.id.c1Button);
        gameGrid[8] = c1Butt;
        c1Butt.setBackgroundResource(R.drawable.backone);
        c1Butt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                thisGame.buttonPress(8);
            }
        });
        c2Butt = (gridButton) findViewById(R.id.c2Button);
        gameGrid[9] = c2Butt;
        c2Butt.setBackgroundResource(R.drawable.backone);
        c2Butt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                thisGame.buttonPress(9);
            }
        });
        c3Butt = (gridButton) findViewById(R.id.c3Button);
        gameGrid[10] = c3Butt;
        c3Butt.setBackgroundResource(R.drawable.backone);
        c3Butt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                thisGame.buttonPress(10);
            }
        });
        c4Butt = (gridButton) findViewById(R.id.c4Button);
        gameGrid[11] = c4Butt;
        c4Butt.setBackgroundResource(R.drawable.backone);
        c4Butt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                thisGame.buttonPress(11);
            }
        });
        d1Butt = (gridButton) findViewById(R.id.d1Button);
        gameGrid[12] = d1Butt;
        d1Butt.setBackgroundResource(R.drawable.backone);
        d1Butt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                thisGame.buttonPress(12);
            }
        });
        d2Butt = (gridButton) findViewById(R.id.d2Button);
        gameGrid[13] = d2Butt;
        d2Butt.setBackgroundResource(R.drawable.backone);
        d2Butt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                thisGame.buttonPress(13);
            }
        });
        d3Butt = (gridButton) findViewById(R.id.d3Button);
        gameGrid[14] = d3Butt;
        d3Butt.setBackgroundResource(R.drawable.backone);
        d3Butt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                thisGame.buttonPress(14);
            }
        });
        d4Butt = (gridButton) findViewById(R.id.d4Button);
        gameGrid[15] = d4Butt;
        d4Butt.setBackgroundResource(R.drawable.backone);
        d4Butt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                thisGame.buttonPress(15);
            }
        });
        e1Butt = (gridButton) findViewById(R.id.e1Button);
        gameGrid[16] = e1Butt;
        e1Butt.setBackgroundResource(R.drawable.backone);
        e1Butt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                thisGame.buttonPress(16);
            }
        });
        e2Butt = (gridButton) findViewById(R.id.e2Button);
        gameGrid[17] = e2Butt;
        e2Butt.setBackgroundResource(R.drawable.backone);
        e2Butt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                thisGame.buttonPress(17);
            }
        });
        e3Butt = (gridButton) findViewById(R.id.e3Button);
        gameGrid[18] = e3Butt;
        e3Butt.setBackgroundResource(R.drawable.backone);
        e3Butt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                thisGame.buttonPress(18);
            }
        });
        e4Butt = (gridButton) findViewById(R.id.e4Button);
        gameGrid[19] = e4Butt;
        e4Butt.setBackgroundResource(R.drawable.backone);
        e4Butt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                thisGame.buttonPress(19);
            }
        });
        f1Butt = (gridButton) findViewById(R.id.f1Button);
        gameGrid[20] = f1Butt;
        f1Butt.setBackgroundResource(R.drawable.backone);
        f1Butt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                thisGame.buttonPress(20);
            }
        });
        f2Butt = (gridButton) findViewById(R.id.f2Button);
        gameGrid[21] = f2Butt;
        f2Butt.setBackgroundResource(R.drawable.backone);
        f2Butt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                thisGame.buttonPress(21);
            }
        });
        f3Butt = (gridButton) findViewById(R.id.f3Button);
        gameGrid[22] = f3Butt;
        f3Butt.setBackgroundResource(R.drawable.backone);
        f3Butt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                thisGame.buttonPress(22);
            }
        });
        f4Butt = (gridButton) findViewById(R.id.f4Button);
        gameGrid[23] = f4Butt;
        f4Butt.setBackgroundResource(R.drawable.backone);
        f4Butt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                thisGame.buttonPress(23);
            }
        });
        g1Butt = (gridButton) findViewById(R.id.g1Button);
        gameGrid[24] = g1Butt;
        g1Butt.setBackgroundResource(R.drawable.backone);
        g1Butt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                thisGame.buttonPress(24);
            }
        });
        g2Butt = (gridButton) findViewById(R.id.g2Button);
        gameGrid[25] = g2Butt;
        g2Butt.setBackgroundResource(R.drawable.backone);
        g2Butt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                thisGame.buttonPress(25);
            }
        });
        g3Butt = (gridButton) findViewById(R.id.g3Button);
        gameGrid[26] = g3Butt;
        g3Butt.setBackgroundResource(R.drawable.backone);
        g3Butt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                thisGame.buttonPress(26);
            }
        });
        g4Butt = (gridButton) findViewById(R.id.g4Button);
        gameGrid[27] = g4Butt;
        g4Butt.setBackgroundResource(R.drawable.backone);
        g4Butt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                thisGame.buttonPress(27);
            }
        });
        h1Butt = (gridButton) findViewById(R.id.h1Button);
        gameGrid[28] = h1Butt;
        h1Butt.setBackgroundResource(R.drawable.backone);
        h1Butt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                thisGame.buttonPress(28);
            }
        });
        h2Butt = (gridButton) findViewById(R.id.h2Button);
        gameGrid[29] = h2Butt;
        h2Butt.setBackgroundResource(R.drawable.backone);
        h2Butt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                thisGame.buttonPress(29);
            }
        });
        h3Butt = (gridButton) findViewById(R.id.h3Button);
        gameGrid[30] = h3Butt;
        h3Butt.setBackgroundResource(R.drawable.backone);
        h3Butt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                thisGame.buttonPress(30);
            }
        });
        h4Butt = (gridButton) findViewById(R.id.h4Button);
        gameGrid[31] = h4Butt;
        h4Butt.setBackgroundResource(R.drawable.backone);
        h4Butt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                thisGame.buttonPress(31);
            }
        });

        thisGame = new GameState();
        Context gameContext = getApplicationContext();
        thisGame.initializeGame(gameGrid,gameContext);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
