package university.jala.databaseApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import university.jala.databaseApp.entities.TaskEntity;

@Repository
public interface TaskRepository extends JpaRepository<TaskEntity, Long> {

    @Query(value = "insert into task(title, description, start_date, end_date, status_id, priority_id, user_id) values(?, ?, ?, ?, ? , ?, ?)", nativeQuery = true)
    public void insert(TaskEntity task);

}
