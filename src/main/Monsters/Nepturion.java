package main.Monsters;

import main.Abilities.AquaAbility.TitanicWave;
import main.Abilities.AquaAbility.Vaporize;
import main.Abilities.ElementlessAbility.Blessing;
import main.Abilities.GodAbility.CometOfTheAncients;
import main.Element;

public class Nepturion extends Monster {
    public Nepturion(int level) {
        super(level, new CometOfTheAncients(), "『Nepturion』", Element.water,180,100,120,100);
        gainAbility(new TitanicWave());
        gainAbility(new Blessing());
        gainAbility(new Vaporize());
    }
}
