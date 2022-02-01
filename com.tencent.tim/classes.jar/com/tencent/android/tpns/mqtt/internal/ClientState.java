package com.tencent.android.tpns.mqtt.internal;

import com.tencent.android.tpns.mqtt.IMqttActionListener;
import com.tencent.android.tpns.mqtt.IMqttAsyncClient;
import com.tencent.android.tpns.mqtt.MqttClientPersistence;
import com.tencent.android.tpns.mqtt.MqttDeliveryToken;
import com.tencent.android.tpns.mqtt.MqttException;
import com.tencent.android.tpns.mqtt.MqttMessage;
import com.tencent.android.tpns.mqtt.MqttPersistable;
import com.tencent.android.tpns.mqtt.MqttPersistenceException;
import com.tencent.android.tpns.mqtt.MqttPingSender;
import com.tencent.android.tpns.mqtt.MqttToken;
import com.tencent.android.tpns.mqtt.internal.wire.MqttAck;
import com.tencent.android.tpns.mqtt.internal.wire.MqttConnack;
import com.tencent.android.tpns.mqtt.internal.wire.MqttConnect;
import com.tencent.android.tpns.mqtt.internal.wire.MqttPingReq;
import com.tencent.android.tpns.mqtt.internal.wire.MqttPingResp;
import com.tencent.android.tpns.mqtt.internal.wire.MqttPubAck;
import com.tencent.android.tpns.mqtt.internal.wire.MqttPubComp;
import com.tencent.android.tpns.mqtt.internal.wire.MqttPubRec;
import com.tencent.android.tpns.mqtt.internal.wire.MqttPubRel;
import com.tencent.android.tpns.mqtt.internal.wire.MqttPublish;
import com.tencent.android.tpns.mqtt.internal.wire.MqttSuback;
import com.tencent.android.tpns.mqtt.internal.wire.MqttSubscribe;
import com.tencent.android.tpns.mqtt.internal.wire.MqttUnsubAck;
import com.tencent.android.tpns.mqtt.internal.wire.MqttUnsubscribe;
import com.tencent.android.tpns.mqtt.internal.wire.MqttWireMessage;
import com.tencent.android.tpns.mqtt.logging.Logger;
import com.tencent.android.tpns.mqtt.logging.LoggerFactory;
import com.tencent.tpns.baseapi.base.logger.TBaseLogger;
import java.io.EOFException;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Properties;
import java.util.Vector;

public class ClientState
{
  private static final String CLASS_NAME = "ClientState";
  private static final int MAX_MSG_ID = 65535;
  private static final int MIN_MSG_ID = 1;
  private static final String PERSISTENCE_CONFIRMED_PREFIX = "sc-";
  private static final String PERSISTENCE_RECEIVED_PREFIX = "r-";
  private static final String PERSISTENCE_SENT_BUFFERED_PREFIX = "sb-";
  private static final String PERSISTENCE_SENT_PREFIX = "s-";
  private static final Logger log = LoggerFactory.getLogger("com.tencent.android.tpns.mqtt.internal.nls.logcat", "ClientState");
  private int actualInFlight = 0;
  private CommsCallback callback = null;
  private boolean cleanSession;
  private ClientComms clientComms = null;
  private boolean connected = false;
  private int inFlightPubRels = 0;
  private Hashtable inUseMsgIds;
  private Hashtable inboundQoS2 = null;
  private long keepAlive;
  private long lastInboundActivity = 0L;
  private long lastOutboundActivity = 0L;
  private long lastPing = 0L;
  private int maxInflight = 0;
  private int nextMsgId = 0;
  private Hashtable outboundQoS0 = null;
  private Hashtable outboundQoS1 = null;
  private Hashtable outboundQoS2 = null;
  private volatile Vector pendingFlows;
  private volatile Vector pendingMessages;
  private MqttClientPersistence persistence;
  private MqttWireMessage pingCommand;
  private int pingOutstanding = 0;
  private Object pingOutstandingLock = new Object();
  private MqttPingSender pingSender = null;
  private Object queueLock = new Object();
  private Object quiesceLock = new Object();
  private boolean quiescing = false;
  private CommsTokenStore tokenStore;
  
  protected ClientState(MqttClientPersistence paramMqttClientPersistence, CommsTokenStore paramCommsTokenStore, CommsCallback paramCommsCallback, ClientComms paramClientComms, MqttPingSender paramMqttPingSender)
    throws MqttException
  {
    log.setResourceName(paramClientComms.getClient().getClientId());
    log.finer("ClientState", "<Init>", "");
    this.inUseMsgIds = new Hashtable();
    this.pendingFlows = new Vector();
    this.outboundQoS2 = new Hashtable();
    this.outboundQoS1 = new Hashtable();
    this.outboundQoS0 = new Hashtable();
    this.inboundQoS2 = new Hashtable();
    this.pingCommand = new MqttPingReq();
    this.inFlightPubRels = 0;
    this.actualInFlight = 0;
    this.persistence = paramMqttClientPersistence;
    this.callback = paramCommsCallback;
    this.tokenStore = paramCommsTokenStore;
    this.clientComms = paramClientComms;
    this.pingSender = paramMqttPingSender;
    restoreState();
  }
  
  private void decrementInFlight()
  {
    synchronized (this.queueLock)
    {
      this.actualInFlight -= 1;
      log.fine("ClientState", "decrementInFlight", "646", new Object[] { new Integer(this.actualInFlight) });
      if (!checkQuiesceLock()) {
        this.queueLock.notifyAll();
      }
      return;
    }
  }
  
  private int getNextMessageId()
    throws MqttException
  {
    do
    {
      try
      {
        int k = this.nextMsgId;
        j = 0;
        this.nextMsgId += 1;
        if (this.nextMsgId > 65535) {
          this.nextMsgId = 1;
        }
        i = j;
        if (this.nextMsgId == k)
        {
          j += 1;
          i = j;
          if (j == 2) {
            throw ExceptionHelper.createMqttException(32001);
          }
        }
      }
      finally {}
      int j = i;
    } while (this.inUseMsgIds.containsKey(new Integer(this.nextMsgId)));
    Integer localInteger = new Integer(this.nextMsgId);
    this.inUseMsgIds.put(localInteger, localInteger);
    int i = this.nextMsgId;
    return i;
  }
  
  private String getReceivedPersistenceKey(int paramInt)
  {
    return "r-" + paramInt;
  }
  
  private String getReceivedPersistenceKey(MqttWireMessage paramMqttWireMessage)
  {
    return "r-" + paramMqttWireMessage.getMessageId();
  }
  
  private String getSendBufferedPersistenceKey(MqttWireMessage paramMqttWireMessage)
  {
    return "sb-" + paramMqttWireMessage.getMessageId();
  }
  
  private String getSendConfirmPersistenceKey(MqttWireMessage paramMqttWireMessage)
  {
    return "sc-" + paramMqttWireMessage.getMessageId();
  }
  
  private String getSendPersistenceKey(MqttWireMessage paramMqttWireMessage)
  {
    return "s-" + paramMqttWireMessage.getMessageId();
  }
  
