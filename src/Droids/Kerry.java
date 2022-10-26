package Droids;

import File.FileSystem;

public class Kerry extends Droid{

    public Kerry() {
        name = "Kerry";
        hp = 100;
        armour = 100;
        stamina = 70;
        miss = 38;
    }
    public double attack(){
        String cacheAttack = "";
        double damage;
        if (stamina >= 20) {
            damage = (int) (Math.random() * 15) + 15;
            stamina -= 20;
        } else {
            cacheAttack = cacheAttack.concat(name + " is tired!\n");
            System.out.print(cacheAttack);
            new FileSystem().appStr(cacheAttack);
            damage = 1;
        }
        return damage;
    }
}