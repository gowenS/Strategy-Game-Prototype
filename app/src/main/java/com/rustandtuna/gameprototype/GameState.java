package com.rustandtuna.gameprototype;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
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
    public PopupWindow p1turn;
    private LayoutInflater layoutInflater;
    LinearLayout now;



    public GameState() {
        gameGrid = new gridButton[50];

    }

    public void initializeGame(gridButton[] gameGrid, Context gameContext){
        this.gameGrid = gameGrid;
        this.context = gameContext;

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
                    //TODO fix popup window below
//                    layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//                    ViewGroup container = (ViewGroup) layoutInflater.inflate(R.layout.push_empty_btn,);
//                    now = (LinearLayout) container.findViewById(R.id.parent_for_emptybtn);
//                    p1turn = new PopupWindow(container,500,500);
//                    p1turn.showAtLocation(now, Gravity.NO_GRAVITY,500,500);

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
}
