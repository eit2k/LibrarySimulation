//Members of the group 
//name: saud Alharbi     id:446103576
//name: Omar Almanea     id:446104590
//name: rakan aldlal     id:446107561

import java.util.*;

public class LibrarySimulation {

 public static void main(String[] args) {
     
     Scanner input = new Scanner(System.in);

     // Create system members
     Member u1 = new Member(1, "Saud", 0);
     Member u2 = new Member(2, "Omar", 0);
     Member u3 = new Member(3, "Rakan", 0);

     boolean running = true;

     while (running) {

         System.out.println("\n------ Welcome to the Library ------");
         System.out.println("1. Login as " + u1.getName() + " (ID: " + u1.getId() + ")");
         System.out.println("2. Login as " + u2.getName() + " (ID: " + u2.getId() + ")");
         System.out.println("3. Login as " + u3.getName() + " (ID: " + u3.getId() + ")");
         System.out.println("4. Login as Administrator");
         System.out.println("5. Exit Program");
         System.out.print("Enter your choice: ");

         int choice = input.nextInt();
         Member current = null;

         // Select user
         if (choice == 1) current = u1;
         else if (choice == 2) current = u2;
         else if (choice == 3) current = u3;

         if (current != null) {

             boolean session = true;

             while (session) {

                 System.out.println("\n--- User Menu (" + current.getName() + ") ---");
                 System.out.println("1. View Borrowed Books Count");
                 System.out.println("2. Borrow a Book");
                 System.out.println("3. Return a Book");
                 System.out.println("4. View Session Statistics");
                 System.out.println("5. Reset Session Statistics");
                 System.out.println("6. Back to Main Menu");
                 System.out.print("Enter your choice: ");

                 int opt = input.nextInt();

                 switch (opt) {
                     case 1:
                         current.viewBorrowedCount();
                         break;

                     case 2:
                         current.borrowOne();
                         break;

                     case 3:
                         current.returnOne();
                         break;

                     case 4:
                         current.displayStatistics();
                         break;

                     case 5:
                         current.reset();
                         break;

                     case 6:
                         System.out.println("Returning to main menu...");
                         session = false;
                         break;

                     default:
                         System.out.println("Invalid option.");
                 }
             }

         } else if (choice == 4) {

             System.out.print("Enter administrator password: ");
             int pass = input.nextInt();

             if (pass == 123) {

                 boolean admin = true;

                 while (admin) {

                     System.out.println("\n====== Administrator Menu ======");
                     System.out.println("1. View Total Revenue");
                     System.out.println("2. Most Frequent Operation");
                     System.out.println("3. Back to Main Menu");
                     System.out.print("Enter your choice: ");

                     int a = input.nextInt();

                     switch (a) {

                         case 1:
                             System.out.println("Total Revenue: " + Member.TotalRevenue);
                             break;

                         case 2:
                             if (Member.TotalBorrows == 0 && Member.TotalReturns == 0) {
                                 System.out.println("No operations performed yet.");
                             } 
                             else if (Member.TotalBorrows > Member.TotalReturns) {
                                 System.out.println("Most Frequent Operation: Borrow");
                             } 
                             else if (Member.TotalReturns > Member.TotalBorrows) {
                                 System.out.println("Most Frequent Operation: Return");
                             } 
                             else {
                                 System.out.println("Most Frequent Operation: Tie between Borrow and Return");
                             }
                             break;

                         case 3:
                             admin = false;
                             break;

                         default:
                             System.out.println("Invalid option.");
                     }
                 }

             } else {
                 System.out.println("Incorrect password.");
             }

         } else if (choice == 5) {

             System.out.println("Thank you for using the system. Goodbye!");
             running = false;

         } else {
             System.out.println("Invalid option.");
         }
     }
     
     input.close();
 }

}
