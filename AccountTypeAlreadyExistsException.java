
/**
 * AccountTypeAlreadyExistsException class.
 * 
 * @author Rudy Nurhadi
 * @version 14/04/2016
 */
public class AccountTypeAlreadyExistsException extends Exception
{
    private char acctType;
    
    /**
     * Constructor for objects of class AccountTypeAlreadyExistsException
     */
    public AccountTypeAlreadyExistsException(char acctType)
    {
        super("Unable to create duplicate account of type ");
        this.acctType = acctType;
    }
    
    public String getMessage() {
        String accountMessage = null;
        
        switch(acctType) {
            case 'S': 
                accountMessage = "savings.";
                break;
            case 'I': 
                accountMessage = "investment.";
                break;
            case 'C': 
                accountMessage = "line of credit.";
                break;
            case 'O': 
                accountMessage = "overdraft protection.";
                break;
        }
        
        return super.getMessage() + accountMessage;
    }
}
