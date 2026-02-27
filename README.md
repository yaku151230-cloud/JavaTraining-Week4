## プロジェクト概要     
本課題では、これまでに作成した Task 永続化アプリをベースに、   
Spring Boot + Thymeleaf を用いた Web 画面を実装することを目的としています。   

タスクの 一覧表示・新規作成・編集・削除 を Web 画面から行えるようにし、   
バリデーションエラーや不正な URL アクセス時の例外処理も含めて実装しています。   

## 起動手順
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
本リポジトリをクローンします。      

3.アプリケーションの起動    
プロジェクトのルートディレクトリ（build.gradleがあるディレクトリ）で以下を実行します。   
gradle  
・コマンドプロンプト  
```powershell
gradlew.bat bootRun
```  

・PowerShell  
```powershell
.\gradlew.bat bootRun
```  

4.起動確認  
以下のようなログが表示されれば起動成功です。  
```Started HelloSpringApplication in xxx seconds```  

5.実行
起動後、ブラウザで以下にアクセスしてください。   
http://localhost:8080/tasks   


## 画面遷移   
画面	　　　URL	　　　　　　　　　　　　内容
一覧画面	　　/tasks	　　　　　　　　　 タスク一覧表示（編集・削除可能）   
新規作成	　　/tasks/new	　　　　　　　タスク新規作成フォーム   
編集	　　　/tasks/{id}/edit	　　　　　タスク編集フォーム   
登録	　　　POST /tasks	　　　　　　　 新規登録処理   
更新	　　　POST /tasks/{id}　　　　	　編集内容の更新   
削除	　　　POST /tasks/{id}/delete	　タスク削除   

