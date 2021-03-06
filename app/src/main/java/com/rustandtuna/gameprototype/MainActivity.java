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

import java.util.Arrays;

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

    Integer[] viewCollection = {R.id.a1Button, R.id.a2Button, R.id.a3Button, R.id.a4Button,
        R.id.b1Button, R.id.b2Button, R.id.b3Button, R.id.b4Button,
        R.id.c1Button, R.id.c2Button, R.id.c3Button, R.id.c4Button,
        R.id.d1Button, R.id.d2Button, R.id.d3Button, R.id.d4Button,
        R.id.e1Button, R.id.e2Button, R.id.e3Button, R.id.e4Button,
        R.id.f1Button, R.id.f2Button, R.id.f3Button, R.id.f4Button,
        R.id.g1Button, R.id.g2Button, R.id.g3Button, R.id.g4Button,
        R.id.h1Button, R.id.h2Button, R.id.h3Button, R.id.h4Button};


    gridButton[] gameGrid = new gridButton[32] ;
    boolean turnOnChoose = false;
    public PopupWindow playerTurnPopup;
    LinearLayout popupLayout;
    int pressedCell;
    int whichPlayerTurn = 1;
    int movesUsedThisTurn = 0;
    ImageView player1Turn1Indicator;
    ImageView player2Turn1Indicator;
    ImageView player1Turn2Indicator;
    ImageView player2Turn2Indicator;
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
    boolean[] visited = new boolean[32];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //gameGrid sorts the items from left to right so that row one is {1,2,3,4,5...}

        player1Turn1Indicator = (ImageView) findViewById(R.id.player1Turn1Indicator);
        player2Turn1Indicator = (ImageView) findViewById(R.id.player2Turn1Indicator);
        player1Turn2Indicator = (ImageView) findViewById(R.id.player1Turn2Indicator);
        player2Turn2Indicator = (ImageView) findViewById(R.id.player2Turn2Indicator);
        p1t1HP = (TextView) findViewById(R.id.p1t1HP);
        p1t2HP = (TextView) findViewById(R.id.p1t2HP);
        p1t3HP = (TextView) findViewById(R.id.p1t3HP);
        p2t1HP = (TextView) findViewById(R.id.p2t1HP);
        p2t2HP = (TextView) findViewById(R.id.p2t2HP);
        p2t3HP = (TextView) findViewById(R.id.p2t3HP);

        for(int m = 0; m < 32; m++){
            gameGrid[m] = (gridButton) findViewById(viewCollection[m]);
            gameGrid[m].setBackgroundResource(R.drawable.backone);
            final int now = m;
            gameGrid[m].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    buttonPress(now);
                }
            });
        }


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
        allAttackPaths = new FoundPath[6];

        for (int l = 0; l<6 ; l++){
            allAttackPaths[l] = new FoundPath();
        }

        switch (this.status){
            case "init":
                player1Turn1Indicator.setBackgroundResource(R.drawable.player_turn_on);
                player2Turn1Indicator.setBackgroundResource(R.drawable.player_turn_off);
                player1Turn2Indicator.setBackgroundResource(R.drawable.player_turn_on);
                player2Turn2Indicator.setBackgroundResource(R.drawable.player_turn_off);
                p1t1HP.setBackgroundResource(R.drawable.t1empty_turn);
                this.initStatus = 1;
                this.status = "";
                break;
            case "btn_prs":

                if (initStatus < 7){
                    switch (this.initStatus){
                        case 1:
                            legalMove = gameGrid[pressedCell].inhabitCell(p1t1,pressedCell);
                            if(legalMove[0] == ""){
                                this.initStatus = 2;
                                this.status = "";
                                player1Turn1Indicator.setBackgroundResource(R.drawable.player_turn_off);
                                player1Turn2Indicator.setBackgroundResource(R.drawable.player_turn_off);
                                player2Turn1Indicator.setBackgroundResource(R.drawable.player_turn_on);
                                player2Turn2Indicator.setBackgroundResource(R.drawable.player_turn_on);
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
                                player1Turn1Indicator.setBackgroundResource(R.drawable.player_turn_on);
                                player1Turn2Indicator.setBackgroundResource(R.drawable.player_turn_on);
                                player2Turn1Indicator.setBackgroundResource(R.drawable.player_turn_off);
                                player2Turn2Indicator.setBackgroundResource(R.drawable.player_turn_off);
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
                                player1Turn1Indicator.setBackgroundResource(R.drawable.player_turn_off);
                                player1Turn2Indicator.setBackgroundResource(R.drawable.player_turn_off);
                                player2Turn1Indicator.setBackgroundResource(R.drawable.player_turn_on);
                                player2Turn2Indicator.setBackgroundResource(R.drawable.player_turn_on);
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
                                player1Turn1Indicator.setBackgroundResource(R.drawable.player_turn_on);
                                player1Turn2Indicator.setBackgroundResource(R.drawable.player_turn_on);
                                player2Turn1Indicator.setBackgroundResource(R.drawable.player_turn_off);
                                player2Turn2Indicator.setBackgroundResource(R.drawable.player_turn_off);
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
                                player1Turn1Indicator.setBackgroundResource(R.drawable.player_turn_off);
                                player1Turn2Indicator.setBackgroundResource(R.drawable.player_turn_off);
                                player2Turn1Indicator.setBackgroundResource(R.drawable.player_turn_on);
                                player2Turn2Indicator.setBackgroundResource(R.drawable.player_turn_on);
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
                                Toast.makeText(this.getApplicationContext(),"Start Game",Toast.LENGTH_SHORT).show();
                                playersInGame = new PlayerPiece[] {p1t1,p1t2,p1t3,p2t1,p2t2,p2t3};
                                player1Turn1Indicator.setBackgroundResource(R.drawable.player_turn_on);
                                player1Turn2Indicator.setBackgroundResource(R.drawable.player_turn_on);
                                player2Turn1Indicator.setBackgroundResource(R.drawable.player_turn_off);
                                player2Turn2Indicator.setBackgroundResource(R.drawable.player_turn_off);
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
                    PlayerTurn(whichPlayerTurn);

                }
                break;
        }

        //Player 1 place piece one
        return null;
    }

    public void buttonPress(int pressedCell){
        status = "btn_prs";
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
                        moveMe();
                    //Executes if player has not yet been chosen for movement;
                    }else{
                        if (gameGrid[this.pressedCell].isOccupied) {
                            availableTiles = checkMove(whichPlayerTurn,pressedCell);
                            showAvailableMoves(availableTiles,pressedCell);
                            moveToggle = true;
                            originCellMoving = pressedCell;
                        } else {
                            Intent intent = new Intent(this.getApplicationContext(), EmptyTilePress.class);
                            intent.putExtra("PlayerTurn", 1);
                            intent.putExtra("curOrnt", gameGrid[pressedCell].getOrientation());
                            startActivityForResult(intent, 2);
                        }
                    }


                } else{
                Toast.makeText(this.getApplicationContext(), "This is not your side of the board.", Toast.LENGTH_SHORT).show();
                }
                break;

            //Player 2 turn
            case 2:
                if (pressedCell < (32/2)) {

                    //Executes if a player has been chosen for movement
                    if(moveToggle) {
                        moveMe();

                    } else {
                        if (gameGrid[this.pressedCell].isOccupied) {
                            availableTiles = checkMove(whichPlayerTurn,pressedCell);
                            showAvailableMoves(availableTiles,pressedCell);
                            moveToggle = true;
                            originCellMoving = pressedCell;
                        } else {
                            Intent intent = new Intent(this.getApplicationContext(), EmptyTilePress.class);
                            intent.putExtra("PlayerTurn", 2);
                            intent.putExtra("curOrnt", gameGrid[pressedCell].getOrientation());
                            startActivityForResult(intent, 2);
                        }
                    }


                } else{
                    Toast.makeText(this.getApplicationContext(), "This is not your side of the board.", Toast.LENGTH_SHORT).show();
                }
                break;

        }

    }

    public void moveMe() {

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

    }



    protected void onActivityResult(int requestCode,int resultCode,Intent data){
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 2){
            if (data != null){
                int orientation = data.getIntExtra("Orientation",0);
                if((orientation != 5)&&(orientation != gameGrid[pressedCell].getOrientation())){
                    gameGrid[this.pressedCell].setOrientation(orientation);
                    nextPlayerTurn();
                }else if(orientation == gameGrid[pressedCell].getOrientation()){

                }

            }

        }

    }

    public void nextPlayerTurn(){
        FoundPath foundPath = new FoundPath();
        resetVisited();
        if(whichPlayerTurn == 1){
            Log.e(log_cat,"Attempting to check path.");
            PathFind(whichPlayerTurn, playersInGame[0].getCoord(), playersInGame[0], foundPath, 0, -1);
            foundPath.resetVals();
            resetVisited();
            PathFind(whichPlayerTurn, playersInGame[1].getCoord(), playersInGame[1], foundPath, 0, -1);
            foundPath.resetVals();
            resetVisited();
            PathFind(whichPlayerTurn, playersInGame[2].getCoord(), playersInGame[2], foundPath, 0, -1);
            foundPath.resetVals();
            resetVisited();
        }else{
            PathFind(whichPlayerTurn,playersInGame[3].getCoord(),playersInGame[3],foundPath,0,-1);
            foundPath.resetVals();
            resetVisited();
            PathFind(whichPlayerTurn, playersInGame[4].getCoord(), playersInGame[4], foundPath, 0, -1);
            foundPath.resetVals();
            resetVisited();
            PathFind(whichPlayerTurn, playersInGame[5].getCoord(), playersInGame[5], foundPath, 0, -1);
            foundPath.resetVals();
            resetVisited();
        }

        if (movesUsedThisTurn < 1){
            movesUsedThisTurn++;
            player1Turn2Indicator.setBackgroundResource(R.drawable.player_turn_off);
            player2Turn2Indicator.setBackgroundResource(R.drawable.player_turn_off);


        }
        else{

            if (whichPlayerTurn == 1){
                whichPlayerTurn = 2;
                player1Turn1Indicator.setBackgroundResource(R.drawable.player_turn_off);
                player1Turn2Indicator.setBackgroundResource(R.drawable.player_turn_off);
                player2Turn1Indicator.setBackgroundResource(R.drawable.player_turn_on);
                player2Turn2Indicator.setBackgroundResource(R.drawable.player_turn_on);

            } else {
                whichPlayerTurn =1;
                player1Turn1Indicator.setBackgroundResource(R.drawable.player_turn_on);
                player1Turn2Indicator.setBackgroundResource(R.drawable.player_turn_on);
                player2Turn1Indicator.setBackgroundResource(R.drawable.player_turn_off);
                player2Turn2Indicator.setBackgroundResource(R.drawable.player_turn_off);
            }
            movesUsedThisTurn = 0;

        }

    }

    public void resetVisited() { Arrays.fill(visited, false); }


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
            visited[originCell] = true;
            //Check above
            if (originCell > 3){  //Top row doesn't need check above
                Log.e(log_cat,"Checking above " + Integer.toString(originCell));
                if (gameGrid[originCell-4].isOccupied){
                    Log.e(log_cat,"Found another PlayerPiece.");
                    foundPlayer = gameGrid[originCell-4].getPlayerPiece();
                    if (foundPlayer.p1p2 != originPlayerPiece.p1p2){

                        attackNow(pathFound,originPlayerPiece,gameGrid[originCell-4].getPlayerPiece());

                    }
                }
                else {
                    if (!visited[originCell - 4]){  //Avoid cycles by only visiting each cell once
                        if(originCell == originPlayerPiece.getCoord()){  //Player pieces can move to any empty adjacent cell on their side of the board.
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
            }
            //Check right
            if ((originCell-3)%4 != 0){
                Log.e(log_cat, "Checking right of " + Integer.toString(originCell));
                if (gameGrid[originCell+1].isOccupied){
                    Log.e(log_cat,"Found another PlayerPiece.");
                    foundPlayer = gameGrid[originCell+1].getPlayerPiece();
                    if (foundPlayer.p1p2 != originPlayerPiece.p1p2){

                        Toast.makeText(this.getApplicationContext(), "Attack Possible now!", Toast.LENGTH_SHORT).show();
                        attackNow(pathFound,originPlayerPiece,gameGrid[originCell+1].getPlayerPiece());

                    }
                }
                else {
                    if (!visited[originCell + 1]){  //Avoid cycles by only visiting each cell once
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
            }
            //Check below
            if (originCell < 28){  //Can't check below the last row
                Log.e(log_cat, "Checking below " + Integer.toString(originCell));
                if (gameGrid[originCell+4].isOccupied){
                    Log.e(log_cat,"Found another PlayerPiece.");
                    foundPlayer = gameGrid[originCell+4].getPlayerPiece();
                    if (foundPlayer.p1p2 != originPlayerPiece.p1p2){

                        Toast.makeText(this.getApplicationContext(), "Attack Possible now!", Toast.LENGTH_SHORT).show();
                        attackNow(pathFound,originPlayerPiece,gameGrid[originCell+4].getPlayerPiece());

                    }
                }
                else {
                    if (!visited[originCell + 4]) {  //Avoid cycles by only visiting each cell once
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
                        attackNow(pathFound,originPlayerPiece,gameGrid[originCell-1].getPlayerPiece());
                    }
                }
                else {
                    if (!visited[originCell - 1]){  //Avoid cycles by only visiting each cell once
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

            case "close":
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
}