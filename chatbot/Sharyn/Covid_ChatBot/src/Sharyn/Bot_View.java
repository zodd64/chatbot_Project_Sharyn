package Sharyn;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.DefaultCaret;

public class Bot_View {

    private JFrame frame;
    private JTextArea screen;
    private JTextField input;
    private JScrollPane sp;
    private JPanel panel;

    public Bot_View() {

        screen = new JTextArea(25, 40);
        DefaultCaret caret = (DefaultCaret) screen.getCaret();// make scroll go down
        caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
        screen.setEditable(false);
        screen.setFont(new Font("Arial", Font.PLAIN, 14));
        sp = new JScrollPane(screen);
        input = new JTextField(40);
        input.setPreferredSize(new Dimension(40, 30));
        layout();
        init_components();
    }

    private void init_components() {

        frame = new JFrame("Covid Chatbot");
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.add(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
    }

    private void layout() {

        panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(15, 20, 15, 20);

        c.gridx = 0;
        c.gridy = 1;
        panel.add(sp, c);

        c.gridx = 0;
        c.gridy = 2;
        panel.add(input, c);

    }

    public JFrame getFrame() {
        return frame;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    public JTextArea getScreen() {
        return screen;
    }

    public void setScreen(JTextArea screen) {
        this.screen = screen;
    }

    public JTextField getInput() {
        return input;
    }

    public void setInput(JTextField input) {
        this.input = input;
    }

}