  private void insertInOrder(Vector paramVector, MqttWireMessage paramMqttWireMessage)
  {
    int j = paramMqttWireMessage.getMessageId();
    int i = 0;
    while (i < paramVector.size())
    {
      if (((MqttWireMessage)paramVector.elementAt(i)).getMessageId() > j)
      {
        paramVector.insertElementAt(paramMqttWireMessage, i);
        return;
      }
      i += 1;
    }
    paramVector.addElement(paramMqttWireMessage);
  }
  
  private Vector reOrder(Vector paramVector)
  {
    int i1 = 0;
    Vector localVector = new Vector();
    if (paramVector.size() == 0) {
      return localVector;
    }
    int i = 0;
    int j = 0;
    int k = 0;
    int m = 0;
    while (i < paramVector.size())
    {
      int i2 = ((MqttWireMessage)paramVector.elementAt(i)).getMessageId();
      int n = k;
      if (i2 - m > k)
      {
        n = i2 - m;
        j = i;
      }
      i += 1;
      m = i2;
      k = n;
    }
    if (((MqttWireMessage)paramVector.elementAt(0)).getMessageId() + (65535 - m) > k) {
      j = 0;
    }
    i = j;
    for (;;)
    {
      k = i1;
      if (i >= paramVector.size()) {
        break;
      }
      localVector.addElement(paramVector.elementAt(i));
      i += 1;
    }
    while (k < j)
    {
      localVector.addElement(paramVector.elementAt(k));
      k += 1;
    }
    return localVector;
  }
  
