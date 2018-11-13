package main;

import main.Abilities.Ability;
import main.Abilities.ElementlessAbility.Tackle;
import main.Abilities.FireAbility.HellCurse;
import main.Abilities.ThunderAbility.ElectricFlow;
import main.Monsters.Monster;

import java.util.Random;
import java.util.Scanner;

public class Battle {

    private Monster MyDenise;
    private boolean allyProtected = false;
    private Monster enemyD;
    private boolean enemyProtected = false;
    private Ability allyLastUsedAbility = new Tackle();
    private Ability enemyLastUsedAbility = new Tackle();


    public void startBattle(Monster ally, Monster enemy) {
        Scanner command = new Scanner(System.in);
        System.out.println("you've entered battle");

        Random r = new Random();

        MyDenise = ally;
        MyDenise.setName("ally" + " " + MyDenise.getName());

        enemyD = enemy;
        enemyD.setName("Enemy" + " " + enemyD.getName());


        while (!MyDenise.isDefeated() && !enemyD.isDefeated()) {

            MyDenise.getStats();
            System.out.println(" ");
            enemyD.getStats();
            System.out.println(" ");


            System.out.println("What would you like to do?");

            String ans = "";

            do {
                System.out.println("press a to attack");
                System.out.println("press q to quit");

                ans = command.next();
                if (!ans.equals("q") && !ans.equals("a")) {
                    System.out.println("Please try again.");
                    break;
                }

                if (MyDenise.getSpeed() > enemyD.getSpeed()) {
                    allyUsesMovesFirst(ans, command);

                } else if (MyDenise.getSpeed() <= enemyD.getSpeed()) {
                    enemyUsesMovesFirst(ans, command);
                }

                checkStatus();

                if (MyDenise.isDefeated()) {
                    System.out.println("U lost!");
                } else if (enemyD.isDefeated()) {

                    System.out.println(enemyD.getName() + " is defeated! U win!!");
                }

            } while (ans.equals(""));

        }
    }


    private void allyUsesMoves(String ans, Scanner command) {
        int flag = 0;

        do {
            switch (ans) {
                case "q":
                    System.exit(0);
                    break;

                case "a":
                    System.out.println("which ability to use?");
                    int numAbilities = MyDenise.getAbilities().size();
                    for (int i = numAbilities; i > 0; i--) {                                         //prints all ability the curr ally has
                        System.out.println("press " + i + " to use " + MyDenise.getAbilities().get(i - 1).getName() +
                                " : " + MyDenise.getAbilities().get(i - 1).getDescription());
                    }

                    String abilityChoice = command.next();
                    for (int n = numAbilities; n > 0; n--) {                      //performs selected ability
                        if (abilityChoice.equals(Integer.toString(n))) {

                            Ability abilityChosen =  MyDenise.getAbilities().get(n - 1);

                            if (enemyProtected && abilityChosen.getAbilityType() == AbilityType.singleTargetDamage) {
                                flag = 1;
                                System.out.println("Enemy protected " + MyDenise.getName() + "'s attack has no effect!");
                                enemyLastUsedAbility = abilityChosen;
                                this.enemyProtected = false;
                                break;
                            }

                            if (allyLastUsedAbility.getName().equals(new ElectricFlow().getName()))       //check for buff ability effect last turn
                                if (abilityChosen.getAbilityType() == AbilityType.singleTargetDamage){
                                    abilityChosen.increaseDmg(allyLastUsedAbility.getDamage());

                                    flag = 1;
                                    //MyDenise.getAbilities().get(n - 1).setUser(MyDenise);
                                    abilityChosen.printBattleDmg(enemyD);
                                    abilityChosen.perform(enemyD);
                                    abilityChosen.decreaseDmg((allyLastUsedAbility.getDamage()));
                                    allyLastUsedAbility = abilityChosen;
                                    break;
                            }
                            //if ()
                            if (abilityChosen.getName().equals(new HellCurse().getName()))                //check for protected
                                allyProtected = true;

                            flag = 1;
                            //MyDenise.getAbilities().get(n - 1).setUser(MyDenise);
                            abilityChosen.printBattleDmg(enemyD);
                            allyLastUsedAbility = abilityChosen;
                            abilityChosen.perform(enemyD);
                        }
                    }
            }

            if (flag == 1){
                break;
            }
            System.out.println("aaaaaaaaaaa");
        }
        while (true);
    }


    private void enemyUsesMovesFirst(String ans, Scanner command) {
        enemyUsesMoves();
        if (!MyDenise.isDefeated() && !enemyD.isDefeated())
            allyUsesMoves(ans, command);
    }

    private void allyUsesMovesFirst(String ans, Scanner command) {
        allyUsesMoves(ans, command);
        if (!MyDenise.isDefeated() && !enemyD.isDefeated())
            enemyUsesMoves();
    }


    private void enemyUsesMoves() {
        Random r = new Random();
        int n = r.nextInt(enemyD.getAbilities().size());

        Ability chosen = enemyD.getAbilities().get(n);

        if (allyProtected && chosen.getAbilityType() == AbilityType.singleTargetDamage) {
            System.out.println("Ally protected " + enemyD.getName() + "'s attack has no effect!");
            allyProtected = false;
            enemyLastUsedAbility = chosen;
            return;
        }

         else if (enemyLastUsedAbility.getName().equals(new ElectricFlow().getName()) &&                           //check for buff ability effect last turn
                chosen.getAbilityType() == AbilityType.singleTargetDamage) {

                chosen.increaseDmg(enemyLastUsedAbility.getDamage());
                chosen.printBattleDmg(MyDenise);
                chosen.perform(MyDenise);
                chosen.decreaseDmg(enemyLastUsedAbility.getDamage());
                enemyLastUsedAbility = chosen;
        } else {
            if (chosen.getName().equals(new HellCurse().getName()))                                                //check for protected
                enemyProtected = true;
            chosen.printBattleDmg(MyDenise);
            chosen.perform(MyDenise);
            enemyLastUsedAbility = chosen;
        }
    }


    public void printBattleDmg(Monster performer, Monster attacker, Ability a) {
        System.out.println(performer.getName() + " used " + a.getName() + ", damaged "
                + attacker.getName() + " " + a.actualDamageDone(attacker)
                + " hp!!!");
    }

    private void checkStatus() {

        if (MyDenise.getStatus().equals(Status.burned)) {
            MyDenise.decreaseCurrentHealth(MyDenise.getMaxHealth()/10);
            System.out.println(MyDenise.getName() + " is burning!!! Inflicted " + MyDenise.getMaxHealth()/10 + " hp!!!");
            System.out.println("");
        }

        if (enemyD.getStatus().equals(Status.burned)) {
            enemyD.decreaseCurrentHealth(enemyD.getMaxHealth()/10);
            System.out.println(enemyD.getName() + " is burning!!! Inflicted " + enemyD.getMaxHealth()/10 + " hp!!!");
            System.out.println("");
        }



    }

}

