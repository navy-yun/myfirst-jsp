package com.kitri.jspbasic.book;

import java.util.*;

public class BookDao {
    static HashMap<Long, Book> books = new HashMap<>();
    static private Long generatedKey = 0L;

    static private BookDao bookDao = new BookDao();

    private BookDao() {

    }

    static BookDao getInstance() {
        return bookDao;
    }

    Long generateKey() {
        int count = 0;
        Long max = books.values().stream().map((book -> {
            return book.getId();
        })).max((o1, o2) -> Math.toIntExact(o1 - o2)).get();
        return ++max;
    }

    Book getById(Long id) {
        return books.values().stream().filter(book -> book.getId() == id).findFirst().orElse(new Book());
    }
    List<Book> getAll() {
        return (List<Book>)(List<?>)Arrays.asList(books.values().stream().toArray());
    }
    void add(Book book) {
        book.setId(++generatedKey);
        books.put(book.getId(), book);
    }

    void update(Long id, Book book) {
        Book _book = getById(id);
        _book.setName(book.getName());
        _book.setAuthor(book.getAuthor());
        _book.setPublishedDate(book.getPublishedDate());
    }

    void remove(Book book) {
        books.remove(book.getId());
    }
    void removeById(Long id) {
        books.remove(id);
    }
}
