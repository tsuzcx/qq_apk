package com.tencent.android.tpns.mqtt.internal;

import com.tencent.android.tpns.mqtt.IMqttActionListener;
import com.tencent.android.tpns.mqtt.IMqttAsyncClient;
import com.tencent.android.tpns.mqtt.IMqttMessageListener;
import com.tencent.android.tpns.mqtt.MqttCallback;
import com.tencent.android.tpns.mqtt.MqttCallbackExtended;
import com.tencent.android.tpns.mqtt.MqttDeliveryToken;
import com.tencent.android.tpns.mqtt.MqttException;
import com.tencent.android.tpns.mqtt.MqttMessage;
import com.tencent.android.tpns.mqtt.MqttToken;
import com.tencent.android.tpns.mqtt.MqttTopic;
import com.tencent.android.tpns.mqtt.internal.wire.MqttPubAck;
import com.tencent.android.tpns.mqtt.internal.wire.MqttPubComp;
import com.tencent.android.tpns.mqtt.internal.wire.MqttPublish;
import com.tencent.android.tpns.mqtt.logging.Logger;
import com.tencent.android.tpns.mqtt.logging.LoggerFactory;
import com.tencent.tpns.baseapi.base.logger.TBaseLogger;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.Semaphore;

public class CommsCallback
  implements Runnable
{
  private static final String CLASS_NAME = "CommsCallback";
  private static final int INBOUND_QUEUE_SIZE = 10;
  private static final Logger log = LoggerFactory.getLogger("com.tencent.android.tpns.mqtt.internal.nls.logcat", "CommsCallback");
  private Future callbackFuture;
  private Thread callbackThread;
  private Hashtable callbacks;
  private ClientComms clientComms;
  private ClientState clientState;
  private Vector completeQueue;
  private Object lifecycle = new Object();
  private boolean manualAcks = false;
  private Vector messageQueue;
  private MqttCallback mqttCallback;
  private boolean quiescing = false;
  private MqttCallbackExtended reconnectInternalCallback;
  public boolean running = false;
  private final Semaphore runningSemaphore = new Semaphore(1);
  private Object spaceAvailable = new Object();
  private String threadName;
  private Object workAvailable = new Object();
  
  CommsCallback(ClientComms paramClientComms)
  {
    this.clientComms = paramClientComms;
    this.messageQueue = new Vector(10);
    this.completeQueue = new Vector(10);
    this.callbacks = new Hashtable();
    log.setResourceName(paramClientComms.getClient().getClientId());
  }
  
  private void handleActionComplete(MqttToken paramMqttToken)
    throws MqttException
  {
    try
    {
      log.fine("CommsCallback", "handleActionComplete", "705", new Object[] { paramMqttToken.internalTok.getKey() });
      if (paramMqttToken.isComplete()) {
        this.clientState.notifyComplete(paramMqttToken);
      }
      paramMqttToken.internalTok.notifyComplete();
      if (!paramMqttToken.internalTok.isNotified())
      {
        if ((this.mqttCallback != null) && ((paramMqttToken instanceof MqttDeliveryToken)) && (paramMqttToken.isComplete())) {
          this.mqttCallback.deliveryComplete((MqttDeliveryToken)paramMqttToken);
        }
        fireActionEvent(paramMqttToken);
      }
      if ((paramMqttToken.isComplete()) && (((paramMqttToken instanceof MqttDeliveryToken)) || ((paramMqttToken.getActionCallback() instanceof IMqttActionListener)))) {
        paramMqttToken.internalTok.setNotified(true);
      }
      return;
    }
    finally {}
  }
  
  private void handleMessage(MqttPublish paramMqttPublish)
    throws MqttException, Exception
  {
    String str = paramMqttPublish.getTopicName();
    log.fine("CommsCallback", "handleMessage", "713", new Object[] { new Integer(paramMqttPublish.getMessageId()), str });
    deliverMessage(str, paramMqttPublish.getMessageId(), paramMqttPublish.getMessage());
    if (!this.manualAcks)
    {
      if (paramMqttPublish.getMessage().getQos() != 1) {
        break label108;
      }
      this.clientComms.internalSend(new MqttPubAck(paramMqttPublish), new MqttToken(this.clientComms.getClient().getClientId()));
    }
    label108:
    while (paramMqttPublish.getMessage().getQos() != 2) {
      return;
    }
    this.clientComms.deliveryComplete(paramMqttPublish);
    paramMqttPublish = new MqttPubComp(paramMqttPublish);
    this.clientComms.internalSend(paramMqttPublish, new MqttToken(this.clientComms.getClient().getClientId()));
  }
  
  public void asyncOperationComplete(MqttToken paramMqttToken)
  {
    if (this.running)
    {
      this.completeQueue.addElement(paramMqttToken);
      synchronized (this.workAvailable)
      {
        log.fine("CommsCallback", "asyncOperationComplete", "715", new Object[] { paramMqttToken.internalTok.getKey() });
        this.workAvailable.notifyAll();
        return;
      }
    }
    try
    {
      handleActionComplete(paramMqttToken);
      return;
    }
    catch (Throwable paramMqttToken)
    {
      TBaseLogger.e("CommsCallback", "asyncOperationComplete", paramMqttToken);
      this.clientComms.shutdownConnection(null, new MqttException(paramMqttToken));
    }
  }
  
  public void connectionLost(MqttException paramMqttException)
  {
    try
    {
      if ((this.mqttCallback != null) && (paramMqttException != null))
      {
        log.fine("CommsCallback", "connectionLost", "708", new Object[] { paramMqttException });
        this.mqttCallback.connectionLost(paramMqttException);
      }
      if ((this.reconnectInternalCallback != null) && (paramMqttException != null)) {
        this.reconnectInternalCallback.connectionLost(paramMqttException);
      }
      return;
    }
    catch (Throwable paramMqttException)
    {
      TBaseLogger.e("CommsCallback", "connectionLost", paramMqttException);
    }
  }
  
  protected boolean deliverMessage(String paramString, int paramInt, MqttMessage paramMqttMessage)
    throws Exception
  {
    Enumeration localEnumeration = this.callbacks.keys();
    boolean bool1 = false;
    if (localEnumeration.hasMoreElements())
    {
      String str = (String)localEnumeration.nextElement();
      if (!MqttTopic.isMatched(str, paramString)) {
        break label118;
      }
      paramMqttMessage.setId(paramInt);
      ((IMqttMessageListener)this.callbacks.get(str)).messageArrived(paramString, paramMqttMessage);
      bool1 = true;
    }
    label118:
    for (;;)
    {
      break;
      boolean bool2 = bool1;
      if (this.mqttCallback != null)
      {
        bool2 = bool1;
        if (!bool1)
        {
          paramMqttMessage.setId(paramInt);
          this.mqttCallback.messageArrived(paramString, paramMqttMessage);
          bool2 = true;
        }
      }
      return bool2;
    }
  }
  
  public void fireActionEvent(MqttToken paramMqttToken)
  {
    IMqttActionListener localIMqttActionListener;
    if (paramMqttToken != null)
    {
      localIMqttActionListener = paramMqttToken.getActionCallback();
      if (localIMqttActionListener != null)
      {
        if (paramMqttToken.getException() != null) {
          break label58;
        }
        log.fine("CommsCallback", "fireActionEvent", "716", new Object[] { paramMqttToken.internalTok.getKey() });
        localIMqttActionListener.onSuccess(paramMqttToken);
      }
    }
    return;
    label58:
    log.fine("CommsCallback", "fireActionEvent", "716", new Object[] { paramMqttToken.internalTok.getKey() });
    localIMqttActionListener.onFailure(paramMqttToken, paramMqttToken.getException());
  }
  
  protected Thread getThread()
  {
    return this.callbackThread;
  }
  
  public boolean isQuiesced()
  {
    return (this.quiescing) && (this.completeQueue.size() == 0) && (this.messageQueue.size() == 0);
  }
  
  public void messageArrived(MqttPublish arg1)
  {
    if ((this.mqttCallback != null) || (this.callbacks.size() > 0)) {
      synchronized (this.spaceAvailable)
      {
        while ((this.running) && (!this.quiescing))
        {
          int i = this.messageQueue.size();
          if (i < 10) {
            break;
          }
          try
          {
            log.fine("CommsCallback", "messageArrived", "709");
            this.spaceAvailable.wait(200L);
          }
          catch (InterruptedException localInterruptedException) {}
        }
        if (!this.quiescing) {
          this.messageQueue.addElement(???);
        }
      }
    }
    synchronized (this.workAvailable)
    {
      log.fine("CommsCallback", "messageArrived", "710");
      this.workAvailable.notifyAll();
      return;
      ??? = finally;
      throw ???;
    }
  }
  
  public void messageArrivedComplete(int paramInt1, int paramInt2)
    throws MqttException
  {
    if (paramInt2 == 1) {
      this.clientComms.internalSend(new MqttPubAck(paramInt1), new MqttToken(this.clientComms.getClient().getClientId()));
    }
    while (paramInt2 != 2) {
      return;
    }
    this.clientComms.deliveryComplete(paramInt1);
    MqttPubComp localMqttPubComp = new MqttPubComp(paramInt1);
    this.clientComms.internalSend(localMqttPubComp, new MqttToken(this.clientComms.getClient().getClientId()));
  }
  
  public void quiesce()
  {
    this.quiescing = true;
    synchronized (this.spaceAvailable)
    {
      log.fine("CommsCallback", "quiesce", "711");
      this.spaceAvailable.notifyAll();
      return;
    }
  }
  
  public void removeMessageListener(String paramString)
  {
    this.callbacks.remove(paramString);
  }
  
  public void removeMessageListeners()
  {
    this.callbacks.clear();
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: ldc 10
    //   2: new 356	java/lang/StringBuilder
    //   5: dup
    //   6: invokespecial 357	java/lang/StringBuilder:<init>	()V
    //   9: ldc_w 359
    //   12: invokevirtual 363	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15: aload_0
    //   16: getfield 365	com/tencent/android/tpns/mqtt/internal/CommsCallback:threadName	Ljava/lang/String;
    //   19: invokevirtual 363	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: invokevirtual 368	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   25: invokestatic 372	com/tencent/tpns/baseapi/base/logger/TBaseLogger:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   28: aload_0
    //   29: invokestatic 377	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   32: putfield 314	com/tencent/android/tpns/mqtt/internal/CommsCallback:callbackThread	Ljava/lang/Thread;
    //   35: aload_0
    //   36: getfield 314	com/tencent/android/tpns/mqtt/internal/CommsCallback:callbackThread	Ljava/lang/Thread;
    //   39: aload_0
    //   40: getfield 365	com/tencent/android/tpns/mqtt/internal/CommsCallback:threadName	Ljava/lang/String;
    //   43: invokevirtual 380	java/lang/Thread:setName	(Ljava/lang/String;)V
    //   46: aload_0
    //   47: getfield 79	com/tencent/android/tpns/mqtt/internal/CommsCallback:runningSemaphore	Ljava/util/concurrent/Semaphore;
    //   50: invokevirtual 383	java/util/concurrent/Semaphore:acquire	()V
    //   53: aload_0
    //   54: getfield 62	com/tencent/android/tpns/mqtt/internal/CommsCallback:running	Z
    //   57: ifeq +233 -> 290
    //   60: aload_0
    //   61: getfield 68	com/tencent/android/tpns/mqtt/internal/CommsCallback:workAvailable	Ljava/lang/Object;
    //   64: astore_1
    //   65: aload_1
    //   66: monitorenter
    //   67: aload_0
    //   68: getfield 62	com/tencent/android/tpns/mqtt/internal/CommsCallback:running	Z
    //   71: ifeq +46 -> 117
    //   74: aload_0
    //   75: getfield 86	com/tencent/android/tpns/mqtt/internal/CommsCallback:messageQueue	Ljava/util/Vector;
    //   78: invokevirtual 386	java/util/Vector:isEmpty	()Z
    //   81: ifeq +36 -> 117
    //   84: aload_0
    //   85: getfield 88	com/tencent/android/tpns/mqtt/internal/CommsCallback:completeQueue	Ljava/util/Vector;
    //   88: invokevirtual 386	java/util/Vector:isEmpty	()Z
    //   91: ifeq +26 -> 117
    //   94: getstatic 55	com/tencent/android/tpns/mqtt/internal/CommsCallback:log	Lcom/tencent/android/tpns/mqtt/logging/Logger;
    //   97: ldc 10
    //   99: ldc_w 387
    //   102: ldc_w 389
    //   105: invokeinterface 327 4 0
    //   110: aload_0
    //   111: getfield 68	com/tencent/android/tpns/mqtt/internal/CommsCallback:workAvailable	Ljava/lang/Object;
    //   114: invokevirtual 391	java/lang/Object:wait	()V
    //   117: aload_1
    //   118: monitorexit
    //   119: aload_0
    //   120: getfield 62	com/tencent/android/tpns/mqtt/internal/CommsCallback:running	Z
    //   123: ifeq +99 -> 222
    //   126: aload_0
    //   127: getfield 88	com/tencent/android/tpns/mqtt/internal/CommsCallback:completeQueue	Ljava/util/Vector;
    //   130: astore_2
    //   131: aload_2
    //   132: monitorenter
    //   133: aload_0
    //   134: getfield 88	com/tencent/android/tpns/mqtt/internal/CommsCallback:completeQueue	Ljava/util/Vector;
    //   137: invokevirtual 386	java/util/Vector:isEmpty	()Z
    //   140: ifne +300 -> 440
    //   143: aload_0
    //   144: getfield 88	com/tencent/android/tpns/mqtt/internal/CommsCallback:completeQueue	Ljava/util/Vector;
    //   147: iconst_0
    //   148: invokevirtual 395	java/util/Vector:elementAt	(I)Ljava/lang/Object;
    //   151: checkcast 120	com/tencent/android/tpns/mqtt/MqttToken
    //   154: astore_1
    //   155: aload_0
    //   156: getfield 88	com/tencent/android/tpns/mqtt/internal/CommsCallback:completeQueue	Ljava/util/Vector;
    //   159: iconst_0
    //   160: invokevirtual 398	java/util/Vector:removeElementAt	(I)V
    //   163: aload_2
    //   164: monitorexit
    //   165: aload_1
    //   166: ifnull +8 -> 174
    //   169: aload_0
    //   170: aload_1
    //   171: invokespecial 235	com/tencent/android/tpns/mqtt/internal/CommsCallback:handleActionComplete	(Lcom/tencent/android/tpns/mqtt/MqttToken;)V
    //   174: aload_0
    //   175: getfield 86	com/tencent/android/tpns/mqtt/internal/CommsCallback:messageQueue	Ljava/util/Vector;
    //   178: astore_2
    //   179: aload_2
    //   180: monitorenter
    //   181: aload_0
    //   182: getfield 86	com/tencent/android/tpns/mqtt/internal/CommsCallback:messageQueue	Ljava/util/Vector;
    //   185: invokevirtual 386	java/util/Vector:isEmpty	()Z
    //   188: ifne +247 -> 435
    //   191: aload_0
    //   192: getfield 86	com/tencent/android/tpns/mqtt/internal/CommsCallback:messageQueue	Ljava/util/Vector;
    //   195: iconst_0
    //   196: invokevirtual 395	java/util/Vector:elementAt	(I)Ljava/lang/Object;
    //   199: checkcast 179	com/tencent/android/tpns/mqtt/internal/wire/MqttPublish
    //   202: astore_1
    //   203: aload_0
    //   204: getfield 86	com/tencent/android/tpns/mqtt/internal/CommsCallback:messageQueue	Ljava/util/Vector;
    //   207: iconst_0
    //   208: invokevirtual 398	java/util/Vector:removeElementAt	(I)V
    //   211: aload_2
    //   212: monitorexit
    //   213: aload_1
    //   214: ifnull +8 -> 222
    //   217: aload_0
    //   218: aload_1
    //   219: invokespecial 400	com/tencent/android/tpns/mqtt/internal/CommsCallback:handleMessage	(Lcom/tencent/android/tpns/mqtt/internal/wire/MqttPublish;)V
    //   222: aload_0
    //   223: getfield 64	com/tencent/android/tpns/mqtt/internal/CommsCallback:quiescing	Z
    //   226: ifeq +11 -> 237
    //   229: aload_0
    //   230: getfield 139	com/tencent/android/tpns/mqtt/internal/CommsCallback:clientState	Lcom/tencent/android/tpns/mqtt/internal/ClientState;
    //   233: invokevirtual 403	com/tencent/android/tpns/mqtt/internal/ClientState:checkQuiesceLock	()Z
    //   236: pop
    //   237: aload_0
    //   238: getfield 79	com/tencent/android/tpns/mqtt/internal/CommsCallback:runningSemaphore	Ljava/util/concurrent/Semaphore;
    //   241: invokevirtual 406	java/util/concurrent/Semaphore:release	()V
    //   244: aload_0
    //   245: getfield 70	com/tencent/android/tpns/mqtt/internal/CommsCallback:spaceAvailable	Ljava/lang/Object;
    //   248: astore_1
    //   249: aload_1
    //   250: monitorenter
    //   251: getstatic 55	com/tencent/android/tpns/mqtt/internal/CommsCallback:log	Lcom/tencent/android/tpns/mqtt/logging/Logger;
    //   254: ldc 10
    //   256: ldc_w 387
    //   259: ldc_w 408
    //   262: invokeinterface 327 4 0
    //   267: aload_0
    //   268: getfield 70	com/tencent/android/tpns/mqtt/internal/CommsCallback:spaceAvailable	Ljava/lang/Object;
    //   271: invokevirtual 233	java/lang/Object:notifyAll	()V
    //   274: aload_1
    //   275: monitorexit
    //   276: goto -223 -> 53
    //   279: astore_2
    //   280: aload_1
    //   281: monitorexit
    //   282: aload_2
    //   283: athrow
    //   284: astore_1
    //   285: aload_0
    //   286: iconst_0
    //   287: putfield 62	com/tencent/android/tpns/mqtt/internal/CommsCallback:running	Z
    //   290: return
    //   291: astore_2
    //   292: aload_1
    //   293: monitorexit
    //   294: aload_2
    //   295: athrow
    //   296: astore_1
    //   297: goto -178 -> 119
    //   300: astore_1
    //   301: aload_2
    //   302: monitorexit
    //   303: aload_1
    //   304: athrow
    //   305: astore_1
    //   306: ldc 10
    //   308: ldc_w 387
    //   311: aload_1
    //   312: invokestatic 241	com/tencent/tpns/baseapi/base/logger/TBaseLogger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   315: aload_0
    //   316: iconst_0
    //   317: putfield 62	com/tencent/android/tpns/mqtt/internal/CommsCallback:running	Z
    //   320: aload_0
    //   321: getfield 81	com/tencent/android/tpns/mqtt/internal/CommsCallback:clientComms	Lcom/tencent/android/tpns/mqtt/internal/ClientComms;
    //   324: aconst_null
    //   325: new 115	com/tencent/android/tpns/mqtt/MqttException
    //   328: dup
    //   329: aload_1
    //   330: invokespecial 244	com/tencent/android/tpns/mqtt/MqttException:<init>	(Ljava/lang/Throwable;)V
    //   333: invokevirtual 248	com/tencent/android/tpns/mqtt/internal/ClientComms:shutdownConnection	(Lcom/tencent/android/tpns/mqtt/MqttToken;Lcom/tencent/android/tpns/mqtt/MqttException;)V
    //   336: aload_0
    //   337: getfield 79	com/tencent/android/tpns/mqtt/internal/CommsCallback:runningSemaphore	Ljava/util/concurrent/Semaphore;
    //   340: invokevirtual 406	java/util/concurrent/Semaphore:release	()V
    //   343: aload_0
    //   344: getfield 70	com/tencent/android/tpns/mqtt/internal/CommsCallback:spaceAvailable	Ljava/lang/Object;
    //   347: astore_1
    //   348: aload_1
    //   349: monitorenter
    //   350: getstatic 55	com/tencent/android/tpns/mqtt/internal/CommsCallback:log	Lcom/tencent/android/tpns/mqtt/logging/Logger;
    //   353: ldc 10
    //   355: ldc_w 387
    //   358: ldc_w 408
    //   361: invokeinterface 327 4 0
    //   366: aload_0
    //   367: getfield 70	com/tencent/android/tpns/mqtt/internal/CommsCallback:spaceAvailable	Ljava/lang/Object;
    //   370: invokevirtual 233	java/lang/Object:notifyAll	()V
    //   373: aload_1
    //   374: monitorexit
    //   375: goto -322 -> 53
    //   378: astore_2
    //   379: aload_1
    //   380: monitorexit
    //   381: aload_2
    //   382: athrow
    //   383: astore_1
    //   384: aload_2
    //   385: monitorexit
    //   386: aload_1
    //   387: athrow
    //   388: astore_2
    //   389: aload_0
    //   390: getfield 79	com/tencent/android/tpns/mqtt/internal/CommsCallback:runningSemaphore	Ljava/util/concurrent/Semaphore;
    //   393: invokevirtual 406	java/util/concurrent/Semaphore:release	()V
    //   396: aload_0
    //   397: getfield 70	com/tencent/android/tpns/mqtt/internal/CommsCallback:spaceAvailable	Ljava/lang/Object;
    //   400: astore_1
    //   401: aload_1
    //   402: monitorenter
    //   403: getstatic 55	com/tencent/android/tpns/mqtt/internal/CommsCallback:log	Lcom/tencent/android/tpns/mqtt/logging/Logger;
    //   406: ldc 10
    //   408: ldc_w 387
    //   411: ldc_w 408
    //   414: invokeinterface 327 4 0
    //   419: aload_0
    //   420: getfield 70	com/tencent/android/tpns/mqtt/internal/CommsCallback:spaceAvailable	Ljava/lang/Object;
    //   423: invokevirtual 233	java/lang/Object:notifyAll	()V
    //   426: aload_1
    //   427: monitorexit
    //   428: aload_2
    //   429: athrow
    //   430: astore_2
    //   431: aload_1
    //   432: monitorexit
    //   433: aload_2
    //   434: athrow
    //   435: aconst_null
    //   436: astore_1
    //   437: goto -226 -> 211
    //   440: aconst_null
    //   441: astore_1
    //   442: goto -279 -> 163
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	445	0	this	CommsCallback
    //   64	217	1	localObject1	Object
    //   284	9	1	localInterruptedException1	InterruptedException
    //   296	1	1	localInterruptedException2	InterruptedException
    //   300	4	1	localObject2	Object
    //   305	25	1	localThrowable	Throwable
    //   347	33	1	localObject3	Object
    //   383	4	1	localObject4	Object
    //   400	42	1	localObject5	Object
    //   130	82	2	localVector	Vector
    //   279	4	2	localObject6	Object
    //   291	11	2	localObject7	Object
    //   378	7	2	localObject8	Object
    //   388	41	2	localObject9	Object
    //   430	4	2	localObject10	Object
    // Exception table:
    //   from	to	target	type
    //   251	276	279	finally
    //   280	282	279	finally
    //   46	53	284	java/lang/InterruptedException
    //   67	117	291	finally
    //   117	119	291	finally
    //   292	294	291	finally
    //   60	67	296	java/lang/InterruptedException
    //   294	296	296	java/lang/InterruptedException
    //   133	163	300	finally
    //   163	165	300	finally
    //   301	303	300	finally
    //   60	67	305	java/lang/Throwable
    //   119	133	305	java/lang/Throwable
    //   169	174	305	java/lang/Throwable
    //   174	181	305	java/lang/Throwable
    //   217	222	305	java/lang/Throwable
    //   222	237	305	java/lang/Throwable
    //   294	296	305	java/lang/Throwable
    //   303	305	305	java/lang/Throwable
    //   386	388	305	java/lang/Throwable
    //   350	375	378	finally
    //   379	381	378	finally
    //   181	211	383	finally
    //   211	213	383	finally
    //   384	386	383	finally
    //   60	67	388	finally
    //   119	133	388	finally
    //   169	174	388	finally
    //   174	181	388	finally
    //   217	222	388	finally
    //   222	237	388	finally
    //   294	296	388	finally
    //   303	305	388	finally
    //   306	336	388	finally
    //   386	388	388	finally
    //   403	428	430	finally
    //   431	433	430	finally
  }
  
  public void setCallback(MqttCallback paramMqttCallback)
  {
    this.mqttCallback = paramMqttCallback;
  }
  
  public void setClientState(ClientState paramClientState)
  {
    this.clientState = paramClientState;
  }
  
  public void setManualAcks(boolean paramBoolean)
  {
    this.manualAcks = paramBoolean;
  }
  
  public void setMessageListener(String paramString, IMqttMessageListener paramIMqttMessageListener)
  {
    this.callbacks.put(paramString, paramIMqttMessageListener);
  }
  
  public void setReconnectCallback(MqttCallbackExtended paramMqttCallbackExtended)
  {
    this.reconnectInternalCallback = paramMqttCallbackExtended;
  }
  
  public void start(String arg1, ExecutorService paramExecutorService)
  {
    this.threadName = ???;
    synchronized (this.lifecycle)
    {
      if (!this.running)
      {
        this.messageQueue.clear();
        this.completeQueue.clear();
        this.running = true;
        this.quiescing = false;
        this.callbackFuture = paramExecutorService.submit(this);
      }
      return;
    }
  }
  
  /* Error */
  public void stop()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 66	com/tencent/android/tpns/mqtt/internal/CommsCallback:lifecycle	Ljava/lang/Object;
    //   4: astore_2
    //   5: aload_2
    //   6: monitorenter
    //   7: aload_0
    //   8: getfield 432	com/tencent/android/tpns/mqtt/internal/CommsCallback:callbackFuture	Ljava/util/concurrent/Future;
    //   11: ifnull +14 -> 25
    //   14: aload_0
    //   15: getfield 432	com/tencent/android/tpns/mqtt/internal/CommsCallback:callbackFuture	Ljava/util/concurrent/Future;
    //   18: iconst_1
    //   19: invokeinterface 439 2 0
    //   24: pop
    //   25: aload_0
    //   26: getfield 62	com/tencent/android/tpns/mqtt/internal/CommsCallback:running	Z
    //   29: ifeq +85 -> 114
    //   32: getstatic 55	com/tencent/android/tpns/mqtt/internal/CommsCallback:log	Lcom/tencent/android/tpns/mqtt/logging/Logger;
    //   35: ldc 10
    //   37: ldc_w 440
    //   40: ldc_w 442
    //   43: invokeinterface 327 4 0
    //   48: aload_0
    //   49: iconst_0
    //   50: putfield 62	com/tencent/android/tpns/mqtt/internal/CommsCallback:running	Z
    //   53: invokestatic 377	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   56: aload_0
    //   57: getfield 314	com/tencent/android/tpns/mqtt/internal/CommsCallback:callbackThread	Ljava/lang/Thread;
    //   60: invokevirtual 446	java/lang/Object:equals	(Ljava/lang/Object;)Z
    //   63: istore_1
    //   64: iload_1
    //   65: ifne +49 -> 114
    //   68: aload_0
    //   69: getfield 68	com/tencent/android/tpns/mqtt/internal/CommsCallback:workAvailable	Ljava/lang/Object;
    //   72: astore_3
    //   73: aload_3
    //   74: monitorenter
    //   75: getstatic 55	com/tencent/android/tpns/mqtt/internal/CommsCallback:log	Lcom/tencent/android/tpns/mqtt/logging/Logger;
    //   78: ldc 10
    //   80: ldc_w 440
    //   83: ldc_w 448
    //   86: invokeinterface 327 4 0
    //   91: aload_0
    //   92: getfield 68	com/tencent/android/tpns/mqtt/internal/CommsCallback:workAvailable	Ljava/lang/Object;
    //   95: invokevirtual 233	java/lang/Object:notifyAll	()V
    //   98: aload_3
    //   99: monitorexit
    //   100: aload_0
    //   101: getfield 79	com/tencent/android/tpns/mqtt/internal/CommsCallback:runningSemaphore	Ljava/util/concurrent/Semaphore;
    //   104: invokevirtual 383	java/util/concurrent/Semaphore:acquire	()V
    //   107: aload_0
    //   108: getfield 79	com/tencent/android/tpns/mqtt/internal/CommsCallback:runningSemaphore	Ljava/util/concurrent/Semaphore;
    //   111: invokevirtual 406	java/util/concurrent/Semaphore:release	()V
    //   114: aload_0
    //   115: aconst_null
    //   116: putfield 314	com/tencent/android/tpns/mqtt/internal/CommsCallback:callbackThread	Ljava/lang/Thread;
    //   119: getstatic 55	com/tencent/android/tpns/mqtt/internal/CommsCallback:log	Lcom/tencent/android/tpns/mqtt/logging/Logger;
    //   122: ldc 10
    //   124: ldc_w 440
    //   127: ldc_w 450
    //   130: invokeinterface 327 4 0
    //   135: aload_2
    //   136: monitorexit
    //   137: return
    //   138: astore 4
    //   140: aload_3
    //   141: monitorexit
    //   142: aload 4
    //   144: athrow
    //   145: astore_3
    //   146: aload_0
    //   147: getfield 79	com/tencent/android/tpns/mqtt/internal/CommsCallback:runningSemaphore	Ljava/util/concurrent/Semaphore;
    //   150: invokevirtual 406	java/util/concurrent/Semaphore:release	()V
    //   153: goto -39 -> 114
    //   156: astore_3
    //   157: aload_2
    //   158: monitorexit
    //   159: aload_3
    //   160: athrow
    //   161: astore_3
    //   162: aload_0
    //   163: getfield 79	com/tencent/android/tpns/mqtt/internal/CommsCallback:runningSemaphore	Ljava/util/concurrent/Semaphore;
    //   166: invokevirtual 406	java/util/concurrent/Semaphore:release	()V
    //   169: aload_3
    //   170: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	171	0	this	CommsCallback
    //   63	2	1	bool	boolean
    //   4	154	2	localObject1	Object
    //   145	1	3	localInterruptedException	InterruptedException
    //   156	4	3	localObject3	Object
    //   161	9	3	localObject4	Object
    //   138	5	4	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   75	100	138	finally
    //   140	142	138	finally
    //   68	75	145	java/lang/InterruptedException
    //   100	107	145	java/lang/InterruptedException
    //   142	145	145	java/lang/InterruptedException
    //   7	25	156	finally
    //   25	64	156	finally
    //   107	114	156	finally
    //   114	137	156	finally
    //   146	153	156	finally
    //   157	159	156	finally
    //   162	171	156	finally
    //   68	75	161	finally
    //   100	107	161	finally
    //   142	145	161	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpns.mqtt.internal.CommsCallback
 * JD-Core Version:    0.7.0.1
 */