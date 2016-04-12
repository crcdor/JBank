import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton; 
import javax.swing.ButtonGroup; 
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Write a description of class ATMGUI here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ATMGUI extends JPanel
{
    private JLabel customerIdLabel;
    private JTextField customerIdTextField;
    private JRadioButton savingsRadioButton;
    private JRadioButton investmentRadioButton;
    private JRadioButton lineOfCreditRadioButton;
    private JRadioButton overdraftRadioButton;
    private ButtonGroup accountTypeRadioGroup;
    private JLabel amountLabel;
    private JTextField amountTextField;
    private JTextArea textArea;
    private JScrollPane textAreaScroll;
    private JButton depositButton;
    private JButton withdrawButton;
    private JButton exitButton;
    private JPanel accountTypeRadioPanel;
    private JPanel buttonPanel;
    private JPanel topPanel;
    private JPanel bottomPanel;
    private StringBuffer textAreaString;
               
    /**
     * Constructor for objects of class ATMGUI
     */
    public ATMGUI()
    {
        buildGUI();
    }
    
    public static void main(String[] args) {
        ATMGUI atm = new ATMGUI();
        JFrame f = new JFrame("test");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(atm);
        f.pack();
        f.setVisible(true);
    }
    
    public void buildGUI() {
        customerIdLabel = new JLabel("Enter customer id:");
        customerIdTextField = new JTextField();
        customerIdTextField.setColumns(10);
        
        savingsRadioButton = new JRadioButton("Savings");
        investmentRadioButton = new JRadioButton("Investment");
        lineOfCreditRadioButton = new JRadioButton("Line Of Credit");
        overdraftRadioButton = new JRadioButton("Overdraft");
        
        accountTypeRadioGroup = new ButtonGroup();
        accountTypeRadioGroup.add(savingsRadioButton);
        accountTypeRadioGroup.add(investmentRadioButton);
        accountTypeRadioGroup.add(lineOfCreditRadioButton);
        accountTypeRadioGroup.add(overdraftRadioButton);
        
        amountLabel = new JLabel("Enter amount here:");
        amountTextField = new JTextField();
        amountTextField.setColumns(10);
        
        textAreaString = new StringBuffer("Welcome\n");
        textArea = new JTextArea(textAreaString.toString());
        textArea.setEditable(false);
        textArea.setColumns(40);
        textArea.setRows(8);
        textAreaScroll = new JScrollPane(textArea);
        textAreaScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        
        ButtonHandler buttonHandler = new ButtonHandler(this);
        depositButton = new JButton("Deposit");
        depositButton.addActionListener(buttonHandler);
        withdrawButton = new JButton("Withdraw");
        withdrawButton.addActionListener(buttonHandler);
        exitButton = new JButton("Exit");
        exitButton.addActionListener(buttonHandler);
        
        accountTypeRadioPanel = new JPanel();
        accountTypeRadioPanel.setLayout(new GridLayout(4, 1));
        accountTypeRadioPanel.add(savingsRadioButton);
        accountTypeRadioPanel.add(investmentRadioButton);
        accountTypeRadioPanel.add(lineOfCreditRadioButton);
        accountTypeRadioPanel.add(overdraftRadioButton);
        
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(3, 1));
        buttonPanel.add(depositButton);
        buttonPanel.add(withdrawButton);
        buttonPanel.add(exitButton);
        
        topPanel = new JPanel();
        topPanel.add(customerIdLabel);
        topPanel.add(customerIdTextField);
        topPanel.add(accountTypeRadioPanel);
        topPanel.add(amountLabel);
        topPanel.add(amountTextField);
        
        bottomPanel = new JPanel();
        bottomPanel.add(textAreaScroll);
        bottomPanel.add(buttonPanel);
        
        
        this.setLayout(new GridLayout(2, 1));
        this.add(topPanel);
        this.add(bottomPanel);
    }
    
    public int getCustID() {
        int id = 0;
        try {
            id = Integer.parseInt(customerIdTextField.getText());
        } catch (NumberFormatException e) {
            
        }
        return id;
    }
    
    public double getAmount() {
        double amount = 0;
        try {
            amount = Double.parseDouble(amountTextField.getText());
        } catch (NumberFormatException e) {
            
        }
        return amount;
    }
    
    public char getAccountType() {
        if(savingsRadioButton.isSelected()) {
            return 'S';
        }
        else if(investmentRadioButton.isSelected()) {
            return 'I';
        }
        else if(lineOfCreditRadioButton.isSelected()) {
            return 'C';
        }
        else if(overdraftRadioButton.isSelected()) {
            return 'O';
        }
        
        return '\0';
    }
    
    public void textAreaPrintln(String message) {
        textAreaString.append(message + "\n");
        textArea.setText(textAreaString.toString());
    }
}
