package com.example.hellospring.task;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TaskService {

    //タスクのリストとID管理
    private final List<Task> tasks = new ArrayList<>();
    private long nextId = 1;

    public List<Task> findAll() {
        return tasks;
    }

    //新しいタスクをリストに追加
    public Task create(String title) {
        Task task = new Task(nextId++, title);
        tasks.add(task);
        return task;
    }
}
