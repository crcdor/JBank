
/**
 * Checking Account class.
 * 
 * @author Rudy Nurhadi 
 * @version 26/03/2016
 */
public abstract class Checking extends Account
{
    protected double monthlyFee;
    
    /**
     * Constructor for objects of class Checking
     * 
     * @param id Customer identifier.
     * @param balance Amount of money stored.
     */
    public Checking(String id, double balance)
    {
        super(id, balance);
    }

    /**
     * Method to withdraw the money in this account.
     * 
     * @param amount Amount of money to withdraw.
     * @return boolean The success of the withdraw process.
     */
    public abstract void withdraw(double amount) throws AmountOverDrawnException;
    
    /**
     * Method for add monthlyFee and cut balance if withdraw success.
     */
    protected abstract void feeAssesment();
    
    /**
     * Method for reset the monthlyFee.
     */
    protected void resetMothlyFee() {
        monthlyFee = 0;
    }
    
    /**
     * Accessor to get monthlyFee.
     * 
     * @return double MonthlyFee.
     */
    protected double getMonthlyFee() {
        return monthlyFee;
    }
}
