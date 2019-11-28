package com.nabesh;

public class Book {
    //Properties, fields, Global variables
    String title;
    int pageCount;
    int ISBN;
    boolean isCheckedOut;
    int dayCheckedOut = -1;


    //Constructor
    public Book(String bookTitle, int bookPageCount, int bookISBN){
        this.title = bookTitle;
        this.pageCount = bookPageCount;
        this.ISBN = bookISBN;
        isCheckedOut = false;

    }


    //Getters are instance methods
    public String getTitle() {
        return title;
    }

    public int getPageCount() {
        return pageCount;
    }


    public int getISBN() {
        return ISBN;
    }

    public boolean isCheckedOut(boolean b, int i) {
        return isCheckedOut;
    }

    public int getDayCheckedOut() {
        return dayCheckedOut;
    }

    //Setters
    public void setCheckedOut(boolean newIsCheckedOut, int currentDayCheckedOut) {
        this.isCheckedOut = newIsCheckedOut;
        setDayCheckedOut(currentDayCheckedOut);
    }

    private void setDayCheckedOut(int day) {
        this.dayCheckedOut = day;
    }



}
