package id.co.bca.springtutorial.HelloWorld.service;

import id.co.bca.springtutorial.HelloWorld.model.Book;
import id.co.bca.springtutorial.HelloWorld.repository.BookSDJRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    @Autowired
    BookSDJRepository bookSDJRepository;

    public void addBook(Book book){
        bookSDJRepository.save(book);
    }

    //CRUD Lainnya disini

}
