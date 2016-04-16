import java.util.Date;

/**
 * Customer class is used as a customer object to hold customer information.
 * 
 * @author Rudy Nurhadi
 * @version 26/03/2016
 */
public class Customer 
{
    private Account[] accounts = new Account[Bank.maxNumOfAcctsPerCustomer];
    private String cityAddress;
    private int custId;
    private Date dateOfBirth;
    private String email;
    private String firstName; 
    private String lastName;
    private int numOfCurrentAccounts = 0;
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
    public Customer(String firstName, String lastName, Date dateOfBirth) 
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        custId = Bank.getNextID();
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
    public Account getAccount(char type) throws AccountTypeNotFoundException
    {
        for(int i = 0; i < Bank.maxNumOfAcctsPerCustomer; i++) {
            if(accounts[i] != null) {
                if (accounts[i].getID().lastIndexOf(type) != -1) {
                    return accounts[i];
                }
            }
        }
        
        throw new AccountTypeNotFoundException(type);
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
     * @return Date Date of customer birth.
     */
    public Date getDateOfBirth()
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
     * Mutator to add the customer account.
     * 
     * @param balance Balance in account.
     * @param type Type of an account.
     * @return boolean The success of add account process.
     */
    public void addAccount(Account account) throws AccountTypeAlreadyExistsException, Exception
    {
        boolean savingsAccountExist = false;
        if(numOfCurrentAccounts < Bank.maxNumOfAcctsPerCustomer) {
            for(int i = 0; i < Bank.maxNumOfAcctsPerCustomer; i++) {
                if(accounts[i] == null) {
                    if(accounts[i] instanceof OverDraftProtection) {
                        if(!savingsAccountExist) {
                            for(int j = i + 1; j < Bank.maxNumOfAcctsPerCustomer; j++) {
                                if(accounts[j] instanceof Savings && !(accounts[j] instanceof Investment)) {
                                    savingsAccountExist = true;
                                }
                            }
                            if(!savingsAccountExist) {
                                throw new Exception("Savings account is not created.");
                            }
                        }
                    }
                    accounts[i] = account;
                    numOfCurrentAccounts += 1;
                    break;
                }
                else {
                    if(accounts[i] instanceof Savings && !(accounts[i] instanceof Investment)) {
                        savingsAccountExist = true;
                    }
                    if(account.getClass().getName().equals(accounts[i].getClass().getName())) {
                        throw new AccountTypeAlreadyExistsException(account.getID().charAt(account.getID().length() - 1));
                    }
                }
            }
        }
        else {
            throw new Exception("Account is full");
        }
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
            if (accounts[i].getID().lastIndexOf(type) != -1) {
                accounts[i] = null;
                numOfCurrentAccounts--;
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
            if (accounts[i] != null) {
                customerInformation += "\nTipe akun = " + accounts[i].getID().charAt(accounts[i].getID().length() - 1) + ", Saldo = $" + accounts[i].getBalance();
            }
        }
        
        return customerInformation;
    }
}
