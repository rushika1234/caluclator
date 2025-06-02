import java.awt.*;
import java.awt.event.*;

public class Cal extends Frame implements ActionListener {
    String msg = " ";
    int v1, v2, result;
    TextField t1;
    Button[] b = new Button[10];
    Button add, sub, mul, div, clear, mod, EQ;
    char OP;

    // Constructor to set up the GUI components
    public Cal() {
        setTitle("Simple Calculator");
        setSize(400, 500);
        setLayout(new GridLayout(6, 5));
		//setLayout(new GridBagLayout());

        // Text field for displaying the result
        t1 = new TextField(10);
		//t1.setBound(50,100,200,30);
        add(t1);
		

        // Create digit buttons (0 to 9)
        for (int i = 0; i < 10; i++) {
            b[i] = new Button("" + i);
            add(b[i]);
            b[i].addActionListener(this);
        }

        // Create operation buttons (+, -, *, /, %, =, Clear)
        add = new Button(" + ");
        sub = new Button(" - ");
        mul = new Button(" * ");
        div = new Button(" / ");
        mod = new Button(" % ");
        clear = new Button("Clear");
        EQ = new Button("=");

        // Add buttons to the layout
        add(add);
        add(sub);
        add(mul);
        add(div);
        add(mod);
        add(clear);
        add(EQ);

        // Add action listeners to operation buttons
        add.addActionListener(this);
        sub.addActionListener(this);
        mul.addActionListener(this);
        div.addActionListener(this);
        mod.addActionListener(this);
        clear.addActionListener(this);
        EQ.addActionListener(this);

        // Setting up the window properties
        setVisible(true);
        setResizable(false);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
    }

    // Method to handle the action events
    public void actionPerformed(ActionEvent ae) {
        String str = ae.getActionCommand(); 
        char ch = str.charAt(0); // Get the first character of the button clicked

        if (Character.isDigit(ch)) {
            // If a digit is clicked, append to the text field
            t1.setText(t1.getText() + str);
        } else if (str.equals(" + ")) {
            // Handle the addition operation
            v1 = Integer.parseInt(t1.getText());
            OP = '+';
            t1.setText("");
        } else if (str.equals(" - ")) {
            // Handle the subtraction operation
            v1 = Integer.parseInt(t1.getText());
            OP = '-';
            t1.setText("");
        } else if (str.equals(" * ")) {
            // Handle the multiplication operation
            v1 = Integer.parseInt(t1.getText());
            OP = '*';
            t1.setText("");
        } else if (str.equals(" / ")) {
            // Handle the division operation
            v1 = Integer.parseInt(t1.getText());
            OP = '/';
            t1.setText("");
        } else if (str.equals(" % ")) {
            // Handle the modulus operation
            v1 = Integer.parseInt(t1.getText());
            OP = '%';
            t1.setText("");
        } else if (str.equals("=")) {
            // Perform the calculation based on the operation selected
            try {
                v2 = Integer.parseInt(t1.getText());

                switch (OP) {
                    case '+':
                        result = v1 + v2;
                        break;
                    case '-':
                        result = v1 - v2;
                        break;
                    case '*':
                        result = v1 * v2;
                        break;
                    case '/':
                        if (v2 == 0) {
                            t1.setText("Error: Div by 0");
                            return;
                        } else {
                            result = v1 / v2;
                        }
                        break;
                    case '%':
                        result = v1 % v2;
                        break;
                    default:
                        t1.setText("Invalid Operation");
                        return;
                }

                t1.setText("" + result); // Display the result
            } catch (NumberFormatException e) {
                t1.setText("Invalid Input");
            }
        } else if (str.equals("Clear")) {
            // Clear the text field
            t1.setText("");
        }
    }

    // Main method to run the calculator
    public static void main(String[] args) {
        new Cal();
    }
}
