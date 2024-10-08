package university.jala.databaseApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import university.jala.databaseApp.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