  private void releaseMessageId(int paramInt)
  {
    try
    {
      this.inUseMsgIds.remove(new Integer(paramInt));
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void restoreInflightMessages()
  {
    this.pendingMessages = new Vector(this.maxInflight);
    this.pendingFlows = new Vector();
    Enumeration localEnumeration = this.outboundQoS2.keys();
    Object localObject1;
    Object localObject2;
    while (localEnumeration.hasMoreElements())
    {
      localObject1 = localEnumeration.nextElement();
      localObject2 = (MqttWireMessage)this.outboundQoS2.get(localObject1);
      if ((localObject2 instanceof MqttPublish))
      {
        log.fine("ClientState", "restoreInflightMessages", "610", new Object[] { localObject1 });
        ((MqttWireMessage)localObject2).setDuplicate(true);
        insertInOrder(this.pendingMessages, (MqttPublish)localObject2);
      }
      else if ((localObject2 instanceof MqttPubRel))
      {
        log.fine("ClientState", "restoreInflightMessages", "611", new Object[] { localObject1 });
        insertInOrder(this.pendingFlows, (MqttPubRel)localObject2);
      }
    }
    localEnumeration = this.outboundQoS1.keys();
    while (localEnumeration.hasMoreElements())
    {
      localObject1 = localEnumeration.nextElement();
      localObject2 = (MqttPublish)this.outboundQoS1.get(localObject1);
      ((MqttPublish)localObject2).setDuplicate(true);
      log.fine("ClientState", "restoreInflightMessages", "612", new Object[] { localObject1 });
      insertInOrder(this.pendingMessages, (MqttWireMessage)localObject2);
    }
    localEnumeration = this.outboundQoS0.keys();
    while (localEnumeration.hasMoreElements())
    {
      localObject1 = localEnumeration.nextElement();
      localObject2 = (MqttPublish)this.outboundQoS0.get(localObject1);
      log.fine("ClientState", "restoreInflightMessages", "512", new Object[] { localObject1 });
      insertInOrder(this.pendingMessages, (MqttWireMessage)localObject2);
    }
    this.pendingFlows = reOrder(this.pendingFlows);
    this.pendingMessages = reOrder(this.pendingMessages);
  }
  
  private MqttWireMessage restoreMessage(String paramString, MqttPersistable paramMqttPersistable)
    throws MqttException
  {
    Object localObject = null;
    try
    {
      paramMqttPersistable = MqttWireMessage.createWireMessage(paramMqttPersistable);
      log.fine("ClientState", "restoreMessage", "601", new Object[] { paramString, paramMqttPersistable });
      return paramMqttPersistable;
    }
    catch (Throwable paramMqttPersistable)
    {
      for (;;)
      {
        TBaseLogger.e("ClientState", "restoreMessage", paramMqttPersistable);
        if (!(paramMqttPersistable.getCause() instanceof EOFException)) {
          break;
        }
        paramMqttPersistable = localObject;
        if (paramString != null)
        {
          this.persistence.remove(paramString);
          paramMqttPersistable = localObject;
        }
      }
      throw paramMqttPersistable;
    }
  }
  
  public MqttToken checkForActivity(IMqttActionListener paramIMqttActionListener)
    throws MqttException
  {
    log.fine("ClientState", "checkForActivity", "616", new Object[0]);
    Object localObject2;
    long l;
    synchronized (this.quiesceLock)
    {
      if (this.quiescing) {
        return null;
      }
      ??? = null;
      localObject2 = null;
      getKeepAlive();
      ??? = ???;
      if (!this.connected) {
        break label610;
      }
      ??? = ???;
      if (this.keepAlive <= 0L) {
        break label610;
      }
      l = System.currentTimeMillis();
      synchronized (this.pingOutstandingLock)
      {
        if ((this.pingOutstanding > 0) && (l - this.lastInboundActivity >= this.keepAlive + 100))
        {
          log.severe("ClientState", "checkForActivity", "619", new Object[] { new Long(this.keepAlive), new Long(this.lastOutboundActivity), new Long(this.lastInboundActivity), new Long(l), new Long(this.lastPing) });
          throw ExceptionHelper.createMqttException(32000);
        }
      }
    }
    if ((this.pingOutstanding == 0) && (l - this.lastOutboundActivity >= 2L * this.keepAlive))
    {
      log.severe("ClientState", "checkForActivity", "642", new Object[] { new Long(this.keepAlive), new Long(this.lastOutboundActivity), new Long(this.lastInboundActivity), new Long(l), new Long(this.lastPing) });
      throw ExceptionHelper.createMqttException(32002);
    }
    if (((this.pingOutstanding == 0) && (l - this.lastInboundActivity >= this.keepAlive - 100)) || (l - this.lastOutboundActivity >= this.keepAlive - 100))
    {
      log.fine("ClientState", "checkForActivity", "620", new Object[] { new Long(this.keepAlive), new Long(this.lastOutboundActivity), new Long(this.lastInboundActivity) });
      ??? = new MqttToken(this.clientComms.getClient().getClientId());
      if (paramIMqttActionListener != null) {
        ((MqttToken)???).setActionCallback(paramIMqttActionListener);
      }
      this.tokenStore.saveToken((MqttToken)???, this.pingCommand);
      this.pendingFlows.insertElementAt(this.pingCommand, 0);
      l = getKeepAlive();
      notifyQueueLock();
    }
    for (paramIMqttActionListener = (IMqttActionListener)???;; paramIMqttActionListener = localObject2)
    {
      log.fine("ClientState", "checkForActivity", "624", new Object[] { new Long(l) });
      ??? = paramIMqttActionListener;
      if (this.pingSender == null) {
        break;
      }
      this.pingSender.schedule(l);
      return paramIMqttActionListener;
      log.fine("ClientState", "checkForActivity", "634", null);
      l = Math.max(1L, getKeepAlive() - (l - this.lastOutboundActivity));
    }
    label610:
    return ???;
  }
  
  protected boolean checkQuiesceLock()
  {
    int i = this.tokenStore.count();
    if ((this.quiescing) && (i == 0) && (this.pendingFlows.size() == 0) && (this.callback.isQuiesced())) {
      synchronized (this.quiesceLock)
      {
        this.quiesceLock.notifyAll();
        return true;
      }
    }
    return false;
  }
  
  protected void clearState()
    throws MqttException
  {
    log.fine("ClientState", "clearState", ">");
    this.persistence.clear();
    this.inUseMsgIds.clear();
    this.pendingMessages.clear();
    this.pendingFlows.clear();
    this.outboundQoS2.clear();
    this.outboundQoS1.clear();
    this.outboundQoS0.clear();
    this.inboundQoS2.clear();
    this.tokenStore.clear();
  }
  
  protected void close()
  {
    this.inUseMsgIds.clear();
    if (this.pendingMessages != null) {
      this.pendingMessages.clear();
    }
    this.pendingFlows.clear();
    this.outboundQoS2.clear();
    this.outboundQoS1.clear();
    this.outboundQoS0.clear();
    this.inboundQoS2.clear();
    this.tokenStore.clear();
    this.inUseMsgIds = null;
    this.pendingMessages = null;
    this.pendingFlows = null;
    this.outboundQoS2 = null;
    this.outboundQoS1 = null;
    this.outboundQoS0 = null;
    this.inboundQoS2 = null;
    this.tokenStore = null;
    this.callback = null;
    this.clientComms = null;
    this.persistence = null;
    this.pingCommand = null;
  }
  
  public void connected()
  {
    log.fine("ClientState", "connected", "631");
    this.connected = true;
    if (this.pingSender != null) {
      this.pingSender.start();
    }
  }
  
  protected void deliveryComplete(int paramInt)
    throws MqttPersistenceException
  {
    log.fine("ClientState", "deliveryComplete", "641", new Object[] { new Integer(paramInt) });
    this.persistence.remove(getReceivedPersistenceKey(paramInt));
    this.inboundQoS2.remove(new Integer(paramInt));
  }
  
  protected void deliveryComplete(MqttPublish paramMqttPublish)
    throws MqttPersistenceException
  {
    log.fine("ClientState", "deliveryComplete", "641", new Object[] { new Integer(paramMqttPublish.getMessageId()) });
    this.persistence.remove(getReceivedPersistenceKey(paramMqttPublish));
    this.inboundQoS2.remove(new Integer(paramMqttPublish.getMessageId()));
  }
  
  public void disconnected(MqttException arg1)
  {
    log.fine("ClientState", "disconnected", "633", new Object[] { ??? });
    this.connected = false;
    try
    {
      if (this.cleanSession) {
        clearState();
      }
      this.pendingMessages.clear();
      this.pendingFlows.clear();
      synchronized (this.pingOutstandingLock)
      {
        this.pingOutstanding = 0;
        return;
      }
      return;
    }
    catch (Throwable ???) {}
  }
  
  /* Error */
  protected MqttWireMessage get()
    throws MqttException
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 99	com/tencent/android/tpns/mqtt/internal/ClientState:queueLock	Ljava/lang/Object;
    //   4: astore 4
    //   6: aload 4
    //   8: monitorenter
    //   9: aconst_null
    //   10: astore_3
    //   11: aload_3
    //   12: ifnonnull +336 -> 348
    //   15: aload_0
    //   16: getfield 262	com/tencent/android/tpns/mqtt/internal/ClientState:pendingMessages	Ljava/util/Vector;
    //   19: invokevirtual 445	java/util/Vector:isEmpty	()Z
    //   22: ifeq +13 -> 35
    //   25: aload_0
    //   26: getfield 161	com/tencent/android/tpns/mqtt/internal/ClientState:pendingFlows	Ljava/util/Vector;
    //   29: invokevirtual 445	java/util/Vector:isEmpty	()Z
    //   32: ifne +28 -> 60
    //   35: aload_0
    //   36: getfield 161	com/tencent/android/tpns/mqtt/internal/ClientState:pendingFlows	Ljava/util/Vector;
    //   39: invokevirtual 445	java/util/Vector:isEmpty	()Z
    //   42: ifeq +57 -> 99
    //   45: aload_0
    //   46: getfield 95	com/tencent/android/tpns/mqtt/internal/ClientState:actualInFlight	I
    //   49: istore_1
    //   50: aload_0
    //   51: getfield 93	com/tencent/android/tpns/mqtt/internal/ClientState:maxInflight	I
    //   54: istore_2
    //   55: iload_1
    //   56: iload_2
    //   57: if_icmplt +42 -> 99
    //   60: getstatic 78	com/tencent/android/tpns/mqtt/internal/ClientState:log	Lcom/tencent/android/tpns/mqtt/logging/Logger;
    //   63: ldc 8
    //   65: ldc_w 446
    //   68: ldc_w 448
    //   71: invokeinterface 405 4 0
    //   76: aload_0
    //   77: getfield 99	com/tencent/android/tpns/mqtt/internal/ClientState:queueLock	Ljava/lang/Object;
    //   80: invokevirtual 451	java/lang/Object:wait	()V
    //   83: getstatic 78	com/tencent/android/tpns/mqtt/internal/ClientState:log	Lcom/tencent/android/tpns/mqtt/logging/Logger;
    //   86: ldc 8
    //   88: ldc_w 446
    //   91: ldc_w 453
    //   94: invokeinterface 405 4 0
    //   99: aload_0
    //   100: getfield 115	com/tencent/android/tpns/mqtt/internal/ClientState:connected	Z
    //   103: ifne +51 -> 154
    //   106: aload_0
    //   107: getfield 161	com/tencent/android/tpns/mqtt/internal/ClientState:pendingFlows	Ljava/util/Vector;
    //   110: invokevirtual 445	java/util/Vector:isEmpty	()Z
    //   113: ifne +20 -> 133
    //   116: aload_0
    //   117: getfield 161	com/tencent/android/tpns/mqtt/internal/ClientState:pendingFlows	Ljava/util/Vector;
    //   120: iconst_0
    //   121: invokevirtual 243	java/util/Vector:elementAt	(I)Ljava/lang/Object;
    //   124: checkcast 228	com/tencent/android/tpns/mqtt/internal/wire/MqttWireMessage
    //   127: instanceof 455
    //   130: ifne +24 -> 154
    //   133: getstatic 78	com/tencent/android/tpns/mqtt/internal/ClientState:log	Lcom/tencent/android/tpns/mqtt/logging/Logger;
    //   136: ldc 8
    //   138: ldc_w 446
    //   141: ldc_w 457
    //   144: invokeinterface 405 4 0
    //   149: aload 4
    //   151: monitorexit
    //   152: aconst_null
    //   153: areturn
    //   154: aload_0
    //   155: getfield 161	com/tencent/android/tpns/mqtt/internal/ClientState:pendingFlows	Ljava/util/Vector;
    //   158: invokevirtual 445	java/util/Vector:isEmpty	()Z
    //   161: ifne +74 -> 235
    //   164: aload_0
    //   165: getfield 161	com/tencent/android/tpns/mqtt/internal/ClientState:pendingFlows	Ljava/util/Vector;
    //   168: iconst_0
    //   169: invokevirtual 459	java/util/Vector:remove	(I)Ljava/lang/Object;
    //   172: checkcast 228	com/tencent/android/tpns/mqtt/internal/wire/MqttWireMessage
    //   175: astore_3
    //   176: aload_3
    //   177: instanceof 291
    //   180: ifeq +47 -> 227
    //   183: aload_0
    //   184: aload_0
    //   185: getfield 97	com/tencent/android/tpns/mqtt/internal/ClientState:inFlightPubRels	I
    //   188: iconst_1
    //   189: iadd
    //   190: putfield 97	com/tencent/android/tpns/mqtt/internal/ClientState:inFlightPubRels	I
    //   193: getstatic 78	com/tencent/android/tpns/mqtt/internal/ClientState:log	Lcom/tencent/android/tpns/mqtt/logging/Logger;
    //   196: ldc 8
    //   198: ldc_w 446
    //   201: ldc_w 461
    //   204: iconst_1
    //   205: anewarray 4	java/lang/Object
    //   208: dup
    //   209: iconst_0
    //   210: new 180	java/lang/Integer
    //   213: dup
    //   214: aload_0
    //   215: getfield 97	com/tencent/android/tpns/mqtt/internal/ClientState:inFlightPubRels	I
    //   218: invokespecial 183	java/lang/Integer:<init>	(I)V
    //   221: aastore
    //   222: invokeinterface 187 5 0
    //   227: aload_0
    //   228: invokevirtual 191	com/tencent/android/tpns/mqtt/internal/ClientState:checkQuiesceLock	()Z
    //   231: pop
    //   232: goto -221 -> 11
    //   235: aload_0
    //   236: getfield 262	com/tencent/android/tpns/mqtt/internal/ClientState:pendingMessages	Ljava/util/Vector;
    //   239: invokevirtual 445	java/util/Vector:isEmpty	()Z
    //   242: ifne -231 -> 11
    //   245: aload_0
    //   246: getfield 95	com/tencent/android/tpns/mqtt/internal/ClientState:actualInFlight	I
    //   249: aload_0
    //   250: getfield 93	com/tencent/android/tpns/mqtt/internal/ClientState:maxInflight	I
    //   253: if_icmpge +70 -> 323
    //   256: aload_0
    //   257: getfield 262	com/tencent/android/tpns/mqtt/internal/ClientState:pendingMessages	Ljava/util/Vector;
    //   260: iconst_0
    //   261: invokevirtual 243	java/util/Vector:elementAt	(I)Ljava/lang/Object;
    //   264: checkcast 228	com/tencent/android/tpns/mqtt/internal/wire/MqttWireMessage
    //   267: astore_3
    //   268: aload_0
    //   269: getfield 262	com/tencent/android/tpns/mqtt/internal/ClientState:pendingMessages	Ljava/util/Vector;
    //   272: iconst_0
    //   273: invokevirtual 464	java/util/Vector:removeElementAt	(I)V
    //   276: aload_0
    //   277: aload_0
    //   278: getfield 95	com/tencent/android/tpns/mqtt/internal/ClientState:actualInFlight	I
    //   281: iconst_1
    //   282: iadd
    //   283: putfield 95	com/tencent/android/tpns/mqtt/internal/ClientState:actualInFlight	I
    //   286: getstatic 78	com/tencent/android/tpns/mqtt/internal/ClientState:log	Lcom/tencent/android/tpns/mqtt/logging/Logger;
    //   289: ldc 8
    //   291: ldc_w 446
    //   294: ldc_w 466
    //   297: iconst_1
    //   298: anewarray 4	java/lang/Object
    //   301: dup
    //   302: iconst_0
    //   303: new 180	java/lang/Integer
    //   306: dup
    //   307: aload_0
    //   308: getfield 95	com/tencent/android/tpns/mqtt/internal/ClientState:actualInFlight	I
    //   311: invokespecial 183	java/lang/Integer:<init>	(I)V
    //   314: aastore
    //   315: invokeinterface 187 5 0
    //   320: goto -309 -> 11
    //   323: getstatic 78	com/tencent/android/tpns/mqtt/internal/ClientState:log	Lcom/tencent/android/tpns/mqtt/logging/Logger;
    //   326: ldc 8
    //   328: ldc_w 446
    //   331: ldc_w 468
    //   334: invokeinterface 405 4 0
    //   339: goto -328 -> 11
    //   342: astore_3
    //   343: aload 4
    //   345: monitorexit
    //   346: aload_3
    //   347: athrow
    //   348: aload 4
    //   350: monitorexit
    //   351: aload_3
    //   352: areturn
    //   353: astore 5
    //   355: goto -256 -> 99
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	358	0	this	ClientState
    //   49	9	1	i	int
    //   54	4	2	j	int
    //   10	258	3	localMqttWireMessage1	MqttWireMessage
    //   342	10	3	localMqttWireMessage2	MqttWireMessage
    //   4	345	4	localObject	Object
    //   353	1	5	localInterruptedException	java.lang.InterruptedException
    // Exception table:
    //   from	to	target	type
    //   15	35	342	finally
    //   35	55	342	finally
    //   60	99	342	finally
    //   99	133	342	finally
    //   133	152	342	finally
    //   154	227	342	finally
    //   227	232	342	finally
    //   235	320	342	finally
    //   323	339	342	finally
    //   343	346	342	finally
    //   348	351	342	finally
    //   60	99	353	java/lang/InterruptedException
  }
  
  public int getActualInFlight()
  {
    return this.actualInFlight;
  }
  
  protected boolean getCleanSession()
  {
    return this.cleanSession;
  }
  
  public Properties getDebug()
  {
    Properties localProperties = new Properties();
    localProperties.put("In use msgids", this.inUseMsgIds);
    localProperties.put("pendingMessages", this.pendingMessages);
    localProperties.put("pendingFlows", this.pendingFlows);
    localProperties.put("maxInflight", new Integer(this.maxInflight));
    localProperties.put("nextMsgID", new Integer(this.nextMsgId));
    localProperties.put("actualInFlight", new Integer(this.actualInFlight));
    localProperties.put("inFlightPubRels", new Integer(this.inFlightPubRels));
    localProperties.put("quiescing", Boolean.valueOf(this.quiescing));
    localProperties.put("pingoutstanding", new Integer(this.pingOutstanding));
    localProperties.put("lastOutboundActivity", new Long(this.lastOutboundActivity));
    localProperties.put("lastInboundActivity", new Long(this.lastInboundActivity));
    localProperties.put("outboundQoS2", this.outboundQoS2);
    localProperties.put("outboundQoS1", this.outboundQoS1);
    localProperties.put("outboundQoS0", this.outboundQoS0);
    localProperties.put("inboundQoS2", this.inboundQoS2);
    localProperties.put("tokens", this.tokenStore);
    return localProperties;
  }
  
  protected long getKeepAlive()
  {
    return this.keepAlive;
  }
  
  public int getMaxInFlight()
  {
    return this.maxInflight;
  }
  
  protected void notifyComplete(MqttToken paramMqttToken)
    throws MqttException
  {
    MqttWireMessage localMqttWireMessage = paramMqttToken.internalTok.getWireMessage();
    if ((localMqttWireMessage != null) && ((localMqttWireMessage instanceof MqttAck)))
    {
      log.fine("ClientState", "notifyComplete", "629", new Object[] { new Integer(localMqttWireMessage.getMessageId()), paramMqttToken, localMqttWireMessage });
      paramMqttToken = (MqttAck)localMqttWireMessage;
      if (!(paramMqttToken instanceof MqttPubAck)) {
        break label181;
      }
      this.persistence.remove(getSendPersistenceKey(localMqttWireMessage));
      this.persistence.remove(getSendBufferedPersistenceKey(localMqttWireMessage));
      this.outboundQoS1.remove(new Integer(paramMqttToken.getMessageId()));
      decrementInFlight();
      releaseMessageId(localMqttWireMessage.getMessageId());
      this.tokenStore.removeToken(localMqttWireMessage);
      log.fine("ClientState", "notifyComplete", "650", new Object[] { new Integer(paramMqttToken.getMessageId()) });
    }
    for (;;)
    {
      checkQuiesceLock();
      return;
      label181:
      if ((paramMqttToken instanceof MqttPubComp))
      {
        this.persistence.remove(getSendPersistenceKey(localMqttWireMessage));
        this.persistence.remove(getSendConfirmPersistenceKey(localMqttWireMessage));
        this.persistence.remove(getSendBufferedPersistenceKey(localMqttWireMessage));
        this.outboundQoS2.remove(new Integer(paramMqttToken.getMessageId()));
        this.inFlightPubRels -= 1;
        decrementInFlight();
        releaseMessageId(localMqttWireMessage.getMessageId());
        this.tokenStore.removeToken(localMqttWireMessage);
        log.fine("ClientState", "notifyComplete", "645", new Object[] { new Integer(paramMqttToken.getMessageId()), new Integer(this.inFlightPubRels) });
      }
    }
  }
  
  public void notifyQueueLock()
  {
    synchronized (this.queueLock)
    {
      log.fine("ClientState", "notifyQueueLock", "638");
      this.queueLock.notifyAll();
      return;
    }
  }
  
  protected void notifyReceivedAck(MqttAck arg1)
    throws MqttException
  {
    this.lastInboundActivity = System.currentTimeMillis();
    log.fine("ClientState", "notifyReceivedAck", "627", new Object[] { new Integer(???.getMessageId()), ??? });
    MqttToken localMqttToken1 = this.tokenStore.getToken(???);
    if (localMqttToken1 == null) {
      log.fine("ClientState", "notifyReceivedAck", "662", new Object[] { new Integer(???.getMessageId()) });
    }
    for (;;)
    {
      checkQuiesceLock();
      return;
      if ((??? instanceof MqttPubRec))
      {
        log.fine("ClientState", "notifyReceivedAck", "663", new Object[] { new Integer(???.getMessageId()) });
        send(new MqttPubRel((MqttPubRec)???), localMqttToken1);
      }
      else if (((??? instanceof MqttPubAck)) || ((??? instanceof MqttPubComp)))
      {
        notifyResult(???, localMqttToken1, null);
      }
      else
      {
        if ((??? instanceof MqttPingResp))
        {
          log.fine("ClientState", "notifyReceivedAck", "664", new Object[] { new Integer(???.getMessageId()) });
          synchronized (this.pingOutstandingLock)
          {
            this.pingOutstanding = Math.max(0, this.pingOutstanding - 1);
            notifyResult(???, localMqttToken1, null);
            if (this.pingOutstanding == 0) {
              this.tokenStore.removeToken(???);
            }
          }
        }
        if ((??? instanceof MqttConnack))
        {
          log.fine("ClientState", "notifyReceivedAck", "665", new Object[] { new Integer(???.getMessageId()) });
          int i = ((MqttConnack)???).getReturnCode();
          if (i == 0) {
            synchronized (this.queueLock)
            {
              if (this.cleanSession)
              {
                clearState();
                this.tokenStore.saveToken(localMqttToken1, ???);
              }
              this.inFlightPubRels = 0;
              this.actualInFlight = 0;
              restoreInflightMessages();
              connected();
              this.clientComms.connectComplete((MqttConnack)???, null);
              notifyResult(???, localMqttToken1, null);
              this.tokenStore.removeToken(???);
              synchronized (this.queueLock)
              {
                this.queueLock.notifyAll();
              }
            }
          }
          throw ExceptionHelper.createMqttException(i);
        }
        log.fine("ClientState", "notifyReceivedAck", "666", new Object[] { new Integer(???.getMessageId()) });
        notifyResult(???, localMqttToken2, null);
        releaseMessageId(???.getMessageId());
        this.tokenStore.removeToken(???);
      }
    }
  }
  
  public void notifyReceivedBytes(int paramInt)
  {
    if (paramInt > 0) {
      this.lastInboundActivity = System.currentTimeMillis();
    }
    log.fine("ClientState", "notifyReceivedBytes", "630", new Object[] { new Integer(paramInt) });
  }
  
  protected void notifyReceivedMsg(MqttWireMessage paramMqttWireMessage)
    throws MqttException
  {
    TBaseLogger.d("ClientState", "action - notifyReceivedMsg:" + paramMqttWireMessage.toString());
    this.lastInboundActivity = System.currentTimeMillis();
    log.fine("ClientState", "notifyReceivedMsg", "651", new Object[] { new Integer(paramMqttWireMessage.getMessageId()), paramMqttWireMessage });
    MqttPublish localMqttPublish;
    if (!this.quiescing)
    {
      if (!(paramMqttWireMessage instanceof MqttPublish)) {
        break label193;
      }
      localMqttPublish = (MqttPublish)paramMqttWireMessage;
      switch (localMqttPublish.getMessage().getQos())
      {
      }
    }
    label193:
    do
    {
      do
      {
        do
        {
          return;
        } while (this.callback == null);
        this.callback.messageArrived(localMqttPublish);
        return;
        this.persistence.put(getReceivedPersistenceKey(paramMqttWireMessage), (MqttPublish)paramMqttWireMessage);
        this.inboundQoS2.put(new Integer(localMqttPublish.getMessageId()), localMqttPublish);
        send(new MqttPubRec(localMqttPublish), null);
        return;
      } while (!(paramMqttWireMessage instanceof MqttPubRel));
      localMqttPublish = (MqttPublish)this.inboundQoS2.get(new Integer(paramMqttWireMessage.getMessageId()));
      if (localMqttPublish == null) {
        break;
      }
    } while (this.callback == null);
    this.callback.messageArrived(localMqttPublish);
    return;
    send(new MqttPubComp(paramMqttWireMessage.getMessageId()), null);
  }
  
  protected void notifyResult(MqttWireMessage paramMqttWireMessage, MqttToken paramMqttToken, MqttException paramMqttException)
  {
    TBaseLogger.d("ClientState", "action:notifyResult");
    paramMqttToken.internalTok.markComplete(paramMqttWireMessage, paramMqttException);
    paramMqttToken.internalTok.notifyComplete();
    if ((paramMqttWireMessage != null) && ((paramMqttWireMessage instanceof MqttAck)) && (!(paramMqttWireMessage instanceof MqttPubRec)))
    {
      log.fine("ClientState", "notifyResult", "648", new Object[] { paramMqttToken.internalTok.getKey(), paramMqttWireMessage, paramMqttException });
      this.callback.asyncOperationComplete(paramMqttToken);
    }
    if (paramMqttWireMessage == null)
    {
      log.fine("ClientState", "notifyResult", "649", new Object[] { paramMqttToken.internalTok.getKey(), paramMqttException });
      this.callback.asyncOperationComplete(paramMqttToken);
    }
  }
  
  protected void notifySent(MqttWireMessage arg1)
  {
    TBaseLogger.d("ClientState", "action - notifySent");
    this.lastOutboundActivity = System.currentTimeMillis();
    log.fine("ClientState", "notifySent", "625", new Object[] { ???.getKey() });
    ??? = this.tokenStore.getToken(???);
    ((MqttToken)???).internalTok.notifySent();
    if ((??? instanceof MqttPingReq)) {}
    while ((!(??? instanceof MqttPublish)) || (((MqttPublish)???).getMessage().getQos() != 0)) {
      synchronized (this.pingOutstandingLock)
      {
        long l = System.currentTimeMillis();
        synchronized (this.pingOutstandingLock)
        {
          this.lastPing = l;
          this.pingOutstanding += 1;
          return;
        }
      }
    }
    localMqttToken.internalTok.markComplete(null, null);
    this.callback.asyncOperationComplete(localMqttToken);
    decrementInFlight();
    releaseMessageId(???.getMessageId());
    this.tokenStore.removeToken(???);
    checkQuiesceLock();
  }
  
  public void notifySentBytes(int paramInt)
  {
    if (paramInt > 0) {
      this.lastOutboundActivity = System.currentTimeMillis();
    }
    log.fine("ClientState", "notifySentBytes", "643", new Object[] { new Integer(paramInt) });
  }
  
  public void persistBufferedMessage(MqttWireMessage paramMqttWireMessage)
  {
    getSendBufferedPersistenceKey(paramMqttWireMessage);
    try
    {
      paramMqttWireMessage.setMessageId(getNextMessageId());
      String str = getSendBufferedPersistenceKey(paramMqttWireMessage);
      try
      {
        this.persistence.put(str, (MqttPublish)paramMqttWireMessage);
        log.fine("ClientState", "persistBufferedMessage", "513", new Object[] { str });
        return;
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          log.fine("ClientState", "persistBufferedMessage", "515");
          this.persistence.open(this.clientComms.getClient().getClientId(), this.clientComms.getClient().getServerURI());
          this.persistence.put(str, (MqttPublish)paramMqttWireMessage);
        }
      }
      return;
    }
    catch (Throwable paramMqttWireMessage)
    {
      TBaseLogger.e("ClientState", "persistBufferedMessage", paramMqttWireMessage);
    }
  }
  
