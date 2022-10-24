package id.co.bca.springtutorial.HelloWorld.repository;

import id.co.bca.springtutorial.HelloWorld.model.Departement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartementSDJRepository extends JpaRepository<Departement, Integer> {
    Departement findDepartementById(Integer aInteger);
}
