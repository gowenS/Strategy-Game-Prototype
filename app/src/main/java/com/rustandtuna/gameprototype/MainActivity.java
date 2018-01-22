package com.rustandtuna.gameprototype;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public String log_cat = "MainActivity";

    final String type1 = "close";
    final String type2 = "mounted";
    final String type3 = "ranged";
    String status = "";
    int initStatus = 0;
    String[] legalMove = new String[2];
    FoundPath[] attackPaths = new FoundPath[9];
    PlayerPiece p1t1 = new PlayerPiece(1,"close");
    PlayerPiece p1t2 = new PlayerPiece(1,"mounted");
    PlayerPiece p1t3 = new PlayerPiece(1,"ranged");
    PlayerPiece p2t1 = new PlayerPiece(2,"close");
    PlayerPiece p2t2 = new PlayerPiece(2,"mounted");
    PlayerPiece p2t3 = new PlayerPiece(2,"ranged");

    //git test line
    //git test line 2


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
    boolean turnOnChoose = false;
    public PopupWindow playerTurnPopup;
    LinearLayout popupLayout;
    int pressedCell;
    int whichPlayerTurn = 1;
    int movesUsedThisTurn = 0;
    ImageView player1TurnIndicator;
    ImageView player2TurnIndicator;
    boolean moveToggle = false;
    int[] availableTiles = new int[4];
    boolean check = false;
    PlayerPiece movingPlayer;
    int originCellMoving;
    FoundPath[] allAttackPaths;
    PlayerPiece[] playersInGame;
    TextView p1t1HP;
    TextView p1t2HP;
    TextView p1t3HP;
    TextView p2t1HP;
    TextView p2t2HP;
    TextView p2t3HP;




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
        player1TurnIndicator = (ImageView) findViewById(R.id.player1TurnIndicator);
        player2TurnIndicator = (ImageView) findViewById(R.id.player2TurnIndicator);
        p1t1HP = (TextView) findViewById(R.id.p1t1HP);
        p1t2HP = (TextView) findViewById(R.id.p1t2HP);
        p1t3HP = (TextView) findViewById(R.id.p1t3HP);
        p2t1HP = (TextView) findViewById(R.id.p2t1HP);
        p2t2HP = (TextView) findViewById(R.id.p2t2HP);
        p2t3HP = (TextView) findViewById(R.id.p2t3HP);





        a1Butt = (gridButton) findViewById(R.id.a1Button);
        gameGrid[0] = a1Butt;
        a1Butt.setBackgroundResource(R.drawable.backone);
        a1Butt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonPress(0);
            }
        });
        a2Butt = (gridButton) findViewById(R.id.a2Button);
        gameGrid[1] = a2Butt;
        a2Butt.setBackgroundResource(R.drawable.backone);
        a2Butt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonPress(1);
            }
        });
        a3Butt = (gridButton) findViewById(R.id.a3Button);
        gameGrid[2] = a3Butt;
        a3Butt.setBackgroundResource(R.drawable.backone);
        a3Butt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonPress(2);
            }
        });
        a4Butt = (gridButton) findViewById(R.id.a4Button);
        gameGrid[3] = a4Butt;
        a4Butt.setBackgroundResource(R.drawable.backone);
        a4Butt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonPress(3);
            }
        });
        b1Butt = (gridButton) findViewById(R.id.b1Button);
        gameGrid[4] = b1Butt;
        b1Butt.setBackgroundResource(R.drawable.backone);
        b1Butt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonPress(4);
            }
        });
        b2Butt = (gridButton) findViewById(R.id.b2Button);
        gameGrid[5] = b2Butt;
        b2Butt.setBackgroundResource(R.drawable.backone);
        b2Butt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonPress(5);
            }
        });
        b3Butt = (gridButton) findViewById(R.id.b3Button);
        gameGrid[6] = b3Butt;
        b3Butt.setBackgroundResource(R.drawable.backone);
        b3Butt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonPress(6);
            }
        });
        b4Butt = (gridButton) findViewById(R.id.b4Button);
        gameGrid[7] = b4Butt;
        b4Butt.setBackgroundResource(R.drawable.backone);
        b4Butt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonPress(7);
            }
        });
        c1Butt = (gridButton) findViewById(R.id.c1Button);
        gameGrid[8] = c1Butt;
        c1Butt.setBackgroundResource(R.drawable.backone);
        c1Butt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonPress(8);
            }
        });
        c2Butt = (gridButton) findViewById(R.id.c2Button);
        gameGrid[9] = c2Butt;
        c2Butt.setBackgroundResource(R.drawable.backone);
        c2Butt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonPress(9);
            }
        });
        c3Butt = (gridButton) findViewById(R.id.c3Button);
        gameGrid[10] = c3Butt;
        c3Butt.setBackgroundResource(R.drawable.backone);
        c3Butt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonPress(10);
            }
        });
        c4Butt = (gridButton) findViewById(R.id.c4Button);
        gameGrid[11] = c4Butt;
        c4Butt.setBackgroundResource(R.drawable.backone);
        c4Butt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonPress(11);
            }
        });
        d1Butt = (gridButton) findViewById(R.id.d1Button);
        gameGrid[12] = d1Butt;
        d1Butt.setBackgroundResource(R.drawable.backone);
        d1Butt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonPress(12);
            }
        });
        d2Butt = (gridButton) findViewById(R.id.d2Button);
        gameGrid[13] = d2Butt;
        d2Butt.setBackgroundResource(R.drawable.backone);
        d2Butt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonPress(13);
            }
        });
        d3Butt = (gridButton) findViewById(R.id.d3Button);
        gameGrid[14] = d3Butt;
        d3Butt.setBackgroundResource(R.drawable.backone);
        d3Butt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonPress(14);
            }
        });
        d4Butt = (gridButton) findViewById(R.id.d4Button);
        gameGrid[15] = d4Butt;
        d4Butt.setBackgroundResource(R.drawable.backone);
        d4Butt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonPress(15);
            }
        });
        e1Butt = (gridButton) findViewById(R.id.e1Button);
        gameGrid[16] = e1Butt;
        e1Butt.setBackgroundResource(R.drawable.backone);
        e1Butt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonPress(16);
            }
        });
        e2Butt = (gridButton) findViewById(R.id.e2Button);
        gameGrid[17] = e2Butt;
        e2Butt.setBackgroundResource(R.drawable.backone);
        e2Butt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonPress(17);
            }
        });
        e3Butt = (gridButton) findViewById(R.id.e3Button);
        gameGrid[18] = e3Butt;
        e3Butt.setBackgroundResource(R.drawable.backone);
        e3Butt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonPress(18);
            }
        });
        e4Butt = (gridButton) findViewById(R.id.e4Button);
        gameGrid[19] = e4Butt;
        e4Butt.setBackgroundResource(R.drawable.backone);
        e4Butt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonPress(19);
            }
        });
        f1Butt = (gridButton) findViewById(R.id.f1Button);
        gameGrid[20] = f1Butt;
        f1Butt.setBackgroundResource(R.drawable.backone);
        f1Butt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonPress(20);
            }
        });
        f2Butt = (gridButton) findViewById(R.id.f2Button);
        gameGrid[21] = f2Butt;
        f2Butt.setBackgroundResource(R.drawable.backone);
        f2Butt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonPress(21);
            }
        });
        f3Butt = (gridButton) findViewById(R.id.f3Button);
        gameGrid[22] = f3Butt;
        f3Butt.setBackgroundResource(R.drawable.backone);
        f3Butt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonPress(22);
            }
        });
        f4Butt = (gridButton) findViewById(R.id.f4Button);
        gameGrid[23] = f4Butt;
        f4Butt.setBackgroundResource(R.drawable.backone);
        f4Butt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonPress(23);
            }
        });
        g1Butt = (gridButton) findViewById(R.id.g1Button);
        gameGrid[24] = g1Butt;
        g1Butt.setBackgroundResource(R.drawable.backone);
        g1Butt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonPress(24);
            }
        });
        g2Butt = (gridButton) findViewById(R.id.g2Button);
        gameGrid[25] = g2Butt;
        g2Butt.setBackgroundResource(R.drawable.backone);
        g2Butt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonPress(25);
            }
        });
        g3Butt = (gridButton) findViewById(R.id.g3Button);
        gameGrid[26] = g3Butt;
        g3Butt.setBackgroundResource(R.drawable.backone);
        g3Butt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonPress(26);
            }
        });
        g4Butt = (gridButton) findViewById(R.id.g4Button);
        gameGrid[27] = g4Butt;
        g4Butt.setBackgroundResource(R.drawable.backone);
        g4Butt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonPress(27);
            }
        });
        h1Butt = (gridButton) findViewById(R.id.h1Button);
        gameGrid[28] = h1Butt;
        h1Butt.setBackgroundResource(R.drawable.backone);
        h1Butt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonPress(28);
            }
        });
        h2Butt = (gridButton) findViewById(R.id.h2Button);
        gameGrid[29] = h2Butt;
        h2Butt.setBackgroundResource(R.drawable.backone);
        h2Butt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonPress(29);
            }
        });
        h3Butt = (gridButton) findViewById(R.id.h3Button);
        gameGrid[30] = h3Butt;
        h3Butt.setBackgroundResource(R.drawable.backone);
        h3Butt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonPress(30);
            }
        });
        h4Butt = (gridButton) findViewById(R.id.h4Button);
        gameGrid[31] = h4Butt;
        h4Butt.setBackgroundResource(R.drawable.backone);
        h4Butt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonPress(31);
            }
        });



