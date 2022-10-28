package id.co.bca.springtutorial.HelloWorld.controller;

import id.co.bca.springtutorial.HelloWorld.model.Book;
import id.co.bca.springtutorial.HelloWorld.model.EmployeeModel;
import id.co.bca.springtutorial.HelloWorld.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

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

    @GetMapping("/getAll")
    public @ResponseBody List<EmployeeModel> findall(){
        return null;
    }
}
