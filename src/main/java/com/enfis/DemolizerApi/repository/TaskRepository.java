package com.enfis.DemolizerApi.repository;

import com.enfis.DemolizerApi.domain.Task;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface TaskRepository extends MongoRepository<Task, String> {
    List<Task> findByStatus(Task.Status status);
}