  /* Error */
  public void quiesce(long paramLong)
  {
    // Byte code:
    //   0: lload_1
    //   1: lconst_0
    //   2: lcmp
    //   3: ifle +155 -> 158
    //   6: getstatic 78	com/tencent/android/tpns/mqtt/internal/ClientState:log	Lcom/tencent/android/tpns/mqtt/logging/Logger;
    //   9: ldc 8
    //   11: ldc_w 679
    //   14: ldc_w 681
    //   17: iconst_1
    //   18: anewarray 4	java/lang/Object
    //   21: dup
    //   22: iconst_0
    //   23: new 347	java/lang/Long
    //   26: dup
    //   27: lload_1
    //   28: invokespecial 350	java/lang/Long:<init>	(J)V
    //   31: aastore
    //   32: invokeinterface 187 5 0
    //   37: aload_0
    //   38: getfield 99	com/tencent/android/tpns/mqtt/internal/ClientState:queueLock	Ljava/lang/Object;
    //   41: astore_3
    //   42: aload_3
    //   43: monitorenter
    //   44: aload_0
    //   45: iconst_1
    //   46: putfield 103	com/tencent/android/tpns/mqtt/internal/ClientState:quiescing	Z
    //   49: aload_3
    //   50: monitorexit
    //   51: aload_0
    //   52: getfield 91	com/tencent/android/tpns/mqtt/internal/ClientState:callback	Lcom/tencent/android/tpns/mqtt/internal/CommsCallback;
    //   55: invokevirtual 683	com/tencent/android/tpns/mqtt/internal/CommsCallback:quiesce	()V
    //   58: aload_0
    //   59: invokevirtual 376	com/tencent/android/tpns/mqtt/internal/ClientState:notifyQueueLock	()V
    //   62: aload_0
    //   63: getfield 101	com/tencent/android/tpns/mqtt/internal/ClientState:quiesceLock	Ljava/lang/Object;
    //   66: astore_3
    //   67: aload_3
    //   68: monitorenter
    //   69: aload_0
    //   70: getfield 170	com/tencent/android/tpns/mqtt/internal/ClientState:tokenStore	Lcom/tencent/android/tpns/mqtt/internal/CommsTokenStore;
    //   73: invokevirtual 394	com/tencent/android/tpns/mqtt/internal/CommsTokenStore:count	()I
    //   76: ifgt +23 -> 99
    //   79: aload_0
    //   80: getfield 161	com/tencent/android/tpns/mqtt/internal/ClientState:pendingFlows	Ljava/util/Vector;
    //   83: invokevirtual 239	java/util/Vector:size	()I
    //   86: ifgt +13 -> 99
    //   89: aload_0
    //   90: getfield 91	com/tencent/android/tpns/mqtt/internal/ClientState:callback	Lcom/tencent/android/tpns/mqtt/internal/CommsCallback;
    //   93: invokevirtual 399	com/tencent/android/tpns/mqtt/internal/CommsCallback:isQuiesced	()Z
    //   96: ifne +11 -> 107
    //   99: aload_0
    //   100: getfield 101	com/tencent/android/tpns/mqtt/internal/ClientState:quiesceLock	Ljava/lang/Object;
    //   103: lload_1
    //   104: invokevirtual 685	java/lang/Object:wait	(J)V
    //   107: aload_3
    //   108: monitorexit
    //   109: aload_0
    //   110: getfield 99	com/tencent/android/tpns/mqtt/internal/ClientState:queueLock	Ljava/lang/Object;
    //   113: astore_3
    //   114: aload_3
    //   115: monitorenter
    //   116: aload_0
    //   117: getfield 262	com/tencent/android/tpns/mqtt/internal/ClientState:pendingMessages	Ljava/util/Vector;
    //   120: invokevirtual 410	java/util/Vector:clear	()V
    //   123: aload_0
    //   124: getfield 161	com/tencent/android/tpns/mqtt/internal/ClientState:pendingFlows	Ljava/util/Vector;
    //   127: invokevirtual 410	java/util/Vector:clear	()V
    //   130: aload_0
    //   131: iconst_0
    //   132: putfield 103	com/tencent/android/tpns/mqtt/internal/ClientState:quiescing	Z
    //   135: aload_0
    //   136: iconst_0
    //   137: putfield 95	com/tencent/android/tpns/mqtt/internal/ClientState:actualInFlight	I
    //   140: aload_3
    //   141: monitorexit
    //   142: getstatic 78	com/tencent/android/tpns/mqtt/internal/ClientState:log	Lcom/tencent/android/tpns/mqtt/logging/Logger;
    //   145: ldc 8
    //   147: ldc_w 679
    //   150: ldc_w 687
    //   153: invokeinterface 405 4 0
    //   158: return
    //   159: astore 4
    //   161: aload_3
    //   162: monitorexit
    //   163: aload 4
    //   165: athrow
    //   166: astore 4
    //   168: aload_3
    //   169: monitorexit
    //   170: aload 4
    //   172: athrow
    //   173: astore 4
    //   175: aload_3
    //   176: monitorexit
    //   177: aload 4
    //   179: athrow
    //   180: astore 4
    //   182: goto -75 -> 107
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	185	0	this	ClientState
    //   0	185	1	paramLong	long
    //   159	5	4	localObject2	Object
    //   166	5	4	localObject3	Object
    //   173	5	4	localObject4	Object
    //   180	1	4	localInterruptedException	java.lang.InterruptedException
    // Exception table:
    //   from	to	target	type
    //   44	51	159	finally
    //   161	163	159	finally
    //   69	99	166	finally
    //   99	107	166	finally
    //   107	109	166	finally
    //   168	170	166	finally
    //   116	142	173	finally
    //   175	177	173	finally
    //   69	99	180	java/lang/InterruptedException
    //   99	107	180	java/lang/InterruptedException
  }
  
