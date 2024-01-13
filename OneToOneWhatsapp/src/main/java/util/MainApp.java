package util;

import operation.DeleteData;
import operation.DisplayData;
import operation.InsertData;
import operation.UpdateData;

import java.util.Scanner;

public class MainApp {
    static Scanner sc1=new Scanner(System.in);

    public static void main(String[] args) {
        boolean status=true;
        while (status){
            System.out.println("=========================================");
            System.out.println("1: Insert Data");
            System.out.println("2: Update Data");
            System.out.println("3: Delete Data");
            System.out.println("4: Display Data");
            System.out.println("5: Exit");
            System.out.println("=========================================");
            System.out.println("Enter Your Choice");
            int choice= sc1.nextInt();
            switch (choice){
                case 1:
                    InsertData.insertData(sc1);
                    break;
                case 2:
                    UpdateData.updateData();
                    break;
                case 3:
                    DeleteData.deleteData();
                    break;
                case 4:
                    DisplayData.displayData();
                    break;
                case 5:
                    status=false;
                    System.out.println("Thank You");
                    break;
                default:
                    System.out.println("Invalid Choice..");
            }
        }
    }
}
