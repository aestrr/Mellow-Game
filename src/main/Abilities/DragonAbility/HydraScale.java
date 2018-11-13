package main.Abilities.DragonAbility;

import main.AbilityType;
import main.Monsters.Monster;

public class HydraScale extends DragonAbility {

    public HydraScale() {
        damage = 30;
        name = "《Hydra Scale》";
        abilityType = AbilityType.singleTargetEffect;
        description = "Buff ability that increases defense by " + damage + " percent and attack by 5 percent";
    }

    @Override
    public void perform(Monster fucker) {

            user.increaseAttackPercent(5);
            user.increaseDefensePercent(damage);

    }

    public void printBattleDmg(Monster fucker) {
            System.out.println(user.getName() + " used " + name + ", increased defense by " + damage + " percent and attack by 5 percent!!");
            System.out.println("");
    }

}
