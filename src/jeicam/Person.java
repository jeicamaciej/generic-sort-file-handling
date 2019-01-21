package jeicam;

public class Person {

    private String name;
    private String surname;
    private String sex; //lol sex ruchanie 69
    private String personalId;
    private String height;
    private String weight;
    private String age;

    public Person(String name, String surname, String sex, String personalId, String height, String weight, String age) {
        this.name = name;
        this.surname = surname;
        this.sex = sex;
        this.personalId = personalId;
        this.height = height;
        this.weight = weight;
        this.age = age;
    }
    public Person(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", sex='" + sex + '\'' +
                ", personalId='" + personalId + '\'' +
                ", height=" + height +
                ", weight=" + weight +
                ", age=" + age +
                '}';
    }
}
