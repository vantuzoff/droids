package Droids;

import File.FileSystem;

public class Tanker extends Droid{

    public Tanker() {
        name = "Tanker";
        hp = 200;
        armour = 100;
        stamina = 40;
        miss = 10;
    }
     public double attack(){
        String cacheAttack = "";
        double damage;
        if (stamina >= 20) {
            damage = (int) (Math.random() * 10) + 15;
            stamina -= 20;
        }else{
            cacheAttack = cacheAttack.concat(name + " is tired!\n");
            System.out.print(cacheAttack);
            new FileSystem().appStr(cacheAttack);
            damage = 2;
        }
        return damage;
     }
}