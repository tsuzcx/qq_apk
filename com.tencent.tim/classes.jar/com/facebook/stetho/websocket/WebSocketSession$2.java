package com.facebook.stetho.websocket;

import java.io.IOException;

class WebSocketSession$2
  implements WriteCallback
{
  WebSocketSession$2(WebSocketSession paramWebSocketSession) {}
  
  public void onFailure(IOException paramIOException)
  {
    WebSocketSession.access$000(this.this$0, paramIOException);
  }
  
  public void onSuccess() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.facebook.stetho.websocket.WebSocketSession.2
 * JD-Core Version:    0.7.0.1
 */