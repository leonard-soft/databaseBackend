package university.jala.databaseApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import university.jala.databaseApp.entities.User;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "Select userId, name, lastName, age, username from User", nativeQuery = true)
    public List<Object[]> getAll();

}
