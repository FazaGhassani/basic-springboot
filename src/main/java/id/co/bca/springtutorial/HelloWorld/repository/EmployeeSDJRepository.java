package id.co.bca.springtutorial.HelloWorld.repository;

import id.co.bca.springtutorial.HelloWorld.model.EmployeeModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeSDJRepository extends JpaRepository <EmployeeModel, Integer>{//class, tipe data id nya
    //custom query bisa di taro di sini
    EmployeeModel findEmployeeModelById(Integer integer);
    List<EmployeeModel> findAllByOrderByLastName();
    Page<EmployeeModel> findAllByOrderByEmail(Pageable pageable);
}