  public Vector resolveOldTokens(MqttException arg1)
  {
    log.fine("ClientState", "resolveOldTokens", "632", new Object[] { ??? });
    MqttException localMqttException = ???;
    if (??? == null) {
      localMqttException = new MqttException(32102);
    }
    Vector localVector = this.tokenStore.getOutstandingTokens();
    Enumeration localEnumeration = localVector.elements();
    while (localEnumeration.hasMoreElements()) {
      synchronized ((MqttToken)localEnumeration.nextElement())
      {
        if ((!???.isComplete()) && (!???.internalTok.isCompletePending()) && (???.getException() == null)) {
          ???.internalTok.setException(localMqttException);
        }
        if (!(??? instanceof MqttDeliveryToken)) {
          this.tokenStore.removeToken(???.internalTok.getKey());
        }
      }
    }
    return localVector;
  }
  
  protected void restoreState()
    throws MqttException
  {
    Enumeration localEnumeration = this.persistence.keys();
    int i = this.nextMsgId;
    Object localObject1 = new Vector();
    log.fine("ClientState", "restoreState", "600");
    if (localEnumeration.hasMoreElements())
    {
      String str = (String)localEnumeration.nextElement();
      Object localObject2 = restoreMessage(str, this.persistence.get(str));
      if (localObject2 != null) {
        if (str.startsWith("r-"))
        {
          log.fine("ClientState", "restoreState", "604", new Object[] { str, localObject2 });
          this.inboundQoS2.put(new Integer(((MqttWireMessage)localObject2).getMessageId()), localObject2);
        }
      }
      for (;;)
      {
        break;
        MqttPublish localMqttPublish;
        if (str.startsWith("s-"))
        {
          localMqttPublish = (MqttPublish)localObject2;
          i = Math.max(localMqttPublish.getMessageId(), i);
          if (this.persistence.containsKey(getSendConfirmPersistenceKey(localMqttPublish)))
          {
            MqttPubRel localMqttPubRel = (MqttPubRel)restoreMessage(str, this.persistence.get(getSendConfirmPersistenceKey(localMqttPublish)));
            if (localMqttPubRel != null)
            {
              log.fine("ClientState", "restoreState", "605", new Object[] { str, localObject2 });
              this.outboundQoS2.put(new Integer(localMqttPubRel.getMessageId()), localMqttPubRel);
            }
          }
          for (;;)
          {
            this.tokenStore.restoreToken(localMqttPublish).internalTok.setClient(this.clientComms.getClient());
            this.inUseMsgIds.put(new Integer(localMqttPublish.getMessageId()), new Integer(localMqttPublish.getMessageId()));
            break;
            log.fine("ClientState", "restoreState", "606", new Object[] { str, localObject2 });
            continue;
            localMqttPublish.setDuplicate(true);
            if (localMqttPublish.getMessage().getQos() == 2)
            {
              log.fine("ClientState", "restoreState", "607", new Object[] { str, localObject2 });
              this.outboundQoS2.put(new Integer(localMqttPublish.getMessageId()), localMqttPublish);
            }
            else
            {
              log.fine("ClientState", "restoreState", "608", new Object[] { str, localObject2 });
              this.outboundQoS1.put(new Integer(localMqttPublish.getMessageId()), localMqttPublish);
            }
          }
        }
        if (str.startsWith("sb-"))
        {
          localMqttPublish = (MqttPublish)localObject2;
          i = Math.max(localMqttPublish.getMessageId(), i);
          if (localMqttPublish.getMessage().getQos() == 2)
          {
            log.fine("ClientState", "restoreState", "607", new Object[] { str, localObject2 });
            this.outboundQoS2.put(new Integer(localMqttPublish.getMessageId()), localMqttPublish);
          }
          for (;;)
          {
            this.tokenStore.restoreToken(localMqttPublish).internalTok.setClient(this.clientComms.getClient());
            this.inUseMsgIds.put(new Integer(localMqttPublish.getMessageId()), new Integer(localMqttPublish.getMessageId()));
            break;
            if (localMqttPublish.getMessage().getQos() == 1)
            {
              log.fine("ClientState", "restoreState", "608", new Object[] { str, localObject2 });
              this.outboundQoS1.put(new Integer(localMqttPublish.getMessageId()), localMqttPublish);
            }
            else
            {
              log.fine("ClientState", "restoreState", "511", new Object[] { str, localObject2 });
              this.outboundQoS0.put(new Integer(localMqttPublish.getMessageId()), localMqttPublish);
              this.persistence.remove(str);
            }
          }
        }
        if (str.startsWith("sc-"))
        {
          localObject2 = (MqttPubRel)localObject2;
          if (!this.persistence.containsKey(getSendPersistenceKey((MqttWireMessage)localObject2))) {
            ((Vector)localObject1).addElement(str);
          }
        }
      }
    }
    localEnumeration = ((Vector)localObject1).elements();
    while (localEnumeration.hasMoreElements())
    {
      localObject1 = (String)localEnumeration.nextElement();
      log.fine("ClientState", "restoreState", "609", new Object[] { localObject1 });
      this.persistence.remove((String)localObject1);
    }
    this.nextMsgId = i;
  }
  
