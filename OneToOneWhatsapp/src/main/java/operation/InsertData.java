package operation;

import connection.Connection;
import model.Contact;
import model.WhatsApp;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.Scanner;
public class InsertData {
    static Contact c1=null;
    static   WhatsApp w1=null;
    static SessionFactory factory= Connection.connectionHelper();
   static Session session= factory.openSession();

    public static void insertData(Scanner sc1) {
        System.out.println("Enter Contact Number");
        long number=sc1.nextLong();
        System.out.println("Enter Contact Holder Name");
        sc1.nextLine();
        String name=sc1.nextLine();
        System.out.println("Enter Service Provider");
        String service=sc1.next();

        String network = null;
        boolean option=true;
        while (option){
            System.out.println("Your Network is 5 G or not ? ");
            System.out.println("1: Yes");
            System.out.println("2: No");
            int choice1= sc1.nextInt();
            switch (choice1) {
                case 1:
                    network = "Yes";
                    option=false;
                    break;
                case 2:
                    network = "No";
                    option=false;
                    break;
                default:
                    System.err.println("Select Correct Option");
                    break;
            }
        }

        c1=new Contact();
        c1.setContactNum(number);
        c1.setHolderName(name);
        c1.setServiceProvider(service);
        c1.setFiveGorNot(network);

        System.out.println("========================================");
        System.out.println("You Want to create WhatsApp Account");
        System.out.println("========================================");
        System.out.println("1: Yes");
        System.out.println("2: No");
        int choice= sc1.nextInt();

        switch (choice){
            case 1:
                addWhatsAppAccount(sc1);
                Transaction tax1= session.beginTransaction();
                w1.setWhatsAppNum(number);
                session.save(c1);
                session.save(w1);
                System.out.println("=========================================");
                System.out.println("Data Added & WhatsApp created Successfully..");
                //System.out.println("=========================================");
                tax1.commit();
                break;
            case 2:
                Transaction tax= session.beginTransaction();
                session.save(c1);
                System.out.println("=========================================");
                System.out.println("Data Added Successfully..");
                tax.commit();
                break;
            default:
                System.out.println("===========================");
                System.out.println("Enter Valid option");
                System.out.println("===========================");
        }
    }
    public static void addWhatsAppAccount(Scanner sc1){
        System.out.println("Enter WhatsApp Name");
        String whatsName= sc1.next();
        System.out.println("Enter WhatsApp About Section");
        String about= sc1.next();

        String accType=null;
        boolean flag=true;
        while (flag){
            System.out.println("Enter Account Type");
            System.out.println("1: Regular Account");
            System.out.println("2: Business Account");
            int actype= sc1.nextInt();
        switch (actype){
            case 1:
                accType="REGULAR_ACCOUNT";
                flag=false;
                break;
            case 2:
                accType="BUSINESS_ACCOUNT";
                flag=false;
                break;
            default:
                System.out.println("===========================");
                System.out.println("Select Correct Option");
                System.out.println("===========================");
                break;
            }
        }
        w1=new WhatsApp();
        w1.setWhatsAppName(whatsName);
        w1.setAbout(about);
        w1.setAccType(accType);
        c1.setWhatsAppRef(w1);
    }
}
