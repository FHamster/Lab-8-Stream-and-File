package test2;

import javax.swing.*;
import java.awt.*;

public class TestJFChoose
{
    public static void main(String[] args)
    {
        EventQueue.invokeLater(() ->
        {
            JFChoose frame = new JFChoose();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}
