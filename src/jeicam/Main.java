package jeicam;

import java.io.File;

public class Main {

    public static void main(String[] args)throws Exception{
        Database database = Database.getInstance();
        database.readPeople(new File("E:\\test.txt"));
        database.displayPeople();
    }
}

