public class Earring implements Accessories {
    private int defenseIncrease;
    private int defenseDecrease;
    private boolean isBought;

    public Earring(int defenseIncrease) {
        this.defenseIncrease = defenseIncrease;
        defenseDecrease = defenseIncrease;
        this.isBought = false;
    }

    @Override
    public void buy() {
        System.out.println("Earring bought!");
        isBought = true;
    }

    @Override
    public void sell() {
        System.out.println("Earring sold!");
        isBought = false;
    }

    public void increaseShieldDefense(Shield shield) {
        if (isBought) {
            // Increase the defense of the provided shield
            shield.increaseDefense(defenseIncrease);
            System.out.println("Shield defense increased by " + defenseIncrease);
        } else {
            System.out.println("You need to buy the earring before using its effects.");
        }
    }
    public void decreaseShieldDefense(Shield shield) {
            shield.decreaseDefense(defenseDecrease);
            System.out.println("Shield defense decreased by " + defenseDecrease);
    }
}