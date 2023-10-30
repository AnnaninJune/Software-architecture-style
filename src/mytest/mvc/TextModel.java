package mytest.mvc;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TextModel {
    private String content;

    public void loadContentFromFile(String fileName) {
        try (BufferedReader inputFile = new BufferedReader(new FileReader(fileName))) {
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = inputFile.readLine()) != null) {
                sb.append(line).append("\n");
            }
            content = sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getContent() {
        return content;
    }
}
