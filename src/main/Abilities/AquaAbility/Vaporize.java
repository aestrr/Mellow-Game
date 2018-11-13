package main.Abilities.AquaAbility;

import main.AbilityType;
import main.Monsters.Monster;

public class Vaporize extends AquaAbility {

    public Vaporize() {
        damage = 20;
        name = "《Vaporize》";
        abilityType = AbilityType.singleTargetEffect;
        description = "Buff ability that increases defense and attack by " + damage + " percent";
    }

    @Override
    public void perform(Monster fucker) {

        user.increaseAttackPercent(damage);
        user.increaseDefensePercent(damage);

    }

    public void printBattleDmg(Monster fucker) {
        System.out.println(user.getName() + " used " + name + ", increased defense and attack by " + damage + " percent!!");
        System.out.println("");
    }
}
