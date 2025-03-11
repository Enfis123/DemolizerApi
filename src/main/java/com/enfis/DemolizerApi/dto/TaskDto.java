package com.enfis.DemolizerApi.dto;

import com.enfis.DemolizerApi.domain.Task;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class TaskDto {
    // Getters y Setters
    private String id;
    private String title;
    private String description;
    private LocalDateTime createdAt;
    private LocalDateTime dueDate;
    private Task.Status status;

    public void setId(String id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
    }

    public void setStatus(Task.Status status) {
        this.status = status;
    }
}