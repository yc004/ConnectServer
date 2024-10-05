/**
 * 该类用于实现登录服务
 * */

import javax.swing.*;

public class LoginService {

    public boolean login(String ip, String port, String folder, String username, String password, JLabel label) {
//        判断是否全部信息都已经填写
        if ((util.stringEmpty(ip)
                || util.stringEmpty(port)
                || util.stringEmpty(folder)
                || util.stringEmpty(username)
                || util.stringEmpty(password))) {
            throw new IllegalStateException("信息填写不完整");
        }

        String msg = "IP地址：" + ip
                + "\n端口号：" + port
                + "\n共享文件夹：" + folder
                + "\n用户名：" + username
                + "\n密码：" + password;
        logger logger = new logger();
        logger.log(msg);
        label.setText("登陆中...");


//        指定端口映射（需要管理员权限）
        int proxyExitCode = util.runCommand("runas", "/user:Administrator", "\"cmd", "/c", "chcp", "65001", "&&", "netsh",
                "interface", "portproxy", "add", "v4tov4\"",
                "listenaddress=127.0.0.1", "listenport=445", "connectaddress=" + ip, "connectport=" + port);
        if (proxyExitCode == 0) {
            label.setText("端口映射成功");
            logger.log("端口映射成功");
        } else {
            label.setText("端口映射失败");
            logger.log("端口映射失败");
        }

//        映射SMB服务器到本地
        int loginExitCode = util.runCommand("cmd", "/c", "chcp", "65001", "&&", "net", "use", "*",
                "\\127.0.0.1\\" + folder, "/user:" + username, password, "/persistent:yes");


        if (loginExitCode == 0) {
            label.setText("登录成功");
            logger.log("登录成功");
            return true;
        } else if (loginExitCode == 1) {
            label.setText("指令错误");
            logger.log("登录失败，指令错误");
            return false;
        } else if (loginExitCode == 2) {
            label.setText("网络错误");
            logger.log("登录失败，网络错误");
            return false;
        } else {
            label.setText("登录失败，未知错误");
            logger.log("登录失败，未知错误");
            return false;
        }
    }
}
