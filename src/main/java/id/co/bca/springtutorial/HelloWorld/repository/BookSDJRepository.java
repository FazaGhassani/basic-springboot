package id.co.bca.springtutorial.HelloWorld.repository;

import id.co.bca.springtutorial.HelloWorld.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookSDJRepository extends JpaRepository<Book, Integer> {

}
