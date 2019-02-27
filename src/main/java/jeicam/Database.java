package main.java.jeicam;

import org.jetbrains.annotations.NotNull;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Database {

    private static Database INSTANCE;
    private List<Person> people;
    private DataValidation dataValidation;
    private final static String CSV_FIELD_SEPARATOR = ",";

    public void peopleToXML(List<Person> sortedList, String fileName) throws JAXBException {
        try {
            FileOutputStream fos = new FileOutputStream(fileName);
            JAXBContext jaxbContext = JAXBContext.newInstance(main.java.jeicam.Person.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            for(int i=0;i< sortedList.size();i++) {
                marshaller.marshal(sortedList.get(i), fos);
            }
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    List sortAndDisplayPeople(Sorter sortable, String fieldName) {
        if (fieldName == null) {
            System.out.println("fieldName == null, sorting is impossible, same collection returned");
            return people;
        }
        return sortable.sort(people, fieldName);
    }

    public void readPeople(@NotNull File file) throws Exception {
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader(dataValidation.fileContentValidation(file)))) {
            while ((line = br.readLine()) != null) {
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
