package com.enfis.DemolizerApi.domain;

import jakarta.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;
import java.time.LocalDateTime;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "tasks")  // Indica que esta clase representa un documento en la colección "tasks"
public class Task {

    @Id  // Anotación para indicar el campo id en MongoDB
    private String id;  // MongoDB utiliza String o ObjectId para los identificadores

    @NotNull(message = "Title cannot be null")  // Validación para asegurar que el título no sea nulo
    private String title;

    private String description;

    private LocalDateTime createdAt;

    private LocalDateTime dueDate;

    private Status status;

    // Constructor sin parámetros
    public Task() {
        this.createdAt = LocalDateTime.now();  // Asignar la fecha de creación actual
        this.status = Status.PENDING;  // Por defecto, la tarea está en estado pendiente
    }

    // Constructor con parámetros
    public Task(String title, String description, LocalDateTime dueDate) {
        this.title = title;
        this.description = description;
        this.createdAt = LocalDateTime.now();  // Asignar la fecha de creación actual
        this.dueDate = dueDate;
        this.status = Status.PENDING;  // Por defecto, la tarea está en estado pendiente
    }

    // Getters y setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    // Enumeración para representar los posibles estados de una tarea
    public enum Status {
        PENDING,        // Tarea pendiente
        IN_PROGRESS,    // Tarea en progreso
        COMPLETED,      // Tarea completada
        CANCELLED       // Tarea cancelada
    }
}
