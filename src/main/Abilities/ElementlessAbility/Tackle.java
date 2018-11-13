package main.Abilities.ElementlessAbility;

import main.AbilityType;
import main.Element;

public class Tackle extends ElementlessAbility {

    public Tackle() {
        super();
        abilityType = AbilityType.singleTargetDamage;
        damage = 30;
        name = "《Tackle》";
        element = Element.elementless;
        description = "Elementless Ability with 30 damage";
    }

}
