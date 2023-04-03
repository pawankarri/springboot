package com.api.book.bootrestbook.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.api.book.bootrestbook.entites.Book;

@Component
public class BookServices {
    private static List<Book> list = new ArrayList<>();
    static {
        list.add(new Book(12, "java book", "xyz"));
        list.add(new Book(36, "java book", "xyz"));
        list.add(new Book(48, "java book", "xyz"));

    }

    public List<Book> getAllBooks() {
        return list;
    }

    public Book getBookById(int id) {
        Book book = null;
        book = list.stream().filter(e -> e.getId() == id).findFirst().get();
        return book;
    }
    public Book addBook(Book b)
    {
list.add(b);
return b;
    }
    public void deleteBook(int bid)
    {
        list.stream().filter(book->book.getId()!=bid).collect(Collectors.toList());
    }
    public void updateBook(Book book,int bookId)
    {
        list.stream().map(b->{
            if(b.getId()==bookId)
            {
                b.setTitle(book.getTitle());
                b.setAuthor(book.getAuthor());
            }
            return b;
        }).collect(Collectors.toList());
    }
}
