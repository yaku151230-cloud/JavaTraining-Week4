package com.example.taskapp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

// クラス宣言@Entityアノテーションを追加して、JPAエンティティであることを示す
@Entity
public class Task {

    //フィールド宣言(IDを自動で生成するためのアノテーションを追加)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //タイトル必須＋最大五十文字のバリデーションアノテーションを追加
    @NotBlank(message = "タイトルを入力してください")
    @Size(max = 50, message = "タイトルは50文字以内で入力してください")
    private String title;

    //完了フラグはデフォルトでfalse
    private boolean completed = false;

    // デフォルトコンストラクタ
    public Task() {}

    //GetterとSetterを追加
    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
