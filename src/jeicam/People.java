package jeicam;

public class People {

    private String name;
    private String surname;
    private String sex; //lol sex ruchanie 69
    private String personalId;
    private String height;
    private String weight;
    private String age;

    public People(String name, String surname, String sex, String personalId, String height, String weight, String age) {
        this.name = name;
        this.surname = surname;
        this.sex = sex;
        this.personalId = personalId;
        this.height = height;
        this.weight = weight;
        this.age = age;
    }
    public People(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "People{" +
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
