package com.example.taskapp.exception;

//クラス宣言RuntimeExceptionを継承して例外クラスを作成
public class TaskNotFoundException extends RuntimeException {

    //コンストラクタ
    public TaskNotFoundException(String message) {
        super(message);
    }
}
