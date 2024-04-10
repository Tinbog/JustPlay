package com.tinbog.Just;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}


class PixivImageDownloader {

    public static void main(String[] args) {
        String pixivUrl = "https://www.pixiv.net/artworks/96384710"; // 替换成你要下载的Pixiv图片的URL
        String downloadDirectory = "D:\\Picture\\3DMark"; // 替换成你要保存图片的本地目录路径

        try {
            downloadPixivImage(pixivUrl, downloadDirectory);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void downloadPixivImage(String pixivUrl, String downloadDirectory) throws IOException {
        // 使用Jsoup连接到Pixiv页面
        Document doc = Jsoup.connect(pixivUrl).get();

        // 获取图片元素
        Elements imgElements = doc.select("img[src~=(?i)\\.(png|jpe?g|gif)]");

        // 遍历图片元素并下载图片
        int i = 1;
        for (Element imgElement : imgElements) {
            String imgUrl = imgElement.attr("src");
            // 下载图片到本地
            downloadImage(imgUrl, downloadDirectory + "/pixiv_image_" + i + ".jpg");
            i++;
        }
    }

    private static void downloadImage(String imageUrl, String destinationFile) throws IOException {
        URL url = new URL(imageUrl);
        try (BufferedInputStream in = new BufferedInputStream(url.openStream());
             FileOutputStream fileOutputStream = new FileOutputStream(destinationFile)) {
            byte[] dataBuffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = in.read(dataBuffer, 0, 1024)) != -1) {
                fileOutputStream.write(dataBuffer, 0, bytesRead);
            }
        }
    }
}
