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
            atmgui.textAreaPrintln(atmgui.getCustID() + " saves an amount of money: $" + atmgui.getAmount());
        }
        else if(button.equals("Withdraw")) {
            atmgui.textAreaPrintln(atmgui.getCustID() + " withdraw an amount of money: $" + atmgui.getAmount());
        }
        else if(button.equals("Exit")) {
            System.exit(0);
        }
  }
}
