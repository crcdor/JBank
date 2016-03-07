
/**
 * ASISTEN: program atau komentar yang tidak digunakan lagi bisa dihapus
 * Bank class.
 * 
 * @author Rudy Nurhadi
 * @version 26/02/2016
 */
public class Bank 
{
    public static final String BANK_NAME = "JBANK";
    public static final String BANK_ADDRESS = "1234 JavaStreet, AnyCity, ThisState, 34567";
    private static String phone;
    public static String website;
    private static String startTime;
    private static String closeTime;
    public static int numOfCurrentCustomers = 0;
    public static final int MAX_NUM_OF_CUSTOMERS = 20;
    public static int maxNumOfAcctsPerCustomer = 4;
    private static double creditInterestRate;
    private static double investmentInterestRate;
    private static double premiumInterestRate;
    private static int lastCustID = 0;
    private static int nextCustID = 0;

    /**
     * Create a new bank object.
     */
    private Bank() 
    {
        
    }
    
//     /**
//      * Accessor to get the name of this bank.
//      * 
//      * @return String The name of this bank.
//      */
//     public static String getName() 
//     {
//         return BANK_NAME;
//     }
// 
//     /**
//      * Accessor to get the bank address.
//      * 
//      * @return String Address of the bank.
//      */
//     public static String getAddress() 
//     {
//         return BANK_ADDRESS;
//     }
    
    /**
     * Accessor to get the phone number of this bank.
     * 
     * @return String The phone number of this bank.
     */
    public static String getPhone() 
    {
        return phone;
    }
    
    /**
     * Accessor to get the website of this bank.
     * 
     * @return String The website of this bank.
     */
    public static String getWebsite() 
    {
        return website;
    }
    
    /**
     * Accessor to get the number of hours of bank operation.
     * 
     * @return String The number of hours of bank operation.
     */
    public static String getHoursOfOperation() 
    {
        return null;
    }
    
    /**
     * Accessor to get the total number of current customer.
     * 
     * @return int Total number of current customer.
     */
    public static int getNumOfCurrentCustomers()
    {
        return numOfCurrentCustomers;
    }
    
//     /**
//      * Accessor to get the maximum total of customer.
//      * 
//      * @return int Maximum total of customer.
//      */
//     public static int getMaxCustomers() 
//     {
//         return MAX_NUM_OF_CUSTOMERS;
//     }
    
    /**
     * Accessor to get the interest rate of credit.
     * 
     * @return double Value of interest rate of credit.
     */
    public static double getCreditRate() 
    {
        return creditInterestRate;
    }
    
    /**
     * Accessor to get the interest rate of investment account.
     * 
     * @return double Value of interest rate of investment account.
     */
    public static double getInvestmentRate() 
    {
        return investmentInterestRate;
    }
    
    /**
     * Accessor to get the interest rate of premium account.
     * 
     * @return double Value of interest rate of credit account.
     */
    public static double getPremiumRate() 
    {
        return premiumInterestRate;
    }
    
    /**
     * Accessor to get the identifier of the last customer.
     * 
     * @return int Identifier of the last customer.
     */
    public static int getLastID() 
    {
        return lastCustID;
    }
    
    /**
     * Accessor to get the identifier of the next customer.
     * 
     * @return int Identifier of the next customer.
     */
    public static int getNextID() 
    {
        int id = 0;
        
        if(nextCustID == 0) {
            nextCustID = 1000;
            numOfCurrentCustomers = 1;
            id = nextCustID;
        }
        else if(numOfCurrentCustomers < MAX_NUM_OF_CUSTOMERS) {
            lastCustID = nextCustID;
            nextCustID++;
            numOfCurrentCustomers++;
            id = nextCustID;
        }
        
        return id;
    }
    
    /**
     * Mutator to set the interest rate of credit account.
     * 
     * @param rate Value of the interest rate of credit account.
     */
    public static void setCreditRate(double rate) 
    {
        creditInterestRate = rate;
    }
    
    /**
     * Mutator to set the interest rate of investment account.
     * 
     * @param rate Value of the interest rate of investment account.
     */
    public static void setInvestmentRate(double rate) 
    {
        investmentInterestRate = rate;
    }
    
    /**
     * Mutator to set the interest rate of premium account.
     * 
     * @param rate Value of the interest rate of premium account.
     */
    public static void setPremium(double rate) 
    {
        premiumInterestRate = rate;
    }
}
