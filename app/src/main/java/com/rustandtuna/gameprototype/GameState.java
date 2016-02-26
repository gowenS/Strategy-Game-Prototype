package com.rustandtuna.gameprototype;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by Sean on 2/18/2016.
 */
public class GameState {
    public String log_cat = "GameState";
    final String type1 = "close";
    final String type2 = "mounted";
    final String type3 = "ranged";
    gridButton[] gameGrid;
    String status = "";
    Context context;
    int initStatus = 0;
    int trackPlayerTurn = 1;
    String[] legalMove = new String[2];
    Activity activity;



    public GameState() {
        gameGrid = new gridButton[50];

    }

    public void initializeGame(gridButton[] gameGrid, Context gameContext){
        this.gameGrid = gameGrid;
        this.context = gameContext;
//        setContentView(R.layout.activity_main);


        status = "init";
        this.runGameState(-1);

    }

    public String runGameState(int pressedCell){
//        Log.e(log_cat,"Entered runGameState method");
        switch (this.status){
            case "init":
//                Log.e(log_cat,"runGameState initialized");
                Toast.makeText(context,"Player one place first piece",Toast.LENGTH_LONG).show();
                this.initStatus = 1;
                this.status = "";
                break;
            case "btn_prs":
                //Log.e(log_cat, "Entered btn_prs switch case");
                if (initStatus < 7){
                    switch (this.initStatus){
                        case 1:
                            //Log.e(log_cat,"button pressed");
                            PlayerPiece p1t1 = new PlayerPiece(1,"close");
                            legalMove = gameGrid[pressedCell].inhabitCell(p1t1,pressedCell);
                            if(legalMove[0] == ""){
                                this.initStatus = 2;
                                this.status = "";
                                Toast.makeText(context,"Player two place first piece",Toast.LENGTH_SHORT).show();
                            }
                            else{
                                this.status = "";
                                Toast.makeText(context,legalMove[1],Toast.LENGTH_LONG).show();
                            }

                            break;
                        case 2:
                            PlayerPiece p2t1 = new PlayerPiece(2,"close");
                            legalMove = gameGrid[pressedCell].inhabitCell(p2t1,pressedCell);
                            if(legalMove[0] == ""){
                                this.initStatus = 3;
                                this.status = "";
                                Toast.makeText(context,"Player one place second piece",Toast.LENGTH_SHORT).show();
                            }
                            else{
                                this.status = "";
                                Toast.makeText(context,legalMove[1],Toast.LENGTH_LONG).show();
                            }

                            break;
                        case 3:
                            PlayerPiece p1t2 = new PlayerPiece(1,"mounted");
                            legalMove = gameGrid[pressedCell].inhabitCell(p1t2,pressedCell);
                            if(legalMove[0] == ""){
                                this.initStatus = 4;
                                this.status = "";
                                Toast.makeText(context,"Player two place second piece",Toast.LENGTH_SHORT).show();
                            }
                            else{
                                this.status = "";
                                Toast.makeText(context,legalMove[1],Toast.LENGTH_LONG).show();
                            }
                            break;
                        case 4:
                            PlayerPiece p2t2 = new PlayerPiece(2,"mounted");
                            legalMove = gameGrid[pressedCell].inhabitCell(p2t2,pressedCell);
                            if(legalMove[0] == ""){
                                this.initStatus = 5;
                                this.status = "";
                                Toast.makeText(context,"Player one place third piece",Toast.LENGTH_SHORT).show();
                            }
                            else{
                                this.status = "";
                                Toast.makeText(context,legalMove[1],Toast.LENGTH_LONG).show();
                            }
                            break;
                        case 5:
                            PlayerPiece p1t3 = new PlayerPiece(1,"ranged");
                            legalMove = gameGrid[pressedCell].inhabitCell(p1t3,pressedCell);
                            if(legalMove[0] == ""){
                                this.initStatus = 6;
                                this.status = "";
                                Toast.makeText(context,"Player two place third piece",Toast.LENGTH_SHORT).show();
                            }
                            else{
                                this.status = "";
                                Toast.makeText(context,legalMove[1],Toast.LENGTH_LONG).show();
                            }
                            break;
                        case 6:
                            PlayerPiece p2t3 = new PlayerPiece(2,"ranged");
                            legalMove = gameGrid[pressedCell].inhabitCell(p2t3,pressedCell);
                            if(legalMove[0] == ""){
                                this.initStatus = 7;
                                this.status = "";
                                //TODO make this toast say something appropriate
                                Toast.makeText(context,"Start Game!!",Toast.LENGTH_LONG).show();
                            }
                            else{
                                this.status = "";
                                Toast.makeText(context,legalMove[1],Toast.LENGTH_LONG).show();
                            }
                            break;
                    }
                }
                else {
                    //TODO fix popup window below'
                    PlayerTurn();
                    gameGrid[pressedCell].setOrientation(EmptyTilePress.ButtonPressed);


                    switch (this.trackPlayerTurn){
                        case 1:
                            break;
                        case 2:
                            break;
                    }
                }
                break;
        }

        //Player 1 place piece one
        return null;


    }

    public void buttonPress(int pressedCell){
        this.status = "btn_prs";
//        Log.e(log_cat,"status = "+ status + " ; initStatus = " + initStatus+ " ; pressedCell = " + pressedCell);
        this.runGameState(pressedCell);

    }
    public void PlayerTurn(){

        Intent intent = new Intent(context,EmptyTilePress.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);


    }
}
