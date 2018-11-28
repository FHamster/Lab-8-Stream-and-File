package test1.scan;

import test1.model.Student;
import test1.util.MyUtil;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ScanTest
{
    public static void main(String[] args) throws IOException
    {
        //file对象
        File file = new File("src/test1/scan/file.txt");

        //Scanner
        Scanner scan = new Scanner(file);
        //PrintWriter
        PrintWriter writer = new PrintWriter(file);
        List<Student> list = MyUtil.getStudentList(MyUtil.TestSize);

        //out
        writeStudentList(list, writer);
        writer.close();


        //in
        List<Student> listIn = readStudentList(scan);
        for (Student x : listIn)
        {
            System.out.println(x);
        }
        scan.close();

    }

    /**
     * @param scan
     * @return 读取的student list
     */
    public static List<Student> readStudentList(Scanner scan)
    {
        List<Student> list = new ArrayList<>();
        Student stu;
        String buffer;
        try
        {
            while ((buffer = scan.nextLine()) != null)
            {
                stu = new Student(buffer);
                list.add(stu);
            }
        } catch (Exception e)
        {
//            e.printStackTrace();
        }

        return list;
    }

    /**
     * @param list 输入的student list
     * @param writer
     * @throws IOException
     */
    public static void writeStudentList(List<Student> list, PrintWriter writer)
    {
        for (Student x : list)
        {
            writer.print(MyUtil.toFileString(x));
        }
    }
}