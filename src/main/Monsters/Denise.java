package main.Monsters;

import main.Abilities.AquaAbility.TitanicWave;
import main.Abilities.AquaAbility.Vaporize;
import main.Abilities.DragonAbility.Destruction;
import main.Abilities.DragonAbility.HydraScale;
import main.Abilities.ElementlessAbility.ElementalDisruption;
import main.Abilities.ElementlessAbility.Blessing;
import main.Abilities.FireAbility.Burn;
import main.Abilities.FireAbility.HellCurse;
import main.Abilities.FireAbility.RingOfFlame;
import main.Abilities.FireAbility.FlameHeavenly;
import main.Abilities.GodAbility.CometOfTheAncients;
import main.Abilities.ThunderAbility.ElectricFlow;
import main.Abilities.ThunderAbility.ZeusShock;
import main.Element;

import java.util.Random;

public class Denise extends Monster{

    public Denise(int level) {
        super(level, new CometOfTheAncients(), "『Denise, the God』", Element.god,
                150,
                150,
                150,
                150);
        Random r = new Random();
        gainAbility(new Blessing());
        gainAbility(new HydraScale());
        gainAbility(new FlameHeavenly());
        gainAbility(new RingOfFlame());
        gainAbility(new ElementalDisruption());
        gainAbility(new ElectricFlow());
        gainAbility(new ZeusShock());
        gainAbility(new Destruction());
        gainAbility(new Burn());
        gainAbility(new HellCurse());
        gainAbility(new TitanicWave());
        gainAbility(new Vaporize());
    }
}
