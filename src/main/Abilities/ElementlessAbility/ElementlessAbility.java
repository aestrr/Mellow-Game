package main.Abilities.ElementlessAbility;

import main.Abilities.Ability;
import main.AbilityType;
import main.Element;
import main.Monsters.Monster;

public abstract class ElementlessAbility implements Ability {

    protected AbilityType abilityType;
    protected int damage;
    protected String name;
    protected Monster user;
    protected Element element;
    protected String description;


    public ElementlessAbility() {
        abilityType = AbilityType.singleTargetDamage;
        damage = 30;
        name = "ah not fucking you again";
        element = Element.elementless;
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

        return j;
    }


    public void printBattleDmg(Monster fucker) {
        System.out.println(user.getName() + " used " + name + ", damaged "
                + fucker.getName() + " " + actualDamageDone(fucker)
                + " hp!!!");

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
