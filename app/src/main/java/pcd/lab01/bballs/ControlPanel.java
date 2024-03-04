package pcd.lab01.bballs;

import javax.swing.*;
import java.awt.event.*;

@FunctionalInterface
interface Function {
    void apply();
}

public class ControlPanel extends JFrame implements ActionListener {
    private JButton buttonPlus;
    private JButton buttonMinus;
    private Context context;

    public ControlPanel(Context ctx) {
        context = ctx;
        setTitle("Control Panel");
        setSize(250, 60);
        setResizable(false);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent ev) {
                System.exit(-1);
            }

            public void windowClosed(WindowEvent ev) {
                System.exit(-1);
            }
        });

        buttonPlus = new JButton("+ ball");
        buttonMinus = new JButton("- ball");
        JPanel p = new JPanel();
        p.add(buttonPlus);
        p.add(buttonMinus);
        getContentPane().add(p);
        buttonPlus.addActionListener(this);
        buttonMinus.addActionListener(this);
    }

    public void actionPerformed(ActionEvent ev) {
        Object src = ev.getSource();
        int howManyBallLaunch = 100;
        if (src == buttonPlus) {
            this.howMany(howManyBallLaunch, () -> context.createNewBall());

        } else {
            this.howMany(howManyBallLaunch, () -> context.removeBall());
        }
    }

    private void howMany(int i, Function f) {
        for (int j = 0; j < i; j++) {
            f.apply();
        }
    }
}
