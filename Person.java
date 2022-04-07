import java.util.Scanner;

/**
 * Class to represent a person
 * @author Ali Ibrahim
 */
public class Person {
    private final String name;
    private int match;
    private int[] pref;

    /**
     * constructor
     * pre:
     * post:
     */
    public Person(String name) {
        match = 1;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPref(int[] pref) {
        this.pref = pref;
    }

    public int getPet() {
        return pref[match];
    }

    public void nextPet() {
        match++;
    }
}
