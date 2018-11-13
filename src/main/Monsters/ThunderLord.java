package main.Monsters;

import main.Abilities.ElementlessAbility.ElementalDisruption;
import main.Abilities.ThunderAbility.ElectricFlow;
import main.Abilities.ThunderAbility.ZeusShock;
import main.Element;

public class ThunderLord extends Monster {
    public ThunderLord(int level) {
        super(level, new ZeusShock(),"『Thunder Lord』", Element.thunder,100,150,150,100);
        gainAbility(new ElementalDisruption());
        gainAbility(new ElectricFlow());
    }
}
