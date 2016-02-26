
/**
 * Customer class is used as a customer object to hold customer information.
 * 
 * @author Rudy Nurhadi
 * @version 26/02/2016
 */
public class Customer 
{
    private Account accounts = new Account();
    private String cityName;
    private int custId;
    private String dateOfBirth;
    private String email;
    private String firstName; 
    private String lastName;
    private int numberOfCurrentAccounts;
    private String streetAddress;
    private String phoneNumber;
    private String zipOrPostalCode;

    /**
     * Create a new customer object.
     */
    public Customer()
    {
        
    }
    
    /**
     * Create a new customer object.
     * 
     * @param fname First name of customer.
     * @param lname Last name of customer.
     * @param dob Date of birth of customer.
     */
    public Customer(String fname, String lname, String dob) 
    {
        firstName = fname;
        lastName = lname;
        dateOfBirth = dob;
    }
    
    /**
     * Create a new customer object.
     * 
     * @param fname First name of customer.
     * @param lname Last name of customer.
     * @param dob Fate of birth of customer.
     * @param id Customer identifier.
     */
    public Customer(String fname, String lname, String dob, int id) 
    {
        firstName = fname;
        lastName = lname;
        dateOfBirth = dob;
        custId = id;
    }
    
    /**
     * Accessor to get the customer address.
     * 
     * @return string Street address, city name, zip or postal code of customer.
     */
    public String getAddress() 
    {
        return streetAddress + " " + cityName + " " + zipOrPostalCode;
    }
    
    /**
     * Accessor to get the customer account object.
     * 
     * @return Account Account object of customer.
     */
    public Account getAccount() 
    {
        return accounts;
    }
    
    /**
     * Accessor to get the customer identifier.
     * 
     * @return int Customer identifier.
     */
    public int getCustomerId() 
    {
        return custId;
    }
    
    /**
     * Accessor to get the customer email.
     * 
     * @return string Email address of customer.
     */
    public String getEmail() 
    {
        return email;
    }
    
    /**
     * Accessor to get the customer name.
     * 
     * @return string Last name and first name of customer.
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
        return numberOfCurrentAccounts;
    }
    
    /**
     * Accessor to get the customer phone number.
     * 
     * @return string Phone number of customer.
     */
    public String getPhoneNumber() 
    {
        return phoneNumber;
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
        cityName = city;
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
     */
    public void setAccount(Account acc) 
    {
        accounts = acc;
    }
}
