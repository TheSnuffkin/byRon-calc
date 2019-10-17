package byRonCalc;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI implements ActionListener{
    private String expression;
    private final JFrame frame;
    private final JPanel panel;
    private final JTextArea text;
    private final JButton but[], butAdd, butMinus, butMultiply, butDivide,
            butEqual, butCancel, butSquareRoot, butSquare, butOneDevidedBy,
            butCos, butSin, butTan, butxpowerofy, butlog, butrate, butabs, butBinary;

    private final String[] numVals = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};

    calc backEnd;

    public GUI(){
        frame = new JFrame("Calculator PH");
        frame.setResizable(false);
        panel = new JPanel(new FlowLayout());

        text = new JTextArea(2, 25);
        but = new JButton[10];
        for (int i = 0; i < 10; i++) {
            but[i] = new JButton(String.valueOf(i));
        }

        butAdd = new JButton("+");
        butMinus = new JButton("-");
        butMultiply = new JButton("*");
        butDivide = new JButton("/");
        butEqual = new JButton("=");
        butSquareRoot = new JButton("√");
        butSquare = new JButton("x*x");
        butOneDevidedBy = new JButton("1/x");
        butCos = new JButton("Cos");
        butSin = new JButton("Sin");
        butTan = new JButton("Tan");
        butxpowerofy = new JButton("x^y");
        butlog = new JButton("log10(x)");
        butrate = new JButton("x%");
        butabs = new JButton("abs(x)");

        butCancel = new JButton("C");
        butBinary = new JButton("Bin");

        backEnd = new calc();
        expression = "";
    }

    public void initialize() {
        frame.setVisible(true);
        frame.setSize(330, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);

        panel.add(text);

        for (int i = 1; i < 10; i++) {
            panel.add(but[i]);
            but[i].addActionListener(this);
        }
        panel.add(but[0]);
        but[0].addActionListener(this);

        panel.add(butAdd);
        panel.add(butMinus);
        panel.add(butMultiply);
        panel.add(butDivide);
        panel.add(butSquare);
        panel.add(butSquareRoot);
        panel.add(butOneDevidedBy);
        panel.add(butCos);
        panel.add(butSin);
        panel.add(butTan);
        panel.add(butxpowerofy);
        panel.add(butlog);
        panel.add(butrate);
        panel.add(butabs);
        panel.add(butabs);
        panel.add(butBinary);

        panel.add(butEqual);
        panel.add(butCancel);

        butAdd.addActionListener(this);
        butMinus.addActionListener(this);
        butMultiply.addActionListener(this);
        butDivide.addActionListener(this);
        butSquare.addActionListener(this);
        butSquareRoot.addActionListener(this);
        butOneDevidedBy.addActionListener(this);
        butCos.addActionListener(this);
        butSin.addActionListener(this);
        butTan.addActionListener(this);
        butxpowerofy.addActionListener(this);
        butlog.addActionListener(this);
        butrate.addActionListener(this);
        butabs.addActionListener(this);
        butBinary.addActionListener(this);

        butEqual.addActionListener(this);
        butCancel.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        final Object source = e.getSource();

        for (int i = 0; i < 10; i++) {
            if (source == but[i]) {
                expression = expression + i;
                return;
            }
        }

        if (source == butAdd) {
            expression = expression + "+";
        }

        if (source == butMinus) {
            expression = expression + "-";
        }

        if (source == butMultiply) {
            expression = expression + "*";
        }

        if (source == butDivide) {
            expression = expression + "/";
        }
        if (source == butxpowerofy) {
            expression = expression + "^";
        }

        if (source == butSquare) {
            expression = expression + "^2";
        }

        if (source == butSquareRoot) {
            expression = expression + "sqrt()";
        }

        if (source == butOneDevidedBy) {
            expression = expression + "";
        }

        if (source == butCos) {
            expression = expression + "cos(";
        }

        if (source == butSin) {
            expression = expression + "sin(";
        }

        if (source == butTan) {
            expression = expression + "tan(";
        }
        if (source == butlog) {
            expression = expression + "log";
        }
        if (source == butrate) {
        }
        if(source == butabs){
            expression = expression + "abs(";
        }

        if (source == butEqual) {
            double result = backEnd.evaluate(expression);
            expression = ""+result;
        }

        if (source == butCancel) {
            expression = "";
        }
        text.setText(expression);
       // text.selectAll();
    }
}
