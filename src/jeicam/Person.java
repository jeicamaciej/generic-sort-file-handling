package jeicam;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class Person implements Comparable<Person> {

    private final String name;
    private final String surname;
    private final String sex;
    private final String personalId;
    private final String height;
    private final String weight;
    private final String age;

    public Person(String name, String surname, String sex, String personalId, String height, String weight, String age) {
        this.name = name;
        this.surname = surname;
        this.sex = sex;
        this.personalId = personalId;
        this.height = height;
        this.weight = weight;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getSex() {
        return sex;
    }

    public String getPersonalId() {
        return personalId;
    }

    public String getHeight() {
        return height;
    }

    public String getWeight() {
        return weight;
    }

    public String getAge() {
        return age;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name) &&
                Objects.equals(surname, person.surname) &&
                Objects.equals(sex, person.sex) &&
                Objects.equals(personalId, person.personalId) &&
                Objects.equals(height, person.height) &&
                Objects.equals(weight, person.weight) &&
                Objects.equals(age, person.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, sex, personalId, height, weight, age);
    }

    @Override
    public int compareTo(@NotNull Person person) {
        return Integer.parseInt(this.getAge()) - Integer.parseInt(person.getAge());
    }
}
