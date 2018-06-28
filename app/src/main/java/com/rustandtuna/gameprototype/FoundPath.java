package com.rustandtuna.gameprototype;

import java.util.Arrays;

/**
 * Created by Sean on 3/1/2016.
 */
public class FoundPath {


    int[] cells;
    int index = 0;
    int capacity;
    public FoundPath() {
        capacity = 8;
        cells = new int[capacity];
        resetVals();
    }

    public void next(int inputCell){
//        int index = 0;
//        while(cells[index] != -1){
//            index++;
//        }
//        cells[index] = inputCell;
        if (index == cells.length) {
            int[] temp = new int[capacity*2];
            Arrays.fill(temp,-1);
            for (int j = 0; j < cells.length; j++) {
                temp[j] = cells[j];
            }
            cells = temp;
            capacity = capacity*2;
        }
        cells[index] = inputCell;
        index++;
    }

    public void deleteLast(){
//        int index = 0;
//        while(cells[index] != -1){
//            index++;
//        }
//        cells[index-1] = -1;
        index--;
        cells[index] = -1;

    }


    public int getCell(int in) {
        return cells[in];
    }

    public void setCells(int[] cells) {
        this.cells = cells;
    }

    public int getLength(){
//        int index = 0;
//        while(cells[index]!= -1){
//            index++;
//        }
//        return index;
        return index;
    }

    public void resetVals() {
        Arrays.fill(cells,-1);
    }


    //    public
}
