package com.example.demo;

import javafx.beans.InvalidationListener;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

public class Books {
    private StringProperty book_name = new SimpleStringProperty(this, "book_name");
    private StringProperty author = new SimpleStringProperty(this, "author");
    public String getBookName(){ return book_name.get(); }
    public void setBookName(String book_name){
        this.book_name.set(book_name);
    }
    public String getAuthor(){
        return author.get();
    }
    public void setAuthor(String author){
        this.author.set(author);
    }
    Books(){};
    Books(String book_name, String author){
        setBookName(book_name);
        setAuthor(author);
    };
}
