import java.util.Scanner;
import java.util.GregorianCalendar;

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
        System.out.println(Bank.getHoursOfOperation());
        
        Scanner scan = new Scanner(System.in);
        String answer, fname, lname;
        Customer cust;
        char type;
        int i = 0, day, month, year;
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
            System.out.println("\nMasukkan tahun lahir anda: ");
            year = scan.nextInt();
            System.out.println("\nMasukkan bulan lahir anda (1-12): ");
            month = scan.nextInt();
            System.out.println("\nMasukkan tanggal lahir anda: ");
            day = scan.nextInt();
            cust = new Customer(fname, lname, new GregorianCalendar(year, month - 1, day).getTime());
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
                    if (!cust.addAccount(balance, type)) {
                        System.out.println("\nPenambahan akun gagal\n");
                    }
                    if(cust.getNumOfAccounts() > 3) {
                        System.out.println("\nJumlah akun anda sudah maksimal\n");
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
            answer = Bank.addCustomer(cust) ? "Kustomer berhasil ditambahkan" : "Gagal menambahkan kustomer";
            System.out.print(answer);
            
            System.out.println("\n\n\nInformasi Customer (ID = " + cust.getCustID() + ")\n\n"); 
            answer = Bank.getCustomer(cust.getCustID()) != null ? Bank.getCustomer(cust.getCustID()).toString() : "Gagal menemukan kustomer";
            
            System.out.println(answer);
        }
        
    }
    
}
