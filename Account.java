
/**
 * Account class is used to hold account information.
 * 
 * @author Rudy Nurhadi 
 * @version 26/02/2016
 * 
 */
public class Account 
{
    private String id;
    private char acctType;
    private double balance;
    private Customer customer;

    /**
     * Create a new account object.
     * 
     * @param type Account type.
     * @param amount Amount of money.
     */
    public Account(Customer cust, char type, double amount) 
    {
        customer = cust;
        acctType = type;
        balance = amount;
        id = cust.getCustID() + "" + type;
    }
    
    /**
     * Accessor to get the account identifier.
     * 
     * @return String Account identifier.
     */
    public String getID() 
    {
        return id;
    }
    
    /**
     * Accessor to get the account type.
     * 
     * @return char Type of an account.
     */
    public char getAcctType() 
    {
        return acctType;
    }
    
    /**
     * Accessor to get the account type.
     * 
     * @return double Balance of an account.
     */
    public double getBalance() 
    {
        return balance;
    }
    
    /**
     * Mutator to set the account type.
     * 
     * @param type Type of an account.
     */
    public void setAcctType(char type) 
    {
        acctType = type;
    }
    
    /**
     * Mutator to set the account balance.
     * 
     * @param amount Amount of money.
     */
    public void setBalance(double amount) 
    {
        balance = amount;
    }
    
    /**
     * Method to withdraw the money in this account.
     * 
     * @param amount Amount of money to withdraw.
     * @return boolean The success of the withdraw process.
     */
    public boolean withdraw(double amount) 
    {
        if(this.acctType != 'C') {
            if((balance - amount) >= 0 && amount > 0) {
                balance -= amount;
                
                return true;
            }
        }
        else {
            if((balance - amount) >= -500 && amount > 0) {
                balance -= amount;
                
                return true;
            }
        }
        
        return false;
    }
    
    /**
     * Method to deposit the money in this account.
     * 
     * @param amount Amount of money to deposit (must be positive).
     * @return boolean The success of the deposit process.
     */
    public boolean deposit(double amount) 
    {
        if(amount >= 0) {
            balance += amount;
            
            return true;
        }
        
        return false;
    }
}
