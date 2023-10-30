package mytest.mvc;

public class TextController {
    private TextModel model;
    private TextView view;

    public TextController(TextModel model, TextView view) {
        this.model = model;
        this.view = view;
    }

    public void loadContentFromFile(String fileName) {
        model.loadContentFromFile(fileName);
        view.displayText(model.getContent());
    }
}
