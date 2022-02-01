package com.tencent.android.tpns.mqtt.internal;

import com.tencent.android.tpns.mqtt.BufferedMessage;
import com.tencent.android.tpns.mqtt.IMqttActionListener;
import com.tencent.android.tpns.mqtt.IMqttAsyncClient;
import com.tencent.android.tpns.mqtt.IMqttMessageListener;
import com.tencent.android.tpns.mqtt.MqttCallback;
import com.tencent.android.tpns.mqtt.MqttCallbackExtended;
import com.tencent.android.tpns.mqtt.MqttClientPersistence;
import com.tencent.android.tpns.mqtt.MqttConnectOptions;
import com.tencent.android.tpns.mqtt.MqttDeliveryToken;
import com.tencent.android.tpns.mqtt.MqttException;
import com.tencent.android.tpns.mqtt.MqttMessage;
import com.tencent.android.tpns.mqtt.MqttPersistenceException;
import com.tencent.android.tpns.mqtt.MqttPingSender;
import com.tencent.android.tpns.mqtt.MqttToken;
import com.tencent.android.tpns.mqtt.MqttTopic;
import com.tencent.android.tpns.mqtt.internal.wire.MqttConnack;
import com.tencent.android.tpns.mqtt.internal.wire.MqttConnect;
import com.tencent.android.tpns.mqtt.internal.wire.MqttDisconnect;
import com.tencent.android.tpns.mqtt.internal.wire.MqttPublish;
import com.tencent.android.tpns.mqtt.internal.wire.MqttWireMessage;
import com.tencent.android.tpns.mqtt.logging.Logger;
import com.tencent.android.tpns.mqtt.logging.LoggerFactory;
import com.tencent.tpns.baseapi.base.logger.TBaseLogger;
import java.util.Enumeration;
import java.util.Properties;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

public class ClientComms
{
  public static String BUILD_LEVEL = "L${build.level}";
  private static final String CLASS_NAME = "ClientComms";
  private static final byte CLOSED = 4;
  private static final byte CONNECTED = 0;
  private static final byte CONNECTING = 1;
  private static final byte DISCONNECTED = 3;
  private static final byte DISCONNECTING = 2;
  private static final String TAG = "ClientComms";
  public static String VERSION = "${project.version}";
  private static final Logger log = LoggerFactory.getLogger("com.tencent.android.tpns.mqtt.internal.nls.logcat", "ClientComms");
  private CommsCallback callback;
  private IMqttAsyncClient client;
  private ClientState clientState;
  private boolean closePending = false;
  private Object conLock = new Object();
  private MqttConnectOptions conOptions;
  private byte conState = 3;
  private DisconnectedMessageBuffer disconnectedMessageBuffer;
  private ExecutorService executorService;
  private int networkModuleIndex;
  private NetworkModule[] networkModules;
  private MqttClientPersistence persistence;
  private MqttPingSender pingSender;
  private CommsReceiver receiver;
  private boolean resting = false;
  private CommsSender sender;
  private boolean stoppingComms = false;
  private CommsTokenStore tokenStore;
  
  public ClientComms(IMqttAsyncClient paramIMqttAsyncClient, MqttClientPersistence paramMqttClientPersistence, MqttPingSender paramMqttPingSender, ExecutorService paramExecutorService)
    throws MqttException
  {
    TBaseLogger.d("ClientComms", "init ClientComms");
    this.conState = 3;
    this.client = paramIMqttAsyncClient;
    this.persistence = paramMqttClientPersistence;
    this.pingSender = paramMqttPingSender;
    if (paramMqttPingSender != null) {
      this.pingSender.init(this);
    }
    this.executorService = paramExecutorService;
    this.tokenStore = new CommsTokenStore(getClient().getClientId());
    this.callback = new CommsCallback(this);
    this.clientState = new ClientState(paramMqttClientPersistence, this.tokenStore, this.callback, this, paramMqttPingSender);
    this.callback.setClientState(this.clientState);
    log.setResourceName(getClient().getClientId());
  }
  
