public class Pet {
    private String name;
    int match;
    private int[] pref;

    public Pet(String name) {
        match = 0;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPref(int[] pref) {
        this.pref = pref;
    }

    public int findPref(int proposed) {

    }
}
