package mytest.mvc;

public class MainProgram {
    public static void main(String[] args) {
        TextModel model = new TextModel();
        TextView view = new TextView();
        TextController controller = new TextController(model, view);

        controller.loadContentFromFile("E://input.txt");
    }
}
