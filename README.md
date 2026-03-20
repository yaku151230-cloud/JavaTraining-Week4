## JavaTraining-Final

## プロダクト概要  
タスク管理アプリケーションです。  
ユーザーはログイン後、タスクの一覧確認・作成・編集・削除・完了切替が可能です。  
画面とREST APIの両方で操作できます。

## 開発環境  
・JDK: Java 17  
・IDE: Visual Studio Code  
・ビルドツール: Gradle  

## セットアップ手順  
1.事前準備  
以下がインストールされているかを確認してください。  
・Java 17  
・Git  

2.リポジトリのクローン  
リポジトリをクローンした後に、クローンしたフォルダに移動します。  
```git clone https://github.com/yaku151230-cloud/JavaTraining-Week4.git```  
```cd JavaTraining-Week4```  

3.アプリケーションの起動  
gradle  
・コマンドプロンプト  
```gradlew.bat bootRun```  

・PowerShell  
```.\gradlew.bat bootRun```  

Maven  
・コマンドプロンプト  
```mvnw.cmd spring-boot:run```  

・PowerShell  
```.\mvnw spring-boot:run```  

4.ログイン画面    
ブラウザから以下にアクセスしてログイン画面に遷移します。  
```http://localhost:8080/login```  

5.初期ユーザーでログイン
・ユーザー名：```user```   
・パスワード：```password```   

6.ログイン後の操作
ログイン後はタスク一覧画面```/tasks```にて以下を確認できます。
・新規作成
・編集
・完了切替
・削除

## API確認用
タスク一覧取得（GET）   
```curl -u testuser:password http://localhost:8080/api/tasks```   

タスク作成（POST）   
```   
curl -u testuser:password -H "Content-Type: application/json"\   
-d '{"title":"テストタスク"}'\   
-X POST http://localhost:8080/api/tasks   
```

## アーキテクチャ   
```
ブラウザ / curl
      ↓
--------------------------
| Spring Boot Web Layer  |
|------------------------|
| Controller (View/REST) |
--------------------------
      ↓
----------------------
|   Service Layer    |
|   (TaskService)    |
----------------------
      ↓
--------------------------
|   Repository Layer     |
|  (TaskRepository / JPA)|
--------------------------
      ↓
--------------------------
| Database (H2/PostgreSQL)|
--------------------------
```

## パッケージ構成
```
com.example.taskapp   
 ├─ config
 │   └─ SecurityConfig.java
 ├─ controller
 │   ├─ TaskViewController.java
 │   └─ TaskRestController.java
 ├─ entity
 │   └─ Task.java
 ├─ exception
 │   ├─ TaskNotFoundException.java
 │   └─ GlobalExceptionHandler.java
 ├─ repository
 │   └─ TaskRepository.java
 └─ service
     └─ TaskService.java
```

## 既知の制約・今後の改善点
### 制約（現状の制限）
・初期ユーザは固定（testuser / password）で、ユーザ管理機能は未実装   
・Validation はタイトルのみ（@NotBlank, @Size(max=50)）で詳細チェックなし   
・REST API は最小限のみ（完了切替エンドポイントは任意）   

### 改善点（今後の拡張）
・ユーザ管理機能やパスワード変更機能の追加   
・UI デザイン改善（フラッシュメッセージ表示、レスポンシブ対応）   
・REST API 機能拡張（完了切替、検索・フィルタリングなど）   
