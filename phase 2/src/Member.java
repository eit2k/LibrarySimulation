// Members of the group
// name: saud Alharbi    id:446103576
// name: Omar Almanea    id:446104590
// name: rakan aldlal    id:446107561


public class Member {

    // Instance attributes
    private int id;
    private String name;
    private int borrowedCount;

    private int numViewBorrowed;
    private int numBorrows;
    private int numReturns;
    private double sessionFees;

    // Class-level cumulative values
    public static double TotalRevenue = 0;
    public static int TotalViewBorrowed = 0;
    public static int TotalBorrows = 0;
    public static int TotalReturns = 0;

    // Constructor
    public Member(int id, String name, int borrowedCount) {
        this.id = id;
        this.name = name;
        this.borrowedCount = borrowedCount;
    }

    // Private helper methods
    private boolean canBorrow() {
        return borrowedCount < 5;
    }

    private boolean canReturn() {
        return borrowedCount > 0;
    }

    // Show current borrowed count
    public void viewBorrowedCount() {
        System.out.println("Books currently borrowed: " + borrowedCount);
        numViewBorrowed++;
        TotalViewBorrowed++;
    }

    // Borrow one book
    public boolean borrowOne() {
        if (!canBorrow()) {
            System.out.println("You cannot borrow more than 5 books.");
            return false;
        }

        borrowedCount++;
        numBorrows++;
        TotalBorrows++;

        sessionFees += 0.50;
        TotalRevenue += 0.50;

        System.out.println("Book borrowed successfully. Fee: 0.50");
        return true;
    }

    // Return one book
    public boolean returnOne() {
        if (!canReturn()) {
            System.out.println("You have no books to return.");
            return false;
        }

        borrowedCount--;
        numReturns++;
        TotalReturns++;

        System.out.println("Book returned successfully.");
        return true;
    }

    // Display statistics for the session
    public void displayStatistics() {
        System.out.println("\n====== Session Statistics ======");
        System.out.println("Member Name: " + name);
        System.out.println("Member ID: " + id);
        System.out.println("Times View Borrowed Count Used: " + numViewBorrowed);
        System.out.println("Books Borrowed in This Session: " + numBorrows);
        System.out.println("Books Returned in This Session: " + numReturns);
        System.out.println("Fees Incurred This Session: " + sessionFees);
        System.out.println("================================\n");
    }

    // Reset session-only statistics
    public void reset() {
        numViewBorrowed = 0;
        numBorrows = 0;
        numReturns = 0;
        sessionFees = 0;
        System.out.println("Session statistics reset.");
    }

    
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getBorrowedCount() {
        return borrowedCount;
    }

}// edit by Saud

