# websocket

websocketを実装するサンプル

* サーバ側
    - CountUpServletのcount変数を1sごとにインクリメントします。

* クライアント側
    - /countUpにwebsocketで接続すると、更新があったタイミングで結果が戻ります。

# 起動方法

* mvn tomcat7:run
