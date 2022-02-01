package com.tencent.android.tpns.mqtt.internal;

import com.tencent.android.tpns.mqtt.IMqttAsyncClient;
import com.tencent.android.tpns.mqtt.MqttException;
import com.tencent.android.tpns.mqtt.internal.wire.MqttOutputStream;
import com.tencent.android.tpns.mqtt.internal.wire.MqttWireMessage;
import com.tencent.android.tpns.mqtt.logging.Logger;
import com.tencent.android.tpns.mqtt.logging.LoggerFactory;
import com.tencent.tpns.baseapi.base.logger.TBaseLogger;
import java.io.OutputStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.Semaphore;

public class CommsSender
  implements Runnable
{
  private static final String CLASS_NAME = "CommsSender";
  private static final Logger log = LoggerFactory.getLogger("com.tencent.android.tpns.mqtt.internal.nls.logcat", "CommsSender");
  private ClientComms clientComms = null;
  private ClientState clientState = null;
  private Object lifecycle = new Object();
  private MqttOutputStream out;
  private boolean running = false;
  private final Semaphore runningSemaphore = new Semaphore(1);
  private Thread sendThread = null;
  private Future senderFuture;
  private String threadName;
  private CommsTokenStore tokenStore = null;
  
  public CommsSender(ClientComms paramClientComms, ClientState paramClientState, CommsTokenStore paramCommsTokenStore, OutputStream paramOutputStream)
  {
    this.out = new MqttOutputStream(paramClientState, paramOutputStream);
    this.clientComms = paramClientComms;
    this.clientState = paramClientState;
    this.tokenStore = paramCommsTokenStore;
    log.setResourceName(paramClientComms.getClient().getClientId());
    TBaseLogger.d("CommsSender", "init CommsSender");
  }
  
  private void handleRunException(MqttWireMessage paramMqttWireMessage, Exception paramException)
  {
    log.fine("CommsSender", "handleRunException", "804", null, paramException);
    if (!(paramException instanceof MqttException)) {}
    for (paramMqttWireMessage = new MqttException(32109, paramException);; paramMqttWireMessage = (MqttException)paramException)
    {
      this.running = false;
      this.clientComms.shutdownConnection(null, paramMqttWireMessage);
      return;
    }
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: ldc 10
    //   2: new 127	java/lang/StringBuilder
    //   5: dup
    //   6: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   9: ldc 130
    //   11: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14: aload_0
    //   15: getfield 136	com/tencent/android/tpns/mqtt/internal/CommsSender:threadName	Ljava/lang/String;
    //   18: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: invokevirtual 139	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   24: invokestatic 100	com/tencent/tpns/baseapi/base/logger/TBaseLogger:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   27: aload_0
    //   28: invokestatic 145	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   31: putfield 60	com/tencent/android/tpns/mqtt/internal/CommsSender:sendThread	Ljava/lang/Thread;
    //   34: aload_0
    //   35: getfield 60	com/tencent/android/tpns/mqtt/internal/CommsSender:sendThread	Ljava/lang/Thread;
    //   38: aload_0
    //   39: getfield 136	com/tencent/android/tpns/mqtt/internal/CommsSender:threadName	Ljava/lang/String;
    //   42: invokevirtual 148	java/lang/Thread:setName	(Ljava/lang/String;)V
    //   45: aconst_null
    //   46: astore_1
    //   47: aload_0
    //   48: getfield 67	com/tencent/android/tpns/mqtt/internal/CommsSender:runningSemaphore	Ljava/util/concurrent/Semaphore;
    //   51: invokevirtual 151	java/util/concurrent/Semaphore:acquire	()V
    //   54: aload_0
    //   55: getfield 50	com/tencent/android/tpns/mqtt/internal/CommsSender:running	Z
    //   58: ifeq +253 -> 311
    //   61: aload_0
    //   62: getfield 74	com/tencent/android/tpns/mqtt/internal/CommsSender:out	Lcom/tencent/android/tpns/mqtt/internal/wire/MqttOutputStream;
    //   65: astore_2
    //   66: aload_2
    //   67: ifnull +244 -> 311
    //   70: aload_1
    //   71: astore_3
    //   72: aload_0
    //   73: getfield 54	com/tencent/android/tpns/mqtt/internal/CommsSender:clientState	Lcom/tencent/android/tpns/mqtt/internal/ClientState;
    //   76: invokevirtual 157	com/tencent/android/tpns/mqtt/internal/ClientState:get	()Lcom/tencent/android/tpns/mqtt/internal/wire/MqttWireMessage;
    //   79: astore_2
    //   80: aload_2
    //   81: ifnull +198 -> 279
    //   84: aload_2
    //   85: astore_3
    //   86: aload_2
    //   87: astore_1
    //   88: ldc 10
    //   90: new 127	java/lang/StringBuilder
    //   93: dup
    //   94: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   97: ldc 159
    //   99: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: aload_2
    //   103: invokevirtual 162	com/tencent/android/tpns/mqtt/internal/wire/MqttWireMessage:toString	()Ljava/lang/String;
    //   106: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: invokevirtual 139	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   112: invokestatic 165	com/tencent/tpns/baseapi/base/logger/TBaseLogger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   115: aload_2
    //   116: astore_3
    //   117: aload_2
    //   118: astore_1
    //   119: aload_2
    //   120: instanceof 167
    //   123: ifeq +65 -> 188
    //   126: aload_2
    //   127: astore_3
    //   128: aload_2
    //   129: astore_1
    //   130: aload_0
    //   131: getfield 74	com/tencent/android/tpns/mqtt/internal/CommsSender:out	Lcom/tencent/android/tpns/mqtt/internal/wire/MqttOutputStream;
    //   134: aload_2
    //   135: invokevirtual 171	com/tencent/android/tpns/mqtt/internal/wire/MqttOutputStream:write	(Lcom/tencent/android/tpns/mqtt/internal/wire/MqttWireMessage;)V
    //   138: aload_2
    //   139: astore_3
    //   140: aload_2
    //   141: astore_1
    //   142: aload_0
    //   143: getfield 74	com/tencent/android/tpns/mqtt/internal/CommsSender:out	Lcom/tencent/android/tpns/mqtt/internal/wire/MqttOutputStream;
    //   146: invokevirtual 174	com/tencent/android/tpns/mqtt/internal/wire/MqttOutputStream:flush	()V
    //   149: aload_2
    //   150: astore_1
    //   151: goto -97 -> 54
    //   154: astore_1
    //   155: aload_0
    //   156: aload_3
    //   157: aload_1
    //   158: invokespecial 176	com/tencent/android/tpns/mqtt/internal/CommsSender:handleRunException	(Lcom/tencent/android/tpns/mqtt/internal/wire/MqttWireMessage;Ljava/lang/Exception;)V
    //   161: aload_3
    //   162: astore_1
    //   163: goto -109 -> 54
    //   166: astore_1
    //   167: aload_0
    //   168: iconst_0
    //   169: putfield 50	com/tencent/android/tpns/mqtt/internal/CommsSender:running	Z
    //   172: aload_0
    //   173: getfield 67	com/tencent/android/tpns/mqtt/internal/CommsSender:runningSemaphore	Ljava/util/concurrent/Semaphore;
    //   176: invokevirtual 179	java/util/concurrent/Semaphore:release	()V
    //   179: aload_1
    //   180: athrow
    //   181: astore_1
    //   182: aload_0
    //   183: iconst_0
    //   184: putfield 50	com/tencent/android/tpns/mqtt/internal/CommsSender:running	Z
    //   187: return
    //   188: aload_2
    //   189: astore_3
    //   190: aload_2
    //   191: astore_1
    //   192: aload_0
    //   193: getfield 58	com/tencent/android/tpns/mqtt/internal/CommsSender:tokenStore	Lcom/tencent/android/tpns/mqtt/internal/CommsTokenStore;
    //   196: aload_2
    //   197: invokevirtual 185	com/tencent/android/tpns/mqtt/internal/CommsTokenStore:getToken	(Lcom/tencent/android/tpns/mqtt/internal/wire/MqttWireMessage;)Lcom/tencent/android/tpns/mqtt/MqttToken;
    //   200: astore 4
    //   202: aload_2
    //   203: astore_1
    //   204: aload 4
    //   206: ifnull -152 -> 54
    //   209: aload_2
    //   210: astore_3
    //   211: aload_2
    //   212: astore_1
    //   213: aload 4
    //   215: monitorenter
    //   216: aload_0
    //   217: getfield 74	com/tencent/android/tpns/mqtt/internal/CommsSender:out	Lcom/tencent/android/tpns/mqtt/internal/wire/MqttOutputStream;
    //   220: aload_2
    //   221: invokevirtual 171	com/tencent/android/tpns/mqtt/internal/wire/MqttOutputStream:write	(Lcom/tencent/android/tpns/mqtt/internal/wire/MqttWireMessage;)V
    //   224: aload_0
    //   225: getfield 74	com/tencent/android/tpns/mqtt/internal/CommsSender:out	Lcom/tencent/android/tpns/mqtt/internal/wire/MqttOutputStream;
    //   228: invokevirtual 174	com/tencent/android/tpns/mqtt/internal/wire/MqttOutputStream:flush	()V
    //   231: aload_0
    //   232: getfield 54	com/tencent/android/tpns/mqtt/internal/CommsSender:clientState	Lcom/tencent/android/tpns/mqtt/internal/ClientState;
    //   235: aload_2
    //   236: invokevirtual 188	com/tencent/android/tpns/mqtt/internal/ClientState:notifySent	(Lcom/tencent/android/tpns/mqtt/internal/wire/MqttWireMessage;)V
    //   239: aload 4
    //   241: monitorexit
    //   242: aload_2
    //   243: astore_1
    //   244: goto -190 -> 54
    //   247: astore 5
    //   249: aload 4
    //   251: monitorexit
    //   252: aload_2
    //   253: astore_3
    //   254: aload_2
    //   255: astore_1
    //   256: aload 5
    //   258: athrow
    //   259: astore_2
    //   260: aload_0
    //   261: aload_1
    //   262: aload_2
    //   263: invokespecial 176	com/tencent/android/tpns/mqtt/internal/CommsSender:handleRunException	(Lcom/tencent/android/tpns/mqtt/internal/wire/MqttWireMessage;Ljava/lang/Exception;)V
    //   266: goto -212 -> 54
    //   269: astore_1
    //   270: aload_2
    //   271: instanceof 190
    //   274: ifne -43 -> 231
    //   277: aload_1
    //   278: athrow
    //   279: aload_2
    //   280: astore_3
    //   281: aload_2
    //   282: astore_1
    //   283: getstatic 43	com/tencent/android/tpns/mqtt/internal/CommsSender:log	Lcom/tencent/android/tpns/mqtt/logging/Logger;
    //   286: ldc 10
    //   288: ldc 191
    //   290: ldc 193
    //   292: invokeinterface 196 4 0
    //   297: aload_2
    //   298: astore_3
    //   299: aload_2
    //   300: astore_1
    //   301: aload_0
    //   302: iconst_0
    //   303: putfield 50	com/tencent/android/tpns/mqtt/internal/CommsSender:running	Z
    //   306: aload_2
    //   307: astore_1
    //   308: goto -254 -> 54
    //   311: aload_0
    //   312: iconst_0
    //   313: putfield 50	com/tencent/android/tpns/mqtt/internal/CommsSender:running	Z
    //   316: aload_0
    //   317: getfield 67	com/tencent/android/tpns/mqtt/internal/CommsSender:runningSemaphore	Ljava/util/concurrent/Semaphore;
    //   320: invokevirtual 179	java/util/concurrent/Semaphore:release	()V
    //   323: getstatic 43	com/tencent/android/tpns/mqtt/internal/CommsSender:log	Lcom/tencent/android/tpns/mqtt/logging/Logger;
    //   326: ldc 10
    //   328: ldc 191
    //   330: ldc 198
    //   332: invokeinterface 196 4 0
    //   337: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	338	0	this	CommsSender
    //   46	105	1	localObject1	Object
    //   154	4	1	localMqttException	MqttException
    //   162	1	1	localObject2	Object
    //   166	14	1	localObject3	Object
    //   181	1	1	localInterruptedException	java.lang.InterruptedException
    //   191	71	1	localObject4	Object
    //   269	9	1	localIOException	java.io.IOException
    //   282	26	1	localObject5	Object
    //   65	190	2	localObject6	Object
    //   259	48	2	localException	Exception
    //   71	228	3	localObject7	Object
    //   200	50	4	localMqttToken	com.tencent.android.tpns.mqtt.MqttToken
    //   247	10	5	localObject8	Object
    // Exception table:
    //   from	to	target	type
    //   72	80	154	com/tencent/android/tpns/mqtt/MqttException
    //   88	115	154	com/tencent/android/tpns/mqtt/MqttException
    //   119	126	154	com/tencent/android/tpns/mqtt/MqttException
    //   130	138	154	com/tencent/android/tpns/mqtt/MqttException
    //   142	149	154	com/tencent/android/tpns/mqtt/MqttException
    //   192	202	154	com/tencent/android/tpns/mqtt/MqttException
    //   213	216	154	com/tencent/android/tpns/mqtt/MqttException
    //   256	259	154	com/tencent/android/tpns/mqtt/MqttException
    //   283	297	154	com/tencent/android/tpns/mqtt/MqttException
    //   301	306	154	com/tencent/android/tpns/mqtt/MqttException
    //   54	66	166	finally
    //   72	80	166	finally
    //   88	115	166	finally
    //   119	126	166	finally
    //   130	138	166	finally
    //   142	149	166	finally
    //   155	161	166	finally
    //   192	202	166	finally
    //   213	216	166	finally
    //   256	259	166	finally
    //   260	266	166	finally
    //   283	297	166	finally
    //   301	306	166	finally
    //   47	54	181	java/lang/InterruptedException
    //   216	224	247	finally
    //   224	231	247	finally
    //   231	242	247	finally
    //   249	252	247	finally
    //   270	279	247	finally
    //   72	80	259	java/lang/Exception
    //   88	115	259	java/lang/Exception
    //   119	126	259	java/lang/Exception
    //   130	138	259	java/lang/Exception
    //   142	149	259	java/lang/Exception
    //   192	202	259	java/lang/Exception
    //   213	216	259	java/lang/Exception
    //   256	259	259	java/lang/Exception
    //   283	297	259	java/lang/Exception
    //   301	306	259	java/lang/Exception
    //   224	231	269	java/io/IOException
  }
  
  public void start(String arg1, ExecutorService paramExecutorService)
  {
    this.threadName = ???;
    synchronized (this.lifecycle)
    {
      if (!this.running)
      {
        this.running = true;
        this.senderFuture = paramExecutorService.submit(this);
      }
      return;
    }
  }
  
  /* Error */
  public void stop()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 52	com/tencent/android/tpns/mqtt/internal/CommsSender:lifecycle	Ljava/lang/Object;
    //   4: astore_2
    //   5: aload_2
    //   6: monitorenter
    //   7: aload_0
    //   8: getfield 208	com/tencent/android/tpns/mqtt/internal/CommsSender:senderFuture	Ljava/util/concurrent/Future;
    //   11: ifnull +14 -> 25
    //   14: aload_0
    //   15: getfield 208	com/tencent/android/tpns/mqtt/internal/CommsSender:senderFuture	Ljava/util/concurrent/Future;
    //   18: iconst_1
    //   19: invokeinterface 215 2 0
    //   24: pop
    //   25: getstatic 43	com/tencent/android/tpns/mqtt/internal/CommsSender:log	Lcom/tencent/android/tpns/mqtt/logging/Logger;
    //   28: ldc 10
    //   30: ldc 216
    //   32: ldc 218
    //   34: invokeinterface 196 4 0
    //   39: aload_0
    //   40: getfield 50	com/tencent/android/tpns/mqtt/internal/CommsSender:running	Z
    //   43: ifeq +62 -> 105
    //   46: aload_0
    //   47: iconst_0
    //   48: putfield 50	com/tencent/android/tpns/mqtt/internal/CommsSender:running	Z
    //   51: invokestatic 145	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   54: aload_0
    //   55: getfield 60	com/tencent/android/tpns/mqtt/internal/CommsSender:sendThread	Ljava/lang/Thread;
    //   58: invokevirtual 222	java/lang/Object:equals	(Ljava/lang/Object;)Z
    //   61: istore_1
    //   62: iload_1
    //   63: ifne +42 -> 105
    //   66: aload_0
    //   67: getfield 50	com/tencent/android/tpns/mqtt/internal/CommsSender:running	Z
    //   70: ifeq +57 -> 127
    //   73: aload_0
    //   74: getfield 54	com/tencent/android/tpns/mqtt/internal/CommsSender:clientState	Lcom/tencent/android/tpns/mqtt/internal/ClientState;
    //   77: invokevirtual 225	com/tencent/android/tpns/mqtt/internal/ClientState:notifyQueueLock	()V
    //   80: aload_0
    //   81: getfield 67	com/tencent/android/tpns/mqtt/internal/CommsSender:runningSemaphore	Ljava/util/concurrent/Semaphore;
    //   84: ldc2_w 226
    //   87: getstatic 233	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   90: invokevirtual 237	java/util/concurrent/Semaphore:tryAcquire	(JLjava/util/concurrent/TimeUnit;)Z
    //   93: pop
    //   94: goto -28 -> 66
    //   97: astore_3
    //   98: aload_0
    //   99: getfield 67	com/tencent/android/tpns/mqtt/internal/CommsSender:runningSemaphore	Ljava/util/concurrent/Semaphore;
    //   102: invokevirtual 179	java/util/concurrent/Semaphore:release	()V
    //   105: aload_0
    //   106: aconst_null
    //   107: putfield 60	com/tencent/android/tpns/mqtt/internal/CommsSender:sendThread	Ljava/lang/Thread;
    //   110: getstatic 43	com/tencent/android/tpns/mqtt/internal/CommsSender:log	Lcom/tencent/android/tpns/mqtt/logging/Logger;
    //   113: ldc 10
    //   115: ldc 216
    //   117: ldc 239
    //   119: invokeinterface 196 4 0
    //   124: aload_2
    //   125: monitorexit
    //   126: return
    //   127: aload_0
    //   128: getfield 67	com/tencent/android/tpns/mqtt/internal/CommsSender:runningSemaphore	Ljava/util/concurrent/Semaphore;
    //   131: invokevirtual 179	java/util/concurrent/Semaphore:release	()V
    //   134: goto -29 -> 105
    //   137: astore_3
    //   138: aload_2
    //   139: monitorexit
    //   140: aload_3
    //   141: athrow
    //   142: astore_3
    //   143: aload_0
    //   144: getfield 67	com/tencent/android/tpns/mqtt/internal/CommsSender:runningSemaphore	Ljava/util/concurrent/Semaphore;
    //   147: invokevirtual 179	java/util/concurrent/Semaphore:release	()V
    //   150: aload_3
    //   151: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	152	0	this	CommsSender
    //   61	2	1	bool	boolean
    //   4	135	2	localObject1	Object
    //   97	1	3	localInterruptedException	java.lang.InterruptedException
    //   137	4	3	localObject2	Object
    //   142	9	3	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   66	94	97	java/lang/InterruptedException
    //   7	25	137	finally
    //   25	62	137	finally
    //   98	105	137	finally
    //   105	126	137	finally
    //   127	134	137	finally
    //   138	140	137	finally
    //   143	152	137	finally
    //   66	94	142	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpns.mqtt.internal.CommsSender
 * JD-Core Version:    0.7.0.1
 */