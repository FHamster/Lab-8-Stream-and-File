package test2;

import java.io.File;

public class FileCounter
{
    private File file;

    public FileCounter(File file)
    {
        this.file = file;
    }

    public int getFileCount()
    {

        File[] list = file.listFiles();

        int fileCount = 0;

        for (int i = 0; i < list.length; i++)
        {
            if (list[i].isFile())
            {
                fileCount++;
            }
        }
        return fileCount;
    }

    public int getFolderCount()
    {
        File[] list = file.listFiles();

        int folderCount = 0;

        for (int i = 0; i < list.length; i++)
        {
            if (list[i].isDirectory())
            {
                folderCount++;
            }
        }
        return folderCount;
    }
}
