package com.rustandtuna.gameprototype;

/**
 * Created by Sean on 2/8/2016.
 */
public class gridCell{
    int orientation;
    String name;

    public gridCell(int orientation) {
        this.orientation = orientation;
    }



    public int getOrientation() {
        return orientation;
    }

    public void setOrientation(int orientation) {
//        if(orientation > 0 && orientation < 5){
//            this.orientation = orientation;
//        }

    }
    public void pressMe(){
        if(orientation < 4){
            orientation++;
        }
        else{
            orientation = 1;
        }
    }
}
