package main.Abilities.FireAbility;

import main.AbilityType;
import main.Monsters.Monster;

public class RingOfFlame extends FireAbility{
    //private int count = 0;

    public RingOfFlame() {
        super();
        damage = 30;
        abilityType = AbilityType.singleTargetEffect;
        name = "《Ring of Flame》";
        description = "Buff Ability that increases the user's attack by " + damage + " percent.";
    }

    @Override
    public void perform(Monster fucker) {
       // if (count < 5) {
            user.increaseAttackPercent(damage);
        //    count++;
        //}
    }

    public void printBattleDmg(Monster fucker) {
        //if (count < 5)
            System.out.println(user.getName() + " used " + name + ", increased attack by " + damage + " percent!!");
            System.out.println("");
        //else System.out.println("Already reached max buff possible from Fire Ring!");
    }


}
