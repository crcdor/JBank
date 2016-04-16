
/**
 * AccountTypeNotFoundException class.
 * 
 * @author Rudy Nurhadi
 * @version 14/04/2016
 */
public class AccountTypeNotFoundException extends Exception
{
    private char acctType;

    /**
     * Constructor for objects of class AccountTypeNotFoundException
     */
    public AccountTypeNotFoundException(char acctType)
    {
        super("account does not exist.");
        this.acctType = acctType;
    }
    
    public String getMessage() {
        String accountMessage = null;
        
        switch(acctType) {
            case 'S': 
                accountMessage = "Savings ";
                break;
            case 'I': 
                accountMessage = "Investment ";
                break;
            case 'C': 
                accountMessage = "Line of credit ";
                break;
            case 'O': 
                accountMessage = "Overdraft protection ";
                break;
        }
        
        return accountMessage + super.getMessage();
    }
}
