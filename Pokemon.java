public class Pokemon {
    public String species;
    public int level;
    public int[] stats;
    public int[] IV;
    public int[] EV;
    public int HP;
    public int Atk;
    public int Def;
    public int SpA;
    public int SpD;
    public int Spe;

    public Pokemon(String species, int level, int[] IV, int[] EV) {
        this.species = species;
        this.level = level;
        this.IV = IV;
        this.EV = EV;
        this.stats = getBaseStats(species);
        this.HP = calculateHP();
        this.Atk = calculateStat(1);
        this.Def = calculateStat(2);
        this.SpA = calculateStat(3);
        this.SpD = calculateStat(4);
        this.Spe = calculateStat(5);
    }

    private int calculateStat(int statIndex) {
        int baseStat = stats[statIndex];
        int IV_stat = IV[statIndex];
        int EV_stat = EV[statIndex];
        return (int) (((2 * baseStat + IV_stat + (EV_stat / 4)) * level) / 100 + 5);
    }

    private int calculateHP() {
        int baseHP = stats[0];
        int IV_HP = IV[0];
        int EV_HP = EV[0];
        return (int) (((2 * baseHP + IV_HP + (EV_HP / 4)) * level) / 100 + level + 10);
    }

    private int[] getBaseStats(String species) {
        int[] baseStats = new int[6];
        switch (species) {
            case "Bulbasaur":
                baseStats[0] = 45;
                baseStats[1] = 49;
                baseStats[2] = 49;
                baseStats[3] = 65;
                baseStats[4] = 65;
                baseStats[5] = 45;
                break;
            case "Ivysaur":
                baseStats[0] = 60;
                baseStats[1] = 62;
                baseStats[2] = 63;
                baseStats[3] = 80;
                baseStats[4] = 80;
                baseStats[5] = 60;
                break;
            case "Venusaur":
                baseStats[0] = 80;
                baseStats[1] = 82;
                baseStats[2] = 83;
                baseStats[3] = 100;
                baseStats[4] = 100;
                baseStats[5] = 80;
                break;
            case "Charmander":
                baseStats[0] = 39;
                baseStats[1] = 52;
                baseStats[2] = 43;
                baseStats[3] = 60;
                baseStats[4] = 50;
                baseStats[5] = 65;
                break;
            // suite
        }
        return baseStats;
    }

    public void displayStats() {
        System.out.println("Species: " + species);
        System.out.println("Level: " + level);
        System.out.println("HP: " + HP);
        System.out.println("Attack: " + Atk);
        System.out.println("Defense: " + Def);
        System.out.println("Special Attack: " + SpA);
        System.out.println("Special Defense: " + SpD);
        System.out.println("Speed: " + Spe);
    }
}
