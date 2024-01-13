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

public class UpdateData {
    static Scanner sc1=new Scanner(System.in);
    static    SessionFactory factory= Connection.connectionHelper();
    static   Session session=factory.openSession();
    public static void updateData() {
        boolean status=true;
        while (status){
            System.out.println("===================================");
            System.out.println("1: Update Name");
            System.out.println("2: Update Service Provider");
            System.out.println("3: Update 5g Network");
            System.out.println("4: Update WhatsApp Name");
            System.out.println("5: Update WhatsApp About Section");
            System.out.println("6: Update Account Type");
            System.out.println("7: Exit");
            System.out.println("===================================");
            int choice=sc1.nextInt();
            switch (choice){
                case 1:
                    System.out.println("Enter Contact Number");
                    long number5= sc1.nextLong();
                    System.out.println("Enter New Name");
                    String newName= sc1.next();
                    updateName(number5,newName);
                    break;
                case 2:
                    System.out.println("Enter Contact Number");
                    long number4= sc1.nextLong();
                    System.out.println("Enter New Service Provider");
                    String service= sc1.next();
                    updateServiceProvider(number4,service);
                    break;
                case 3:
                    System.out.println("Enter Contact Number");
                    long number3= sc1.nextLong();
                    updateNetwork(number3);
                    break;
                case 4:
                    System.out.println("Enter Contact number");
                    long number2= sc1.nextLong();
                    System.out.println("Enter New WhatsApp Name");
                    String name2= sc1.next();
                    updateWhatsAppName(number2,name2);
                    break;
                case 5:
                    System.out.println("Enter Contact number");
                    long number1= sc1.nextLong();
                    System.out.println("Enter New About Section");
                    String about= sc1.next();
                    aboutSection(number1,about);
                    break;
                case 6:
                    System.out.println("Enter Contact number");
                    long number= sc1.nextLong();
                    updateAccountType(number);
                    break;
                case 7:
                    status=false;
                    System.out.println("Thank You...");
                default:
                    System.out.println("Invalid Choice");
            }
        }
    }
    private static void updateAccountType(long number) {
        Transaction tax= session.beginTransaction();
        Query result = session.createQuery("from Contact c where c.contactNum = :number");
        result.setParameter("number", number);
        List<Contact> data=result.getResultList();

        for (Contact c2:data) {
            WhatsApp w1 = c2.getWhatsAppRef();
            System.out.println("Your old Account Type : " +w1.getAccType());
            System.out.println("===========================================");
            String accType=null;
            boolean flag=true;
            while (flag){
                System.out.println("Set New Account Type");
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
                        break;
                }
            }
            w1.setAccType(accType);
            session.update(w1);
            tax.commit();
            System.out.println("==================================");
            System.out.println("WhatsApp Account Type Updated Successfully.");
            System.out.println("==================================");
        }
    }
    private static void aboutSection(long number1,String about) {
        Transaction tax= session.beginTransaction();
        Query result = session.createQuery("from Contact c where c.contactNum = :number");
        result.setParameter("number", number1);
        List<Contact> data=result.getResultList();

        for (Contact c2:data) {
            WhatsApp w1 = c2.getWhatsAppRef();
            w1.setAbout(about);
            session.update(w1);
            tax.commit();
            System.out.println("==================================");
            System.out.println("WhatsApp About Section Updated Successfully.");
            System.out.println("==================================");
        }
    }

    private static void updateWhatsAppName(long number2,String name2) {
        Transaction tax= session.beginTransaction();
        Query result = session.createQuery("from Contact c where c.contactNum = :number");
        result.setParameter("number", number2);
        List<Contact> data=result.getResultList();

            for (Contact c2:data) {
                WhatsApp w1 = c2.getWhatsAppRef();
                w1.setWhatsAppName(name2);
                session.update(w1);
                tax.commit();
                System.out.println("==================================");
                System.out.println("WhatsApp Name Updated Successfully.");
                System.out.println("==================================");
            }
    }

    private static void updateNetwork(long number3) {
        String network = null;
        boolean option=true;
        while (option){
            System.out.println("Your new Network is 5 G or not ? ");
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
        Transaction tax= session.beginTransaction();
        Query update=session.createQuery("update Contact c set c.fiveGorNot =: network where c.contactNum  =: number");
        update.setParameter("number",number3);
        update.setParameter("network",network);
        int count=update.executeUpdate();
        tax.commit();
        if (count>0){
            System.out.println("==================================");
            System.out.println("New Network Updated Successfully..");
            System.out.println("==================================");
        }else {
            System.out.println("Enter Valid Contact Number..");
        }
    }

    private static void updateServiceProvider(long number4,String service) {
       Transaction tax= session.beginTransaction();
        Query update=session.createQuery("update Contact c set c.serviceProvider =: newprovider where c.contactNum  =: number");
        update.setParameter("number",number4);
        update.setParameter("newprovider",service);
        int count=update.executeUpdate();
        tax.commit();
        if (count>0){
            System.out.println("==================================");
            System.out.println("Service Provider Updated Successfully..");
            System.out.println("==================================");
        }else {
            System.out.println("Enter Valid Contact Number..");
        }
    }
    private static void updateName(long number5,String newName) {
        Transaction tax= session.beginTransaction();
        Query update=session.createQuery("update Contact c set c.holderName =:newName where c.contactNum  =: number");
        update.setParameter("number",number5);
        update.setParameter("newName",newName);
        int count=update.executeUpdate();
        tax.commit();

       if (count>0){
           System.out.println("==================================");
           System.out.println("Name Updated Successfully..");
           System.out.println("==================================");
       }else {
           System.out.println("Enter Valid Contact Number..");
       }
    }
}
