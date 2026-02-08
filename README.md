## プロジェクト概要  
Spring Bootを用いて、簡単なREST API（/hello, /api/tasks）を提供するサンプルアプリケーションです。

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
以下のコマンドをコマンドプロンプトかpowershellで入力してください。  
```git clone https://github.com/yaku151230-cloud/JavaTraining-Week4.git```  
```cd JavaTraining-Week4```  

3.アプリケーションの起動  
gradle  
・コマンドプロンプト  
```gradlew.bat bootRun```  

・PowerShell  
```.\gradle.bat bootRun```  

Maven  
・コマンドプロンプト  
```mvnw.cmd spring-boot:run```  

・PowerShell  
```.\mvnw spring-boot:run```  

4.起動確認  
以下のようなログが表示されれば起動成功です。  
```Started HelloSpringApplication in xxx seconds```  

5.動作確認    
①```curl http://localhost:8080/hello```  
②```curl http://localhost:8080/api/tasks```  
※ curl が使用できない場合は、ブラウザで ①http://localhost:8080/hello もしくは ②http://localhost:8080/api/tasks にアクセスしても確認できます。

## エラーが出た場合の対処
・gradlew 実行時にコマンドが見つからないエラーが出たが、プロジェクト直下に移動して再実行することで解決した。  
・起動時に Java のバージョンエラーが発生したが、Java25 から Java17 に変更することで解決した。  
