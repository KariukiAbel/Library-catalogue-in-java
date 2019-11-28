package com.nabesh;

import java.util.HashMap;
import java.util.Map;

public class Main {
    Map<String, Book> bookCollection = new HashMap<String, Book>();
    int currentDay = 0;
    int lengthOfCheckOutPeriod = 7;
    double initialLateFee = 150;
    double feesPerLateDay = 100;


    public Main(Map<String, Book> collection){
        this.bookCollection= collection;
    }

    public Main(Map<String, Book> collection, int lengthOfCheckOutPeriod, double initialLateFee, double feesPerLateDay){
        this.bookCollection = collection;
        this.lengthOfCheckOutPeriod = lengthOfCheckOutPeriod;
        this.initialLateFee = initialLateFee;
        this.feesPerLateDay = feesPerLateDay;

    }

    public Map<String, Book> getBookCollection() {
        return this.bookCollection;
    }

    public int getCurrentDay() {
        return this.currentDay;
    }

    public Book getBook(String bookTitle){
        return getBookCollection().get(bookTitle);
    }

    public int getLengthOfCheckOutPeriod() {
        return this.lengthOfCheckOutPeriod;
    }

    public double getInitialLateFee() {
        return this.initialLateFee;
    }

    public double getFeesPerLateDay() {
        return this.feesPerLateDay;
    }

    //setters
    public void nextDay(){
        currentDay++;
    }

    public void setDay(int day){
        currentDay = day;
    }

    //instance methods
    public void checkOutBook(String title){
        Book book = getBook(title);
        if (book.isCheckedOut(false, -1)){
            sorryBookAlreadyCheckedOut(book);
        }else {
            book.setCheckedOut(true, currentDay);
            System.out.println("You just checked out " + title + ". It is due on day " +
                    (getCurrentDay() + getLengthOfCheckOutPeriod()) + ".");
        }
    }

    public void returnBook(String title){
        Book book = getBook(title);
        int daysLate = currentDay -(book.getDayCheckedOut() + getLengthOfCheckOutPeriod());
        if (daysLate > 0){
            System.out.println("You owe the library Ksh: " + (getInitialLateFee() + daysLate * getFeesPerLateDay()) +
                    " because your book is " + daysLate + " days overdue.");
        }else{
            System.out.println("Book returned. Thank you");
        }
        book.isCheckedOut(false, -1);
    }

    public void sorryBookAlreadyCheckedOut(Book book){
        System.out.println("Sorry, " + book.getTitle() + " is already checked out. It should be back by day "
                + (book.getDayCheckedOut() + getLengthOfCheckOutPeriod()) + ".");

    }

    public static void main(String[] args) {
	// write your code here
        Map<String, Book> bookCollection = new HashMap<String, Book>();
        Book harry = new Book("Harry Potter", 485656685, 999999);
        bookCollection.put("Harry Potter", harry);
        Main main = new Main(bookCollection);
        main.checkOutBook("Harry Potter");
        main.nextDay();
        main.nextDay();
        main.checkOutBook("Harry Potter");
        main.setDay(17);
        main.returnBook("Harry Potter");
        main.checkOutBook("Harry Potter");

    }
}
