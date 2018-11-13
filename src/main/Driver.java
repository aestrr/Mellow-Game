package main;

import main.Monsters.Denise;
import main.Monsters.DragonOfFlame;

public class Driver {

    int battleStateAllyLevel;
    int battleStateEnemyLevel;


    public static void main(String[] args) {
        System.out.println("fuck you");
        Battle battle = new Battle();
        battle.startBattle(new Denise(100), new DragonOfFlame(100));
    }

    public void setAllyLevel(int i) {
        battleStateAllyLevel = i;
    }

    public void setEnemylevel(int i) {
        battleStateEnemyLevel = i;
    }
}