  public void send(MqttWireMessage paramMqttWireMessage, MqttToken paramMqttToken)
    throws MqttException
  {
    if ((paramMqttWireMessage.isMessageIdRequired()) && (paramMqttWireMessage.getMessageId() == 0))
    {
      if ((!(paramMqttWireMessage instanceof MqttPublish)) || (((MqttPublish)paramMqttWireMessage).getMessage().getQos() == 0)) {
        break label132;
      }
      paramMqttWireMessage.setMessageId(getNextMessageId());
    }
    for (;;)
    {
      if (paramMqttToken != null) {}
      try
      {
        paramMqttToken.internalTok.setMessageID(paramMqttWireMessage.getMessageId());
        if (!(paramMqttWireMessage instanceof MqttPublish)) {
          break label409;
        }
        synchronized (this.queueLock)
        {
          if (this.actualInFlight < this.maxInflight) {
            break;
          }
          log.fine("ClientState", "send", "613", new Object[] { new Integer(this.actualInFlight) });
          throw new MqttException(32202);
        }
        label132:
        if (((paramMqttWireMessage instanceof MqttPubAck)) || ((paramMqttWireMessage instanceof MqttPubRec)) || ((paramMqttWireMessage instanceof MqttPubRel)) || ((paramMqttWireMessage instanceof MqttPubComp)) || ((paramMqttWireMessage instanceof MqttSubscribe)) || ((paramMqttWireMessage instanceof MqttSuback)) || ((paramMqttWireMessage instanceof MqttUnsubscribe)) || ((paramMqttWireMessage instanceof MqttUnsubAck))) {
          paramMqttWireMessage.setMessageId(getNextMessageId());
        }
      }
      catch (Throwable paramMqttWireMessage)
      {
        throw new MqttException(32201);
      }
    }
    MqttMessage localMqttMessage = ((MqttPublish)paramMqttWireMessage).getMessage();
    log.fine("ClientState", "send", "628", new Object[] { new Integer(paramMqttWireMessage.getMessageId()), new Integer(localMqttMessage.getQos()), paramMqttWireMessage });
    switch (localMqttMessage.getQos())
    {
    }
    for (;;)
    {
      this.tokenStore.saveToken(paramMqttToken, paramMqttWireMessage);
      this.pendingMessages.addElement(paramMqttWireMessage);
      this.queueLock.notifyAll();
      return;
      this.outboundQoS2.put(new Integer(paramMqttWireMessage.getMessageId()), paramMqttWireMessage);
      this.persistence.put(getSendPersistenceKey(paramMqttWireMessage), (MqttPublish)paramMqttWireMessage);
      continue;
      this.outboundQoS1.put(new Integer(paramMqttWireMessage.getMessageId()), paramMqttWireMessage);
      this.persistence.put(getSendPersistenceKey(paramMqttWireMessage), (MqttPublish)paramMqttWireMessage);
      continue;
      label409:
      log.fine("ClientState", "send", "615", new Object[] { new Integer(paramMqttWireMessage.getMessageId()), paramMqttWireMessage });
      if ((paramMqttWireMessage instanceof MqttConnect)) {
        synchronized (this.queueLock)
        {
          this.tokenStore.saveToken(paramMqttToken, paramMqttWireMessage);
          this.pendingFlows.insertElementAt(paramMqttWireMessage, 0);
          this.queueLock.notifyAll();
          return;
        }
      }
      if ((paramMqttWireMessage instanceof MqttPingReq)) {
        this.pingCommand = paramMqttWireMessage;
      }
      for (;;)
      {
        synchronized (this.queueLock)
        {
          if (!(paramMqttWireMessage instanceof MqttAck)) {
            this.tokenStore.saveToken(paramMqttToken, paramMqttWireMessage);
          }
          this.pendingFlows.addElement(paramMqttWireMessage);
          this.queueLock.notifyAll();
          return;
        }
        if ((paramMqttWireMessage instanceof MqttPubRel))
        {
          this.outboundQoS2.put(new Integer(paramMqttWireMessage.getMessageId()), paramMqttWireMessage);
          this.persistence.put(getSendConfirmPersistenceKey(paramMqttWireMessage), (MqttPubRel)paramMqttWireMessage);
        }
        else if ((paramMqttWireMessage instanceof MqttPubComp))
        {
          this.persistence.remove(getReceivedPersistenceKey(paramMqttWireMessage));
        }
      }
    }
  }
  
