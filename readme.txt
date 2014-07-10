TwitterにアクセスしてハッシュタグのTop10を表示する Scalaプログラム 
-------------------------------------------------------------------


1) git cloneして、ディレクトリに移動
$ git clone git@github.com:TomoyaIgarashi/spark_streaming_test1.git
$ cd spark_streaming_test1

2) twitter.txtを作成し、以下の文字列をコピペの上、YourTwitter...部分を書き換える
$ touch twitter.txt
$ vi twitter.txt

consumerKey=YourTwitterConsumerKey
consumerSecret=YourTwitterConsumerSecret
accessToken=YourTwitterAccessToken
accessTokenSecret=YourTwitterAccessTokenSecret

3) sbt clean;sbt compile でコンパイル
  
4) sbt run にて実行

