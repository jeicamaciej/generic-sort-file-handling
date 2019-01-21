package jeicam;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Database {
    private static Database INSTANCE;
    private List<People> people;
    //private String path;

    public void readPeople(String path) throws Exception {
        File file = new File(path);
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {

            while (!(line = br.readLine()).isEmpty()) {
                String []test = line.split(",");
                people.add(new People(test[0],test[1],test[2],test[3],test[4],test[5],test[6]));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void displayPeople() {
        for(People person : people){
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
