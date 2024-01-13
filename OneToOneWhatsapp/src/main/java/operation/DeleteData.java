package operation;

import connection.Connection;
import model.Contact;
import model.WhatsApp;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import javax.persistence.Query;
import java.util.List;
import java.util.Scanner;

public class DeleteData {
    static Scanner sc1=new Scanner(System.in);
    static SessionFactory factory= Connection.connectionHelper();
    static Session session=factory.openSession();
    public static void deleteData() {

        boolean status=true;
        while (status){
            System.out.println("==========================");
            System.out.println("1: Delete All Data");
            System.out.println("2: Delete only WhatsApp Account");
            System.out.println("3: Main Menu");
            System.out.println("==========================");
            System.out.println("Enter Your Choice");
            int choice= sc1.nextInt();
            switch (choice){
                case 1:
                    System.out.println("Enter Contact Number");
                    long number= sc1.nextLong();
                    deleteAllData(number);
                    break;
                case 2:
                    System.out.println("Enter Contact Number");
                    long number1= sc1.nextLong();
                    deleteOnlyWhatsApp(number1);
                    break;
                case 3:
                    status=false;
                    System.out.println("Thank you...");
                default:
                    System.out.println("Enter Valid option");
            }
        }
    }
    private static void deleteOnlyWhatsApp(long number1) {
        Transaction tax= session.beginTransaction();
        Query result = session.createQuery("from Contact c where c.contactNum = :number");
        result.setParameter("number", number1);
        List<Contact> data=result.getResultList();
        for (Contact c2:data) {
            WhatsApp w1= c2.getWhatsAppRef();
            c2.setWhatsAppRef(null);
            session.delete(w1);
            tax.commit();
            System.out.println("==================================");
            System.out.println("WhatsApp Deleted Successfully.");
        }
    }
    private static void deleteAllData(long number) {
        Transaction tax= session.beginTransaction();
        Query result = session.createQuery("from Contact c where c.contactNum = :number");
        result.setParameter("number", number);
        List<Contact> data=result.getResultList();
        for (Contact c2:data) {
            c2.getWhatsAppRef();
            session.delete(c2);
            tax.commit();
            System.out.println("==================================");
            System.out.println("Data Deleted Successfully.");
        }
    }
}
