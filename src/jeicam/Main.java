package jeicam;

public class Main {

    public static void main(String[] args)throws Exception{
        Database database = Database.getInstance();
        database.readPeople(args[0]);
        database.displayPeople();
    }
}
