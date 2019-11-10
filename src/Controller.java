import javax.swing.*;
import java.awt.*;

public class Controller {
    private Model model;
    private View view;

    public Controller(Model model) {
        this.model = model;
        this.view = new View(this);

        Color newColor = JColorChooser.showDialog(null,
                "Choose Symbol Color",
                view.banner.getBackground());

    }

    public static void main(String[] args) {
        Model model = new Model();
        Controller controller = new Controller(model);
    }
}
