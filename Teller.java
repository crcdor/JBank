import java.text.DecimalFormat;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

/**
 * Teller class.
 * 
 * @author Rudy Nurhadi
 * @version 26/02/2016
 */

public class Teller 
{
    /**
     * Create a new teller object.
     */
    public Teller() 
    {
        
    }

    /**
     * Main method of Teller Class.
     */
    public static void main(String[] args) 
    {  
       Account savingAcc = new Account('S', 1000);
       Account investmentAcc = new Account('I', 1000);
       Account creditAcc = new Account('C', 500);
       creditAcc.withdraw(750);
       
       System.out.println("Saving Account Balance = " + savingAcc.getBalance());
       System.out.println("Investment Account Balance = " + investmentAcc.getBalance());
       System.out.println("Credit Account Balance = " + creditAcc.getBalance());
       
       //Calculate Saving Account
       BigDecimal bal = new BigDecimal(savingAcc.getBalance());
       BigDecimal n = new BigDecimal(360); //per day
       BigDecimal t = new BigDecimal(1); //1 year
       BigDecimal r = new BigDecimal(0.03); //3% interest rate
       
       BigDecimal f1 = r.divide(n, new MathContext(10, RoundingMode.DOWN)).add(new BigDecimal(1)); //(r/n)+1
       BigDecimal f2 = n.multiply(t); //(n*t)
       
       double balance = f1.pow(f2.intValue()).multiply(bal).doubleValue(); //(((r/n)+1)^(n*t))*P
       balance = Double.parseDouble(new DecimalFormat("#.##").format(balance)); //format double to 2 decimal places
       savingAcc.setBalance(balance);
       
       
       //Calculate Investment first 6 month
       bal = new BigDecimal(investmentAcc.getBalance());
       n = new BigDecimal(12); //per month
       t = new BigDecimal(0.5); //6 month
       r = new BigDecimal(0.05); //5% interest rate for first 6 month
       
       f1 = r.divide(n, new MathContext(10, RoundingMode.DOWN)).add(new BigDecimal(1)); //(r/n)+1
       f2 = n.multiply(t); //(n*t)
       
       balance = f1.pow(f2.intValue()).multiply(bal).doubleValue(); //(((r/n)+1)^(n*t))*P
       balance = Double.parseDouble(new DecimalFormat("#.##").format(balance)); //format double to 2 decimal places
       
       
       //Calculate Investment at 6-12 month
       bal = new BigDecimal(balance); //balance from first 6 month 
       r = new BigDecimal(0.06); //6% interest rate at 6-12 month
       
       f1 = r.divide(n, new MathContext(10, RoundingMode.DOWN)).add(new BigDecimal(1));  //(r/n)+1
       f2 = n.multiply(t); //(n*t)
       
       balance = f1.pow(f2.intValue()).multiply(bal).doubleValue(); //(((r/n)+1)^(n*t))*P
       balance = Double.parseDouble(new DecimalFormat("#.##").format(balance)); //format to 2 decimal places
       
       investmentAcc.setBalance(balance);
       
       
       //Calculate Credit Account
       bal = new BigDecimal(creditAcc.getBalance());
       n = new BigDecimal(360); //per day
       t = new BigDecimal(1); //1 year
       r = new BigDecimal(0.18); //3% interest rate
       
       f1 = r.divide(n, new MathContext(10, RoundingMode.DOWN)).add(new BigDecimal(1)); //(r/n)+1
       f2 = n.multiply(t); //(n*t)
       
       balance = f1.pow(f2.intValue()).multiply(bal).doubleValue(); //(((r/n)+1)^(n*t))*P
       balance = Double.parseDouble(new DecimalFormat("#.##").format(balance)); //format double to 2 decimal places
       creditAcc.setBalance(balance);
       
       
       System.out.println("\nAfter 1 year");
       System.out.println("Saving Account Balance = " + savingAcc.getBalance());
       System.out.println("Investment Account Balance = " + investmentAcc.getBalance());
       System.out.println("Credit Account Balance = " + creditAcc.getBalance());
    }
}
