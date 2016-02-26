
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
     * Main method to print an example of customer account name and balance.
     */
    public static void main() 
    {
        Customer c1 = new Customer(); //create a new customer object
        Account a1 = new Account(); //create a new account object
        
        c1.setName("Sanadhi", "Sutandi"); //set customer name
        a1.setBalance(10); //set account balance
        c1.setAccount(a1); //assign a1 account to c1 customer object
        
        System.out.println(c1.getName()); //print customer name
        System.out.println(c1.getAccount().getBalance()); //print customer balance
    }
}
