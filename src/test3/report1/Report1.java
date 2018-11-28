package test3.report1;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Report1
{
//    这是report1的测试代码
    public static void main(String[] args) throws IOException
    {
        //file对象
        File file = new File("src/test3/file.txt");
        int totalSpace = 32;

        DataInputStream dis = new DataInputStream(new FileInputStream(file));

        byte[] itemBuf = new byte[totalSpace];

        dis.read(itemBuf, 0, totalSpace);

        for (int i = 0; i < 1024; i++)
        {
            System.out.printf("%d %s\n", i, new String(itemBuf, 0, i));
        }

    }
}
