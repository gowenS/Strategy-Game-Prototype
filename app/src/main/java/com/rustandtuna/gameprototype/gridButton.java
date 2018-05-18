package com.rustandtuna.gameprototype;


import android.content.Context;
import android.util.AttributeSet;

/**
 * Created by Sean on 2/18/2016.
 */
public class gridButton extends android.support.v7.widget.AppCompatImageButton{
    int orientation  = 1;
    boolean isOccupied;
    PlayerPiece playerPiece = null;
    int p1p2;
    int numberBoardPieces = 32;



    public gridButton(Context context) {
        super(context);
    }

    public gridButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public gridButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }



    public int getOrientation() {
        return orientation;
    }
    public void setOrientation(int orientation) {
//        int orientNow = this.getOrientation();
//        if(orientNow == orientation){
//            //TODO build error catcher here
//        }

        if(orientation > 0 && orientation < 5){
            this.orientation = orientation;
        }
        this.updateBackground(orientation);
        //TODO write this code to throw exception when given a number outside of legal range

    }

    public String[] inhabitCell(PlayerPiece playerPiece, int thisCoord){

        String[] out = new String[2];
        this.setPlayerPiece(playerPiece);
        this.p1p2 = playerPiece.getP1P2();

        //Check if this is spot is taken already
        if(this.isOccupied){
            out[0] = "error";
            out[1] = "This spot is already taken. Find your own.";
            return out;
        }
        else{

            //Check if this unit is on the right side of the board
            //TODO Add functionality for close units to move on other side of board
            if ((p1p2 == 1 && thisCoord >= (numberBoardPieces/2))||(p1p2 == 2 && thisCoord < ((numberBoardPieces/2))) ){
                this.isOccupied = true;
                playerPiece.setCoord(thisCoord);
                this.updateBackground(orientation);
                out[0] = "";
                out[1] = "legal move";
                return out;
            }
            else{
                out[0] = "error";
                out[1] = "Player units must remain on their own side";
                return out;
            }
        }

    }

    public void emptyCell(){
        this.isOccupied = false;
        this.playerPiece = null;
        switch (this.orientation){
            case 1:
                this.setBackgroundResource(R.drawable.backone);
                break;
            case 2:
                this.setBackgroundResource(R.drawable.backtwo);
                break;
            case 3:
                this.setBackgroundResource(R.drawable.backthree);
                break;
            case 4:
                this.setBackgroundResource(R.drawable.backfour);
                break;
        }
    }

    public void killPlayer(){
        this.isOccupied = false;
        this.playerPiece.setCoord(-1);
        this.playerPiece = null;
        switch (this.orientation){
            case 1:
                this.setBackgroundResource(R.drawable.backone);
                break;
            case 2:
                this.setBackgroundResource(R.drawable.backtwo);
                break;
            case 3:
                this.setBackgroundResource(R.drawable.backthree);
                break;
            case 4:
                this.setBackgroundResource(R.drawable.backfour);
                break;
        }
    }

//    public void pressMe(){
//        if(orientation < 4){
//            orientation++;
//        }
//        else{
//            orientation = 1;
//        }
//        this.updateBackground(orientation);
//    }

    public void updateBackground(int orientation){
        if(this.isOccupied){
            String type = playerPiece.getType();
            int whichPlayer = playerPiece.getP1P2();
            switch (type) {
                case "ranged":
                    switch (whichPlayer) {
                        case 1:
                            this.setBackgroundResource(R.drawable.backonet3);
                            break;
                        case 2:
                            this.setBackgroundResource(R.drawable.backonet3p2);
                            break;
                    }
                    //switch below is for displaying different orientations for player pieces
//                    switch (orientation){
//                        case 1:
//                            this.setBackgroundResource(R.drawable.backonet3);
//                            break;
//                        case 2:
//                            this.setBackgroundResource(R.drawable.backtwot3);
//                            break;
//                        case 3:
//                            this.setBackgroundResource(R.drawable.backthreet3);
//                            break;
//                        case 4:
//                            this.setBackgroundResource(R.drawable.backfourt3);
//                            break;
//                    }
                    break;
                case "mounted":
                    switch (whichPlayer) {
                        case 1:
                            this.setBackgroundResource(R.drawable.backonet2);
                            break;
                        case 2:
                            this.setBackgroundResource(R.drawable.backonet2p2);
                            break;
                    }

//                    switch (orientation){
//                        case 1:
//                            this.setBackgroundResource(R.drawable.backonet2);
//                            break;
//                        case 2:
//                            this.setBackgroundResource(R.drawable.backtwot2);
//                            break;
//                        case 3:
//                            this.setBackgroundResource(R.drawable.backthreet2);
//                            break;
//                        case 4:
//                            this.setBackgroundResource(R.drawable.backfourt2);
//                            break;
//                    }
                    break;
                case "close":
                    switch (whichPlayer) {
                        case 1:
                            this.setBackgroundResource(R.drawable.backonet1);
                            break;
                        case 2:
                            this.setBackgroundResource(R.drawable.backonet1p2);
                            break;
                    }
//                    switch (orientation){
//                        case 1:
//                            this.setBackgroundResource(R.drawable.backonet1);
//                            break;
//                        case 2:
//                            this.setBackgroundResource(R.drawable.backtwot1);
//                            break;
//                        case 3:
//                            this.setBackgroundResource(R.drawable.backthreet1);
//                            break;
//                        case 4:
//                            this.setBackgroundResource(R.drawable.backfourt1);
//                            break;
//                    }
                    break;
            }


        }
        else{
            switch (orientation){
                case 1:
                    this.setBackgroundResource(R.drawable.backone);
                    break;
                case 2:
                    this.setBackgroundResource(R.drawable.backtwo);
                    break;
                case 3:
                    this.setBackgroundResource(R.drawable.backthree);
                    break;
                case 4:
                    this.setBackgroundResource(R.drawable.backfour);
                    break;
            }
        }

    }

    public void illuminate(){
        this.setBackgroundResource(R.drawable.available_tile);
    }

    public PlayerPiece getPlayerPiece() {
        return playerPiece;
    }

    public void setPlayerPiece(PlayerPiece playerPiece) {
        this.playerPiece = playerPiece;
    }


}
