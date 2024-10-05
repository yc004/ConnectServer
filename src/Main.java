import javax.swing.*;
import java.awt.*;

import com.formdev.flatlaf.IntelliJTheme;
import com.formdev.flatlaf.FlatIntelliJLaf;

// 这里是程序的入口


public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
//            基本设置
            JFrame frame = new JFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(600, 400);
            frame.setLocationRelativeTo(null);
            frame.setResizable(false);
            frame.setTitle("活力调频服务器登录系统");

            Image ico = new ImageIcon("img\\mainIcon.png").getImage();
            frame.setIconImage(ico);

            try {
                UIManager.setLookAndFeel(new FlatIntelliJLaf());
            } catch (Exception e) {
                e.printStackTrace();
            }

//            将主面板设置为内容面板
            index index = new index();
            frame.setContentPane(index.getMainPanel());

//            设置窗口可见
            frame.setVisible(true);
        });
    }
}