// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Character a = new Character("Loki", 1, 8.0, "archer");
        Character k = new Character("Arthur", 1, 6.0, "knIght");
        Character t = new Character("Robin", 1, 7.0, "thieF");
        System.out.println(a.name+" is the "+a.job);
        System.out.println(k.name+" is the "+k.job);
        System.out.println(t.name+" is the "+t.job);
        System.out.println(a.name+" level's is "+a.level+" and got "+a.maxHp+" hp.");
        System.out.println(k.name+" level's is "+k.level+" and got "+k.maxHp+" hp.");
        System.out.println(t.name+" level's is "+t.level+" and got "+t.maxHp+" hp.");
        a.levelUp();
        System.out.println(a.name+" got level up, now Loki level's is "+a.level+" and got "+a.maxHp+" hp.");
        System.out.println(a.name + " got base "+a.damage+" damage because of his job(Archer).");
        Sword Ex = new Sword("Excalibur",40);
        System.out.println(Ex.damage);
        a.equipSword(Ex);
        System.out.println(a.name + " got "+a.damage+" damage by equipped "+ a.equippedSword.name);
        System.out.println(k.name + " got base "+k.defense+" defense because of his job(Knight).");
        Shield Cw = new Shield("ChinaWall",20);
        k.equipShield(Cw);
        System.out.println(k.name + " got "+k.defense+" defense by equipped "+k.equippedShield.name);
        System.out.println("----------------------------------");
        Accessories r = new Ring(5);
        System.out.println(a.damage);
        System.out.println(Ex.damage);
        a.buyAccessory(r);
        System.out.println(a.damage);
        System.out.println(Ex.damage);
        a.sellAccessory(r);
        System.out.println(a.damage);
        System.out.println(Ex.damage);
        System.out.println("----------------------------------");
        Accessories e = new Earring(5);
        System.out.println(k.defense);
        System.out.println(Cw.defense);
        k.buyAccessory(e);
        System.out.println(k.defense);
        System.out.println(Cw.defense);
        k.sellAccessory(e);
        System.out.println(k.defense);
        System.out.println(Cw.defense);
        System.out.println("----------------------------------");
        Accessories n = new Necklace(5);
        System.out.println(k.maxHp);
        k.buyAccessory(n);
        System.out.println(k.maxHp);
        k.sellAccessory(n);
        System.out.println(k.maxHp);
        System.out.println("----------------------------------");
        Accessories ta = new Talisman();
        System.out.println(k.hp);
        System.out.println(a.damage);
        System.out.println(k.defense);
        a.attack(k);
        System.out.println(k.hp);
        k.buyAccessory(ta);
        System.out.println(k.hp);
        k.heal();
        System.out.println(k.hp);
        k.sellAccessory(ta);
        k.heal();
        System.out.println(k.hp);
    }
}