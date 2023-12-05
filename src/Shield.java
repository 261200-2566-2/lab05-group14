public class Shield {
    public double defense;
    public final String name;
    public int level=1;

    public Shield(String _name,int baseDefense){
        name = _name;
        defense = baseDefense;
    }
    public void levelUp() {
        defense = defense*(1+(0.05*level));
    }

    public void increaseDefense(int amount) {
        defense += amount;
    }
    public void decreaseDefense(int amount) {
        defense = Math.max(0, defense - amount);
    }
}