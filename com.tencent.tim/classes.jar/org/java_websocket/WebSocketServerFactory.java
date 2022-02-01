package org.java_websocket;

import java.io.IOException;
import java.nio.channels.ByteChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;
import java.util.List;
import org.java_websocket.drafts.Draft;

public abstract interface WebSocketServerFactory
  extends WebSocketFactory
{
  public abstract void close();
  
  public abstract WebSocketImpl createWebSocket(WebSocketAdapter paramWebSocketAdapter, List<Draft> paramList);
  
  public abstract WebSocketImpl createWebSocket(WebSocketAdapter paramWebSocketAdapter, Draft paramDraft);
  
  public abstract ByteChannel wrapChannel(SocketChannel paramSocketChannel, SelectionKey paramSelectionKey)
    throws IOException;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     org.java_websocket.WebSocketServerFactory
 * JD-Core Version:    0.7.0.1
 */