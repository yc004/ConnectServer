import javax.swing.*;
import java.util.Arrays;

public class index {
    private JTextField IPAddress;
    private JTextField Port;
    private JTextField Folder;
    private JTextField Username;
    private JPasswordField Password;
    private JButton LoginButton;
    private JButton ResetButton;
    private JPanel mainPanel;


    public index() {
        LoginButton.addActionListener(e -> {
            String ip = IPAddress.getText();
            String port = Port.getText();
            String folder = Folder.getText();
            String username = Username.getText();
            String password = String.valueOf(Password.getPassword());
            LoginService loginService = new LoginService();

//            发起登录请求
            try {
                if (loginService.login(ip, port, folder, username, password)) {

                }
            } catch (IllegalStateException exception) {
                System.out.println(exception.getMessage());
            }


        });

        ResetButton.addActionListener(e -> System.out.println("重置设置"));
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }
}
