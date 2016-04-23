import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.ClassNotFoundException;

import java.util.ArrayList;

/**
 * CustomerFileReader class.
 * 
 * @author Rudy Nurhadi
 * @version 21/04/2016
 */
public class CustomerFileReader
{
    private static FileInputStream fileInputStream;
    private static ObjectInputStream objectInputStream;
    private static File objectFile;
    
    /**
     * Constructor for objects of class CustomerFileReader
     */
    public CustomerFileReader()
    {
        
    }
    
    public static ArrayList<Customer> readCustomer() {
        try {
            objectFile = new File(Bank.CUSTOMER_FILE_NAME);
            
            try {
                fileInputStream = new FileInputStream(objectFile);
                objectInputStream = new ObjectInputStream(fileInputStream);
            }
            catch(FileNotFoundException e) {
                ArrayList<Customer> customers = new ArrayList<Customer>();
                new CustomerFileWriter().saveCustomer(customers);
                fileInputStream = new FileInputStream(objectFile);
                objectInputStream = new ObjectInputStream(fileInputStream);
            }
            
            ArrayList<Customer> customers = (ArrayList<Customer>)objectInputStream.readObject();
            return customers;
        }
        catch(Exception e) {
            System.out.println("Ex1:" + e.getMessage());
        }
        
        return null;
    }
}



















