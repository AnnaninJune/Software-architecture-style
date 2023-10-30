package mytest;

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.*;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import javax.swing.text.StyledDocument;

public class TextDisplayApp extends JFrame {
    private JTextPane textPane;

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
        processInputFile("E:\\input.txt");
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
            displayText(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void displayText(String text) {
        StyledDocument doc = textPane.getStyledDocument();
        Style defaultStyle = doc.getStyle(StyleContext.DEFAULT_STYLE);
        Style largeStyle = doc.addStyle("large", defaultStyle);
        StyleConstants.setFontSize(largeStyle, 24);

        try {
            doc.insertString(doc.getLength(), text.substring(0, 1), largeStyle);
            doc.insertString(doc.getLength(), text.substring(1), defaultStyle);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

