import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class View extends JFrame implements ActionListener {
    private Controller controller;
    protected JLabel statusLabel;
    protected JLabel banner;
    protected JLabel playerOneName;
    protected JLabel playerTwoName;
    protected JLabel playerOneWins;
    protected JLabel playerOneLosses;
    protected JLabel playerTwoWins;
    protected JLabel playerTwoLosses;
    protected JPanel contentPanel;
    protected JButton resetButton;
    protected JButton saveExitButton;
    protected JButton[] buttons;
    protected final String PLAYER_ONE_SYMBOL = "X";
    protected final String PLAYER_TWO_SYMBOL = "O";


    public View(Controller controller) {
        super("Go-Moku");
        this.controller = controller;
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(800, 1000));
        setupUI();
        pack();
    }

    public void setupUI() {
        contentPanel = (JPanel) getContentPane();
        banner = new JLabel("Welcome to Color Chooser!");

        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));

        // layout for the top half of the app: two gridLayouts for the players inside of a boxLayout
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.X_AXIS));
        topPanel.setPreferredSize(new Dimension(800, 100));

        // player 1 info box
        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new GridLayout(3, 2));
        leftPanel.setBorder(BorderFactory.createTitledBorder("Player 1 (X)"));
        JLabel playerOneNameLabel = new JLabel("Name:");
        playerOneName = new JLabel(" ");
        JLabel playerOneWinLabel = new JLabel("Wins:");
        playerOneWins = new JLabel("0");
        JLabel playerOneLossLabel = new JLabel("Losses:");
        playerOneLosses = new JLabel("0");
        leftPanel.add(playerOneNameLabel);
        leftPanel.add(playerOneName);
        leftPanel.add(playerOneWinLabel);
        leftPanel.add(playerOneWins);
        leftPanel.add(playerOneLossLabel);
        leftPanel.add(playerOneLosses);

        // player 2 info box
        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new GridLayout(3, 2));
        rightPanel.setBorder(BorderFactory.createTitledBorder("Player 2 (O)"));
        JLabel playerTwoNameLabel = new JLabel("Name:");
        playerTwoName = new JLabel(" ");
        JLabel playerTwoWinLabel = new JLabel("Wins:");
        playerTwoWins = new JLabel("0");
        JLabel playerTwoLossLabel = new JLabel("Losses:");
        playerTwoLosses = new JLabel("0");
        rightPanel.add(playerTwoNameLabel);
        rightPanel.add(playerTwoName);
        rightPanel.add(playerTwoWinLabel);
        rightPanel.add(playerTwoWins);
        rightPanel.add(playerTwoLossLabel);
        rightPanel.add(playerTwoLosses);

        // encapsulates the player info boxes into the topPanel
        topPanel.add(leftPanel);
        topPanel.add(rightPanel);

        statusLabel = new JLabel("Welcome to GO-MOKU!");
        statusLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        statusLabel.setFont(new Font(" ", Font.BOLD, 20));

        // layout for the bottom half of the app: one gridlayout for the buttons inside of a boxLayout
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.X_AXIS));
        bottomPanel.setPreferredSize(new Dimension(800, 800));
        // grid for the JButtons
        JPanel gridPanel = new JPanel();
        gridPanel.setLayout(new GridLayout(15, 15));
        buttons = new JButton[225];
        for(int i = 0; i < 225; i++) {
            buttons[i] = new JButton();
            buttons[i].setText(" ");
            buttons[i].setFont(new Font(" ", Font.BOLD, 20));
            buttons[i].setPreferredSize(new Dimension(3, 3));
            buttons[i].addActionListener(this);
            buttons[i].setOpaque(true);
            gridPanel.add(buttons[i]);
        }
        bottomPanel.add(gridPanel);

        JPanel lastPanel = new JPanel();
        resetButton = new JButton("Reset Names and Stats");
        saveExitButton = new JButton("Save and Exit");
        lastPanel.add(saveExitButton);
        lastPanel.add(resetButton);

        // encapsulates both panels into the app
        contentPanel.add(topPanel);
        contentPanel.add(statusLabel);
        contentPanel.add(bottomPanel);
        contentPanel.add(lastPanel);
    }

    public void actionPerformed(ActionEvent e) {
        for(int i = 0; i < 225; i++) {
            if(e.getSource() == buttons[i])
                controller.pressButton(i);
        }
    }
}
