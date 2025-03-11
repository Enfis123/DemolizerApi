package com.enfis.DemolizerApi.mapper;

import com.enfis.DemolizerApi.domain.Task;
import com.enfis.DemolizerApi.dto.TaskDto;
import org.springframework.stereotype.Component;

@Component
public class TaskMapper {

    public TaskDto toDTO(Task task) {
        TaskDto dto = new TaskDto();
        dto.setId(task.getId());
        dto.setTitle(task.getTitle());
        dto.setDescription(task.getDescription());
        dto.setCreatedAt(task.getCreatedAt());
        dto.setDueDate(task.getDueDate());
        dto.setStatus(task.getStatus());
        return dto;
    }

    public Task toEntity(TaskDto dto) {
        Task task = new Task();
        task.setId(dto.getId());
        task.setTitle(dto.getTitle());
        task.setDescription(dto.getDescription());
        task.setDueDate(dto.getDueDate());
        task.setStatus(dto.getStatus());
        return task;
    }
}