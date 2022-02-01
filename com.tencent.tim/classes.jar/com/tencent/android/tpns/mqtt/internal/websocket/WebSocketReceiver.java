package com.tencent.android.tpns.mqtt.internal.websocket;

import com.tencent.android.tpns.mqtt.logging.Logger;
import com.tencent.android.tpns.mqtt.logging.LoggerFactory;
import java.io.IOException;
import java.io.InputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class WebSocketReceiver
  implements Runnable
{
  private static final String CLASS_NAME = "WebSocketReceiver";
  private static final Logger log = LoggerFactory.getLogger("com.tencent.android.tpns.mqtt.internal.nls.logcat", "WebSocketReceiver");
  private InputStream input;
  private Object lifecycle = new Object();
  private PipedOutputStream pipedOutputStream;
  private Thread receiverThread = null;
  private volatile boolean receiving;
  private boolean running = false;
  private boolean stopping = false;
  
  public WebSocketReceiver(InputStream paramInputStream, PipedInputStream paramPipedInputStream)
    throws IOException
  {
    this.input = paramInputStream;
    this.pipedOutputStream = new PipedOutputStream();
    paramPipedInputStream.connect(this.pipedOutputStream);
  }
  
  private void closeOutputStream()
  {
    try
    {
      this.pipedOutputStream.close();
      return;
    }
    catch (IOException localIOException) {}
  }
  
  public boolean isReceiving()
  {
    return this.receiving;
  }
  
  public boolean isRunning()
  {
    return this.running;
  }
  
  public void run()
  {
    if ((this.running) && (this.input != null)) {}
    label136:
    for (;;)
    {
      boolean bool;
      try
      {
        log.fine("WebSocketReceiver", "run", "852");
        if (this.input.available() <= 0) {
          break label136;
        }
        bool = true;
        this.receiving = bool;
        WebSocketFrame localWebSocketFrame = new WebSocketFrame(this.input);
        if (localWebSocketFrame.isCloseFlag()) {
          break label118;
        }
        int i = 0;
        if (i < localWebSocketFrame.getPayload().length)
        {
          this.pipedOutputStream.write(localWebSocketFrame.getPayload()[i]);
          i += 1;
          continue;
        }
        this.pipedOutputStream.flush();
        this.receiving = false;
      }
      catch (IOException localIOException)
      {
        stop();
      }
      break;
      label118:
      if (!this.stopping)
      {
        throw new IOException("Server sent a WebSocket Frame with the Stop OpCode");
        return;
        bool = false;
      }
    }
  }
  
  public void start(String paramString)
  {
    log.fine("WebSocketReceiver", "start", "855");
    synchronized (this.lifecycle)
    {
      if (!this.running)
      {
        this.running = true;
        this.receiverThread = new Thread(this, paramString);
        this.receiverThread.start();
      }
      return;
    }
  }
  
  public void stop()
  {
    int i = 1;
    this.stopping = true;
    for (;;)
    {
      synchronized (this.lifecycle)
      {
        log.fine("WebSocketReceiver", "stop", "850");
        if (!this.running) {
          break label104;
        }
        this.running = false;
        this.receiving = false;
        closeOutputStream();
        if ((i == 0) || (Thread.currentThread().equals(this.receiverThread))) {}
      }
      try
      {
        this.receiverThread.join();
        label75:
        this.receiverThread = null;
        log.fine("WebSocketReceiver", "stop", "851");
        return;
        localObject2 = finally;
        throw localObject2;
      }
      catch (InterruptedException localInterruptedException)
      {
        break label75;
      }
      label104:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpns.mqtt.internal.websocket.WebSocketReceiver
 * JD-Core Version:    0.7.0.1
 */