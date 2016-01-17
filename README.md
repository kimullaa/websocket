# websocket

websocketを実装するサンプル

* サーバ側
    - CountUpServletのcount変数を5sごとにインクリメントします。

* クライアント側
    - /countUpにwebsocketで接続すると、更新があったタイミングで結果が戻ります。

# ポイント
* サーバ・クライアントともに、WebSocket用のAPIを利用した

# 起動方法

* websocketの実装があるtomcat8あたりにデプロイする
