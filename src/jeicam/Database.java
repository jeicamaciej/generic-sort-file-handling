package jeicam;

import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Database {

    private static Database INSTANCE;
    private List<Person> people;
    private DataValidation dataValidation;
    private final static String CSV_FIELD_SEPARATOR = ",";

    Collection sortAndDisplayPeople(Sorter sorter) {
        return sorter.sort(people);
    }

    public void readPeople(@NotNull File file) throws Exception {
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader(dataValidation.fileContentValidation(file)))) {
            while (!(line = br.readLine()).isEmpty()) {
                if (toPerson(line) != null) {
                    people.add(toPerson(line));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Person toPerson(@NotNull String line) throws DataException {
        String array[] = dataValidation.csvLineArrayValidation(line.split(CSV_FIELD_SEPARATOR));
        return new Person(array[0], array[1], array[2], array[3], array[4], array[5], array[6]);
    }

    public void displayPeople() {
        for (Person person : people) {
            System.out.println(person);
        }
    }

    private Database() {
        this.people = new ArrayList<>();
        this.dataValidation = new DataValidation();
    }

    public static Database getInstance() {
        if (INSTANCE == null) {
            synchronized (Database.class) {
                if (INSTANCE == null) {
                    INSTANCE = new Database();
                }
            }
        }
        return INSTANCE;
    }

    public List<Person> getPeople() {
        return people;
    }
}
