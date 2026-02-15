## プロジェクト概要  
Spring Boot を使用して、タスクを登録・取得できる簡単な REST API を作成しました。  
入力値のバリデーションおよび例外ハンドリング（400 / 404）を実装しています。

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
1. 本リポジトリをクローンします。   
2. プロジェクトのルートディレクトリ（build.gradleがあるディレクトリ）で以下を実行します。   

3.アプリケーションの起動  
gradle  
・コマンドプロンプト  
```gradlew.bat bootRun```  

・PowerShell  
```.\gradle.bat bootRun```  

4.起動確認  
以下のようなログが表示されれば起動成功です。  
```Started HelloSpringApplication in xxx seconds```  

## 実行・確認手順(以下は PowerShell での実行例です。)
・タスク一覧取得   
```Invoke-RestMethod http://localhost:8080/api/tasks```   

・タスク登録   
```powershell
Invoke-RestMethod `
  -Uri http://localhost:8080/api/tasks `
  -Method POST `
  -ContentType "application/json" `
  -Body '{"title":"テストタスク"}'
```   

## 例外ハンドリングの動作例   
・バリデーションエラー   
```powershell
Invoke-RestMethod `   
  -Uri http://localhost:8080/api/tasks `   
  -Method POST `   
  -ContentType "application/json" `   
  -Body '{"title":""}'
```   

・存在しないリソースへのアクセス   
```Invoke-RestMethod http://localhost:8080/api/tasks/999```   
