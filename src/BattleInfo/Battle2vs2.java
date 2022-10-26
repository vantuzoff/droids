package BattleInfo;

import Droids.*;
import File.FileSystem;

import java.util.Objects;
import java.util.Scanner;

public class Battle2vs2 {
    Team attackerTeam;
    Team defenderTeam;

    public void battleIni(){
        String cacheBattleIni = "";
        Droid attacker1 = new IronFist();
        Droid attacker2 = new IronFist();
        Droid defender1 = new IronFist();
        Droid defender2 = new IronFist();
        attacker1 = selectAttacker(attacker1);
        defender1 = selectDefender(defender1);
        attacker2 = selectAttacker(attacker2);
        defender2 = selectDefender(defender2);
        attackerTeam = new Team(attacker1, attacker2);
        defenderTeam = new Team(defender1, defender2);
        if (!Objects.equals(attacker1.getName(), attacker2.getName()) || !Objects.equals(defender1.getName(), defender2.getName())) {
            battleBegin(attackerTeam, defenderTeam);
        }
        else {
            cacheBattleIni = cacheBattleIni.concat("Droids must be different!\n");
            System.out.print(cacheBattleIni);
            new FileSystem().appStr(cacheBattleIni);
        }
    }

    public void battleBegin(Team attackT, Team defendT){
        String cacheBattleBegin = "";
        int choose;
        while (attackT.character1.isAlive() || attackT.character2.isAlive()){
            if (attackT.character1.isAlive()) {
                cacheBattleBegin = cacheBattleBegin.concat(attackT.character1.getName() + " is attacking!\n");
                System.out.print(cacheBattleBegin);
                new FileSystem().appStr(cacheBattleBegin);
                if (defendT.character1.isAlive() && defendT.character2.isAlive()) {
                    cacheBattleBegin = "";
                    cacheBattleBegin = cacheBattleBegin.concat("Choose character to attack:\n1." + defendT.character1.getName() + "\n2." + defendT.character2.getName()+"\n");
                    System.out.print(cacheBattleBegin);
                    new FileSystem().appStr(cacheBattleBegin);
                    Scanner scan = new Scanner(System.in);
                    choose = scan.nextInt();
                    cacheBattleBegin = "";
                    cacheBattleBegin = cacheBattleBegin.concat(" " + choose + "\n");
                    new FileSystem().appStr(cacheBattleBegin);
                    if (choose == 1)
                        defendT.character1.getAttacked(attackT.character1.attack());
                    else
                        defendT.character2.getAttacked(attackT.character1.attack());
                }else if (defendT.character1.isAlive()) {
                    cacheBattleBegin = "";
                    cacheBattleBegin = cacheBattleBegin.concat(defendT.character2.getName()+" is died! Attacking only "+defendT.character1.getName()+"\n");
                    System.out.print(cacheBattleBegin);
                    new FileSystem().appStr(cacheBattleBegin);
                    defendT.character1.getAttacked(attackT.character1.attack());
                }
                else if (defendT.character2.isAlive()){
                    cacheBattleBegin = "";
                    cacheBattleBegin = cacheBattleBegin.concat(defendT.character1.getName()+" is died! Attacking only "+defendT.character2.getName()+"\n");
                    System.out.print(cacheBattleBegin);
                    new FileSystem().appStr(cacheBattleBegin);
                    defendT.character2.getAttacked(attackT.character1.attack());
                }
            }
            if (attackT.character2.isAlive()) {
                cacheBattleBegin = "";
                cacheBattleBegin = cacheBattleBegin.concat(attackT.character2.getName() + " is attacking!\n");
                System.out.print(cacheBattleBegin);
                new FileSystem().appStr(cacheBattleBegin);
                if (defendT.character1.isAlive() && defendT.character2.isAlive()) {
                    cacheBattleBegin = "";
                    cacheBattleBegin = cacheBattleBegin.concat("Choose character to attack:\n1." + defendT.character1.getName() + "\n2." + defendT.character2.getName()+"\n");
                    System.out.print(cacheBattleBegin);
                    new FileSystem().appStr(cacheBattleBegin);
                    Scanner scan = new Scanner(System.in);
                    choose = scan.nextInt();
                    cacheBattleBegin = "";
                    cacheBattleBegin = cacheBattleBegin.concat(" " + choose + "\n");
                    new FileSystem().appStr(cacheBattleBegin);
                    if (choose == 1)
                        defendT.character1.getAttacked(attackT.character2.attack());
                    else
                        defendT.character2.getAttacked(attackT.character2.attack());
                }else if (defendT.character1.isAlive()) {
                    cacheBattleBegin = "";
                    cacheBattleBegin = cacheBattleBegin.concat(defendT.character2.getName()+" is died! Attacking only "+defendT.character1.getName()+"\n");
                    System.out.print(cacheBattleBegin);
                    new FileSystem().appStr(cacheBattleBegin);
                    defendT.character1.getAttacked(attackT.character2.attack());
                }
                else if (defendT.character2.isAlive()){
                    cacheBattleBegin = "";
                    cacheBattleBegin = cacheBattleBegin.concat(defendT.character1.getName()+" is died! Attacking only "+defendT.character2.getName()+"\n");
                    System.out.print(cacheBattleBegin);
                    new FileSystem().appStr(cacheBattleBegin);
                    defendT.character2.getAttacked(attackT.character2.attack());
                }
            }
                Team temp = defendT;
                defendT = attackT;
                attackT = temp;
            }
        cacheBattleBegin = "";
        cacheBattleBegin = cacheBattleBegin.concat(defendT.character1.getName()+" and "+defendT.character2.getName()+" won!!!\n");
        System.out.print(cacheBattleBegin);
        new FileSystem().appStr(cacheBattleBegin);
    }

    public Droid selectAttacker(Droid attack){
        String cacheSelectDefender = "";
        cacheSelectDefender = cacheSelectDefender.concat("Choose defender droid:\n1. Tanker\n2. IronFist\n3. Kerry\n4. Vivacious\n");
        System.out.print(cacheSelectDefender);
        new FileSystem().appStr(cacheSelectDefender);
        int choice;
        Scanner scan = new Scanner(System.in);
        choice = scan.nextInt();
        cacheSelectDefender = "";
        cacheSelectDefender = cacheSelectDefender.concat(" " + choice + "\n");
        new FileSystem().appStr(cacheSelectDefender);
        if (choice == 1)
            attack = new Tanker();
        else if (choice == 2)
            attack = new IronFist();
        else if (choice == 3)
            attack = new Kerry();
        else
            attack = new Vivacious();
        return attack;
    }

    public Droid selectDefender(Droid defend){
        String cacheSelectAttacker = "";
        cacheSelectAttacker = cacheSelectAttacker.concat("Choose attacker droid:\n1. Tanker\n2. IronFist\n3. Kerry\n4. Vivacious\n");
        System.out.print(cacheSelectAttacker);
        new FileSystem().appStr(cacheSelectAttacker);
        int choice;
        Scanner scan = new Scanner(System.in);
        choice = scan.nextInt();
        cacheSelectAttacker = "";
        cacheSelectAttacker = cacheSelectAttacker.concat(" " + choice + "\n");
        new FileSystem().appStr(cacheSelectAttacker);
        if (choice == 1)
            defend = new Tanker();
        else if (choice == 2)
            defend = new IronFist();
        else if (choice == 3)
            defend = new Kerry();
        else
            defend = new Vivacious();
        return defend;
    }

}
