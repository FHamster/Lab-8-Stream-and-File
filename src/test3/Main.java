package test3;

import java.io.*;
import java.util.Arrays;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        //file对象
        File file = new File("src/test3/file.txt");
        int length = 16;

        DataInputStream dis = new DataInputStream(new FileInputStream(file));

        byte[] itemBuf = new byte[length];
//        while ()
        for (int i = 0; dis.read(itemBuf, 0, length) != -1; i += 16)
        {
            System.out.printf("%08X %s %s\n", i, toHexString(itemBuf), toUTFString(itemBuf, length));

            //buffer填充0

            Arrays.fill(itemBuf, (byte) 0);
        }
    }

    /**
     * @param itemBuf 存储byte的buffer
     * @param length byte的数量
     * @return buffer生成的字符串
     */
    public static String toUTFString(byte[] itemBuf, int length)
    {
        return new String(itemBuf, 0, length);
    }

    /**
     * @param itemBuf 存储byte的buffer
     * @return buffer的16进制字符串
     */
    public static String toHexString(byte[] itemBuf)
    {
        StringBuffer buffer = new StringBuffer();
        for (byte x : itemBuf)
        {
            buffer.append(String.format("%02X ", x));
        }
        return buffer.toString();
    }
}
