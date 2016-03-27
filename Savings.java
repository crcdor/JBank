
/**
 * Savings Account class.
 * 
 * @author Rudy Nurhadi
 * @version 26/03/2016
 */
public class Savings extends Account
{
    private double interestEarned;

    /**
     * Constructor for objects of class Savings.
     * 
     * @param customer Customer object.
     * @param balance Amount of money stored.
     */
    public Savings(Customer customer, double balance)
    {
        super(customer.getCustID() + "", balance < 10 ? 10 : balance);
        id += this instanceof Investment ? "I" : "S";
    }
    
    /**
     * Accessor to get the interest earned in this account.
     * 
     * @return double Amount of interest earned in this account.
     */
    public double getInterestEarned()
    {
        return interestEarned;
    }
    
    /**
     * Method to withdraw the money in this account.
     * 
     * @param amount Amount of money to withdraw.
     * @return boolean The success of the withdraw process.
     */
    public boolean withdraw(double amount) {
        if((balance - amount) >= 10 && amount > 0) {
            balance -= amount;
            
            return true;
        }
        
        return false;
    }
    
    /**
     * Method to add the daily interest in this account.
     * 
     * @param days Total days of money stored in this account.
     */
    public void addDailyInterest(int days)
    {
        double f;
        f = balance * Math.pow((1 + (.03/365)), (days));
        interestEarned += f - balance;
        balance = f;
    }
}
