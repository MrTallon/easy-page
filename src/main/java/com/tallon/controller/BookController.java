package com.tallon.controller;

import com.tallon.bean.Book;
import com.tallon.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * controller层
 *
 * @author tallon
 * @version v1.0.0
 * @date 2020-05-20 23:36
 */
@Controller
public class BookController {

    @Resource
    private BookService service;

    @ResponseBody
    @GetMapping("/add")
    public void add() {
        Book b1 = new Book(1, "红楼梦", "曹雪芹", 1, LocalDateTime.now());
        Book b2 = new Book(2, "水浒传", "施耐庵", 1, LocalDateTime.now());
        Book b3 = new Book(3, "三国演义", "罗贯中", 1, LocalDateTime.now());
        Book b4 = new Book(4, "西游记", "吴承恩", 1, LocalDateTime.now());
        List<Book> books = new ArrayList<>();
        books.add(b1);
        books.add(b2);
        books.add(b3);
        books.add(b4);
        service.save(books);
    }

    @ResponseBody
    @GetMapping("/{id}")
    public Book findByBook(@PathVariable Integer id) {
        return service.findById(id);
    }

    @ResponseBody
    @GetMapping("/list")
    public List<Book> list() {
        return service.list();
    }


    @GetMapping("/index")
    public String index(Model model) {
        List<Book> list = service.sortList();
        model.addAttribute("list", list);
        return "index";
    }
}
