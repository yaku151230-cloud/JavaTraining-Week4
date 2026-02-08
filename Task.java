package com.example.hellospring.task;

public class Task {

    //タスクのIDとタイトル
    private Long id;
    private String title;

    //コンストラクタ
    public Task(Long id, String title) {
        this.id = id;
        this.title = title;
    }

    //ゲッター
    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }
}
