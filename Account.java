
/**
 * Account class is used to hold account information.
 * 
 * @author Rudy Nurhadi 
 * @version 26/03/2016
 * 
 */
public abstract class Account 
{
    protected String id;
    protected double balance;
    
    
    /**
     * Default constructor for account class.
     * 
     * @param id Account identifier.
     * @param balance Amount of money stored.
     */
    public Account(String id, double balance)
    {
        if(balance < 0) balance = 0;
        this.id = id;
        this.balance = balance;
    }
    
    /**
     * Accessor to get the account identifier.
     * 
     * @return String Account id.
     */
    public String getID() 
    {
        return id;
    }
    
    /**
     * Accessor to get the balance of this account.
     * 
     * @return double Balance of an account.
     */
    public double getBalance() 
    {
        return balance;
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
    public abstract boolean withdraw(double amount);
    
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
    
    /**
     * Method to return string of account id to print.
     * 
     * @return String Account ID.
     */
    public String toString() {
        return id;
    }
}
