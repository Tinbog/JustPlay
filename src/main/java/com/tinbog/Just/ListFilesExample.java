package com.tinbog.Just;

import java.io.File;

public class ListFilesExample  implements Comparable<ListFilesExample>{
    public static void main(String[] args) {
        // 指定要列出文件的目录路径
        String directoryPath = "I:\\Users\\98624\\Downloads\\dark";

        // 创建一个 File 对象来表示目录
        File directory = new File(directoryPath);

        // 使用 listFiles() 方法获取目录中的所有文件和子目录
        File[] files = directory.listFiles();

        // 检查目录是否存在以及是否是一个目录
        if (directory.exists() && directory.isDirectory()) {
            // 检查是否有文件或目录
            if (files != null && files.length > 0) {
                System.out.println("Files and directories found in " + directoryPath + ":");
                // 遍历文件和目录并输出它们的名称
                for (File file : files) {
                    System.out.println(file.getName());
                }
            } else {
                System.out.println("No files or directories found in " + directoryPath);
            }
        } else {
            System.out.println(directoryPath + " does not exist or is not a directory.");
        }
    }

    @Override
    public int compareTo(ListFilesExample o) {
        return 0;
    }
    public int compareTo(String o) {
        return 0;
    }
}
