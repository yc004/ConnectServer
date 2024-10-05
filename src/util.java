/*
 * 工具类，用于存储一些基本工具
 * */

import java.io.*;
import java.nio.charset.StandardCharsets;

public class util {
//    检查指定文件夹是否存在
    public static boolean folderExists(String path) {
        File folder = new File(path);
        return folder.exists();
    }

//    创建文件夹
    public static void createFolder(String folder) {
        File directory = new File(folder);
        try {
            if (directory.mkdir()) {
                logger log = new logger();
                log.log("文件夹创建成功");
                System.out.println("Folder created");
            } else {
                System.out.println("Folder not created");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    检查字符串是否为空
    public static boolean stringEmpty(String string) {
        return string != null && string.isEmpty();
    }

//    运行控制台指令
    public static int runCommand(String... command) {
        ProcessBuilder processBuilder = new ProcessBuilder(command);
        processBuilder.redirectErrorStream(true);

        try {
            processBuilder.inheritIO();
//            执行指令
            Process process = processBuilder.start();

//            读取返回值
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream(), StandardCharsets.UTF_8));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();

            int exitCode = process.waitFor();
            System.out.println(exitCode);
            return exitCode;
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return -1;
        }
    }
}
