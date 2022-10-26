package Droids;

import File.FileSystem;

public class Vivacious extends Droid{

    public Vivacious() {
        name = "Vivacious";
        hp = 90;
        armour = 100;
        stamina = 70;
        miss = 25;
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
        if (((int) (Math.random() * 100) + 1) < 35) {
            cacheAttack = "";
            int heal = (int) (Math.random() * 5) + 10;
            hp +=heal;
            String strHp = String.format("%.1f%%", hp);
            cacheAttack = cacheAttack.concat(name+" healed! Hp left = "+strHp+"\n");
            System.out.print(cacheAttack);
            new FileSystem().appStr(cacheAttack);
        }
        return damage;
    }
}