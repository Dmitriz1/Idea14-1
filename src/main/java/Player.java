public class Player {
    public int id;

    public int getId() {
        return id;
    }

    public String name;

    public String getName() {
        return name;
    }


    public int strength;

    public int getStrength() {
        return strength;
    }

    public Player(int id, String name, int strength) {
        this.id = id;
        this.name = name;
        this.strength = strength;
    }
}
