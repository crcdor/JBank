import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


/**
 * Write a description of class ButtonHandler here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
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
            
            for(int i = 0; i < Bank.MAX_NUM_OF_CUSTOMERS; i++) {
                if(Bank.customer[i] != null) {
                    if(custID == Bank.customer[i].getCustID()) {
                        cust = Bank.customer[i];
                        search = false;
                        break;
                    }
                }
            }
            
            if(search) {
                atmgui.textAreaPrintln("Customer ID not found");
            }
            else {
                if(cust.getAccount(acctType) != null) {
                    if(cust.getAccount(acctType).deposit(amount)) {
                        atmgui.textAreaPrintln(custID + " saves an amount of money: $" + amount + " to " + acctType + " account.");
                        atmgui.textAreaPrintln("Sisa saldo akun " + acctType + ": $" + cust.getAccount(acctType).getBalance());
                    }
                }
                else {
                    atmgui.textAreaPrintln("Deposit not success");
                }
            }           
        }
        else if(button.equals("Withdraw")) {
            Customer cust = null;
            boolean search = true;
            int custID = atmgui.getCustID();
            double amount = atmgui.getAmount();
            char acctType = atmgui.getAccountType();
            
            for(int i = 0; i < Bank.MAX_NUM_OF_CUSTOMERS; i++) {
                if(Bank.customer[i] != null) {
                    if(custID == Bank.customer[i].getCustID()) {
                        cust = Bank.customer[i];
                        search = false;
                        break;
                    }
                }
            }
            
            if(search) {
                atmgui.textAreaPrintln("Customer ID not found");
            }
            else {
                if(cust.getAccount(acctType) != null) {
                    if(cust.getAccount(acctType).withdraw(amount)) {
                        atmgui.textAreaPrintln(custID + " saves an amount of money: $" + amount + " to " + acctType + " account.");
                        atmgui.textAreaPrintln("Sisa saldo akun " + acctType + ": $" + cust.getAccount(acctType).getBalance());
                    }
                }
                else {
                    atmgui.textAreaPrintln("Deposit not success");
                }
            }
        }
        else if(button.equals("Exit")) {
            System.exit(0);
        }
  }
}
