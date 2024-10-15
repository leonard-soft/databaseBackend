package university.jala.databaseApp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import university.jala.databaseApp.Dto.TaskDto;
import university.jala.databaseApp.entities.Task;
import university.jala.databaseApp.repositories.TaskViewRepository;
import university.jala.databaseApp.services.TaskService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class TaskController {

    @Autowired
    private TaskViewRepository taskViewRepository;

    @Autowired
    private TaskService taskService;

    @GetMapping("/task/findAll")
    public List<Task> getAllTasks() {
        return taskViewRepository.findAll();
    }

    @GetMapping("/task/findByUserId/{id}")
    public List<Task> getTaskByUserId(@PathVariable int id) {
        return taskViewRepository.findByUserId(id);
    }

    @GetMapping("/task/findById/{id}")
    public Task findTaskById(@PathVariable int id) {
        return taskViewRepository.findById(id);
    }

    @PostMapping("/task/save")
    public TaskDto createTask(@RequestBody TaskDto taskDto) {
        return taskService.save(taskDto);
    }

    @PutMapping("/task/update/{id}")
    public TaskDto updateTask(@PathVariable int id, @RequestBody TaskDto taskDto) {
        return taskService.update(taskDto, id);
    }

    @DeleteMapping("/task/delete/{id}")
    public ResponseEntity<?> deleteTask(@PathVariable int id) {
        taskService.delete(id);
        Map<String, String> response = new HashMap<>();
        response.put("status", "OK");
        return ResponseEntity.ok(response);
    }

}
