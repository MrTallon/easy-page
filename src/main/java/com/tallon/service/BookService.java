package com.tallon.service;

import com.tallon.bean.Book;
import com.tallon.dao.BookRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * serivice层
 *
 * @author tallon
 * @version v1.0.0
 * @date 2020-05-20 23:31
 */
@Service
public class BookService {

    @Resource
    private BookRepository repository;

    public void save(Book book) {
        repository.save(book);
    }

    public void save(List<Book> books) {
        repository.saveAll(books);
    }

    public Book findById(Integer id) {
        return repository.getOne(id);
    }

    public List<Book> list() {
        return repository.findAll();
    }
    public List<Book> sortList() {
        return repository.sortList();
    }
}
