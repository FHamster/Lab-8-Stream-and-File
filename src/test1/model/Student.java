package test1.model;

import java.io.Serializable;
import java.util.Scanner;

public class Student implements Serializable
{
    private int id;
    private String name;
    private int age;
    private double grade;

    private static int primaryID;

    public Student(String fileString)
    {
        Scanner scanner = new Scanner(fileString);
        setId(scanner.nextInt());
        setName(scanner.next());
        setAge(scanner.nextInt());
        setGrade(scanner.nextDouble());
    }

    public Student(int id, String name, int age, double grade)
    {
        this.id = id;
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    public double getGrade()
    {
        return grade;
    }

    public void setGrade(double grade)
    {

        this.grade = grade;
    }

    @Override
    public String toString()
    {
        return String.format("id:%d name:%s age:%d grade:%f,", id, name, age, grade);
    }
}

/*
class stutest
{
    public static void main(String[] args)
    {
        Student student = new Student("12 jcoak 23 144");
        System.out.println(student);

    }
}*/

