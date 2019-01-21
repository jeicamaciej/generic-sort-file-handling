package jeicam;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Database {
    private static Database INSTANCE;
    private List<Person> people;

    public void readPeople(File file) throws Exception {
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {

            while (!(line = br.readLine()).isEmpty()) {
                people.add(toPerson(line));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    Person toPerson(String line) {
        String[] array = line.split(",");
        return new Person(array[0], array[1], array[2], array[3], array[4], array[5], array[6]);
    }

    public void displayPeople() {
        for (Person person : people) {
            System.out.println(person);
        }
    }


    private Database() {
        this.people = new ArrayList<>();
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

}
