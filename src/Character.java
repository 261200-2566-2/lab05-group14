import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class Character {
    public String name;
    public int level;
    public double hp;
    public double mana;
    public double runSpeed;
    private final double defaultRunSpeed;
    public double maxHp;
    public double maxMana;
    public double maxRunSpeed;
    public boolean equippedTalisman;
    public Sword equippedSword;
    public Shield equippedShield;
    public double damage;
    public double defense;
    public double defaultDamage;
    public double defaultDefense;
    public Job job;
    public void levelUp() {
        level++;
        maxHp = 100+(10*level);
        maxMana = 50+(2*level);
        maxRunSpeed = runSpeed+(0.1+(0.03*level));

    }
    public void attack(Character target) {
        double damageDealt = 0;
        if(equippedSword == null){
            System.out.println(name + " can't attack without a sword");
        }
        else {
            damageDealt += damage-target.defense;
        }

        // You can add more logic for additional damage sources (e.g., spells, items)

        // Reduce target's HP
        target.hp -= damageDealt;
        if(target.hp <= 0) {
            System.out.println(target.name + " is now dead");
        }
    }
    public Character(String _name,int _level,double _baseRunSpeed,String job){
        name = _name;
        level = _level;
        runSpeed = _baseRunSpeed;
        defaultRunSpeed = _baseRunSpeed;
        damage = 0;
        defense = 0;

        maxHp = 100+(10*level);
        hp = maxHp;
        maxMana = 50+(2*level);
        mana = maxMana;
        maxRunSpeed = runSpeed+(0.1+(0.03*level));
        initializeJob(Job.fromString(job.toUpperCase()));
    }
    private void initializeJob(Job job) {
        // Perform job-specific initialization here
        switch (job) {
            case ARCHER:
                this.job = Job.ARCHER;
                damage += 5;
                defaultDamage = damage;
                defaultDefense = defense;
                break;
            case KNIGHT:
                this.job = Job.KNIGHT;
                defense += 5;
                defaultDamage = damage;
                defaultDefense = defense;
                break;
            case THIEF:
                this.job = Job.THIEF;
                runSpeed += 2;
                maxRunSpeed += 2;
                maxHp += 20;
                hp = maxHp;
                defaultDamage = damage;
                defaultDefense = defense;
                break;
        }
    }
    public void equipSword(Sword sword) {
        equippedSword = sword;
        runSpeed -= runSpeed * (0.1 + (0.04 * level));
        damage += sword.damage;
    }

    public void equipShield(Shield shield) {
        equippedShield = shield;
        runSpeed -= runSpeed * (0.1 + (0.06 * level));
        defense += shield.defense;
    }
    public void unEquipSword(Sword sword){
        if(equippedSword == sword){
            equippedSword = null;
            damage -= sword.damage;
        }else{
            System.out.println(name+" hasn't equipped "+sword.name+" sword");
        }
        runSpeed = defaultRunSpeed;
    }
    public void unEquipShield(Shield shield){
        if(equippedShield == shield){
            equippedShield = null;
            defense -= shield.defense;
        }else{
            System.out.println(name+" hasn't equipped "+shield.name+" shield");
        }
        runSpeed = defaultRunSpeed;
    }

    //effect of Necklace
    public void increaseMaxHp(int amount) {
        maxHp += amount;
        hp = Math.min(hp + amount, maxHp); // Ensure current HP does not exceed the new max HP
    }
    //effect of Necklace
    public void decreaseMaxHp(int amount) {
        maxHp -= amount;
        hp = Math.min(hp - amount, maxHp); // Ensure current HP does not exceed the new max HP
    }
    //effect of Talisman
    public void heal() {
        Random rand = new Random();
        int healAmount = rand.nextInt(11) + 10; // Random heal between 1 and 20
        if(equippedTalisman){
            hp = Math.min(maxHp, hp + healAmount);
            System.out.println(name + " healed for " + healAmount + " HP.");
        }else{
            System.out.println("You need to buy the talisman before using its effects.");
        }
    }
    private List<Accessories> accessoriesList = new ArrayList<>();
    // Method to buy an accessory
    public void buyAccessory(Accessories accessory) {
        accessory.buy();
        accessoriesList.add(accessory);
        applyAccessoryEffects();
    }

    // Method to sell an accessory
    public void sellAccessory(Accessories accessory) {
        accessory.sell();
        accessoriesList.remove(accessory);
        if(accessory instanceof Ring){
            ((Ring) accessory).decreaseSwordDamage(equippedSword);
        } else if (accessory instanceof Earring) {
            ((Earring) accessory).decreaseShieldDefense(equippedShield);
        } else if (accessory instanceof Necklace) {
            ((Necklace) accessory).decreaseMaxHp(this);
        }  else if (accessory instanceof Talisman) {
            ((Talisman) accessory).stopRandomHeal(this);
            equippedTalisman = false;
        }
        applyAccessoryEffects();
    }

    // Apply effects of all accessories
    private void applyAccessoryEffects() {
        resetStats(); // Reset stats to the base values

        for (Accessories accessory : accessoriesList) {
            if (accessory instanceof Ring) {
                ((Ring) accessory).increaseSwordDamage(equippedSword);
                damage = defaultDamage + equippedSword.damage;
            } else if (accessory instanceof Earring) {
                ((Earring) accessory).increaseShieldDefense(equippedShield);
                defense = defaultDefense + equippedShield.defense;
            } else if (accessory instanceof Necklace) {
                ((Necklace) accessory).increaseMaxHp(this);
            } else if (accessory instanceof Talisman) {
                ((Talisman) accessory).randomHeal(this);
                equippedTalisman = true;
            }
        }
    }

    // Reset stats to base values
    private void resetStats() {
        // Reset character stats to base values before applying accessory effects
        // You may want to keep track of base stats separately for proper resetting
        if(equippedShield == null && equippedSword == null){
            damage = defaultDamage;
            defense = defaultDefense;
        }else if(equippedShield == null){
            damage = equippedSword.damage + defaultDamage;
            defense = defaultDefense;
        }else if(equippedSword == null){
            damage = defaultDamage;
            defense = equippedShield.defense + defaultDefense;
        }else {
            damage = equippedSword.damage + defaultDamage;
            defense = equippedShield.defense + defaultDefense;
        }
        // Reset other stats as needed
    }
}
