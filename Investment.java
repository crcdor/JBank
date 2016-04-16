import java.util.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Investment Account class.
 * 
 * @author Rudy Nurhadi 
 * @version 26/03/2016
 */
public final class Investment extends Savings
{
    private Date startDate;
    private Date endDate;
    private int term;
    private double interestRate;

    /**
     * Constructor for objects of class Investment.
     * 
     * @param customer Customer object.
     * @param balance Amount of money stored.
     * @param term Total month of investment commitment.
     */
    public Investment(Customer customer, double balance, int term)
    {
        super(customer, balance < 100 ? 100 : balance);
        if(term < 6) term = 6;
        this.term = term;
        Calendar s = new GregorianCalendar();
        startDate = s.getTime();
        s.add(Calendar.MONTH, term);
        endDate = s.getTime();
    }
    
    /**
     * Method to withdraw the money in this account.
     * 
     * @param amount Amount of money to withdraw.
     * @return boolean The success of the withdraw process.
     */
    public void withdraw(double amount) throws AmountOverDrawnException
    {
        double tempBalance = balance;
        
        if (Calendar.getInstance().before(endDate)) {
            tempBalance = balance - (balance * 20 / 100);
        }
        
        if((tempBalance - amount) >= 0 && amount > 0) {
            tempBalance -= amount;
            balance = tempBalance;
        }
        else {
            throw new AmountOverDrawnException(this);
        }
    }
    
    /**
     * Method to add the daily interest in this account.
     * 
     * @param days Total days of money stored in this account.
     */
    public void addDailyInterest(int days)
    {
        if(term >= 6 && term <= 12) {
            interestRate = .06;
        }
        else if(term > 12) {
            interestRate = .07;
        }
        double f;
        f = balance * Math.pow((1 + (interestRate/365)), (days));
        balance = f;
    }
}
