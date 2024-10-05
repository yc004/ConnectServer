/**
 * 该类用于记录程序运行时的日志，以便在程序运行出现问题时查找问题
 * */

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class logger {
    public logger() {
//        检测存储log的文件夹是否存在
        if (!util.folderExists("data")) {
//            创建文件夹
            util.createFolder("data");
        }
    }


    public void log(String msg) {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String fommattedtime = now.format(formatter);


        System.out.println(msg);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("data/log.log", true))) {
            writer.write(fommattedtime
                    + "\n-------------------------------------\n"
                    + msg
                    + "\n-------------------------------------\n\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
