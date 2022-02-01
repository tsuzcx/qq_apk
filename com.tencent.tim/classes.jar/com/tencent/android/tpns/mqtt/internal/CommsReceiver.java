package com.tencent.android.tpns.mqtt.internal;

import com.tencent.android.tpns.mqtt.IMqttAsyncClient;
import com.tencent.android.tpns.mqtt.MqttException;
import com.tencent.android.tpns.mqtt.MqttToken;
import com.tencent.android.tpns.mqtt.internal.wire.MqttAck;
import com.tencent.android.tpns.mqtt.internal.wire.MqttInputStream;
import com.tencent.android.tpns.mqtt.internal.wire.MqttPubAck;
import com.tencent.android.tpns.mqtt.internal.wire.MqttPubComp;
import com.tencent.android.tpns.mqtt.internal.wire.MqttPubRec;
import com.tencent.android.tpns.mqtt.internal.wire.MqttWireMessage;
import com.tencent.android.tpns.mqtt.logging.Logger;
import com.tencent.android.tpns.mqtt.logging.LoggerFactory;
import com.tencent.tpns.baseapi.base.logger.TBaseLogger;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.Semaphore;

public class CommsReceiver
  implements Runnable
{
  private static final String CLASS_NAME = "CommsReceiver";
  private static final Logger log = LoggerFactory.getLogger("com.tencent.android.tpns.mqtt.internal.nls.logcat", "CommsReceiver");
  private ClientComms clientComms = null;
  private ClientState clientState = null;
  private MqttInputStream in;
  private Object lifecycle = new Object();
  private Thread recThread = null;
  private Future receiverFuture;
  private volatile boolean receiving;
  private boolean running = false;
  private final Semaphore runningSemaphore = new Semaphore(1);
  private String threadName;
  private CommsTokenStore tokenStore = null;
  
  public CommsReceiver(ClientComms paramClientComms, ClientState paramClientState, CommsTokenStore paramCommsTokenStore, InputStream paramInputStream)
  {
    this.in = new MqttInputStream(paramClientState, paramInputStream);
    this.clientComms = paramClientComms;
    this.clientState = paramClientState;
    this.tokenStore = paramCommsTokenStore;
    log.setResourceName(paramClientComms.getClient().getClientId());
    TBaseLogger.d("CommsReceiver", "init CommsReceiver");
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
    TBaseLogger.d("CommsReceiver", "Run loop to receive messages from the server, threadName:" + this.threadName);
    this.recThread = Thread.currentThread();
    this.recThread.setName(this.threadName);
    MqttToken localMqttToken = null;
    for (;;)
    {
      try
      {
        this.runningSemaphore.acquire();
        if ((!this.running) || (this.in == null)) {
          break label473;
        }
        localObject3 = localMqttToken;
        localObject5 = localMqttToken;
      }
      catch (InterruptedException localInterruptedException)
      {
        try
        {
          log.fine("CommsReceiver", "run", "852");
          localObject3 = localMqttToken;
          localObject5 = localMqttToken;
          if (this.in.available() > 0)
          {
            bool = true;
            localObject3 = localMqttToken;
            localObject5 = localMqttToken;
            this.receiving = bool;
            localObject3 = localMqttToken;
            localObject5 = localMqttToken;
            localMqttWireMessage1 = this.in.readMqttWireMessage();
            localObject3 = localMqttToken;
            localObject5 = localMqttToken;
            this.receiving = false;
            if (localMqttWireMessage1 != null)
            {
              localObject3 = localMqttToken;
              localObject5 = localMqttToken;
              TBaseLogger.i("CommsReceiver", localMqttWireMessage1.toString());
            }
            localObject3 = localMqttToken;
            localObject5 = localMqttToken;
            if (!(localMqttWireMessage1 instanceof MqttAck)) {
              break label436;
            }
            localObject3 = localMqttToken;
            localObject5 = localMqttToken;
            localMqttToken = this.tokenStore.getToken(localMqttWireMessage1);
            if (localMqttToken == null) {
              break;
            }
            localObject3 = localMqttToken;
            localObject5 = localMqttToken;
          }
        }
        catch (MqttException localMqttException)
        {
          Object localObject5;
          boolean bool;
          MqttWireMessage localMqttWireMessage1;
          localObject1 = localObject3;
          TBaseLogger.e("CommsReceiver", "run", localMqttException);
          this.running = false;
          this.clientComms.shutdownConnection(localObject1, localMqttException);
          this.receiving = false;
          this.runningSemaphore.release();
          continue;
          Object localObject3 = localObject1;
          localObject6 = localObject1;
          if ((localMqttWireMessage2 instanceof MqttPubRec)) {
            break label332;
          }
          localObject3 = localObject1;
          localObject6 = localObject1;
          if ((localMqttWireMessage2 instanceof MqttPubComp)) {
            break label332;
          }
          localObject3 = localObject1;
          localObject6 = localObject1;
          if (!(localMqttWireMessage2 instanceof MqttPubAck)) {
            break label354;
          }
          localObject3 = localObject1;
          localObject6 = localObject1;
          log.fine("CommsReceiver", "run", "857");
          continue;
          localObject3 = localObject1;
          localObject6 = localObject1;
          throw new MqttException(6);
        }
        catch (IOException localIOException)
        {
          Object localObject1 = localObject6;
          log.fine("CommsReceiver", "run", "853");
          this.running = false;
          if (this.clientComms.isDisconnecting()) {
            break label421;
          }
          this.clientComms.shutdownConnection(localObject1, new MqttException(32109, localIOException));
          this.receiving = false;
          this.runningSemaphore.release();
          continue;
          if (localMqttWireMessage2 == null) {
            break label455;
          }
          Object localObject4 = localObject1;
          Object localObject6 = localObject1;
          this.clientState.notifyReceivedMsg(localMqttWireMessage2);
          continue;
        }
        finally
        {
          this.receiving = false;
          this.runningSemaphore.release();
        }
        try
        {
          this.clientState.notifyReceivedAck((MqttAck)localMqttWireMessage1);
          this.receiving = false;
          this.runningSemaphore.release();
          continue;
        }
        finally
        {
          localObject3 = localInterruptedException;
          localObject5 = localInterruptedException;
        }
        localInterruptedException = localInterruptedException;
        this.running = false;
        return;
      }
      bool = false;
    }
    label332:
    label354:
    log.fine("CommsReceiver", "run", "854");
    label421:
    label436:
    label455:
    label473:
    return;
  }
  
  public void start(String arg1, ExecutorService paramExecutorService)
  {
    this.threadName = ???;
    log.fine("CommsReceiver", "start", "855");
    synchronized (this.lifecycle)
    {
      if (!this.running)
      {
        this.running = true;
        this.receiverFuture = paramExecutorService.submit(this);
      }
      return;
    }
  }
  
  /* Error */
  public void stop()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 53	com/tencent/android/tpns/mqtt/internal/CommsReceiver:lifecycle	Ljava/lang/Object;
    //   4: astore_2
    //   5: aload_2
    //   6: monitorenter
    //   7: aload_0
    //   8: getfield 221	com/tencent/android/tpns/mqtt/internal/CommsReceiver:receiverFuture	Ljava/util/concurrent/Future;
    //   11: ifnull +14 -> 25
    //   14: aload_0
    //   15: getfield 221	com/tencent/android/tpns/mqtt/internal/CommsReceiver:receiverFuture	Ljava/util/concurrent/Future;
    //   18: iconst_1
    //   19: invokeinterface 228 2 0
    //   24: pop
    //   25: getstatic 44	com/tencent/android/tpns/mqtt/internal/CommsReceiver:log	Lcom/tencent/android/tpns/mqtt/logging/Logger;
    //   28: ldc 10
    //   30: ldc 229
    //   32: ldc 231
    //   34: invokeinterface 146 4 0
    //   39: aload_0
    //   40: getfield 51	com/tencent/android/tpns/mqtt/internal/CommsReceiver:running	Z
    //   43: ifeq +42 -> 85
    //   46: aload_0
    //   47: iconst_0
    //   48: putfield 51	com/tencent/android/tpns/mqtt/internal/CommsReceiver:running	Z
    //   51: aload_0
    //   52: iconst_0
    //   53: putfield 105	com/tencent/android/tpns/mqtt/internal/CommsReceiver:receiving	Z
    //   56: invokestatic 133	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   59: aload_0
    //   60: getfield 61	com/tencent/android/tpns/mqtt/internal/CommsReceiver:recThread	Ljava/lang/Thread;
    //   63: invokevirtual 235	java/lang/Object:equals	(Ljava/lang/Object;)Z
    //   66: istore_1
    //   67: iload_1
    //   68: ifne +17 -> 85
    //   71: aload_0
    //   72: getfield 68	com/tencent/android/tpns/mqtt/internal/CommsReceiver:runningSemaphore	Ljava/util/concurrent/Semaphore;
    //   75: invokevirtual 139	java/util/concurrent/Semaphore:acquire	()V
    //   78: aload_0
    //   79: getfield 68	com/tencent/android/tpns/mqtt/internal/CommsReceiver:runningSemaphore	Ljava/util/concurrent/Semaphore;
    //   82: invokevirtual 177	java/util/concurrent/Semaphore:release	()V
    //   85: aload_2
    //   86: monitorexit
    //   87: aload_0
    //   88: aconst_null
    //   89: putfield 61	com/tencent/android/tpns/mqtt/internal/CommsReceiver:recThread	Ljava/lang/Thread;
    //   92: getstatic 44	com/tencent/android/tpns/mqtt/internal/CommsReceiver:log	Lcom/tencent/android/tpns/mqtt/logging/Logger;
    //   95: ldc 10
    //   97: ldc 229
    //   99: ldc 237
    //   101: invokeinterface 146 4 0
    //   106: return
    //   107: astore_3
    //   108: aload_0
    //   109: getfield 68	com/tencent/android/tpns/mqtt/internal/CommsReceiver:runningSemaphore	Ljava/util/concurrent/Semaphore;
    //   112: invokevirtual 177	java/util/concurrent/Semaphore:release	()V
    //   115: goto -30 -> 85
    //   118: astore_3
    //   119: aload_2
    //   120: monitorexit
    //   121: aload_3
    //   122: athrow
    //   123: astore_3
    //   124: aload_0
    //   125: getfield 68	com/tencent/android/tpns/mqtt/internal/CommsReceiver:runningSemaphore	Ljava/util/concurrent/Semaphore;
    //   128: invokevirtual 177	java/util/concurrent/Semaphore:release	()V
    //   131: aload_3
    //   132: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	133	0	this	CommsReceiver
    //   66	2	1	bool	boolean
    //   4	116	2	localObject1	Object
    //   107	1	3	localInterruptedException	InterruptedException
    //   118	4	3	localObject2	Object
    //   123	9	3	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   71	78	107	java/lang/InterruptedException
    //   7	25	118	finally
    //   25	67	118	finally
    //   78	85	118	finally
    //   85	87	118	finally
    //   108	115	118	finally
    //   119	121	118	finally
    //   124	133	118	finally
    //   71	78	123	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpns.mqtt.internal.CommsReceiver
 * JD-Core Version:    0.7.0.1
 */