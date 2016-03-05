import java.util.Scanner;

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
        Scanner scan = new Scanner(System.in);
        String answer, fname, lname, dob;
        Customer[] cust = new Customer[Bank.MAX_NUM_OF_CUSTOMERS];
        char type;
        int i = 0;
        double balance;

        while(true) {
            while(true) {
                System.out.println("\nApakah ingin membuat customer? (Y/N)");
                answer = scan.next();
                if(answer.charAt(0) == 'N' || answer.charAt(0) == 'n') {
                    return;
                }
                else if(answer.charAt(0) == 'Y' || answer.charAt(0) == 'y') {
                    break;
                }
            }
            System.out.println("\nMasukkan nama depan anda: ");
            fname = scan.next();
            System.out.println("\nMasukkan nama belakang anda: ");
            lname = scan.next();
            System.out.println("\nMasukkan tanggal lahir anda: ");
            dob = scan.next();
            cust[i] = new Customer(fname, lname, dob);
            while(true) {
                System.out.println("\nMasukkan tipe akun yang ingin anda buat (S: Savings, O: Overdraft, I: Investment, C: Credit, N: Tidak membuat");
                answer = scan.next();
                type = answer.charAt(0);
                if (type == 'S' || type == 'O' || type == 'I' || type == 'C') {
                    while(true) {
                        System.out.println("Masukkan nilai saldo awal: ");
                        balance = scan.nextDouble();
                        if (balance < 10) {
                            System.out.println("Maaf saldo yang anda masukkan tidak mencukupi");
                        }
                        else break;
                    }
                    if(!cust[i].setAccount(new Account(type, balance))) {
                        System.out.println("\nMaaf anda sudah tidak dapat membuat akun lagi\n");
                        break;
                    }
                    System.out.println("\nApakah anda ingin membuat akun lagi? (Y/N)");
                    answer = scan.next();
                    type = answer.charAt(0);
                }
                if (type == 'N' || type == 'n') {
                    break;
                }
            }
            System.out.println("\n\n\nInformasi Customer\n\n" + cust[i]);
        }
    }
}
