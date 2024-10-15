package university.jala.databaseApp.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import university.jala.databaseApp.entities.Task;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class TaskViewRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Task> findAll() {
        String sql = "select * from taskmanagerdb.vw_task where user_id = ?";
        return jdbcTemplate.query(sql, new TaskRowMapper());
    }

    public List<Task> findByUserId(int id) {
        String sql = "select * from taskmanagerdb.vw_task where user_id = ?";
        return jdbcTemplate.query(sql, new TaskRowMapper(), id);
    }

    public Task findById(int id) {
        String sql = "select * from taskmanagerdb.vw_task where task_id = ?";
        return jdbcTemplate.queryForObject(sql, new TaskRowMapper(), id);
    }

    private static class TaskRowMapper implements RowMapper<Task> {
        @Override
        public Task mapRow(ResultSet rs, int rowNum) throws SQLException {
            Task task = new Task();
            task.setTaskId(rs.getInt("task_id"));
            task.setTitle(rs.getString("title"));
            task.setDescription(rs.getString("description"));
            task.setStartDate(rs.getDate("start_date"));
            task.setEndDate(rs.getDate("end_date"));
            task.setStatus(rs.getString("status"));
            task.setPriority(rs.getString("priority"));
            task.setUserId(rs.getInt("user_id"));
            task.setName(rs.getString("name"));
            task.setLastName(rs.getString("last_name"));
            return task;
        }
    }
}
