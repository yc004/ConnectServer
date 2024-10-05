public class LoginService {

    public boolean login(String ip, String port, String folder, String username, String password) {
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


//        判断连接是否成功
        int proxyExitCode = util.runCommand("runas", "/user:Administrator", "cmd", "/c", "chcp", "65001", "&&", "netsh", "interface", "portproxy", "add", "v4tov4",
                "listenaddress=127.0.0.1", "listenport=445", "connectaddress=" + ip, "connectport=" + port);
        if (proxyExitCode == 0) {
            logger.log("端口映射成功");
        } else {
            logger.log("端口映射失败");
        }

        int loginExitCode = util.runCommand("cmd", "/c", "chcp", "65001", "&&", "net", "use", "*", "\\127.0.0.1\\" + folder, "/user:" + username, password, "/persistent:yes");


        if (loginExitCode == 0) {
            logger.log("登录成功");
            return true;
        } else if (loginExitCode == 1) {
            logger.log("登录失败，指令错误");
            return false;
        } else if (loginExitCode == 2) {
            logger.log("登录失败，网络错误");
            return false;
        } else {
            logger.log("登录失败，未知错误");
            return false;
        }
    }
}
