package main.Monsters;

import main.Abilities.DragonAbility.Destruction;
import main.Abilities.DragonAbility.HydraScale;
import main.Abilities.ElementlessAbility.Blessing;
import main.Element;

public class YozTheHydra extends Monster{

    public YozTheHydra(int level) {
        super(level, new HydraScale(), "『YoZ, the Hydra』", Element.dragon, 200, 50, 200, 50);
        gainAbility(new Blessing());
        gainAbility(new Destruction());

    }
}
