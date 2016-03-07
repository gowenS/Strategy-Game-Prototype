package com.rustandtuna.gameprototype;

/**
 * Created by Sean on 3/1/2016.
 */
public class FoundPath {
    int[] cells;
    public FoundPath() {
        cells = new int[]{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1};
    }

    public void next(int inputCell){
        int index = 0;
        while(cells[index] != -1){
            index++;
        }
        cells[index] = inputCell;
    }

    public void deleteLast(){
        int index = 0;
        while(cells[index] != -1){
            index++;
        }
        cells[index-1] = -1;

    }


    public int[] getCells() {
        return cells;
    }

    public void setCells(int[] cells) {
        this.cells = cells;
    }

    public int getLength(){
        int index = 0;
        while(cells[index]!= -1){
            index++;
        }
        return index;
    }

    public void resetVals() {
        this.cells = new int[]{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1};
    }


    //    public
}
