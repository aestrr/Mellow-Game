package main.Abilities.FireAbility;

import main.AbilityType;
import main.Monsters.Monster;
import main.Status;

public class Burn extends FireAbility {
    public Burn() {
        damage = 0;
        name = "《Burn!!!!!!》";
        abilityType = AbilityType.singleTargetEffect;
        description = "debuff ability that inflicts burning status to the target";
    }

    @Override
    public void perform(Monster fucker) {
        // if (count < 5) {
        fucker.setStatus(Status.burned);
        System.out.println("");
        //    count++;
        //}
    }

    public void printBattleDmg(Monster fucker) {
        //if (count < 5)
        System.out.println(user.getName() + " used " + name + ", inflicted burning effect on " + fucker.getName() + "!!!");
        //else System.out.println("Already reached max buff possible from Fire Ring!");
    }
}
