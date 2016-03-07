
/**
 * Customer class is used as a customer object to hold customer information.
 * 
 * @author Rudy Nurhadi
 * @version 26/02/2016
 */
public class Customer 
{
    private Account[] accounts = new Account[Bank.maxNumOfAcctsPerCustomer];
    private String cityAddress;
    private int custId;
    private String dateOfBirth;
    private String email;
    private String firstName; 
    private String lastName;
    private int numOfCurrentAccounts;
    private String streetAddress;
    private String phoneNumber;
    private String zipOrPostalCode;

    /**
     * Create a new customer object.
     * 
     * @param fname First name of customer.
     * @param lname Last name of customer.
     */
    public Customer(String fname, String lname)
    {
        this(fname, lname, null);
    }
    
    /**
     * Create a new customer object.
     * 
     * @param fname First name of customer.
     * @param lname Last name of customer.
     * @param dob Date of birth of customer.
     */
    public Customer(String firstName, String lastName, String dateOfBirth) 
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        custId = Bank.getNextID();
        for(int i = 0; i < Bank.maxNumOfAcctsPerCustomer; i++) {
            accounts[i] = new Account();
        }
    }
    
    /**
     * Accessor to get the customer address.
     * 
     * @return String Street address, city name, zip or postal code of customer.
     */
    public String getAddress() 
    {
        return streetAddress + " " + cityAddress + " " + zipOrPostalCode;
    }
    
    /**
     * Accessor to get the customer account object.
     * 
     * @param type Account type that want to get.
     * @return Account Account object of customer.
     */
    public Account getAccount(char type) 
    {
        for(int i = 0; i < Bank.maxNumOfAcctsPerCustomer; i++) {
            if (accounts[i].getAcctType() == type) {
                return accounts[i];
            }
        }
        
        return null;
    }
    
    /**
     * Accessor to get the customer identifier.
     * 
     * @return int Customer identifier.
     */
    public int getCustID() 
    {
        return custId;
    }
    
    /**
     * Accessor to get the customer email.
     * 
     * @return String Email address of customer.
     */
    public String getEmail() 
    {
        return email;
    }
    
    /**
     * Accessor to get the customer name.
     * 
     * @return String Last name and first name of customer.
     */
    public String getName() 
    {
        return lastName + ", " + firstName;
    }
    
    /**
     * Accessor to get the total number of customer account.
     * 
     * @return int Total number of customer account.
     */
    public int getNumOfAccounts() 
    {
        return numOfCurrentAccounts;
    }
    
    /**
     * Accessor to get the customer phone number.
     * 
     * @return String Phone number of customer.
     */
    public String getPhoneNumber() 
    {
        return phoneNumber;
    }
    
    /**
     * Accessor to get the date of customer birth.
     * 
     * @return String Date of customer birth.
     */
    public String getDateOfBirth()
    {
        return dateOfBirth;
    }
    
    /**
     * Mutator to set the customer address.
     * 
     * @param street Street address of customer.
     * @param city City address of customer.
     * @param code Zip or postal code of customer address.
     */
    public void setAddress(String street, String city, String code) 
    {
        streetAddress = street;
        cityAddress = city;
        code = zipOrPostalCode;
    }
    
    /**
     * Mutator to set the customer email.
     * 
     * @param emailAddress Email address of customer.
     * @return boolean The success of email change process.
     */
    public boolean setEmail(String emailAddress) 
    {
        String EMAIL_REGEX = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        
        if(emailAddress.matches(EMAIL_REGEX)) {
            email = emailAddress;
            
            return true;
        }
        
        return false;
    }
    
    /**
     * Mutator to set the customer name.
     * 
     * @param fname First name of customer.
     * @param lname Last name of customer.
     */
    public void setName(String fname, String lname) 
    {
        firstName = fname;
        lastName = lname;
    }
    
    /**
     * Mutator to set the customer phone number.
     * 
     * @param phoneNum Phone number of customer.
     */
    public void setPhoneNumber(String phoneNum) 
    {
        phoneNumber = phoneNum;
    }
    
    /**
     * Mutator to set the customer account.
     * 
     * @param acc Account object for customer.
     * @return boolean The success of set account process.
     */
    public boolean setAccount(Account acc) 
    {
        for(int i = 0; i < Bank.maxNumOfAcctsPerCustomer; i++) {
            if (accounts[i].getAcctType() == '\0') {
                accounts[i] = acc;
                return true;
            }
        }
        
        return false;
    }
    
    /**
     * Mutator to set the customer id.
     * 
     * @param id Customer identifier.
     */
    public void setCustID(int id) {
        custId = id;
    }
    
    /**
     * Method to remove one of the customer account.
     * 
     * @param type Account type that customer want to remove.
     * @return boolean The success of remove process.
     */
    public boolean removeAccount(char type) {
        for(int i = 0; i < Bank.maxNumOfAcctsPerCustomer; i++) {
            if (accounts[i].getAcctType() == type) {
                accounts[i] = new Account();
                return true;
            }
        }
        
        return false;
    }
    
    /**
     * Method to return string of customer information to print.
     * 
     * @return String Customer information to print.
     */
    public String toString() {
        String customerInformation = "ID = " + this.getCustID() + "\nNama = " + this.getName() + "\nTanggal Lahir = " + this.getDateOfBirth();
        
        for(int i = 0; i < Bank.maxNumOfAcctsPerCustomer; i++) {
            if (accounts[i].getAcctType() != '\0') {
                customerInformation += "\nTipe akun = " + accounts[i].getAcctType() + ", Saldo = $" + accounts[i].getBalance();
            }
        }
        
        return customerInformation;
    }
}
