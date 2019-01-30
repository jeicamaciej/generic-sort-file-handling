package jeicam;

import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Database {

    private static Database INSTANCE;
    private List<Person> people;
    private DataValidation dataValidation;

    public void readPeople(@NotNull File file) throws Exception {
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            while (!(line = br.readLine()).isEmpty()) {
                if (null != toPerson(line)) {
                    people.add(toPerson(line));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    Person toPerson(@NotNull String line) throws DataException {
        String array[] = dataValidation.validateString(line.split(","));
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
