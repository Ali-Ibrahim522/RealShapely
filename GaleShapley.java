import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class GaleShapley {
    private static Person[] people;
    private static Pet[] pets;

    public static void main(String[] args) {
        File file = new File("src\\program1data.txt");
        Scanner data;
        try {
            data = new Scanner(file);
            initializeData(data);
            stableMatching();
        } catch(FileNotFoundException ex) {
            System.out.println("File not found");
        }
    }

    public static void stableMatching() {
        Queue<Integer> unmatched = new LinkedList<>();
        for (int i = 1; i < people.length; i++) {
            unmatched.add(i);
        }
        while(!unmatched.isEmpty()) {
            int person = unmatched.remove();
            int pet = people[person].getPet();
            if (pets[pet].getMatch() == 0) {

            } else if (findPref(petsPref[pet], person, isMatched[pet]) == person) {
                unmatched.add(isMatched[pet]);
                isMatched[pet] = person;
                matching[person] = people[person] + " / " + pets[pet];
            } else {
                peopleIndices[person]++;
                unmatched.add(person);
            }
            unmatched.remove();
        }
    }

    public static void initializeData(Scanner data) {
        int n = data.nextInt();
        n++;
        people = new Person[n];
        data.nextLine();
        for (int i = 1; i < n; i++) {
            people[i] = new Person(data.nextLine());
        }
        int[] pref = new int[n];
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                pref[j] = data.nextInt();
            }
            people[i].setPref(pref);
        }
        data.nextLine();
        pets = new Pet[n];
        for (int i = 0; i < n; i++) {
            pets[i] = new Pet(data.nextLine());
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                pref[data.nextInt()] = i;
            }
            pets[i].setPref(pref);
        }
    }
}