//        PlayerTurn();


        Context gameContext = getApplicationContext();
        initializeGame();

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

    public void initializeGame(){

        status = "init";
        this.runGameState(-1);

    }
    public String runGameState(int pressedCell){
//        Log.e(log_cat,"Entered runGameState method");
        allAttackPaths = new FoundPath[6];


        for (int l = 0; l<6 ; l++){
            allAttackPaths[l] = new FoundPath();
        }
        switch (this.status){
            case "init":
//                Log.e(log_cat,"runGameState initialized");
//                Toast.makeText(this.getApplicationContext(), "Player one place first piece", Toast.LENGTH_SHORT).show();
                player1TurnIndicator.setBackgroundResource(R.drawable.player_turn_on);
                player2TurnIndicator.setBackgroundResource(R.drawable.player_turn_off);
                p1t1HP.setBackgroundResource(R.drawable.t1empty_turn);
                this.initStatus = 1;
                this.status = "";
                break;
            case "btn_prs":
                //Log.e(log_cat, "Entered btn_prs switch case");
                if (initStatus < 7){
                    switch (this.initStatus){
                        case 1:
                            //Log.e(log_cat,"button pressed");
                            legalMove = gameGrid[pressedCell].inhabitCell(p1t1,pressedCell);
                            if(legalMove[0] == ""){
                                this.initStatus = 2;
                                this.status = "";
//                                Toast.makeText(this.getApplicationContext(),"Player two place first piece",Toast.LENGTH_SHORT).show();
                                player1TurnIndicator.setBackgroundResource(R.drawable.player_turn_off);
                                player2TurnIndicator.setBackgroundResource(R.drawable.player_turn_on);
                                p1t1HP.setBackgroundResource(R.drawable.swordp1);
                                p2t1HP.setBackgroundResource(R.drawable.t1empty_turn);
                            }
                            else{
                                this.status = "";
                                Toast.makeText(this.getApplicationContext(),legalMove[1],Toast.LENGTH_LONG).show();
                            }

                            break;
                        case 2:
                            legalMove = gameGrid[pressedCell].inhabitCell(p2t1,pressedCell);
                            if(legalMove[0] == ""){
                                this.initStatus = 3;
                                this.status = "";
//                                Toast.makeText(this.getApplicationContext(),"Player one place second piece",Toast.LENGTH_SHORT).show();
                                player1TurnIndicator.setBackgroundResource(R.drawable.player_turn_on);
                                player2TurnIndicator.setBackgroundResource(R.drawable.player_turn_off);
                                p2t1HP.setBackgroundResource(R.drawable.swordp1);
                                p1t2HP.setBackgroundResource(R.drawable.t2empty_turn);
                            }
                            else{
                                this.status = "";
                                Toast.makeText(this.getApplicationContext(),legalMove[1],Toast.LENGTH_LONG).show();
                            }

                            break;
                        case 3:
                            legalMove = gameGrid[pressedCell].inhabitCell(p1t2,pressedCell);
                            if(legalMove[0] == ""){
                                this.initStatus = 4;
                                this.status = "";
//                                Toast.makeText(this.getApplicationContext(),"Player two place second piece",Toast.LENGTH_SHORT).show();
                                player1TurnIndicator.setBackgroundResource(R.drawable.player_turn_off);
                                player2TurnIndicator.setBackgroundResource(R.drawable.player_turn_on);
                                p1t2HP.setBackgroundResource(R.drawable.bow_arrow_p1);
                                p2t2HP.setBackgroundResource(R.drawable.t2empty_turn);
                            }
                            else{
                                this.status = "";
                                Toast.makeText(this.getApplicationContext(),legalMove[1],Toast.LENGTH_LONG).show();
                            }
                            break;
                        case 4:
                            legalMove = gameGrid[pressedCell].inhabitCell(p2t2,pressedCell);
                            if(legalMove[0] == ""){
                                this.initStatus = 5;
                                this.status = "";
//                                Toast.makeText(this.getApplicationContext(),"Player one place third piece",Toast.LENGTH_SHORT).show();
                                player1TurnIndicator.setBackgroundResource(R.drawable.player_turn_on);
                                player2TurnIndicator.setBackgroundResource(R.drawable.player_turn_off);
                                p2t2HP.setBackgroundResource(R.drawable.bow_arrow_p1);
                                p1t3HP.setBackgroundResource(R.drawable.t3empty_turn);
                            }
                            else{
                                this.status = "";
                                Toast.makeText(this.getApplicationContext(),legalMove[1],Toast.LENGTH_LONG).show();
                            }
                            break;
                        case 5:
                            legalMove = gameGrid[pressedCell].inhabitCell(p1t3,pressedCell);
                            if(legalMove[0] == ""){
                                this.initStatus = 6;
                                this.status = "";
//                                Toast.makeText(this.getApplicationContext(),"Player two place third piece",Toast.LENGTH_SHORT).show();
                                player1TurnIndicator.setBackgroundResource(R.drawable.player_turn_off);
                                player2TurnIndicator.setBackgroundResource(R.drawable.player_turn_on);
                                p1t3HP.setBackgroundResource(R.drawable.seigep1);
                                p2t3HP.setBackgroundResource(R.drawable.t3empty_turn);

                            }
                            else{
                                this.status = "";
                                Toast.makeText(this.getApplicationContext(),legalMove[1],Toast.LENGTH_LONG).show();
                            }
                            break;
                        case 6:
                            legalMove = gameGrid[pressedCell].inhabitCell(p2t3,pressedCell);
                            if(legalMove[0] == ""){
                                this.initStatus = 7;
                                this.status = "";
                                //TODO make this toast say something appropriate
                                Toast.makeText(this.getApplicationContext(),"Start Game!!",Toast.LENGTH_SHORT).show();
                                playersInGame = new PlayerPiece[] {p1t1,p1t2,p1t3,p2t1,p2t2,p2t3};
                                player1TurnIndicator.setBackgroundResource(R.drawable.player_turn_on);
                                player2TurnIndicator.setBackgroundResource(R.drawable.player_turn_off);
                                updateHP();
                                p2t3HP.setBackgroundResource(R.drawable.seigep1);
                            }
                            else{
                                this.status = "";
                                Toast.makeText(this.getApplicationContext(),legalMove[1],Toast.LENGTH_SHORT).show();
                            }
                            break;
                    }
                }
                else {
                    //TODO fix popup window below and remove turnOnChoose
                    PlayerTurn(whichPlayerTurn);





//                    switch (this.trackPlayerTurn){
//                        case 1:
//                            break;
//                        case 2:
//                            break;
//                    }
                }
                break;
        }

        //Player 1 place piece one
        return null;


    }
    public void buttonPress(int pressedCell){
        status = "btn_prs";
//        Log.e(log_cat,"status = "+ status + " ; initStatus = " + initStatus+ " ; pressedCell = " + pressedCell);
        this.pressedCell = pressedCell;
        runGameState(pressedCell);
    }

    public void PlayerTurn(int whichPlayerTurn){

        switch (whichPlayerTurn){
            //Player 1 turn
            case 1:

                //Check to see that P1 is using correct side of the board
                if (pressedCell > (32/2)-1) {

                    //Executes if a player has been chosen for movement
                    if(moveToggle){
                        //TODO make this code a method
                        for (int j = 0; j<4; j++){
                            if (availableTiles[j] == pressedCell){
                                movingPlayer = gameGrid[originCellMoving].getPlayerPiece();
                                legalMove = gameGrid[pressedCell].inhabitCell(movingPlayer, pressedCell);
                                if(legalMove[0] == ""){
                                    gameGrid[originCellMoving].emptyCell();
                                    for(int k = 0; k <4 ; k++){
                                        if(availableTiles[k] != pressedCell && availableTiles[k]!= -1){
                                            gameGrid[availableTiles[k]].emptyCell();
                                            Log.e(log_cat,"k: " + k + ", corresponding tile: "+availableTiles[k]);
                                        }

                                    }
                                    moveToggle = false;
                                    nextPlayerTurn();

//                                Toast.makeText(this.getApplicationContext(),"Player two place third piece",Toast.LENGTH_SHORT).show();
                                } else{
                                    Toast.makeText(this.getApplicationContext(),legalMove[1],Toast.LENGTH_SHORT).show();
                                }
                            }
                        }

                        //Cancel moving player on a turn by clicking a second time on occupied cell.
                        if (pressedCell == originCellMoving){
                            for(int k = 0; k <4 ; k++){
                                if(availableTiles[k] != pressedCell && availableTiles[k]!= -1){
                                    gameGrid[availableTiles[k]].emptyCell();
                                    Log.e(log_cat,"k: " + k + ", corresponding tile: "+availableTiles[k]);
                                }

                            }
                            moveToggle = false;
                        }

                        //Executes if player has not been chosen for movement yet
                    }else{
                        if (gameGrid[this.pressedCell].isOccupied) {
//                            Toast.makeText(this.getApplicationContext(), "Functionality to move player not built yet.", Toast.LENGTH_SHORT).show();
                            availableTiles = checkMove(whichPlayerTurn,pressedCell);
                            showAvailableMoves(availableTiles,pressedCell);
                            moveToggle = true;
                            originCellMoving = pressedCell;
                        } else {
                            Intent intent = new Intent(this.getApplicationContext(), EmptyTilePress.class);
                            startActivityForResult(intent, 2);
                        }
                    }

//                    nextPlayerTurn();
                } else{
                Toast.makeText(this.getApplicationContext(), "This is not your side of the board.", Toast.LENGTH_SHORT).show();
                }
                break;

            //Player 2 turn


            case 2:
                if (pressedCell < (32/2)) {

                    //Executes if a player has been chosen for movement
                    if(moveToggle) {
                        //TODO make this code a method
                        for (int j = 0; j < 4; j++) {
                            if (availableTiles[j] == pressedCell) {
                                movingPlayer = gameGrid[originCellMoving].getPlayerPiece();
                                legalMove = gameGrid[pressedCell].inhabitCell(movingPlayer, pressedCell);
                                if (legalMove[0] == "") {
                                    gameGrid[originCellMoving].emptyCell();
                                    for (int k = 0; k < 4; k++) {
                                        if (availableTiles[k] != pressedCell && availableTiles[k] != -1) {
                                            gameGrid[availableTiles[k]].emptyCell();
                                            Log.e(log_cat, "k: " + k + ", corresponding tile: " + availableTiles[k]);
                                        }

                                    }
                                    moveToggle = false;
                                    nextPlayerTurn();

//                                Toast.makeText(this.getApplicationContext(),"Player two place third piece",Toast.LENGTH_SHORT).show();
                                } else {
                                    Toast.makeText(this.getApplicationContext(), legalMove[1], Toast.LENGTH_SHORT).show();
                                }
                            }
                        }
                        if (pressedCell == originCellMoving){
                            for(int k = 0; k <4 ; k++){
                                if(availableTiles[k] != pressedCell && availableTiles[k]!= -1){
                                    gameGrid[availableTiles[k]].emptyCell();
                                    Log.e(log_cat,"k: " + k + ", corresponding tile: "+availableTiles[k]);
                                }

                            }
                            moveToggle = false;
                        }
                    } else {
                        if (gameGrid[this.pressedCell].isOccupied) {
//                            Toast.makeText(this.getApplicationContext(), "Functionality to move player not built yet.", Toast.LENGTH_SHORT).show();
                            availableTiles = checkMove(whichPlayerTurn,pressedCell);
                            showAvailableMoves(availableTiles,pressedCell);
                            moveToggle = true;
                            originCellMoving = pressedCell;
                        } else {
                            Intent intent = new Intent(this.getApplicationContext(), EmptyTilePress.class);
                            startActivityForResult(intent, 2);
                        }
                    }

//                    nextPlayerTurn();
                } else{
                    Toast.makeText(this.getApplicationContext(), "This is not your side of the board.", Toast.LENGTH_SHORT).show();
                }
                break;

        }

    }



    protected void onActivityResult(int requestCode,int resultCode,Intent data){
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 2){
            if (data != null){
                int orientation = data.getIntExtra("Orientation",0);
//                Log.e(log_cat,"onActivityResult called.");
                if((orientation != 5)&&(orientation != gameGrid[pressedCell].getOrientation())){
                    gameGrid[this.pressedCell].setOrientation(orientation);
                    nextPlayerTurn();
                }else if(orientation == gameGrid[pressedCell].getOrientation()){

                }

            }

        }

