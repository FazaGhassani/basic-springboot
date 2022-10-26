package id.co.bca.springtutorial.HelloWorld.repository;

import id.co.bca.springtutorial.HelloWorld.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository  extends JpaRepository<User, Integer> {
    User findByUsername(String username);
}
