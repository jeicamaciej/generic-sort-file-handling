package main.java.jeicam;

import main.java.jeicam.sort.BubbleSort;

import java.io.File;

public class Main {

    public static void main(String[] args) throws Exception {

        Database database = Database.getInstance();
        database.readPeople(new File(args[0]));
        //database.displayPeople();
        database.peopleToXML(database.sortAndDisplayPeople(new BubbleSort(),"name"),"dupa.xml");
    }
}

