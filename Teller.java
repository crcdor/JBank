import java.util.Scanner;
import java.util.GregorianCalendar;

import java.text.DecimalFormat;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

import javax.swing.JFrame;

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
        try {
            Customer c1 = new Customer("Rudy", "Nurhadi");
            Account as1 = new Savings(c1, 1000);
            Account ai1 = new Investment(c1, 1000, 6);
            Account ac1 = new LineOfCredit(c1, 1000, 100);
            c1.addAccount(as1);
            c1.addAccount(ai1);
            c1.addAccount(ac1);
            
            Customer c2 = new Customer("Rudy1", "Nurhadi1");
            Account as2 = new Savings(c2, 2000);
            Account ai2 = new Investment(c2, 2000, 6);
            Account ac2 = new LineOfCredit(c2, 2000, 100);
            Account ao2 = new OverDraftProtection(c2, 2000, (Savings)as2);
            c2.addAccount(as2);
            c2.addAccount(ai2);
            c2.addAccount(ac2);
            c2.addAccount(ao2);
            
            
            Bank.addCustomer(c1);
            Bank.addCustomer(c2);
        }
        catch(Exception e){
        }
        
        
        
        
        System.out.println(Bank.getHoursOfOperation());
        
        Scanner scan = new Scanner(System.in);
        
        ATMGUI atm = new ATMGUI();
        JFrame f = new JFrame("test");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(atm);
        f.pack();
        f.setVisible(true);
        
//         System.out.println(Bank.getHoursOfOperation());
//         
//         Scanner scan = new Scanner(System.in);
//         String answer, fname, lname;
//         Customer cust;
//         char type;
//         int i = 0, day, month, year;
//         double balance;
// 
//         while(true) {
//             while(true) {
//                 System.out.println("\nApakah ingin membuat customer? (Y/N)");
//                 answer = scan.next();
//                 if(answer.charAt(0) == 'N' || answer.charAt(0) == 'n') {
//                     return;
//                 }
//                 else if(answer.charAt(0) == 'Y' || answer.charAt(0) == 'y') {
//                     break;
//                 }
//             }
//             System.out.println("\nMasukkan nama depan anda: ");
//             fname = scan.next();
//             System.out.println("\nMasukkan nama belakang anda: ");
//             lname = scan.next();
//             System.out.println("\nMasukkan tahun lahir anda: ");
//             year = scan.nextInt();
//             System.out.println("\nMasukkan bulan lahir anda (1-12): ");
//             month = scan.nextInt();
//             System.out.println("\nMasukkan tanggal lahir anda: ");
//             day = scan.nextInt();
//             cust = new Customer(fname, lname, new GregorianCalendar(year, month - 1, day).getTime());
//             while(true) {
//                 if(cust.getNumOfAccounts() > 3) {
//                     System.out.println("\nJumlah akun anda sudah maksimal\n");
//                     break;
//                 } 
//                 
//                 System.out.println("\nMasukkan tipe akun yang ingin anda buat (S: Savings, O: Overdraft, I: Investment, C: Credit, N: Tidak membuat");
//                 answer = scan.next();
//                 type = answer.charAt(0);
//                 
//                 if (type == 'S' || type == 'I' || type == 'O' || type == 'C') {
//                     if (type == 'S') {
//                         while(true) {
//                             System.out.println("Masukkan nilai saldo awal: ");
//                             balance = scan.nextDouble();
//                             
//                             if (balance < 10) {
//                                 System.out.println("Maaf saldo yang anda masukkan tidak mencukupi");
//                             }
//                             else break;
//                         }
//                         
//                         Savings savingsAcc = new Savings(cust, balance);
//                         if (!cust.addAccount(savingsAcc)) System.out.println("\nPenambahan akun gagal\n");
//                     }
//                     else if (type == 'I') {
//                         int term = 0;
//                         
//                         while(true) {
//                             System.out.println("Masukkan nilai saldo awal: ");
//                             balance = scan.nextDouble();
//                             System.out.println("Masukkan jangka investasi (minimal 6 bulan): ");
//                             term = scan.nextInt();
//                             
//                             if(balance >= 100 && term >= 6) {
//                                 break;
//                             }
//                             
//                             if(balance < 100) {
//                                 System.out.println("Maaf saldo yang anda masukkan tidak mencukupi");
//                             }
//                             
//                             if(term < 6) {
//                                 System.out.println("Maaf jangka waktu investasi minimal adalah 6 bulan");
//                             }
//                             
//                         }
//                         
//                         Investment investmentAcc = new Investment(cust, balance, term);
//                         if (!cust.addAccount(investmentAcc)) System.out.println("\nPenambahan akun gagal\n");
//                     }
//                     else if (type == 'O') {
//                         Savings savingsAcc = (Savings)cust.getAccount('S');
//                         
//                         if(savingsAcc != null) {
//                             while(true) {
//                                 System.out.println("Masukkan nilai saldo awal: ");
//                                 balance = scan.nextDouble();
//                                 
//                                 if (balance < 10) {
//                                     System.out.println("Maaf saldo yang anda masukkan tidak mencukupi");
//                                 }
//                                 else break;
//                             }
//                             OverDraftProtection overDraftProtectionAcc = new OverDraftProtection(cust, balance, savingsAcc);
//                             
//                             if (!cust.addAccount(overDraftProtectionAcc)) System.out.println("\nPenambahan akun gagal\n");
//                         }
//                         else {
//                             System.out.println("\nUntuk membuat akun overdraft anda diharuskan membuat akun savings terlebih dahulu\n");
//                         }
//                     }
//                     else if (type == 'C') {
//                         double limit;
//                         
//                         while(true) {
//                             System.out.println("Masukkan nilai saldo awal: ");
//                             balance = scan.nextDouble();
//                             System.out.println("Masukkan nilai credit limit: ");
//                             limit = scan.nextDouble();
//                             
//                             if(balance >= 10 && limit > 0) {
//                                 break;
//                             }
//                             
//                             if(balance < 10) {
//                                 System.out.println("Maaf saldo yang anda masukkan tidak mencukupi");
//                             }
//                             
//                             if(limit < 0) {
//                                 System.out.println("Maaf limit tidak boleh kurang dari 0");
//                             }
//                         }
//                         
//                         LineOfCredit lineOfCreditAcc = new LineOfCredit(cust, balance, limit);
//                         if (!cust.addAccount(lineOfCreditAcc)) System.out.println("\nPenambahan akun gagal\n");
//                     }
//                 }
//                 else continue;
//                 
//                 while(true) {
//                     System.out.println("\nApakah anda ingin membuat akun lagi? (Y/N)");
//                     answer = scan.next();
//                     type = answer.charAt(0);
//                     
//                     if(type == 'Y' || type == 'y' || type == 'N' || type == 'n') break;
//                 }
//                 
//                 if(type == 'N' || type == 'n') break;
//             }
//             
//             answer = Bank.addCustomer(cust) ? "Kustomer berhasil ditambahkan" : "Gagal menambahkan kustomer";
//             System.out.print(answer);
//             
//             System.out.println("\n\n\nInformasi Customer (ID = " + cust.getCustID() + ")\n\n"); 
//             answer = Bank.getCustomer(cust.getCustID()) != null ? Bank.getCustomer(cust.getCustID()).toString() : "Gagal menemukan kustomer";
//             
//             System.out.println(answer);
//         }
        
    }
    
}
