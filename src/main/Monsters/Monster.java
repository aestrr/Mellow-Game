package main.Monsters;


import main.Abilities.Ability;
import main.Element;
import main.Status;

import java.util.ArrayList;
import java.util.Random;

public abstract class Monster {
    protected int level;
    protected int attack;
    protected int defense;
    protected int maxHealth;
    protected int currentHealth;
    protected int speed;
    protected String name;
    protected boolean isAttacked;
    protected ArrayList<Ability> abilities;
    protected Status status;
    protected Element element;



    public Monster(int level, Ability defaultAbility, String name, Element element,
                   int hpv,
                   int atkv,
                   int dfsv,
                   int spdv) {

        Random r = new Random();
        abilities = new ArrayList<>();
        this.element = element;

        this.level = level;


            this.attack = (atkv*2 + generateIntBetween(212,275)) * level/100 + 5;


            this.defense = (dfsv*2 + generateIntBetween(212,275)) * level/100 + 5;

            this.speed = (spdv*2 + generateIntBetween(212,275)) * level/100 + 5;

            this.maxHealth = (level * (hpv + generateIntBetween(212,275))/50) + (level/100) + level + 10;

            currentHealth = maxHealth;
            status = Status.gud;

        this.gainAbility(defaultAbility);

        setName(name);
    }

    public void getStats() {
        System.out.println("======name======:" + name);
        System.out.println("====Element====:" + element);
        System.out.println("===level: " + level);
        System.out.println("===max health: " + maxHealth);
        System.out.println("===current health: " + currentHealth);
        System.out.println("===attack: " + attack);
        System.out.println("===defense: " + defense);
        System.out.println("===speed: " + speed);
        System.out.println("===status: " + status);
    }

    public int getLevel() {
        return level;
    }

    public int getAttack() {
        return attack;
    }

    public void increaseAttack(int amt) {
        attack += amt;
    }

    public void increaseAttackPercent(int amt) {
        attack += attack*amt/100;
    }

    public int getDefense() {
        return defense;
    }

    public void increaseDefense(int amt) {
        defense += amt;
    }

    public void increaseDefensePercent(int amt) {
        defense += defense*amt/100;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public int getSpeed() {
        return speed;
    }

    public void decreaseCurrentHealth(int dmg) {
        currentHealth -= dmg;
    }

    public void increaseCurrentHealth(int heal) {
        currentHealth += heal;
        if (currentHealth > maxHealth) {
            currentHealth = maxHealth;
        }
    }

    public boolean isDefeated() {
        return currentHealth <= 0;
    }

    public void gainAbility(Ability a) {
        if (!abilities.contains(a)) {
            abilities.add(a);
            a.setUser(this);
        }
    }

    public void setName(String n) {
        name = n;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Ability> getAbilities() {
        return abilities;
    }

    public int generateIntBetween(int i, int j) {
        Random r = new Random();
        int q = Math.abs(r.nextInt());
        return q%(j-i) + i;
    }

    public Element getElement() {
        return element;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Status getStatus() {
        return status;
    }

    public void decreseSpeed(int amt) {
        speed -= amt;
    }
}
