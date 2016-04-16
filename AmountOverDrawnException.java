
/**
 * AmountOverDrawnException class.
 * 
 * @author Rudy Nurhadi
 * @version 14/04/2016
 */
public class AmountOverDrawnException extends Exception
{
    private Account account;
    
    /**
     * Constructor for objects of class AmountOverDrawnException
     */
    public AmountOverDrawnException(Account account)
    {
        super("Insufficient funds");
        this.account = account;
    }
    
    public String getMessage() {
        String accountMessage = null;
        
        if(account instanceof Investment) {
            accountMessage = " in investment account.";
        }
        else if(account instanceof Savings) {
            accountMessage = " in savings account.";
        }
        else if(account instanceof LineOfCredit) {
            accountMessage = " in line of creadit account.";
        }
        else if(account instanceof OverDraftProtection) {
            accountMessage = " in overdraft protection account.";
        }
        
        return super.getMessage() + accountMessage;
    }
}