  private MqttToken handleOldTokens(MqttToken paramMqttToken, MqttException paramMqttException)
  {
    log.fine("ClientComms", "handleOldTokens", "222");
    Enumeration localEnumeration = null;
    MqttToken localMqttToken = null;
    Object localObject;
    if (paramMqttToken != null) {
      localObject = localEnumeration;
    }
    for (;;)
    {
      try
      {
        if (this.tokenStore.getToken(paramMqttToken.internalTok.getKey()) == null)
        {
          localObject = localEnumeration;
          this.tokenStore.saveToken(paramMqttToken, paramMqttToken.internalTok.getKey());
        }
        localObject = localEnumeration;
        localEnumeration = this.clientState.resolveOldTokens(paramMqttException).elements();
        paramMqttToken = localMqttToken;
        localObject = paramMqttToken;
        paramMqttException = paramMqttToken;
        if (localEnumeration.hasMoreElements())
        {
          localObject = paramMqttToken;
          localMqttToken = (MqttToken)localEnumeration.nextElement();
          localObject = paramMqttToken;
          paramMqttException = localMqttToken;
          if (localMqttToken.internalTok.getKey().equals("Disc")) {
            break label184;
          }
          localObject = paramMqttToken;
          if (localMqttToken.internalTok.getKey().equals("Con"))
          {
            paramMqttException = localMqttToken;
          }
          else
          {
            localObject = paramMqttToken;
            if (this.callback != null)
            {
              localObject = paramMqttToken;
              this.callback.asyncOperationComplete(localMqttToken);
            }
            paramMqttException = paramMqttToken;
          }
        }
      }
      catch (Exception paramMqttToken)
      {
        paramMqttException = (MqttException)localObject;
      }
      return paramMqttException;
      label184:
      paramMqttToken = paramMqttException;
    }
  }
  
  private void handleRunException(Exception paramException)
  {
    log.fine("ClientComms", "handleRunException", "804", null, paramException);
    if (!(paramException instanceof MqttException)) {}
    for (paramException = new MqttException(32109, paramException);; paramException = (MqttException)paramException)
    {
      shutdownConnection(null, paramException);
      return;
    }
  }
  
  private void shutdownExecutorService()
  {
    this.executorService.shutdown();
    try
    {
      if (!this.executorService.awaitTermination(1L, TimeUnit.SECONDS))
      {
        this.executorService.shutdownNow();
        if (!this.executorService.awaitTermination(1L, TimeUnit.SECONDS)) {
          log.fine("ClientComms", "shutdownExecutorService", "executorService did not terminate");
        }
      }
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      this.executorService.shutdownNow();
      Thread.currentThread().interrupt();
    }
  }
  
  public MqttToken checkForActivity()
  {
    return checkForActivity(null);
  }
  
  public MqttToken checkForActivity(IMqttActionListener paramIMqttActionListener)
  {
    try
    {
      paramIMqttActionListener = this.clientState.checkForActivity(paramIMqttActionListener);
      return paramIMqttActionListener;
    }
    catch (MqttException paramIMqttActionListener)
    {
      handleRunException(paramIMqttActionListener);
      return null;
    }
    catch (Exception paramIMqttActionListener)
    {
      handleRunException(paramIMqttActionListener);
    }
    return null;
  }
  
  public void close(boolean paramBoolean)
    throws MqttException
  {
    for (;;)
    {
      synchronized (this.conLock)
      {
        if (!isClosed())
        {
          if ((!isDisconnected()) || (paramBoolean))
          {
            log.fine("ClientComms", "close", "224");
            if (isConnecting()) {
              TBaseLogger.e("ClientComms", "close when is isConnecting");
            }
          }
          else
          {
            this.conState = 4;
            shutdownExecutorService();
            this.clientState.close();
            this.clientState = null;
            this.callback = null;
            this.persistence = null;
            this.sender = null;
            this.pingSender = null;
            this.receiver = null;
            this.networkModules = null;
            this.conOptions = null;
            this.tokenStore = null;
          }
        }
        else {
          return;
        }
        if (isConnected()) {
          TBaseLogger.e("ClientComms", "close when is isConnected");
        }
      }
      if (isDisconnecting()) {
        this.closePending = true;
      }
    }
  }
  
