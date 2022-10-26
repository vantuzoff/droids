package BattleInfo;

import Droids.*;
import File.FileSystem;

import java.util.Objects;
import java.util.Scanner;

public class Battle {
    Droid attacker;
    Droid defender;

    public void battleIni(){
        String cacheBattleIni = "";
        selectAttacker();
        selectDefender();
        if (!Objects.equals(attacker.getName(), defender.getName()))
            battleBegin();
        else {
            cacheBattleIni = cacheBattleIni.concat("Droids must be different!\n");
            System.out.print(cacheBattleIni);
            new FileSystem().appStr(cacheBattleIni);
        }
    }
    public void battleBegin(){
        String cacheBattleBegin = "";
        while (attacker.isAlive()){
                defender.getAttacked(attacker.attack());
                Droid temp = defender;
                defender = attacker;
                attacker = temp;

        }
        cacheBattleBegin = cacheBattleBegin.concat(defender.getName()+" won!!!\n");
        System.out.print(cacheBattleBegin);
        new FileSystem().appStr(cacheBattleBegin);
    }

    public void selectDefender(){
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
            defender = new Tanker();
        else if (choice == 2)
            defender = new IronFist();
        else if (choice == 3)
            defender = new Kerry();
        else if (choice == 4)
            defender = new Vivacious();
    }

    public void selectAttacker(){
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
            attacker = new Tanker();
        else if (choice == 2)
            attacker = new IronFist();
        else if (choice == 3)
            attacker = new Kerry();
        else if (choice == 4)
            attacker = new Vivacious();
    }
}