//

    }

    public void nextPlayerTurn(){
        FoundPath foundPath = new FoundPath();
        if(whichPlayerTurn == 1){
            Log.e(log_cat,"Attempting to check path.");
            PathFind(whichPlayerTurn, playersInGame[0].getCoord(), playersInGame[0], foundPath, 0, -1);
            foundPath.resetVals();
            PathFind(whichPlayerTurn, playersInGame[1].getCoord(), playersInGame[1], foundPath, 0, -1);
            foundPath.resetVals();
            PathFind(whichPlayerTurn, playersInGame[2].getCoord(), playersInGame[2], foundPath, 0, -1);
            foundPath.resetVals();
        }else{
            PathFind(whichPlayerTurn,playersInGame[3].getCoord(),playersInGame[3],foundPath,0,-1);
            foundPath.resetVals();
            PathFind(whichPlayerTurn, playersInGame[4].getCoord(), playersInGame[4], foundPath, 0, -1);
            foundPath.resetVals();
            PathFind(whichPlayerTurn, playersInGame[5].getCoord(), playersInGame[5], foundPath, 0, -1);
            foundPath.resetVals();
        }

        if (movesUsedThisTurn < 1){
            movesUsedThisTurn++;
//            Log.e(log_cat,"Moves used this turn = " +movesUsedThisTurn);
        }
        else{
//            Log.e(log_cat,"Moves used this turn = " +movesUsedThisTurn);
            if (whichPlayerTurn == 1){
                whichPlayerTurn = 2;
                player1TurnIndicator.setBackgroundResource(R.drawable.player_turn_off);
                player2TurnIndicator.setBackgroundResource(R.drawable.player_turn_on);

            } else {
                whichPlayerTurn =1;
                player1TurnIndicator.setBackgroundResource(R.drawable.player_turn_on);
                player2TurnIndicator.setBackgroundResource(R.drawable.player_turn_off);
            }
            movesUsedThisTurn = 0;
//            Log.e(log_cat,"Moves used this turn = " +movesUsedThisTurn);

        }

    }

    public int[] checkMove(int playerIdentifier, int location){
        int[] out = {-1,-1,-1,-1};
        switch (playerIdentifier){
            case 1:
                if (location >19){
                    //Check above
                    check = gameGrid[location-4].isOccupied;
                    if(!check){
                        out[0] = location-4;
                    }else{
                        out[0] = -1;
                    }
                }
                if (location%4 != 0){
                    //Check left
                    check = gameGrid[location-1].isOccupied;
                    if(!check){
                        out[1] = location-1;
                    }else{
                        out[1] = -1;
                    }
                }
                if ((location-3)%4 != 0){
                    //Check right
                    check = gameGrid[location+1].isOccupied;
                    if(!check){
                        out[2] = location+1;
                    }else{
                        out[2] = -1;
                    }
                }
                if (location <28){
                    //check below
                    check = gameGrid[location+4].isOccupied;
                    if(!check){
                        out[3] = location+4;
                    }else{
                        out[3] = -1;
                    }
                }
                break;
            case 2:
                if (location >3){
                    //Check above
                    check = gameGrid[location-4].isOccupied;
                    if(!check){
                        out[0] = location-4;
                    }else{
                        out[0] = -1;
                    }
                }
                if (location%4 != 0){
                    //Check left
                    check = gameGrid[location-1].isOccupied;
                    if(!check){
                        out[1] = location-1;
                    }else{
                        out[1] = -1;
                    }
                }
                if ((location-3)%4 != 0){
                    //Check right
                    check = gameGrid[location+1].isOccupied;
                    if(!check){
                        out[2] = location+1;
                    }else{
                        out[2] = -1;
                    }
                }
                if (location <12){
                    //check below
                    check = gameGrid[location+4].isOccupied;
                    if(!check){
                        out[3] = location+4;
                    }else{
                        out[3] = -1;
                    }
                }
                break;

        }
        //out = {up, left, right, down}
        return out;
    }

    public void showAvailableMoves(int[] legals, int location){

        //legals = {up, left, right, down}
        if (legals[0] != -1){
            gameGrid[location-4].setBackgroundResource(R.drawable.available_tile);
        }
        if (legals[1] != -1){
            gameGrid[location-1].setBackgroundResource(R.drawable.available_tile);
        }
        if (legals[2] != -1){
            gameGrid[location+1].setBackgroundResource(R.drawable.available_tile);
        }
        if (legals[3] != -1){
            gameGrid[location+4].setBackgroundResource(R.drawable.available_tile);
        }

    }

    public void PathFind(int whichPlayerTurn, int originCell,PlayerPiece originPlayerPiece,FoundPath pathFound,int attackPathIndex,int cellFrom){
        PlayerPiece foundPlayer;
        if(originCell == -1){

        }else{
            Log.e(log_cat,"Current cell: " +Integer.toString(originCell));
            //Check above
            if (originCell > 3){
                Log.e(log_cat,"Checking above " + Integer.toString(originCell));
                if (gameGrid[originCell-4].isOccupied){
                    Log.e(log_cat,"Found another PlayerPiece.");
                    foundPlayer = gameGrid[originCell-4].getPlayerPiece();
                    if (foundPlayer.p1p2 != originPlayerPiece.p1p2){
//                    attackPaths[attackPathIndex].setCells(pathFound.getCells());
//                    attackPathIndex++;
                        Toast.makeText(this.getApplicationContext(), "Attack Possible now!", Toast.LENGTH_SHORT).show();
                        //TODO add attack function
                        attackNow(pathFound,originPlayerPiece,gameGrid[originCell-4].getPlayerPiece());

                    }
                }
                else {
                    if(originCell == originPlayerPiece.getCoord()){
                        Log.e(log_cat,"Adding the cell " + Integer.toString(originCell-4)+ " to the path.");
                        pathFound.next(originCell-4);
                        PathFind(whichPlayerTurn, (originCell - 4), originPlayerPiece, pathFound,attackPathIndex,originCell);
                    }else{
                        if (CanIMove(gameGrid[originCell].getOrientation(),gameGrid[originCell-4].getOrientation())&& (originCell-4) != cellFrom){
                            Log.e(log_cat,"Adding the cell " + Integer.toString(originCell-4)+ " to the path.");
                            pathFound.next(originCell-4);
                            PathFind(whichPlayerTurn, (originCell - 4), originPlayerPiece, pathFound,attackPathIndex,originCell);
                        }
                    }

                }
            }
            //Check right
            if ((originCell-3)%4 != 0){
                Log.e(log_cat, "Checking right of " + Integer.toString(originCell));
                if (gameGrid[originCell+1].isOccupied){
                    Log.e(log_cat,"Found another PlayerPiece.");
                    foundPlayer = gameGrid[originCell+1].getPlayerPiece();
                    if (foundPlayer.p1p2 != originPlayerPiece.p1p2){
//                    attackPaths[attackPathIndex].setCells(pathFound.getCells());
//                    attackPathIndex++;
                        Toast.makeText(this.getApplicationContext(), "Attack Possible now!", Toast.LENGTH_SHORT).show();
                        //TODO add attack function
                        attackNow(pathFound,originPlayerPiece,gameGrid[originCell+1].getPlayerPiece());

                    }
                }
                else {
                    if (originCell == originPlayerPiece.getCoord()){
                        Log.e(log_cat,"Adding the cell " + Integer.toString(originCell+1)+ " to the path.");
                        pathFound.next(originCell+1);
                        PathFind(whichPlayerTurn,(originCell+1),originPlayerPiece,pathFound, attackPathIndex,originCell);
                    } else {
                        if (CanIMove(gameGrid[originCell].getOrientation(),gameGrid[originCell+1].getOrientation())&& (originCell+1) != cellFrom){
                            Log.e(log_cat,"Adding the cell " + Integer.toString(originCell+1)+ " to the path.");
                            pathFound.next(originCell+1);
                            PathFind(whichPlayerTurn,(originCell+1),originPlayerPiece,pathFound, attackPathIndex,originCell);
                        }
                    }

                }
            }
            //Check below
            if (originCell < 28){
                Log.e(log_cat, "Checking below " + Integer.toString(originCell));
                if (gameGrid[originCell+4].isOccupied){
                    Log.e(log_cat,"Found another PlayerPiece.");
                    foundPlayer = gameGrid[originCell+4].getPlayerPiece();
                    if (foundPlayer.p1p2 != originPlayerPiece.p1p2){
//                    attackPaths[attackPathIndex].setCells(pathFound.getCells());
//                    attackPathIndex++;
                        Toast.makeText(this.getApplicationContext(), "Attack Possible now!", Toast.LENGTH_SHORT).show();
                        //TODO add attack function
                        attackNow(pathFound,originPlayerPiece,gameGrid[originCell+4].getPlayerPiece());

                    }
                }
                else {
                    if (originCell == originPlayerPiece.getCoord()){
                        Log.e(log_cat,"Adding the cell " + Integer.toString(originCell+4)+ " to the path.");
                        pathFound.next(originCell+4);
                        PathFind(whichPlayerTurn,(originCell+4),originPlayerPiece,pathFound, attackPathIndex,originCell);
                    } else{
                        if (CanIMove(gameGrid[originCell].getOrientation(),gameGrid[originCell+4].getOrientation())&& (originCell+4) != cellFrom){
                            Log.e(log_cat,"Adding the cell " + Integer.toString(originCell+4)+ " to the path.");
                            pathFound.next(originCell+4);
                            PathFind(whichPlayerTurn,(originCell+4),originPlayerPiece,pathFound, attackPathIndex,originCell);
                        }
                    }

                }
            }
            //Check left
            if (originCell%4 != 0){
                Log.e(log_cat, "Checking left of " + Integer.toString(originCell));
                if (gameGrid[originCell-1].isOccupied){
                    Log.e(log_cat,"Found another PlayerPiece.");
                    foundPlayer = gameGrid[originCell-1].getPlayerPiece();
                    if (foundPlayer.p1p2 != originPlayerPiece.p1p2){
//                    attackPaths[attackPathIndex].setCells(pathFound.getCells());
//                    attackPathIndex++;
                        Toast.makeText(this.getApplicationContext(), "Attack Possible now!", Toast.LENGTH_SHORT).show();
                        //TODO add attack function
                        attackNow(pathFound,originPlayerPiece,gameGrid[originCell-1].getPlayerPiece());
                    }
                }
                else {
                    if (originCell == originPlayerPiece.getCoord()){
                        Log.e(log_cat,"Adding the cell " + Integer.toString(originCell-1)+ " to the path.");
                        pathFound.next(originCell-1);
                        PathFind(whichPlayerTurn,(originCell-1),originPlayerPiece,pathFound, attackPathIndex,originCell);
                    } else {
                        if (CanIMove(gameGrid[originCell].getOrientation(),gameGrid[originCell-1].getOrientation())&& (originCell-1) != cellFrom){
                            Log.e(log_cat,"Adding the cell " + Integer.toString(originCell-1)+ " to the path.");
                            pathFound.next(originCell-1);
                            PathFind(whichPlayerTurn,(originCell-1),originPlayerPiece,pathFound, attackPathIndex,originCell);
                        }
                    }

                }
            }
            if (originCell == originPlayerPiece.getCoord()){
                Log.e(log_cat,"Finished checking for attacks from this position.");
            }else{
                pathFound.deleteLast();
                Log.e(log_cat, "Deleting cell: " + Integer.toString(originCell));
            }
        }

    }
    public void attackNow(FoundPath pathFound, PlayerPiece attacker, PlayerPiece beingAttacked){
        //TODO add for loop to change tiles on pathFound to whatever color
        int mortality;
        IlluminatePath(pathFound);
        double distance = (double) pathFound.getLength();
        int attackDamage;
        double defaultDamage = 10;
        switch (attacker.getType()) {
            //TODO add specific attack damages per PlayerPiece type
            case "close":
//                switch (beingAttacked.getType()){
//                    case "close":
//                        break;
//                    case "mounted":
//                        break;
//                    case "ranged":
//                        break;
//                }
                attackDamage = (int) ((1/distance)*defaultDamage);
                beingAttacked.inflictDamage(attackDamage);
                break;
            case "mounted":
                beingAttacked.inflictDamage(5);
                break;
            case "ranged":
                attackDamage = (int)((distance/10)*defaultDamage);
                beingAttacked.inflictDamage(attackDamage);
                break;
        }
        mortality = beingAttacked.getHP();
        if (mortality<1){
            gameGrid[beingAttacked.getCoord()].killPlayer();
        }
        updateHP();
        //Changes pathFound tiles to orientation 1
        resetPath(pathFound);

    }

    public void IlluminatePath(FoundPath pathFound){
        final Handler handler = new Handler();
        int delay = 0;

        for (int e = 0; e< pathFound.getLength();e++){
            final int useThis = pathFound.getCell(e);
            delay = delay +200;
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    gameGrid[useThis].illuminate();
                }
            },delay);

            //TODO make this happen sequentially
