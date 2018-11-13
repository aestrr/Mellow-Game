package main.Abilities.ThunderAbility;

import main.Abilities.Ability;
import main.AbilityType;
import main.Element;
import main.Monsters.Monster;

public abstract class ThunderAbility implements Ability{
    protected AbilityType abilityType;
    protected int damage;
    protected String name;
    protected Monster user;
    protected Element element;
    protected String description;

    public ThunderAbility() {
        abilityType = AbilityType.singleTargetDamage;
        damage = 200;
        name = "you fucker hacked the game";
        element = Element.thunder;
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

        if (fucker.getElement() == Element.water ||
                fucker.getElement() == Element.dragon) {

            System.out.println(getName() + " inflicted " + fucker.getName() + " twice the damage!");
        }
        if (fucker.getElement() == Element.god )
            System.out.println(getName() + " only inflicted " + fucker.getName() + " three quarter the damage...");

        System.out.println("");
        fucker.decreaseCurrentHealth(actualdmg);

    }

//    public void perform(List<Monster> Monsters) {
//
//        for (Monster fucker: Monsters) {
//            int actualdmg = actualDamageDone(fucker);
//            if (fucker.getElement() == Element.devil ||
//                    fucker.getElement() == Element.god ||
//                    fucker.getElement() == Element.dragon ||
//                    fucker.getElement() == Element.elementless) {
//                System.out.println(getName() + " inflicted " + fucker.getName() + " twice the damage!");
//            }
//            fucker.decreaseCurrentHealth(actualdmg);
//        }
//
//    }

    @Override
    public int actualDamageDone(Monster fucker) {

        double damage1 = (user.getLevel() * 0.4 + 2) * damage * user.getAttack();
        int defense1 = (fucker.getDefense()*50 + 2);
        double actual = damage1/defense1;
        long i = Math.round(actual);
        int j = (int) i;

        if (fucker.getElement() == Element.dragon ||
                fucker.getElement() == Element.water) {
            j *= 2;
        }
        if (fucker.getElement() == Element.god )
            j -= j/4;
        return j;
    }

    @Override
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
        damage = amt*damage;
    }

    @Override
    public void decreaseDmg(int amt) {
        damage /= amt;
    }
}