  protected void setCleanSession(boolean paramBoolean)
  {
    this.cleanSession = paramBoolean;
  }
  
  public void setKeepAliveInterval(long paramLong)
  {
    this.keepAlive = paramLong;
  }
  
  protected void setKeepAliveSecs(long paramLong)
  {
    this.keepAlive = (1000L * paramLong);
  }
  
  protected void setMaxInflight(int paramInt)
  {
    this.maxInflight = paramInt;
    this.pendingMessages = new Vector(this.maxInflight);
  }
  
  public void unPersistBufferedMessage(MqttWireMessage paramMqttWireMessage)
  {
    try
    {
      log.fine("ClientState", "unPersistBufferedMessage", "517", new Object[] { paramMqttWireMessage.getKey() });
      this.persistence.remove(getSendBufferedPersistenceKey(paramMqttWireMessage));
      return;
    }
    catch (Throwable paramMqttWireMessage)
    {
      TBaseLogger.e("ClientState", "unPersistBufferedMessage", paramMqttWireMessage);
    }
  }
  
  protected void undo(MqttPublish paramMqttPublish)
    throws MqttPersistenceException
  {
    synchronized (this.queueLock)
    {
      log.fine("ClientState", "undo", "618", new Object[] { new Integer(paramMqttPublish.getMessageId()), new Integer(paramMqttPublish.getMessage().getQos()) });
      if (paramMqttPublish.getMessage().getQos() == 1)
      {
        this.outboundQoS1.remove(new Integer(paramMqttPublish.getMessageId()));
        this.pendingMessages.removeElement(paramMqttPublish);
        this.persistence.remove(getSendPersistenceKey(paramMqttPublish));
        this.tokenStore.removeToken(paramMqttPublish);
        if (paramMqttPublish.getMessage().getQos() > 0)
        {
          releaseMessageId(paramMqttPublish.getMessageId());
          paramMqttPublish.setMessageId(0);
        }
        checkQuiesceLock();
        return;
      }
      this.outboundQoS2.remove(new Integer(paramMqttPublish.getMessageId()));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpns.mqtt.internal.ClientState
 * JD-Core Version:    0.7.0.1
 */