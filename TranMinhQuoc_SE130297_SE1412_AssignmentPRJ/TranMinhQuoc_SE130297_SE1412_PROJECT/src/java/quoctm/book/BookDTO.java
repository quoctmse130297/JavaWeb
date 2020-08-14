/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quoctm.book;

import java.io.Serializable;

/**
 *
 * @author SE130297
 */
public class BookDTO implements Serializable{
    private int bookID;
    private String bookName;
    private float price;

    public BookDTO(int bookID) {
        this.bookID = bookID;
    }

    public BookDTO() {
    }

    public BookDTO(int bookID, String bookName, float price) {
        this.bookID = bookID;
        this.bookName = bookName;
        this.price = price;
    }    

    public int getBookID() {
        return bookID;
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
    
    
}
