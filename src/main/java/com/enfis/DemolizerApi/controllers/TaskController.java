package com.enfis.DemolizerApi.controllers;

import com.enfis.DemolizerApi.domain.Task;
import com.enfis.DemolizerApi.dto.TaskDto;
import com.enfis.DemolizerApi.repository.TaskRepository;
import com.enfis.DemolizerApi.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {
    private final TaskRepository taskRepository;
    public TaskController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }
    @Autowired
    private TaskService taskService;

    @GetMapping
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable String id) {
        return taskService.getTaskById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Task createTask(@RequestBody Task task) {
        return taskService.createTask(task);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable String id, @RequestBody TaskDto taskDTO) {
        return ResponseEntity.ok(taskService.updateTask(id, taskDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable String id) {
        taskService.deleteTask(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/status/{status}")
    public List<Task> getTasksByStatus(@PathVariable Task.Status status) {
        return taskService.getTasksByStatus(status);
    }
    // Endpoint para insertar múltiples tareas
    @PostMapping("/batch")
    public List<Task> createTasks(@RequestBody List<Task> tasks) {
        for (Task task : tasks) {
            task.setCreatedAt(LocalDateTime.now());
            if (task.getStatus() == null) {
                task.setStatus(Task.Status.valueOf("PENDING")); // Valor por defecto si no se envía en la petición
            }
        }
        return taskRepository.saveAll(tasks);
    }
}