import java.util.Random;

public class Talisman implements Accessories {
    private boolean isBought;

    public Talisman() {
        this.isBought = false;
    }

    @Override
    public void buy() {
        System.out.println("Talisman bought!");
        isBought = true;
    }

    @Override
    public void sell() {
        System.out.println("Talisman sold!");
        isBought = false;
    }

    public void randomHeal(Character character) {
        if (isBought) {
            character.heal();
        } else {
            System.out.println("You need to buy the talisman before using its effects.");
        }
    }
    public void stopRandomHeal(Character character) {
        isBought = false;
        System.out.println("No more heal effect by talisman.");
    }
}
