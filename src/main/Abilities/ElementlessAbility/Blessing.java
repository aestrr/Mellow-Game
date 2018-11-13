package main.Abilities.ElementlessAbility;

import main.AbilityType;
import main.Element;
import main.Monsters.Monster;
import main.Status;

public class Blessing extends ElementlessAbility {
    public Blessing() {
        super();
        damage = 33;
        name = "《Blessing》";
        element = Element.elementless;
        description = "Elementless Ability that heals the user for " + damage + " percent of the user's max hp";
        abilityType = AbilityType.singleTargetEffect;

    }


    @Override
    public void perform(Monster fucker) {
        user.increaseCurrentHealth(user.getMaxHealth()*damage/100);
        user.setStatus(Status.gud);
    }

    public void printBattleDmg(Monster fucker) {
        System.out.println(user.getName() + " used " + name + ", restored itself " + user.getMaxHealth()*damage/100 + " health and removed all debuffs!!!");
        System.out.println("");
    }

}
