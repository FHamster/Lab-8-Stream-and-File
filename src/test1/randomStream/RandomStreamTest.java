package test1.randomStream;

import test1.model.Student;
import test1.util.MyUtil;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class RandomStreamTest
{
    public static void main(String[] args) throws IOException
    {
        File file = new File("src/test1/randomStream/file.txt");
        RandomAccessFile raf = new RandomAccessFile(file, "rw");

        List<Student> list = MyUtil.getStudentList(MyUtil.TestSize);
        writeStudentList(list, raf);
        raf.close();

        RandomAccessFile raf2 = new RandomAccessFile(file, "rw");
        list = readStudentList(raf2);

        for (Student x : list)
        {
            System.out.println(x);
        }
    }


    public static List<Student> readStudentList(RandomAccessFile raf)
    {
        List<Student> list = new ArrayList<>();
        Student stu;
        String buffer;
        try
        {
            while ((buffer = raf.readUTF()) != null)
            {
                stu = new Student(buffer);
                list.add(stu);
            }
        } catch (Exception e)
        {
            e.printStackTrace();
        }

        return list;
    }


    public static void writeStudentList(List<Student> list, RandomAccessFile raf)
    {
        for (Student x : list)
        {
            try
            {
                raf.writeUTF(MyUtil.toFileString(x));
            } catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }
}
