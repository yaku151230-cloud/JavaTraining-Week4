package com.example.hellospring.task;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    // GET /api/tasks
    //タスク一覧を取得
    @GetMapping
    public List<Task> getTasks() {
        return taskService.findAll();
    }

    // POST /api/tasks
    //新しいタスクを作成
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Task createTask(@RequestBody Map<String, String> body) {
        String title = body.get("title");

        //タイトルのバリデーション
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("title is required");
        }

        //正しいならタスクを作成して返す
        return taskService.create(title);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleBadRequest(Exception e) {
        return e.getMessage();
    }
}
