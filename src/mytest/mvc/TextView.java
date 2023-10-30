package mytest.mvc;

import javax.swing.*;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import javax.swing.text.StyledDocument;
import java.awt.*;

public class TextView {
    private JFrame frame;
    private JTextPane textPane;

    public TextView() {
        frame = new JFrame("Text Display App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);

        textPane = new JTextPane();
        textPane.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(textPane);
        frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
    }

    public void displayText(String text) {
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

        frame.setVisible(true);
    }
}
