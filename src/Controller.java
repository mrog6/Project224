import com.intellij.ui.JBColor;

import javax.swing.*;
import java.awt.*;

public class Controller extends JPanel {
    private Model model;
    private View view;
    protected int turn;
    protected String playerOne;
    protected String playerTwo;

    public Controller(Model model) {
        this.model = model;
        this.view = new View(this);
        Color c = Color.WHITE;
        startOver();

        Color newColor1 = JColorChooser.showDialog(null,
                 playerOne + ", choose your symbol color!",
                view.banner.getBackground());
        if (newColor1 == null || newColor1.equals(c)) {
            view.playerOneName.setForeground(Color.BLACK);
        }
        else {
            view.playerOneName.setForeground(newColor1);
        }

        Color newColor2 = JColorChooser.showDialog(null,
                playerTwo + ", choose your symbol color!",
                view.banner.getBackground());
        if (newColor2 == null || newColor2.equals(c)) {
            view.playerTwoName.setForeground(Color.BLACK);
        }
        else {
            view.playerTwoName.setForeground(newColor2);
        }



        //view.statusLabel.setForeground(newColor);
    }

    public void startOver() {
        playerOne = JOptionPane.showInputDialog("Please enter player 1's name");
        if (playerOne.length() != 0)
            view.playerOneName.setText(playerOne);
        else
            view.playerOneName.setText("Player 1");

        playerTwo = JOptionPane.showInputDialog("Please enter player 2's name");
        if (playerTwo.length() != 0)
            view.playerTwoName.setText(playerTwo);
        else
            view.playerTwoName.setText("Player 2");

        this.turn = 1;
        view.statusLabel.setText(view.playerOneName.getText() + "'s turn");
    }

    public void pressButton(int index) {

    }

    public static void main(String[] args) {
        Model model = new Model();
        Controller controller = new Controller(model);
    }
}
