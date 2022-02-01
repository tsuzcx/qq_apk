package org.java_websocket;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.TimerTask;

class AbstractWebSocket$1
  extends TimerTask
{
  private ArrayList<WebSocket> connections = new ArrayList();
  
  AbstractWebSocket$1(AbstractWebSocket paramAbstractWebSocket) {}
  
  public void run()
  {
    this.connections.clear();
    try
    {
      this.connections.addAll(this.this$0.getConnections());
      long l1 = System.currentTimeMillis();
      long l2 = AbstractWebSocket.access$000(this.this$0) * 1500;
      Iterator localIterator = this.connections.iterator();
      while (localIterator.hasNext())
      {
        WebSocket localWebSocket = (WebSocket)localIterator.next();
        AbstractWebSocket.access$100(this.this$0, localWebSocket, l1 - l2);
      }
      return;
    }
    catch (Exception localException)
    {
      this.connections.clear();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     org.java_websocket.AbstractWebSocket.1
 * JD-Core Version:    0.7.0.1
 */