/*
* 工具类，用于存储一些基本工具
* */

import java.io.File;

public class util {
    public static boolean folderExists(String path) {
        File folder = new File(path);
        return folder.exists();
    }

    public static void createFolder(String folder) {
        File directory = new File(folder);
        try {
            if (directory.mkdir()) {
                System.out.println("Folder created");
            }else {
                System.out.println("Folder not created");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