//            wait(1000);
        }
    }

    public void resetPath(FoundPath pathFound){
        final Handler handler = new Handler();
        int delay = pathFound.getLength()*200 +100;

        for (int e = 0; e< pathFound.getLength();e++){
            final int useThis = pathFound.getCell(e);
            delay = delay +200;
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    gameGrid[useThis].setOrientation(1);
                }
            },delay);


        }
    }


    public boolean CanIMove(int from, int to){
        boolean result = false;
        switch (from){
            case 1:
                if (to == 3){
                    result = true;
                    Log.e(log_cat,"I found a tile with the correct orientation!");
                }
                break;
            case 2:
                if (to == 4){
                    result = true;
                    Log.e(log_cat,"I found a tile with the correct orientation!");
                }
                break;
            case 3:
                if (to == 1){
                    result = true;
                    Log.e(log_cat,"I found a tile with the correct orientation!");
                }
                break;
            case 4:
                if (to == 2){
                    result = true;
                    Log.e(log_cat,"I found a tile with the correct orientation!");
                }
                break;
        }
        return result;
    }

    public void updateHP(){
        p1t1HP.setText(Integer.toString(p1t1.getHP()));
        p1t2HP.setText(Integer.toString(p1t2.getHP()));
        p1t3HP.setText(Integer.toString(p1t3.getHP()));
        p2t1HP.setText(Integer.toString(p2t1.getHP()));
        p2t2HP.setText(Integer.toString(p2t2.getHP()));
        p2t3HP.setText(Integer.toString(p2t3.getHP()));

    }


//
}
