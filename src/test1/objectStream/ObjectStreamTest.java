package test1.objectStream;

import test1.model.Student;
import test1.util.MyUtil;

import java.io.*;
import java.util.List;

public class ObjectStreamTest
{

    public static void main(String[] args) throws IOException
    {
        //file对象
        File file = new File("src/test1/objectStream/file.txt");

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));
        List<Student> list = MyUtil.getStudentList(MyUtil.TestSize);

        writeStudentList(list, objectOutputStream);

        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file));
        list = readStudentList(objectInputStream);

        for (Student x : list)
        {
            System.out.println(x);
        }
    }

    /**
     * @param ois 字节输入流
     * @return 读取的student list
     */
    public static List<Student> readStudentList(ObjectInputStream ois)
    {
        List<Student> list = null;
        try
        {
            list = (List<Student>) ois.readObject();
        } catch (IOException e)
        {
            e.printStackTrace();
        } catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * @param list 输入的student list
     * @param oos  输出的对象流
     * @throws IOException
     */
    public static void writeStudentList(List<Student> list, ObjectOutputStream oos) throws IOException
    {
        oos.writeObject(list);
    }
}
