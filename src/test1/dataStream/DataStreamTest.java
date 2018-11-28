package test1.dataStream;

import test1.util.MyUtil;
import test1.model.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DataStreamTest
{
    public static void main(String[] args) throws IOException
    {
        //file对象
        File file = new File("src/test1/dataStream/file.txt");
        //DataOutputStream
        DataOutputStream outputStream = new DataOutputStream(new FileOutputStream(file));
        //DataInputStream
        DataInputStream inputStream = new DataInputStream(new FileInputStream(file));

        List<Student> list = MyUtil.getStudentList(MyUtil.TestSize);

        writeStudentList(list, outputStream);
        list = readStudentList(inputStream);

        //我只是想输出到控制台看看
        for (Student x : list)
        {
            System.out.println(x);
        }

        inputStream.close();
        outputStream.close();
    }

    //转换为方便读取的记录字符串
    public static String toFileString(Student s)
    {
        return String.format("%d %s %d %f\n", s.getId(), s.getName(), s.getAge(), s.getGrade());
    }

    /**
     * @param dis 字节输入流
     * @return 读取的student list
     */
    public static List<Student> readStudentList(DataInputStream dis)
    {
        List<Student> list = new ArrayList<>();
        Student stu;
        String buffer;
        try
        {
            while ((buffer = dis.readUTF()) != null)
            {
                stu = new Student(buffer);
                list.add(stu);
            }
        } catch (IOException e)
        {
//            e.printStackTrace();
        }
        return list;
    }

    /**
     * @param list 输入的student list
     * @param dos
     * @throws IOException
     */
    public static void writeStudentList(List<Student> list, DataOutputStream dos) throws IOException
    {
        for (Student x : list)
        {
            dos.writeUTF(toFileString(x));
        }
    }
/*
    public static Student readStudent(DataInputStream dis) throws IOException
    {
        Student student = new Student(dis.readUTF());
        return student;
    }

    public static void writeStudent(Student s, DataOutputStream dos) throws IOException
    {
        dos.writeUTF(toFileString(s));
    }*/
}
