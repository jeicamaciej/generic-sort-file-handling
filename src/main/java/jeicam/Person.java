package main.java.jeicam;

import org.jetbrains.annotations.NotNull;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import java.util.ArrayList;
import java.util.Objects;

@XmlRootElement
@XmlSeeAlso(ArrayList.class)
public class Person implements Comparable<Person> {

    @XmlElement(name = "name")
    private  String name;
    @XmlElement(name = "surname")
    private String surname;
    @XmlElement(name = "sex")
    private  String sex;
    @XmlAttribute(name = "id")
    private  String personalId;
    @XmlElement(name = "height")
    private  String height;
    @XmlElement(name = "weight")
    private  String weight;
    @XmlElement(name = "age")
    private  String age;

    public Person(String name, String surname, String sex, String personalId, String height, String weight, String age) {
        this.name = name;
        this.surname = surname;
        this.sex = sex;
        this.personalId = personalId;
        this.height = height;
        this.weight = weight;
        this.age = age;
    }

    public Person() {
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
    public int compareTo(@NotNull Person o) {
        return 0;
    }
}
