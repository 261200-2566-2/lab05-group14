public class Necklace implements Accessories {
    private int maxHpIncrease;
    private int maxHpDecrease;
    private boolean isBought;

    public Necklace(int maxHpIncrease) {
        this.maxHpIncrease = maxHpIncrease;
        maxHpDecrease = maxHpIncrease;
        this.isBought = false;
    }

    @Override
    public void buy() {
        System.out.println("Necklace bought!");
        isBought = true;
    }

    @Override
    public void sell() {
        System.out.println("Necklace sold!");
        isBought = false;
    }

    public void increaseMaxHp(Character character) {
        if (isBought) {
            // Increase the maximum HP of the provided character
            character.increaseMaxHp(maxHpIncrease);
            System.out.println("Max HP increased by " + maxHpIncrease);
        } else {
            System.out.println("You need to buy the necklace before using its effects.");
        }
    }
    public void decreaseMaxHp(Character character) {
            character.decreaseMaxHp(maxHpDecrease);
            System.out.println("Max HP decreased by " + maxHpIncrease);
    }
}
