package Droids;

import File.FileSystem;

public class IronFist extends Droid{

    public IronFist() {
        name = "IronFist";
        hp = 85;
        armour = 100;
        stamina = 30;
        miss = 20;
    }
    public double attack(){
        String cacheAttack = "";
        double damage;
        if (stamina >= 20) {
            damage = (int) (Math.random() * 15) + 35;
            stamina -= 20;
        } else {
            cacheAttack = cacheAttack.concat(name + " is tired!\n");
            System.out.print(cacheAttack);
            new FileSystem().appStr(cacheAttack);
            damage = 5;
        }
        return damage;
    }
}