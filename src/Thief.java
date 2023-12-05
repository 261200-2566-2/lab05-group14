public class Thief extends Character {
    public Thief(String name, int level, double baseRunSpeed, String job) {
        super(name, level, baseRunSpeed, job);
    }

    @Override
    public void levelUp() {
        super.levelUp();
        // Increase base run speed
        runSpeed += 2; // Adjust the value as needed
        maxRunSpeed += 2; // Adjust the value as needed
        maxHp += 20; // Adjust the value as needed
        hp = maxHp;
    }
}