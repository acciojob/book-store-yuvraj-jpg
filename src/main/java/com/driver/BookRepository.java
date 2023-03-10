package com.driver;
import java.util.*;

import org.springframework.stereotype.Repository;

@Repository
public class BookRepository {
    private HashMap<Integer,Book> bookrecord;
    public BookRepository() {
        this.bookrecord = new HashMap<>();
    }

    public Book save(Book book){
        bookrecord.put(book.getId(),book);
        return book;
    }

    public Book findBookById(int id){
        return bookrecord.get(id);
    }

    public List<Book> findAll(){
        List<Book> list = new ArrayList<>();
        for(Integer id : bookrecord.keySet()){
            list.add(bookrecord.get(id));
        }
        return list;
    }

    public void deleteBookById(int id){
        bookrecord.remove(id);
    }

    public void deleteAll(){
        bookrecord = new HashMap<>();
    }

    public List<Book> findBooksByAuthor(String author){
        List<Book> list = new ArrayList<>();
        for(Integer id : bookrecord.keySet()){
            if(bookrecord.get(id).getAuthor().equals(author)){
                list.add(bookrecord.get(id));
            }
        }
        return list;
    }

    public List<Book> findBooksByGenre(String genre){
        List<Book> list = new ArrayList<>();
        for(Integer id : bookrecord.keySet()){
            if(bookrecord.get(id).getGenre().equals(genre)){
                list.add(bookrecord.get(id));
            }
        }
        return list;
    }
}
