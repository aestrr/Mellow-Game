package main.Abilities.AquaAbility;

import main.Abilities.Ability;
import main.AbilityType;
import main.Element;
import main.Monsters.Monster;

public class AquaAbility implements Ability {

    protected AbilityType abilityType;
    protected int damage;
    protected String name;
    protected Monster user;
    protected Element element;
    protected String description;


    public AquaAbility() {
        abilityType = AbilityType.singleTargetDamage;
        damage = 30;
        name = "ah not fucking you again";
        element = Element.water;
        description = "?";
    }

    public void setUser(Monster monster) {
        user = monster;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public AbilityType getAbilityType() {
        return abilityType;
    }

    @Override
    public int getDamage() {
        return damage;
    }

    @Override
    public void perform(Monster fucker) {

        int actualdmg = actualDamageDone(fucker);

        if (fucker.getElement() == Element.fire  ||
                fucker.getElement() == Element.ice) {

            System.out.println(getName() + " inflicted " + fucker.getName() + " twice the damage!");
        }
        if (fucker.getElement() == Element.water)
            System.out.println(getName() + " only inflicted " + fucker.getName() + " three quarter the damage...");

        System.out.println("");

        fucker.decreaseCurrentHealth(actualdmg);

    }

    @Override
    public int actualDamageDone(Monster fucker) {

        double damagee1 = (user.getLevel() * 0.4 + 2) * damage * user.getAttack();
        int defense1 = (fucker.getDefense()*50 + 2);
        double actual = damagee1/defense1;
        long i = Math.round(actual);
        int j = (int) i;

        if (fucker.getElement() == Element.ice ||
                fucker.getElement() == Element.fire) {
            j *= 2;
        }

        if (fucker.getElement() == Element.water)
            j -= j/4;

        return j;
    }


    public void printBattleDmg(Monster fucker) {
        System.out.println(user.getName() + " used " + name + ", damaged "
                + fucker.getName() + " " + actualDamageDone(fucker)
                + " hp!!!");
        System.out.println("");
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void increaseDmg(int amt) {
        damage *= amt;
    }

    @Override
    public void decreaseDmg(int amt) {
        damage /= amt;
    }

}
