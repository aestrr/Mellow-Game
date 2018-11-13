package main.Monsters;

import main.Abilities.FireAbility.Burn;
import main.Abilities.FireAbility.HellCurse;
import main.Abilities.FireAbility.RingOfFlame;
import main.Abilities.FireAbility.FlameHeavenly;
import main.Element;

public class DragonOfFlame extends Monster{

    public DragonOfFlame(int level) {
        super(level, new FlameHeavenly(), "『Dragon of the Flames』", Element.fire, 50, 200, 50,200);
        gainAbility(new RingOfFlame());
        gainAbility(new Burn());
        gainAbility(new HellCurse());
    }
}