import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.File;
import java.io.InvalidClassException;
import java.io.NotSerializableException;
import java.io.IOException;

import java.util.ArrayList;

/**
 * CustomerFileWriter class.
 * 
 * @author Rudy Nurhadi
 * @version 21/04/2016
 */
public class CustomerFileWriter
{
    private static FileOutputStream fileOutputStream;
    private static ObjectOutputStream objectOutputStream;
    private static File objectFile;
    
    /**
     * Constructor for objects of class CustomerFileWriter
     */
    public CustomerFileWriter()
    {
        
    }

    public static void saveCustomer(ArrayList<Customer> customers) {
        try {
            objectFile = new File(Bank.CUSTOMER_FILE_NAME);
            objectFile.createNewFile();
            fileOutputStream = new FileOutputStream(objectFile);
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            
            try {
                objectOutputStream.writeObject(customers);
            }
            catch(InvalidClassException e) {
                System.out.println("InvalidClassException:" + e.getMessage());
            }
            catch(NotSerializableException e) {
                System.out.println("NotSerializableException:" + e.getMessage());
            }
            catch(IOException e) {
                System.out.println("IOException:" + e.getMessage());
            }
            finally {
                objectOutputStream.close();
            }
        }
        catch(Exception e) {
            System.out.println("Ex1:" + e.getMessage());
        }
    }
}

















