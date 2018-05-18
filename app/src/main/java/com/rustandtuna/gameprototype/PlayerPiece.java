package com.rustandtuna.gameprototype;

/**
 * Created by Sean on 2/8/2016.
 */
public class PlayerPiece {
    private String type;
    private int HP;
    private int coord;
    int maxHp = 20;
    int p1p2;



//  Only accepts "ranged","close", or "mounted"
    public PlayerPiece(int p1p2, String type) {
        this.p1p2 = p1p2;

        if (type == "ranged"|| type == "close" || type == "mounted"){
            this.type = type;
        }

        this.HP = maxHp;

    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
//        this.type = type;
    }

    public int getHP() {
        return HP;
    }

    public void setHP(int HP) {
//        this.HP = HP;
    }

    public int getCoord() {
        return coord;
    }

    public void setCoord(int coord) {
        this.coord = coord;
    }

    public int getP1P2() {
        return p1p2;
    }

    public void inflictDamage(int damage){
        HP = HP-damage;
        if (HP<0){

            HP = 0;
        }
    }
}
