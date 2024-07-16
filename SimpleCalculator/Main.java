package SimpleCalculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main implements ActionListener {

    JFrame frame;
    JTextField textField;
    JButton[] nButtons = new JButton[10];
    JButton[] fButtons = new JButton[8];
    JButton addButton, sButton, mButton, dButton;
    JButton decButton, eqButton, delButton, clrButton;
    JPanel panel;

    Font myFont = new Font("Ink Free", Font.BOLD, 30);

    double firstNumber = 0, secondNumber = 0, result = 0;
    char operator;

    Main() {
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 550);
        Container container = frame.getContentPane();
        container.setBackground(Color.BLACK);
        frame.setLayout(null);

        textField = new JTextField();
        textField.setBounds(50, 25, 300, 50);
        textField.setFont(myFont);
        textField.setEditable(false);

        addButton = new JButton("+");
        sButton = new JButton("-");
        mButton = new JButton("*");
        dButton = new JButton("/");
        decButton = new JButton(".");
        eqButton = new JButton("=");
        delButton = new JButton("delete");
        clrButton = new JButton("clear");

        fButtons[0] = addButton;
        fButtons[1] = sButton;
        fButtons[2] = mButton;
        fButtons[3] = dButton;
        fButtons[4] = decButton;
        fButtons[5] = eqButton;
        fButtons[6] = delButton;
        fButtons[7] = clrButton;

        for (int i = 0; i < 8; i++) {
            fButtons[i].addActionListener(this);
            fButtons[i].setFont(myFont);
            fButtons[i].setFocusable(false);
        }

        for (int i = 0; i < 10; i++) {
            nButtons[i] = new JButton(String.valueOf(i));
            nButtons[i].addActionListener(this);
            nButtons[i].setFont(myFont);
            nButtons[i].setFocusable(false);
        }

        delButton.setBounds(50, 430, 145, 50);
        clrButton.setBounds(205, 430, 145, 50);

        panel = new JPanel();
        panel.setBounds(50, 100, 300, 300);
        panel.setLayout(new GridLayout(4,4,10, 10));
        panel.setBackground(Color.CYAN);

        panel.add(nButtons[1]);
        panel.add(nButtons[2]);
        panel.add(nButtons[3]);
        panel.add(nButtons[4]);
        panel.add(nButtons[5]);
        panel.add(nButtons[6]);
        panel.add(nButtons[7]);
        panel.add(nButtons[8]);
        panel.add(nButtons[9]);
        panel.add(nButtons[0]);
        panel.add(decButton);
        panel.add(eqButton);
        panel.add(addButton);
        panel.add(sButton);
        panel.add(mButton);
        panel.add(dButton);
        

        frame.add(panel);
        frame.add(delButton);
        frame.add(clrButton);
        frame.add(textField);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new Main();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        for(int i = 0; i < 10; ++i){
            if(e.getSource() == nButtons[i]){
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }
        
        if(e.getSource() == decButton){
            textField.setText(textField.getText().concat("."));
        }

        if(e.getSource() == addButton){
            firstNumber = Double.parseDouble(textField.getText());
            operator = '+';
            textField.setText("");
        }
        if(e.getSource() == sButton){
            firstNumber = Double.parseDouble(textField.getText());
            operator = '-';
            textField.setText("");
        }
        if(e.getSource() == mButton){
            firstNumber = Double.parseDouble(textField.getText());
            operator = '*';
            textField.setText("");
        }
        if(e.getSource() == dButton){
            firstNumber = Double.parseDouble(textField.getText());
            operator = '/';
            textField.setText("");
        }
        if(e.getSource() == eqButton){
            secondNumber = Double.parseDouble(textField.getText());

            switch (operator) {
                case '+':
                    result = firstNumber+secondNumber;
                    break;
                case '-':
                    result = firstNumber-secondNumber;
                    break;

                case '*':
                    result = firstNumber*secondNumber;
                    break;
                case '/':
                    result = firstNumber/secondNumber;
                default:
                    break;
            }
            textField.setText(String.valueOf(result));
            firstNumber = result;
        }
        if(e.getSource() == clrButton){
            textField.setText("");
        }
        if(e.getSource() == delButton){
            String string = textField.getText();
            textField.setText("");
            for(int i = 0; i < string.length()-1; ++i){
                textField.setText(textField.getText()+string.charAt(i));
            }
        }
    }
}
