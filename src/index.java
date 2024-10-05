import javax.swing.*;

public class index {
    private JTextField IPAddress;
    private JTextField Port;
    private JTextField Folder;
    private JTextField Username;
    private JPasswordField Password;
    private JButton LoginButton;
    private JButton ResetButton;
    private JPanel mainPanel;
    private JLabel Notification;
    private JProgressBar Progress;
    private JCheckBox Memory;


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
                if (loginService.login(ip, port, folder, username, password, Notification)) {
                    Notification.setText("登录成功");
                    System.out.println("Login Successful");
                }
            } catch (IllegalStateException exception) {
                Notification.setText("信息填写不全");
                System.out.println(exception.getMessage());
            }


        });

        ResetButton.addActionListener(e -> {
            ResetService resetService = new ResetService();
            System.out.println("重置");
        });
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }
}
