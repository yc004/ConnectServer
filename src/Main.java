import javax.swing.*;

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

//            将主面板设置为内容面板
            index index = new index();
            frame.setContentPane(index.getMainPanel());

//            设置窗口可见
            frame.setVisible(true);
        });
    }
}