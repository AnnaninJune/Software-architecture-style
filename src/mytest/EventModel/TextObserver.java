package mytest.EventModel;

import javax.swing.*;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import javax.swing.text.StyledDocument;

class TextObserver implements Observer {
    private JTextPane textPane;

    public TextObserver(JTextPane textPane) {
        this.textPane = textPane;
    }

    @Override
    public void update(String text) {
        StyledDocument doc = textPane.getStyledDocument();
        Style defaultStyle = doc.getStyle(StyleContext.DEFAULT_STYLE);
        Style largeStyle = doc.addStyle("large", defaultStyle);
        StyleConstants.setFontSize(largeStyle, 24);

        try {
            doc.insertString(doc.getLength(), text.substring(0, 1), largeStyle);
            doc.insertString(doc.getLength(), text.substring(1), defaultStyle);
        } catch (Exception e) {
            // 将更新后的文本内容设置到textPane中
            textPane.setStyledDocument(doc);
            e.printStackTrace();
        }
    }
}