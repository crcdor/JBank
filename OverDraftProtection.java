
/**
 * OverDraftProtection Account Class.
 * 
 * @author Rudy Nurhadi
 * @version 27/3/2016
 */
public class OverDraftProtection extends Checking
{
    private Savings savingsAccount;
    
    /**
     * Constructor for objects of class OverDraftProtection.
     * 
     * @param customer Customer object.
     * @param balance Amount of money stored.
     * @param savingsAcc Savings account linked to this account.
     */
    public OverDraftProtection(Customer customer, double balance, Savings savingsAcc)
    {
        super(customer.getCustID() + "O", balance);
        savingsAccount = savingsAcc;
    }
    
    /**
     * Method to withdraw the money in this account.
     * 
     * @param amount Amount of money to withdraw.
     * @return boolean The success of the withdraw process.
     */
    public boolean withdraw(double amount) 
    {
        if(((balance + savingsAccount.getBalance()) - amount) >= 10 && amount > 0) {
            balance -= amount;
            if(balance < 0) {
                feeAssesment();
                savingsAccount.setBalance(savingsAccount.getBalance() + balance);
                balance = 0;
            }
            
            return true;
        }
        
        return false;
    }
    
    /**
     * Method for add monthlyFee and cut balance if withdraw success.
     */
    protected void feeAssesment()
    {
        double fee = 3;
        
        monthlyFee += fee;
        balance -= fee;
    }
}
