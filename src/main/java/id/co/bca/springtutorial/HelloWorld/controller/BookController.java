package id.co.bca.springtutorial.HelloWorld.controller;

import id.co.bca.springtutorial.HelloWorld.model.Book;
import id.co.bca.springtutorial.HelloWorld.model.EmployeeModel;
import id.co.bca.springtutorial.HelloWorld.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

@Controller
@RequestMapping("book")
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping("/add")
    public String addBook(@RequestParam("title") String title){
        Book book = new Book();
        book.setTitle(title);
        book.setBorrowDate(null);
        bookService.addBook(book);
        return null;
    };
}
