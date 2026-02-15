package com.example.taskapp.service;

import com.example.taskapp.entity.Task;
import com.example.taskapp.repository.TaskRepository;
import com.example.taskapp.exception.TaskNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

// タスク管理のサービスクラスを作成
@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    // タスクの一覧取得
    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    // タスクの登録
    public Task create(Task task) {
        return taskRepository.save(task);
    }

    // タスクの更新
    public Task update(Long id, Task updatedTask) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException("Task not found"));


        task.setTitle(updatedTask.getTitle());
        task.setCompleted(updatedTask.isCompleted());

        return taskRepository.save(task);
    }

    // タスクの削除
    public void delete(Long id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException("Task not found"));


        taskRepository.delete(task);
    }

    // タスクの1件取得
    public Task findById(Long id) {
    return taskRepository.findById(id)
            .orElseThrow(() -> new TaskNotFoundException("Task not found"));
}
}
