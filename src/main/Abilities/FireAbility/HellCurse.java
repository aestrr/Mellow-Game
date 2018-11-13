package main.Abilities.FireAbility;

import main.AbilityType;
import main.Monsters.Monster;

public class HellCurse extends FireAbility {
    public HellCurse() {
        super();
        damage = 0;
        name = "《Hell Curse》";
        description = "buff ability that prevents the user from the next attack";
        abilityType = AbilityType.singleTargetEffect;
    }

    @Override
    public void perform(Monster fucker) {}

    public void printBattleDmg(Monster fucker) {
        //if (count < 5)
        System.out.println(user.getName() + " used " + name + ", preventing the next attack!!");
        System.out.println("");
        //else System.out.println("Already reached max buff possible from Fire Ring!");
    }
}
