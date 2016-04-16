import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * LineOfCredit Account class.
 * 
 * @author Rudy Nurhadi
 * @version 27/03/2016
 */
public class LineOfCredit extends Checking
{
    private double creditBalance;
    private double creditLimit;

    /**
     * Constructor for objects of class LineOfCredit
     * 
     * @param customer Customer object.
     * @param balance Amount of money stored.
     * @param limit Credit account limit.
     */
    public LineOfCredit(Customer customer, double balance, double limit)
    {
        super(customer.getCustID() + "C", balance);
        creditBalance = 0;
        creditLimit = limit;
    }

    /**
     * Accessor to get the account credit balance.
     * 
     * @return double Credit balance of an account.
     */
    public double getCreditBalance() 
    {
        return creditBalance;
    }
    
    /**
     * Accessor to get the account credit limit.
     * 
     * @return double Credit limit of an account.
     */
    public double getCreditLimit() 
    {
        return creditLimit;
    }
    
    /**
     * Mutator to set the credit balance.
     * 
     * @param amount Amount of money.
     */
    public void setCreditBalance(double amount) 
    {
        creditBalance = amount;
    }
    
    /**
     * Mutator to set the credit limit.
     * 
     * @param amount Amount of money.
     */
    public void setCreditLimit(double amount) 
    {
        creditLimit = amount;
    }
    
    /**
     * Method to withdraw the money in this account.
     * 
     * @param amount Amount of money to withdraw.
     * @return boolean The success of the withdraw process.
     */
    public void withdraw(double amount) throws AmountOverDrawnException
    {
        if(((balance + creditBalance) - amount) >= 0 && amount > 0) {
            balance -= amount;
            if(balance < 0) {
                creditBalance += balance;
                balance = 0;
            }
        }
        else {
            throw new AmountOverDrawnException(this);
        }
    }
    
    /**
     * Method for add monthlyFee and cut balance if withdraw success.
     */
    protected void feeAssesment()
    {
        int days = new GregorianCalendar().get(Calendar.DAY_OF_MONTH);
        double deficit = creditLimit - creditBalance;
        double amt = deficit * Math.pow((1 + (.03/365)), (days));
        monthlyFee = amt - deficit;
    }
}
