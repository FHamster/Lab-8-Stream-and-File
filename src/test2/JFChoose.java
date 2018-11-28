package test2;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class JFChoose extends JFrame
{
    private JPanel chooser;

    JFileChooser jfc;

    public JFChoose()
    {
        this.setTitle("File");

        setSize(800, 600);

        //初始化FileChooser
        jfc = new JFileChooser();
        jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        jfc.showDialog(new JLabel(), "选择");
        File file = jfc.getSelectedFile();

        //layout
        setLayout(new GridLayout(3, 1));

        //TextField
        TextField txt = new TextField("FileName ：" + file.getName());
        FileCounter ff = new FileCounter(file);
        TextField fileCount = new TextField("file : " + ff.getFileCount());
        TextField folderCount = new TextField("folder : " + ff.getFolderCount());

        Font font = new Font("宋体", Font.BOLD, 50);
        txt.setFont(font);
        fileCount.setFont(font);
        folderCount.setFont(font);

        this.add(txt);
        this.add(fileCount);
        this.add(folderCount);
    }
}
