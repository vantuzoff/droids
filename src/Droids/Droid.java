package Droids;

import File.*;

public abstract class Droid {
    String name;
    double hp;
    int armour;
    int stamina;
    int miss;

    abstract public double attack();
    public void getAttacked(double damage){
        String cacheGetAttacked = "";
        if(armour > 80){
            damage -= damage/5;
        }else if (armour > 60) {
            damage -= damage/7;
        }else if (armour > 40) {
            damage -= damage/10;
        }else if (armour > 20) {
            damage -= damage/12;
        }
        stamina += 10;
        if (((int) (Math.random() * 100) + 1) < miss){
            cacheGetAttacked = cacheGetAttacked.concat("Attack to "+name+ " missed!\n");
            System.out.print(cacheGetAttacked);
            new FileSystem().appStr(cacheGetAttacked);
            return;
        }
        armour -= 20;
        hp -= damage;
        String strDamage = String.format("%.1f", damage);
        String strHp = String.format("%.1f%%", hp);
        cacheGetAttacked = cacheGetAttacked.concat(name+ " was hit by "+strDamage+ " damage Hp left = "+strHp+ " Stamina = "+stamina+"\n");
        System.out.print(cacheGetAttacked);
        new FileSystem().appStr(cacheGetAttacked);
    }
    public boolean isAlive(){
        return hp > 0;
    }

    public String getName() {
        return name;
    }
}