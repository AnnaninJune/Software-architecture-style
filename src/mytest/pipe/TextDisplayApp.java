package mytest.pipe;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class TextDisplayApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入文件名: ");
        String filename = scanner.nextLine();

        try {
            // 从文件中读取文本
            String text = readTextFromFile(filename);

            // 创建管道
            Pipe inputFilter = new InputFilter();
            Pipe highlightFilter = new HighlightFilter();

            // 设置管道的顺序
            inputFilter.setNextPipe(highlightFilter);

            // 处理文本
            String output = inputFilter.handle(text);

            // 输出处理结果
            System.out.println(output);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String readTextFromFile(String filename) throws IOException {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
                sb.append("\n");
            }
        }
        return sb.toString();
    }
}