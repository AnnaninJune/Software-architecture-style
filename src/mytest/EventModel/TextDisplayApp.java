package mytest.EventModel;


import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

// 主应用程序类
public class TextDisplayApp extends JFrame implements Subject {
    private JTextPane textPane;
    private List<Observer> observers = new ArrayList<>();

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                TextDisplayApp app = new TextDisplayApp();
                app.setVisible(true);
            }
        });
    }

    public TextDisplayApp() {
        initializeUI();
        Observer textObserver = new TextObserver(textPane);
        registerObserver(textObserver); // 注册观察者
        processInputFile("E:\\input.txt");
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String text) {
        for (Observer observer : observers) {
            observer.update(text);
        }
    }

    private void initializeUI() {
        setTitle("Text Display App");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 400);

        textPane = new JTextPane();
        textPane.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textPane);
        getContentPane().add(scrollPane, BorderLayout.CENTER);
    }

    private void processInputFile(String fileName) {
        try (BufferedReader inputFile = new BufferedReader(new FileReader(fileName))) {
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = inputFile.readLine()) != null) {
                sb.append(line).append("\n");
            }
            String content = sb.toString();
            notifyObservers(content); // 读取完文件后通知观察者更新文本
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

