import javax.swing.*;
import java.util.Arrays;

public class index {
    private JTextField IPAddress;
    private JTextField Port;
    private JTextField folder;
    private JTextField username;
    private JPasswordField password;
    private JButton LoginButton;
    private JButton ResetButton;
    private JPanel mainPanel;


    public index() {
        LoginButton.addActionListener(e -> {
            String msg = "IP地址：" + IPAddress.getText()
                    + "\n端口号：" + Port.getText()
                    + "\n共享文件夹：" + folder.getText()
                    + "\n用户名：" + username.getText()
                    + "\n密码：" + Arrays.toString(password.getPassword());
            logger logger = new logger();
            logger.log(msg);
        });

        ResetButton.addActionListener(e -> {
            System.out.println("重置设置");
        });
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }
}
