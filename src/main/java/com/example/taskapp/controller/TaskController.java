package com.example.taskapp.controller;

import com.example.taskapp.entity.Task;
import com.example.taskapp.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// RESTコントローラーを作成
@RestController
@RequestMapping("/api/tasks")

// タスク管理のAPIエンドポイントを定義
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    // タスク一覧取得
    @GetMapping
    public ResponseEntity<List<Task>> getTasks() {
        return ResponseEntity.ok(taskService.findAll());
    }

    // タスク1件取得
    @GetMapping("/{id}")
    public ResponseEntity<Task> getTask(@PathVariable Long id) {
        return ResponseEntity.ok(taskService.findById(id));
    }

    // タスクの登録
    @PostMapping
    public ResponseEntity<Task> createTask(
            @RequestBody @Valid Task task
    ) {
        Task created = taskService.create(task);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(created);
    }

    // タスクの更新
    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(
            @PathVariable Long id,
            @RequestBody @Valid Task task
    ) {
        return ResponseEntity.ok(taskService.update(id, task));
    }

    // タスクの削除
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        taskService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
