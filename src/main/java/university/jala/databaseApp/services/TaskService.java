package university.jala.databaseApp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import university.jala.databaseApp.Dto.TaskDto;
import university.jala.databaseApp.entities.TaskEntity;
import university.jala.databaseApp.repositories.TaskRepository;

import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    TaskRepository taskRepository;

    public TaskDto convertToDto(TaskEntity task) {
        return new TaskDto(task.getTaskId(), task.getTitle(), task.getDescription(), task.getStartDate(), task.getEndDate(), task.getStatusId(), task.getPriorityId(), task.getUserId());
    }

    public TaskDto save (TaskDto task) {
        TaskEntity taskEntity = new TaskEntity();
        taskEntity.setTaskId(task.getTaskId());
        taskEntity.setTitle(task.getTitle());
        taskEntity.setDescription(task.getDescription());
        taskEntity.setStartDate(task.getStartDate());
        taskEntity.setEndDate(task.getEndDate());
        taskEntity.setStatusId(task.getStatusId());
        taskEntity.setPriorityId(task.getPriorityId());
        taskEntity.setUserId(task.getUserId());
        return convertToDto(taskRepository.save(taskEntity));
    }

    public TaskDto update(TaskDto task, int id) {
        Optional<TaskEntity> taskEntity = taskRepository.findById((long) id);
        if (taskEntity.isPresent()) {
            TaskEntity taskEntityToUpdate = taskEntity.get();
            taskEntityToUpdate.setTitle(task.getTitle());
            taskEntityToUpdate.setDescription(task.getDescription());
            taskEntityToUpdate.setStartDate(task.getStartDate());
            taskEntityToUpdate.setEndDate(task.getEndDate());
            taskEntityToUpdate.setStatusId(task.getStatusId());
            taskEntityToUpdate.setPriorityId(task.getPriorityId());
            taskEntityToUpdate.setUserId(task.getUserId());
            return convertToDto(taskRepository.save(taskEntityToUpdate));
        }
        return null;
    }

    public void delete(int id) {
        taskRepository.deleteById((long) id);
    }

}