  public void connect(MqttConnectOptions paramMqttConnectOptions, MqttToken paramMqttToken)
    throws MqttException
  {
    synchronized (this.conLock)
    {
      if ((isDisconnected()) && (!this.closePending))
      {
        log.fine("ClientComms", "connect", "214");
        this.conState = 1;
        this.conOptions = paramMqttConnectOptions;
        paramMqttConnectOptions = new MqttConnect(this.client.getClientId(), this.conOptions.getMqttVersion(), this.conOptions.isCleanSession(), this.conOptions.getKeepAliveInterval(), this.conOptions.getUserName(), this.conOptions.getPassword(), this.conOptions.getWillMessage(), this.conOptions.getWillDestination());
        this.clientState.setKeepAliveSecs(this.conOptions.getKeepAliveInterval());
        this.clientState.setCleanSession(this.conOptions.isCleanSession());
        this.clientState.setMaxInflight(this.conOptions.getMaxInflight());
        this.tokenStore.open();
        new ConnectBG(this, paramMqttToken, paramMqttConnectOptions, this.executorService).start();
        return;
      }
      log.fine("ClientComms", "connect", "207", new Object[] { new Byte(this.conState) });
      if ((isClosed()) || (this.closePending)) {
        throw new MqttException(32111);
      }
    }
    if (isConnecting()) {
      throw new MqttException(32110);
    }
    if (isDisconnecting()) {
      throw new MqttException(32102);
    }
    throw ExceptionHelper.createMqttException(32100);
  }
  
  public void connectComplete(MqttConnack paramMqttConnack, MqttException paramMqttException)
    throws MqttException
  {
    int i = paramMqttConnack.getReturnCode();
    paramMqttConnack = this.conLock;
    if (i == 0) {}
    try
    {
      log.fine("ClientComms", "connectComplete", "215");
      this.conState = 0;
      return;
    }
    finally {}
    log.fine("ClientComms", "connectComplete", "204", new Object[] { new Integer(i) });
    if (paramMqttException != null) {
      throw paramMqttException;
    }
  }
  
  public void deleteBufferedMessage(int paramInt)
  {
    this.disconnectedMessageBuffer.deleteMessage(paramInt);
  }
  
  protected void deliveryComplete(int paramInt)
    throws MqttPersistenceException
  {
    this.clientState.deliveryComplete(paramInt);
  }
  
  protected void deliveryComplete(MqttPublish paramMqttPublish)
    throws MqttPersistenceException
  {
    this.clientState.deliveryComplete(paramMqttPublish);
  }
  
  public void disconnect(MqttDisconnect paramMqttDisconnect, long paramLong, MqttToken paramMqttToken)
    throws MqttException
  {
    synchronized (this.conLock)
    {
      if (isClosed())
      {
        log.fine("ClientComms", "disconnect", "223");
        throw ExceptionHelper.createMqttException(32111);
      }
    }
    if (isDisconnected())
    {
      log.fine("ClientComms", "disconnect", "211");
      throw ExceptionHelper.createMqttException(32101);
    }
    if (isDisconnecting())
    {
      log.fine("ClientComms", "disconnect", "219");
      throw ExceptionHelper.createMqttException(32102);
    }
    if (Thread.currentThread() == this.callback.getThread()) {
      log.fine("ClientComms", "disconnect", "210");
    }
    log.fine("ClientComms", "disconnect", "218");
    this.conState = 2;
    new DisconnectBG(paramMqttDisconnect, paramLong, paramMqttToken, this.executorService).start();
  }
  
  public void disconnectForcibly(long paramLong1, long paramLong2)
    throws MqttException
  {
    disconnectForcibly(paramLong1, paramLong2, true);
  }
  
