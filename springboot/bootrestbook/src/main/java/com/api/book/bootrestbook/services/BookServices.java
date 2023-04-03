package com.api.book.bootrestbook.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.api.book.bootrestbook.dao.BookRepository;
import com.api.book.bootrestbook.entites.Book;

@Component
public class BookServices {
    @Autowired
    private BookRepository bookRepository;
    // private static List<Book> list = new ArrayList<>();
    // static {
    // list.add(new Book(12, "java book", "xyz"));
    // list.add(new Book(36, "java book", "xyz"));
    // list.add(new Book(48, "java book", "xyz"));

    // }

    public List<Book> getAllBooks() {
        List<Book> list = (List<Book>) this.bookRepository.findAll();
        return list;
    }

    public Book getBookById(int id) {
        Book book = null;
        try {

            // book = list.stream().filter(e -> e.getId() == id).findFirst().get();
            book = this.bookRepository.findById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return book;
    }

    public Book addBook(Book b) {
        // list.add(b);
        Book result = bookRepository.save(b);
        return result;
    }

    public void deleteBook(int bid) {
        // list.stream().filter(book -> book.getId() !=
        // bid).collect(Collectors.toList());
        bookRepository.deleteById(bid);
    }

    public void updateBook(Book book, int bookId) {
        // list.stream().map(b -> {
        // if (b.getId() == bookId) {
        // b.setTitle(book.getTitle());
        // b.setAuthor(book.getAuthor());
        // }
        // return b;
        // }).collect(Collectors.toList());
        book.setId(bookId);
        bookRepository.save(book);
    }

}
