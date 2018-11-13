package main.Monsters;

import main.Abilities.ElementlessAbility.Tackle;
import main.Abilities.FireAbility.HellCurse;
import main.Abilities.ThunderAbility.ElectricFlow;
import main.Element;

public class MeatBall extends Monster {

    public MeatBall(int level) {
        super(level,new ElectricFlow(),"《Meat Ball》", Element.god,250,1,250,1);
        gainAbility(new HellCurse());
        gainAbility(new Tackle());
    }
}