  /* Error */
  public void disconnectForcibly(long paramLong1, long paramLong2, boolean paramBoolean)
    throws MqttException
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 155	com/tencent/android/tpns/mqtt/internal/ClientComms:clientState	Lcom/tencent/android/tpns/mqtt/internal/ClientState;
    //   4: ifnull +11 -> 15
    //   7: aload_0
    //   8: getfield 155	com/tencent/android/tpns/mqtt/internal/ClientComms:clientState	Lcom/tencent/android/tpns/mqtt/internal/ClientState;
    //   11: lload_1
    //   12: invokevirtual 487	com/tencent/android/tpns/mqtt/internal/ClientState:quiesce	(J)V
    //   15: new 208	com/tencent/android/tpns/mqtt/MqttToken
    //   18: dup
    //   19: aload_0
    //   20: getfield 113	com/tencent/android/tpns/mqtt/internal/ClientComms:client	Lcom/tencent/android/tpns/mqtt/IMqttAsyncClient;
    //   23: invokeinterface 137 1 0
    //   28: invokespecial 488	com/tencent/android/tpns/mqtt/MqttToken:<init>	(Ljava/lang/String;)V
    //   31: astore 6
    //   33: iload 5
    //   35: ifeq +22 -> 57
    //   38: aload_0
    //   39: new 490	com/tencent/android/tpns/mqtt/internal/wire/MqttDisconnect
    //   42: dup
    //   43: invokespecial 491	com/tencent/android/tpns/mqtt/internal/wire/MqttDisconnect:<init>	()V
    //   46: aload 6
    //   48: invokevirtual 495	com/tencent/android/tpns/mqtt/internal/ClientComms:internalSend	(Lcom/tencent/android/tpns/mqtt/internal/wire/MqttWireMessage;Lcom/tencent/android/tpns/mqtt/MqttToken;)V
    //   51: aload 6
    //   53: lload_3
    //   54: invokevirtual 498	com/tencent/android/tpns/mqtt/MqttToken:waitForCompletion	(J)V
    //   57: aload 6
    //   59: getfield 212	com/tencent/android/tpns/mqtt/MqttToken:internalTok	Lcom/tencent/android/tpns/mqtt/internal/Token;
    //   62: aconst_null
    //   63: aconst_null
    //   64: invokevirtual 502	com/tencent/android/tpns/mqtt/internal/Token:markComplete	(Lcom/tencent/android/tpns/mqtt/internal/wire/MqttWireMessage;Lcom/tencent/android/tpns/mqtt/MqttException;)V
    //   67: aload_0
    //   68: aload 6
    //   70: aconst_null
    //   71: invokevirtual 274	com/tencent/android/tpns/mqtt/internal/ClientComms:shutdownConnection	(Lcom/tencent/android/tpns/mqtt/MqttToken;Lcom/tencent/android/tpns/mqtt/MqttException;)V
    //   74: return
    //   75: astore 7
    //   77: aload 6
    //   79: getfield 212	com/tencent/android/tpns/mqtt/MqttToken:internalTok	Lcom/tencent/android/tpns/mqtt/internal/Token;
    //   82: aconst_null
    //   83: aconst_null
    //   84: invokevirtual 502	com/tencent/android/tpns/mqtt/internal/Token:markComplete	(Lcom/tencent/android/tpns/mqtt/internal/wire/MqttWireMessage;Lcom/tencent/android/tpns/mqtt/MqttException;)V
    //   87: aload_0
    //   88: aload 6
    //   90: aconst_null
    //   91: invokevirtual 274	com/tencent/android/tpns/mqtt/internal/ClientComms:shutdownConnection	(Lcom/tencent/android/tpns/mqtt/MqttToken;Lcom/tencent/android/tpns/mqtt/MqttException;)V
    //   94: return
    //   95: astore 7
    //   97: aload 6
    //   99: getfield 212	com/tencent/android/tpns/mqtt/MqttToken:internalTok	Lcom/tencent/android/tpns/mqtt/internal/Token;
    //   102: aconst_null
    //   103: aconst_null
    //   104: invokevirtual 502	com/tencent/android/tpns/mqtt/internal/Token:markComplete	(Lcom/tencent/android/tpns/mqtt/internal/wire/MqttWireMessage;Lcom/tencent/android/tpns/mqtt/MqttException;)V
    //   107: aload_0
    //   108: aload 6
    //   110: aconst_null
    //   111: invokevirtual 274	com/tencent/android/tpns/mqtt/internal/ClientComms:shutdownConnection	(Lcom/tencent/android/tpns/mqtt/MqttToken;Lcom/tencent/android/tpns/mqtt/MqttException;)V
    //   114: aload 7
    //   116: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	117	0	this	ClientComms
    //   0	117	1	paramLong1	long
    //   0	117	3	paramLong2	long
    //   0	117	5	paramBoolean	boolean
    //   31	78	6	localMqttToken	MqttToken
    //   75	1	7	localThrowable	Throwable
    //   95	20	7	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   38	57	75	java/lang/Throwable
    //   38	57	95	finally
  }
  
  public int getActualInFlight()
  {
    return this.clientState.getActualInFlight();
  }
  
  public MqttMessage getBufferedMessage(int paramInt)
  {
    return ((MqttPublish)this.disconnectedMessageBuffer.getMessage(paramInt).getMessage()).getMessage();
  }
  
  public int getBufferedMessageCount()
  {
    return this.disconnectedMessageBuffer.getMessageCount();
  }
  
  public IMqttAsyncClient getClient()
  {
    return this.client;
  }
  
  public ClientState getClientState()
  {
    return this.clientState;
  }
  
  public MqttConnectOptions getConOptions()
  {
    return this.conOptions;
  }
  
  public Properties getDebug()
  {
    Properties localProperties = new Properties();
    localProperties.put("conState", new Integer(this.conState));
    localProperties.put("serverURI", getClient().getServerURI());
    localProperties.put("callback", this.callback);
    localProperties.put("stoppingComms", new Boolean(this.stoppingComms));
    return localProperties;
  }
  
  public long getKeepAlive()
  {
    return this.clientState.getKeepAlive();
  }
  
  public int getNetworkModuleIndex()
  {
    return this.networkModuleIndex;
  }
  
  public NetworkModule[] getNetworkModules()
  {
    return this.networkModules;
  }
  
  public MqttDeliveryToken[] getPendingDeliveryTokens()
  {
    return this.tokenStore.getOutstandingDelTokens();
  }
  
  CommsReceiver getReceiver()
  {
    return this.receiver;
  }
  
  protected MqttTopic getTopic(String paramString)
  {
    return new MqttTopic(paramString, this);
  }
  
  void internalSend(MqttWireMessage paramMqttWireMessage, MqttToken paramMqttToken)
    throws MqttException
  {
    TBaseLogger.d("ClientComms", "action - internalSend");
    log.fine("ClientComms", "internalSend", "200", new Object[] { paramMqttWireMessage.getKey(), paramMqttWireMessage, paramMqttToken });
    if (paramMqttToken.getClient() == null)
    {
      paramMqttToken.internalTok.setClient(getClient());
      if (this.clientState == null) {}
    }
    try
    {
      this.clientState.send(paramMqttWireMessage, paramMqttToken);
      return;
    }
    catch (MqttException paramMqttToken)
    {
      if (!(paramMqttWireMessage instanceof MqttPublish)) {
        break label143;
      }
      this.clientState.undo((MqttPublish)paramMqttWireMessage);
      throw paramMqttToken;
    }
    log.fine("ClientComms", "internalSend", "213", new Object[] { paramMqttWireMessage.getKey(), paramMqttWireMessage, paramMqttToken });
    throw new MqttException(32201);
  }
  
  public boolean isClosed()
  {
    for (;;)
    {
      synchronized (this.conLock)
      {
        if (this.conState == 4)
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }
  
  public boolean isConnected()
  {
    for (;;)
    {
      synchronized (this.conLock)
      {
        if (this.conState == 0)
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }
  
  public boolean isConnecting()
  {
    for (boolean bool = true;; bool = false) {
      synchronized (this.conLock)
      {
        if (this.conState == 1) {
          return bool;
        }
      }
    }
  }
  
  public boolean isDisconnected()
  {
    for (;;)
    {
      synchronized (this.conLock)
      {
        if (this.conState == 3)
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }
  
  public boolean isDisconnecting()
  {
    for (;;)
    {
      synchronized (this.conLock)
      {
        if (this.conState == 2)
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }
  
  public boolean isResting()
  {
    synchronized (this.conLock)
    {
      boolean bool = this.resting;
      return bool;
    }
  }
  
  public void messageArrivedComplete(int paramInt1, int paramInt2)
    throws MqttException
  {
    this.callback.messageArrivedComplete(paramInt1, paramInt2);
  }
  
  public void notifyConnect()
  {
    if (this.disconnectedMessageBuffer != null)
    {
      log.fine("ClientComms", "notifyConnect", "509");
      this.disconnectedMessageBuffer.setPublishCallback(new ReconnectDisconnectedBufferCallback("notifyConnect"));
      this.executorService.execute(this.disconnectedMessageBuffer);
    }
  }
  
  public void removeMessageListener(String paramString)
  {
    this.callback.removeMessageListener(paramString);
  }
  
  public void sendNoWait(MqttWireMessage paramMqttWireMessage, MqttToken paramMqttToken)
    throws MqttException
  {
    if ((isConnected()) || ((!isConnected()) && ((paramMqttWireMessage instanceof MqttConnect))) || ((isDisconnecting()) && ((paramMqttWireMessage instanceof MqttDisconnect))))
    {
      if ((this.disconnectedMessageBuffer != null) && (this.disconnectedMessageBuffer.getMessageCount() != 0))
      {
        log.fine("ClientComms", "sendNoWait", "507", new Object[] { paramMqttWireMessage.getKey() });
        if (this.disconnectedMessageBuffer.isPersistBuffer()) {
          this.clientState.persistBufferedMessage(paramMqttWireMessage);
        }
        this.disconnectedMessageBuffer.putMessage(paramMqttWireMessage, paramMqttToken);
        return;
      }
      internalSend(paramMqttWireMessage, paramMqttToken);
      return;
    }
    if (this.disconnectedMessageBuffer != null)
    {
      log.fine("ClientComms", "sendNoWait", "508", new Object[] { paramMqttWireMessage.getKey() });
      if (this.disconnectedMessageBuffer.isPersistBuffer()) {
        this.clientState.persistBufferedMessage(paramMqttWireMessage);
      }
      this.disconnectedMessageBuffer.putMessage(paramMqttWireMessage, paramMqttToken);
      return;
    }
    log.fine("ClientComms", "sendNoWait", "208");
    throw ExceptionHelper.createMqttException(32104);
  }
  
  public void setCallback(MqttCallback paramMqttCallback)
  {
    if (this.callback != null) {
      this.callback.setCallback(paramMqttCallback);
    }
  }
  
  public void setDisconnectedMessageBuffer(DisconnectedMessageBuffer paramDisconnectedMessageBuffer)
  {
    this.disconnectedMessageBuffer = paramDisconnectedMessageBuffer;
  }
  
  public void setManualAcks(boolean paramBoolean)
  {
    this.callback.setManualAcks(paramBoolean);
  }
  
  public void setMessageListener(String paramString, IMqttMessageListener paramIMqttMessageListener)
  {
    this.callback.setMessageListener(paramString, paramIMqttMessageListener);
  }
  
  public void setNetworkModuleIndex(int paramInt)
  {
    this.networkModuleIndex = paramInt;
  }
  
  public void setNetworkModules(NetworkModule[] paramArrayOfNetworkModule)
  {
    this.networkModules = paramArrayOfNetworkModule;
  }
  
  public void setReconnectCallback(MqttCallbackExtended paramMqttCallbackExtended)
  {
    this.callback.setReconnectCallback(paramMqttCallbackExtended);
  }
  
  public void setRestingState(boolean paramBoolean)
  {
    this.resting = paramBoolean;
  }
  
  public void shutdownConnection(MqttToken arg1, MqttException paramMqttException)
  {
    int k = 1;
    for (;;)
    {
      synchronized (this.conLock)
      {
        if ((this.stoppingComms) || (this.closePending) || (isClosed())) {
          return;
        }
        this.stoppingComms = true;
        log.fine("ClientComms", "shutdownConnection", "216");
        if (isConnected()) {
          break label435;
        }
        if (isDisconnecting())
        {
          break label435;
          this.conState = 2;
          if ((??? != null) && (!???.isComplete())) {
            ???.internalTok.setException(paramMqttException);
          }
          if (this.callback != null) {
            this.callback.stop();
          }
          if (this.receiver != null) {
            this.receiver.stop();
          }
        }
        try
        {
          if (this.networkModules != null)
          {
            ??? = this.networkModules[this.networkModuleIndex];
            if (??? != null) {
              ((NetworkModule)???).stop();
            }
          }
        }
        catch (Throwable localThrowable)
        {
          continue;
        }
        this.tokenStore.quiesce(new MqttException(32102));
        ??? = handleOldTokens(???, paramMqttException);
      }
      try
      {
        this.clientState.disconnected(paramMqttException);
        if ((this.callback != null) && (this.clientState.getCleanSession())) {
          this.callback.removeMessageListeners();
        }
        label216:
        if (this.sender != null) {
          this.sender.stop();
        }
        if (this.pingSender != null) {
          this.pingSender.stop();
        }
        try
        {
          if ((this.disconnectedMessageBuffer == null) && (this.persistence != null)) {
            this.persistence.close();
          }
          label269:
          int j;
          synchronized (this.conLock)
          {
            log.fine("ClientComms", "shutdownConnection", "217");
            this.conState = 3;
            this.stoppingComms = false;
            if (??? != null)
            {
              j = 1;
              label314:
              if (this.callback == null) {
                break label410;
              }
              if ((j & k) != 0) {
                this.callback.asyncOperationComplete(???);
              }
              if ((i != 0) && (this.callback != null)) {
                this.callback.connectionLost(paramMqttException);
              }
              synchronized (this.conLock)
              {
                boolean bool = this.closePending;
                if (!bool) {}
              }
            }
          }
          try
          {
            close(true);
            label379:
            return;
            paramMqttException = finally;
            throw paramMqttException;
            i = 0;
            continue;
            ??? = finally;
            throw ???;
            ??? = finally;
            throw ???;
            j = 0;
            break label314;
            label410:
            k = 0;
          }
          catch (Throwable paramMqttException)
          {
            break label379;
          }
        }
        catch (Exception localException1)
        {
          break label269;
        }
      }
      catch (Exception localException2)
      {
        break label216;
      }
      label435:
      int i = 1;
    }
  }
  
  class ConnectBG
    implements Runnable
  {
    ClientComms clientComms = null;
    MqttConnect conPacket;
    MqttToken conToken;
    private String threadName;
    
    ConnectBG(ClientComms paramClientComms, MqttToken paramMqttToken, MqttConnect paramMqttConnect, ExecutorService paramExecutorService)
    {
      this.clientComms = paramClientComms;
      this.conToken = paramMqttToken;
      this.conPacket = paramMqttConnect;
      this.threadName = ("MQTT Con: " + ClientComms.this.getClient().getClientId());
    }
    
    public void run()
    {
      MqttException localMqttException1 = null;
      TBaseLogger.dd("ClientComms", "ConnectBG mqtt thread");
      Thread.currentThread().setName(this.threadName);
      ClientComms.log.fine("ClientComms", "connectBG:run", "220");
      try
      {
        Object localObject = ClientComms.this.tokenStore.getOutstandingDelTokens();
        int i = 0;
        while (i < localObject.length)
        {
          localObject[i].internalTok.setException(null);
          i += 1;
        }
        ClientComms.this.tokenStore.saveToken(this.conToken, this.conPacket);
        localObject = ClientComms.this.networkModules[ClientComms.this.networkModuleIndex];
        ((NetworkModule)localObject).start();
        ClientComms.access$502(ClientComms.this, new CommsReceiver(this.clientComms, ClientComms.this.clientState, ClientComms.this.tokenStore, ((NetworkModule)localObject).getInputStream()));
        ClientComms.this.receiver.start("MQTT Rec: " + ClientComms.this.getClient().getClientId(), ClientComms.this.executorService);
        ClientComms.access$702(ClientComms.this, new CommsSender(this.clientComms, ClientComms.this.clientState, ClientComms.this.tokenStore, ((NetworkModule)localObject).getOutputStream()));
        ClientComms.this.sender.start("MQTT Snd: " + ClientComms.this.getClient().getClientId(), ClientComms.this.executorService);
        ClientComms.this.callback.start("MQTT Call: " + ClientComms.this.getClient().getClientId(), ClientComms.this.executorService);
        ClientComms.this.internalSend(this.conPacket, this.conToken);
      }
      catch (MqttException localMqttException2)
      {
        for (;;)
        {
          ClientComms.log.fine("ClientComms", "connectBG:run", "212", null, localMqttException2);
        }
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          ClientComms.log.fine("ClientComms", "connectBG:run", "209", null, localThrowable);
          MqttException localMqttException3 = ExceptionHelper.createMqttException(localThrowable);
        }
      }
      if (localMqttException1 != null) {
        ClientComms.this.shutdownConnection(this.conToken, localMqttException1);
      }
    }
    
    void start()
    {
      ClientComms.this.executorService.execute(this);
    }
  }
  
  class DisconnectBG
    implements Runnable
  {
    MqttDisconnect disconnect;
    long quiesceTimeout;
    private String threadName;
    MqttToken token;
    
    DisconnectBG(MqttDisconnect paramMqttDisconnect, long paramLong, MqttToken paramMqttToken, ExecutorService paramExecutorService)
    {
      this.disconnect = paramMqttDisconnect;
      this.quiesceTimeout = paramLong;
      this.token = paramMqttToken;
    }
    
    public void run()
    {
      Thread.currentThread().setName(this.threadName);
      ClientComms.log.fine("ClientComms", "disconnectBG:run", "221");
      TBaseLogger.i("disconnectBG:run", "disconnectBG:run");
      ClientComms.this.clientState.quiesce(this.quiesceTimeout);
      try
      {
        ClientComms.this.internalSend(this.disconnect, this.token);
        this.token.internalTok.waitUntilSent();
        return;
      }
      catch (Throwable localThrowable)
      {
        TBaseLogger.i("disconnectBG:run", "unexpected for disconnectBG:run-" + localThrowable.getMessage());
        return;
      }
      finally
      {
        this.token.internalTok.markComplete(null, null);
        ClientComms.this.shutdownConnection(this.token, null);
      }
    }
    
    void start()
    {
      this.threadName = ("MQTT Disc: " + ClientComms.this.getClient().getClientId());
      ClientComms.this.executorService.execute(this);
    }
  }
  
  class ReconnectDisconnectedBufferCallback
    implements IDisconnectedBufferCallback
  {
    final String methodName;
    
    ReconnectDisconnectedBufferCallback(String paramString)
    {
      this.methodName = paramString;
    }
    
    public void publishBufferedMessage(BufferedMessage paramBufferedMessage)
      throws MqttException
    {
      if (ClientComms.this.isConnected())
      {
        while (ClientComms.this.clientState.getActualInFlight() >= ClientComms.this.clientState.getMaxInFlight() - 1) {
          Thread.yield();
        }
        ClientComms.log.fine("ClientComms", this.methodName, "510", new Object[] { paramBufferedMessage.getMessage().getKey() });
        ClientComms.this.internalSend(paramBufferedMessage.getMessage(), paramBufferedMessage.getToken());
        ClientComms.this.clientState.unPersistBufferedMessage(paramBufferedMessage.getMessage());
        return;
      }
      ClientComms.log.fine("ClientComms", this.methodName, "208");
      throw ExceptionHelper.createMqttException(32104);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpns.mqtt.internal.ClientComms
 * JD-Core Version:    0.7.0.1
 */