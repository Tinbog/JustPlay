package com.tinbog.Just;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class FileRenamer {
    private static int counter = 1;
    public static void main(String[] args) {
        File rootDir = new File("I:\\Users\\98624\\Downloads\\莉莉丝"); // 替换成你的源目录路径
        File targetDir = new File("I:\\Users\\98624\\Downloads\\莉莉丝\\test"); // 替换成你的目标目录路径
        try {
            renameFilesAndCopyToDirectory(rootDir, targetDir);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void renameFilesAndCopyToDirectory(File directory, File targetDirectory) throws IOException {
        if (!targetDirectory.exists()) {
            System.out.println(targetDirectory.mkdirs()); // 创建目标目录
        }

        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    renameFilesAndCopyToDirectory(file, targetDirectory); // 递归调用遍历子文件夹
                } else {

                    String newFileName = file.getName() ; // 构造新文件名
                    File newFile = new File(targetDirectory, newFileName);
                    Files.copy(file.toPath(), newFile.toPath(), StandardCopyOption.REPLACE_EXISTING); // 复制文件
                    System.out.println("File copied successfully: " + file.getAbsolutePath() + " -> " + newFile.getAbsolutePath());
                    counter++;
                }
            }
        }
    }
}

