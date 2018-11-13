package main.Abilities;

import main.Monsters.Monster;
import main.AbilityType;

public interface Ability {

    String getName();

    AbilityType getAbilityType();

    int getDamage();

    int actualDamageDone(Monster fucker);

    void perform(Monster fucker);

    void setUser(Monster monster);

    public void printBattleDmg(Monster fucker);

    String getDescription();

    void increaseDmg(int amt);

    void decreaseDmg(int amt);

}
