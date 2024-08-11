import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class TicTacToe implements ActionListener {

    Icon iconx = new ImageIcon("X.png");
    Icon icono = new ImageIcon("O.png");
    Random random = new Random();
    JFrame frame = new JFrame();
    JPanel title_panel = new JPanel();
    JPanel button_panel = new JPanel();
    JLabel textfield = new JLabel();
    JButton[] buttons = new JButton[9];
    JButton resetb = new JButton(iconx);
    JButton resetb1 = new JButton();
    JButton resetb2 = new JButton(icono);
    boolean player1_turn;
    String checkwin;
    int ij = 0;

    public void start() {

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        frame.getContentPane().setBackground(new Color(50, 50, 50));
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

        textfield.setBackground(new Color(25, 25, 25));
        textfield.setForeground(new Color(25, 255, 0));
        textfield.setFont(new Font("Chalkboard SE", Font.BOLD, 75));
        textfield.setHorizontalAlignment(JLabel.CENTER);
        textfield.setText("Tic-Tac-Toe");
        textfield.setOpaque(true);

        title_panel.setLayout(new BorderLayout());
        title_panel.setBounds(0, 0, 800, 100);

        button_panel.setLayout(new GridLayout(4, 3));
        button_panel.setBackground(new Color(150, 150, 150));

        resetb1.setText("reset only works 4 times");
        resetb1.addActionListener(this);
        title_panel.add(textfield);

        frame.add(title_panel, BorderLayout.NORTH);
        frame.add(button_panel);
        button_panel.add(resetb);
        button_panel.add(resetb1);
        button_panel.add(resetb2);

        firstTurn();
        actionpls();

    }

    public void actionpls() {
        for (int i = 0; i < 9; i++) {
            buttons[i].addActionListener(this);
        }

    }

    public void addButtons() {
        for (int i = 0; i < 9; i++) {
            buttons[i] = new JButton();
            button_panel.add(buttons[i]);
            buttons[i].setFont(new Font("Bradley Hand", Font.BOLD, 120));
            buttons[i].setFocusable(false);
            // buttons[i].addActionListener(this);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == resetb1) {
            ij = 0;
            reset();

        }

        for (ij = 0; ij < 9; ij++) {
            if (e.getSource() == buttons[ij]) {
                if (player1_turn) {
                    if (buttons[ij].getText() == "") {
                        buttons[ij].setForeground(new Color(255, 0, 0));
                        buttons[ij].setText("X");
                        player1_turn = false;
                        textfield.setText("O Turn");
                        check();
                    }
                } else {
                    if (buttons[ij].getText() == "") {
                        buttons[ij].setForeground(new Color(0, 0, 255));
                        buttons[ij].setText("O");
                        player1_turn = true;
                        textfield.setText("X Turn");
                        check();
                    }
                }
            }

        }

    }

    public void reset() {
        ij = 0;
        for (ij = 0; ij < 9; ij++) {
            buttons[ij].setEnabled(true);
            buttons[ij].setText(null);
            buttons[ij].setText("");
        }
        start();
        // System.out.print("it works");
        // resetb.setText("hello");
    }

    public void firstTurn() {

        try {
            for (int i = 0; i < 9; i++) {
                buttons[i].setEnabled(false);
            }
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        for (int i = 0; i < 9; i++) {
            buttons[i].setEnabled(true);
        }
        if (random.nextInt(2) == 0) {
            player1_turn = true;
            textfield.setText("X Turn");
        } else {
            player1_turn = false;
            textfield.setText("O Turn");
        }
    }

    public void check() {
        String Wins = "";
        // X win
        if ((buttons[0].getText() == "X") &&
                (buttons[1].getText() == "X") &&
                (buttons[2].getText() == "X")) {
            Wins = "xWins";

        }
        if ((buttons[3].getText() == "X") &&
                (buttons[4].getText() == "X") &&
                (buttons[5].getText() == "X")) {
            Wins = "xWins";
        }
        if ((buttons[6].getText() == "X") &&
                (buttons[7].getText() == "X") &&
                (buttons[8].getText() == "X")) {
            Wins = "xWins";
        }
        if ((buttons[0].getText() == "X") &&
                (buttons[3].getText() == "X") &&
                (buttons[6].getText() == "X")) {
            Wins = "xWins";
        }
        if ((buttons[1].getText() == "X") &&
                (buttons[4].getText() == "X") &&
                (buttons[7].getText() == "X")) {
            Wins = "xWins";
        }
        if ((buttons[2].getText() == "X") &&
                (buttons[5].getText() == "X") &&
                (buttons[8].getText() == "X")) {
            Wins = "xWins";
        }
        if ((buttons[0].getText() == "X") &&
                (buttons[4].getText() == "X") &&
                (buttons[8].getText() == "X")) {
            Wins = "xWins";
        }
        if ((buttons[2].getText() == "X") &&
                (buttons[4].getText() == "X") &&
                (buttons[6].getText() == "X")) {
            Wins = "xWins";
        }

        // O win
        if ((buttons[0].getText() == "O") &&
                (buttons[1].getText() == "O") &&
                (buttons[2].getText() == "O")) {
            Wins = "oWins";
        }
        if ((buttons[3].getText() == "O") &&
                (buttons[4].getText() == "O") &&
                (buttons[5].getText() == "O")) {
            Wins = "oWins";
        }
        if ((buttons[6].getText() == "O") &&
                (buttons[7].getText() == "O") &&
                (buttons[8].getText() == "O")) {
            Wins = "oWins";
        }
        if ((buttons[0].getText() == "O") &&
                (buttons[3].getText() == "O") &&
                (buttons[6].getText() == "O")) {
            Wins = "oWins";
        }
        if ((buttons[1].getText() == "O") &&
                (buttons[4].getText() == "O") &&
                (buttons[7].getText() == "O")) {
            Wins = "oWins";
        }
        if ((buttons[2].getText() == "O") &&
                (buttons[5].getText() == "O") &&
                (buttons[8].getText() == "O")) {
            Wins = "oWins";
        }
        if ((buttons[0].getText() == "O") &&
                (buttons[4].getText() == "O") &&
                (buttons[8].getText() == "O")) {
            Wins = "oWins";
        }
        if ((buttons[2].getText() == "O") &&
                (buttons[4].getText() == "O") &&
                (buttons[6].getText() == "O")) {
            Wins = "oWins";
        }
        if (Wins == "xWins") {
            xWins();
        } else if (Wins == "oWins") {
            oWins();
        } else if ((buttons[0].getText() == "X" || buttons[0].getText() == "O") &&
                (buttons[1].getText() == "X" || buttons[1].getText() == "O") &&
                (buttons[2].getText() == "X" || buttons[2].getText() == "O") &&
                (buttons[3].getText() == "X" || buttons[3].getText() == "O") &&
                (buttons[4].getText() == "X" || buttons[4].getText() == "O") &&
                (buttons[5].getText() == "X" || buttons[5].getText() == "O") &&
                (buttons[6].getText() == "X" || buttons[6].getText() == "O") &&
                (buttons[7].getText() == "X" || buttons[7].getText() == "O") &&
                (buttons[8].getText() == "X" || buttons[8].getText() == "O")) {
            draw();
        }
    }

    public void xWins() {
        button_panel.setBackground(Color.green);

        for (int i = 0; i < 9; i++) {
            buttons[i].setEnabled(false);
        }
        textfield.setText("X wins");
        // button_panel.add(resetb);button_panel.add(resetb1);button_panel.add(resetb2);
    }

    public void oWins() {
        button_panel.setBackground(Color.green);

        for (int i = 0; i < 9; i++) {
            buttons[i].setEnabled(false);
        }
        textfield.setText("O wins");
        // button_panel.add(resetb);button_panel.add(resetb1);button_panel.add(resetb2);
    }

    public void draw() {
        button_panel.setBackground(Color.green);

        for (int i = 0; i < 9; i++) {
            buttons[i].setEnabled(false);
        }
        textfield.setText("Draw");
        // button_panel.add(resetb);button_panel.add(resetb1);button_panel.add(resetb2);
    }

}
