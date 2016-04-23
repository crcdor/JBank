import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * ButtonHandler class.
 * 
 * @author Rudy Nurhadi
 * @version 14/04/2016
 */
public class ButtonHandler implements ActionListener
{
    ATMGUI atmgui;
    
    /**
     * Constructor for objects of class ButtonHandler
     */
    public ButtonHandler(ATMGUI atmgui)
    {
        this.atmgui = atmgui;
    }

    public void actionPerformed(ActionEvent e) {
        String button = e.getActionCommand();
        
        if(button.equals("Deposit")) {
            Customer cust = null;
            boolean search = true;
            int custID = atmgui.getCustID();
            double amount = atmgui.getAmount();
            char acctType = atmgui.getAccountType();
            
            cust = Bank.getCustomer(custID);
            
            if(cust == null) {
                atmgui.textAreaPrintln("Customer ID not found");
            }
            else {
                try {
                    if(cust.getAccount(acctType) != null) {
                        if(cust.getAccount(acctType).deposit(amount)) {
                            atmgui.textAreaPrintln(custID + " saves an amount of money: $" + amount + " to " + acctType + " account.");
                            atmgui.textAreaPrintln("Sisa saldo akun " + acctType + ": $" + cust.getAccount(acctType).getBalance());
                        }
                    }
                }
                catch(AccountTypeNotFoundException e1) {
                    atmgui.textAreaPrintln(e1.getMessage());
                }
            }           
        }
        else if(button.equals("Withdraw")) {
            Customer cust = null;
            boolean search = true;
            int custID = atmgui.getCustID();
            double amount = atmgui.getAmount();
            char acctType = atmgui.getAccountType();
            
            cust = Bank.getCustomer(custID);
            
            if(cust == null) {
                atmgui.textAreaPrintln("Customer ID not found");
            }
            else {
                try {
                    if(cust.getAccount(acctType) != null) {
                        try {
                            cust.getAccount(acctType).withdraw(amount);
                            atmgui.textAreaPrintln(custID + " withdraw an amount of money: $" + amount + " to " + acctType + " account.");
                            atmgui.textAreaPrintln("Sisa saldo akun " + acctType + ": $" + cust.getAccount(acctType).getBalance());       
                        }
                        catch(AmountOverDrawnException e1) {
                            atmgui.textAreaPrintln(e1.getMessage());
                        }
                            
                    }
                }
                catch(AccountTypeNotFoundException e1) {
                    atmgui.textAreaPrintln(e1.getMessage());
                }
            }
        }
        else if(button.equals("Exit")) {
            System.exit(0);
        }
        
        CustomerFileWriter.saveCustomer(Bank.customer);
    }
    
}
