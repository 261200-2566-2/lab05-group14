public class Ring implements Accessories {
    private int damageIncrease;
    private int damageDecrease;
    private boolean isBought;

    public Ring(int damageIncrease) {
        this.damageIncrease = damageIncrease;
        damageDecrease = damageIncrease;
        this.isBought = false;
    }

    @Override
    public void buy() {
        System.out.println("Ring bought!");
        isBought = true;
    }

    @Override
    public void sell() {
        System.out.println("Ring sold!");
        isBought = false;
    }

    public void increaseSwordDamage(Sword sword) {
        if (isBought) {
            // Increase the damage of the provided sword
            sword.increaseDamage(damageIncrease);
            System.out.println("Sword damage increased by " + damageIncrease);
        } else {
            System.out.println("You need to buy the ring before using its effects.");
        }
    }
    public void decreaseSwordDamage(Sword sword) {
            sword.decreaseDamage(damageDecrease);
            System.out.println("Sword damage decreased by " + damageDecrease);
    }
}