import javax.swing.*;
import java.awt.*;

public class View extends JFrame {
    private Controller controller;

    public View(Controller controller) {
        super("");
        this.controller = controller;
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(500, 500));
        setupUI();
        pack();
    }

    public void setupUI() {
        JPanel contentPanel = new JPanel();



        getContentPane().add(contentPanel);
    }
}
