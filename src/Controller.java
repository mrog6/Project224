import javax.swing.*;
import java.awt.*;

public class Controller extends JPanel {
    private Model model;
    private View view;
    protected int turn;
    protected String playerOne;
    protected String playerTwo;
    protected Color newColor1;
    protected Color newColor2;

    public Controller(Model model) {
        this.model = model;
        this.view = new View(this);
        Color c = Color.WHITE;
        startOver();

        newColor1 = JColorChooser.showDialog(null,
                playerOne + ", choose your symbol color!",
                view.banner.getBackground());
        if (newColor1 == null || newColor1.equals(c)) {
            view.playerOneName.setForeground(Color.BLACK);
        }
        else {
            view.playerOneName.setForeground(newColor1);
        }

        newColor2 = JColorChooser.showDialog(null,
                playerTwo + ", choose your symbol color!",
                view.banner.getBackground());
        if (newColor2 == null || newColor2.equals(c)) {
            view.playerTwoName.setForeground(Color.BLACK);
        }
        else {
            view.playerTwoName.setForeground(newColor2);
        }
        view.buttons[0][0].setBackground(newColor1);

        //view.statusLabel.setForeground(newColor);
        //^^ do that with the buttons each turn :)
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

    public void pressButton(int i, int j) {

        if (!model.validMove(i, j)) {
            if (turn % 2 == 1) {
                view.statusLabel.setText("Invalid Move. " + view.playerOneName.getText() + "'s turn");
            }
            else if (turn % 2 == 0) {
                view.statusLabel.setText("Invalid Move. " + view.playerTwoName.getText() + "'s turn");
            }
            return;
        }
        else {
            model.insertSymbol(i, j, turn);

            if (turn % 2 == 1) {
                view.buttons[i][j].setText("X");
                view.statusLabel.setText(view.playerTwoName.getText() + "'s turn");
                view.buttons[i][j].setForeground(newColor1);
            }
            else if (turn % 2 == 0) {
                view.buttons[i][j].setText("O");
                view.statusLabel.setText(view.playerOneName.getText() + "'s turn");
                view.buttons[i][j].setForeground(newColor2);
            }


            if (model.checkWin(i, j, turn)) {
                System.out.println("WINNER");
                for (int x = 0; x<15; x++) {
                    for (int y = 0; y<15; y++) {
                        view.buttons[x][y].setEnabled(false);
                    }
                }

                if (turn % 2 == 1) {
                    view.statusLabel.setText(view.playerOneName.getText() + " Wins!");
                }
                else if (turn % 2 == 0) {
                    view.buttons[i][j].setText("O");
                    view.statusLabel.setText(view.playerTwoName.getText() + " Wins!");
                    view.buttons[i][j].setForeground(newColor2);
                }
            }

            turn++;
        }
    }

    public static void main(String[] args) {
        Model model = new Model();
        Controller controller = new Controller(model);
    }
}
