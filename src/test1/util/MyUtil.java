package test1.util;

import test1.model.Student;

import java.util.ArrayList;
import java.util.List;

public class MyUtil
{
    public static int TestSize = 10000;
    public static List<Student> getStudentList(int n)
    {
        Student s1 = new Student(12, "我的妈也", 45, 345.3);
        Student s2 = new Student(12, "马也", 45, 345.3);

        List<Student> list = new ArrayList<>();
        list.add(s1);
        for (int i = 0; i < n; i++)
        {
            list.add(s2);
        }
        return list;
    }

    //转换为方便读取的记录字符床
    public static String toFileString(Student s)
    {
        return String.format("%d %s %d %f\n", s.getId(), s.getName(), s.getAge(), s.getGrade());
    }

}
