package main.Abilities.ThunderAbility;

import main.AbilityType;
import main.Monsters.Monster;

public class ElectricFlow extends ThunderAbility {
    public ElectricFlow() {
        super();
        damage = 2;
        name = "《Electric Flow》";
        description = "Buff Ability that makes the user's attack next round to do " + damage + " times the damage";
        abilityType = AbilityType.singleTargetEffect;
    }


    @Override
    public void perform(Monster fucker) {}

    public void printBattleDmg(Monster fucker) {
        //if (count < 5)
        System.out.println(user.getName() + " used " + name + ", increasing the next attack by " + damage + " times!!");
        System.out.println("");
        //else System.out.println("Already reached max buff possible from Fire Ring!");
    }
}
