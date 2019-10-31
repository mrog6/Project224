import javax.swing.*;
import java.awt.*;

public class View extends JFrame {
    private Controller controller;
    protected JLabel statusLabel;

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



        statusLabel = new JLabel();
        contentPanel.add(statusLabel);

        getContentPane().add(contentPanel);
    }
}
