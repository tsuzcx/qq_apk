package com.tencent.android.tpns.mqtt.internal;

import com.tencent.android.tpns.mqtt.IMqttActionListener;
import com.tencent.android.tpns.mqtt.IMqttAsyncClient;
import com.tencent.android.tpns.mqtt.MqttException;
import com.tencent.android.tpns.mqtt.MqttMessage;
import com.tencent.android.tpns.mqtt.internal.wire.MqttAck;
import com.tencent.android.tpns.mqtt.internal.wire.MqttConnack;
import com.tencent.android.tpns.mqtt.internal.wire.MqttSuback;
import com.tencent.android.tpns.mqtt.internal.wire.MqttWireMessage;
import com.tencent.android.tpns.mqtt.logging.Logger;
import com.tencent.android.tpns.mqtt.logging.LoggerFactory;
import com.tencent.tpns.baseapi.base.logger.TBaseLogger;

public class Token
{
  private static final String CLASS_NAME = "Token";
  private static final Logger log = LoggerFactory.getLogger("com.tencent.android.tpns.mqtt.internal.nls.logcat", "Token");
  private IMqttActionListener callback = null;
  private IMqttAsyncClient client = null;
  private volatile boolean completed = false;
  private MqttException exception = null;
  private String key;
  protected MqttMessage message = null;
  private int messageID = 0;
  private boolean notified = false;
  private boolean pendingComplete = false;
  private MqttWireMessage response = null;
  private Object responseLock = new Object();
  private boolean sent = false;
  private Object sentLock = new Object();
  private String[] topics = null;
  private Object userContext = null;
  
  public Token(String paramString)
  {
    log.setResourceName(paramString);
  }
  
  public boolean checkResult()
    throws MqttException
  {
    if (getException() != null) {
      throw getException();
    }
    return true;
  }
  
  public IMqttActionListener getActionCallback()
  {
    return this.callback;
  }
  
  public IMqttAsyncClient getClient()
  {
    return this.client;
  }
  
  public MqttException getException()
  {
    return this.exception;
  }
  
  public int[] getGrantedQos()
  {
    int[] arrayOfInt = new int[0];
    if ((this.response instanceof MqttSuback)) {
      arrayOfInt = ((MqttSuback)this.response).getGrantedQos();
    }
    return arrayOfInt;
  }
  
  public String getKey()
  {
    return this.key;
  }
  
  public MqttMessage getMessage()
  {
    return this.message;
  }
  
  public int getMessageID()
  {
    return this.messageID;
  }
  
  public MqttWireMessage getResponse()
  {
    return this.response;
  }
  
  public boolean getSessionPresent()
  {
    boolean bool = false;
    if ((this.response instanceof MqttConnack)) {
      bool = ((MqttConnack)this.response).getSessionPresent();
    }
    return bool;
  }
  
  public String[] getTopics()
  {
    return this.topics;
  }
  
  public Object getUserContext()
  {
    return this.userContext;
  }
  
  public MqttWireMessage getWireMessage()
  {
    return this.response;
  }
  
  public boolean isComplete()
  {
    return this.completed;
  }
  
  protected boolean isCompletePending()
  {
    return this.pendingComplete;
  }
  
  protected boolean isInUse()
  {
    return (getClient() != null) && (!isComplete());
  }
  
  public boolean isNotified()
  {
    return this.notified;
  }
  
  protected void markComplete(MqttWireMessage paramMqttWireMessage, MqttException paramMqttException)
  {
    log.fine("Token", "markComplete", "404", new Object[] { getKey(), paramMqttWireMessage, paramMqttException });
    synchronized (this.responseLock)
    {
      if ((paramMqttWireMessage instanceof MqttAck)) {
        this.message = null;
      }
      this.pendingComplete = true;
      this.response = paramMqttWireMessage;
      this.exception = paramMqttException;
      return;
    }
  }
  
  protected void notifyComplete()
  {
    log.fine("Token", "notifyComplete", "404", new Object[] { getKey(), this.response, this.exception });
    for (;;)
    {
      synchronized (this.responseLock)
      {
        if ((this.exception == null) && (this.pendingComplete))
        {
          this.completed = true;
          this.pendingComplete = false;
          this.responseLock.notifyAll();
        }
      }
      synchronized (this.sentLock)
      {
        this.sent = true;
        this.sentLock.notifyAll();
        return;
        this.pendingComplete = false;
        continue;
        localObject2 = finally;
        throw localObject2;
      }
    }
  }
  
  protected void notifySent()
  {
    log.fine("Token", "notifySent", "403", new Object[] { getKey() });
    synchronized (this.responseLock)
    {
      this.response = null;
      this.completed = false;
    }
    synchronized (this.sentLock)
    {
      this.sent = true;
      this.sentLock.notifyAll();
      return;
      localObject2 = finally;
      throw localObject2;
    }
  }
  
  public void reset()
    throws MqttException
  {
    if (isInUse()) {
      throw new MqttException(32201);
    }
    log.fine("Token", "reset", "410", new Object[] { getKey() });
    this.client = null;
    this.completed = false;
    this.response = null;
    this.sent = false;
    this.exception = null;
    this.userContext = null;
  }
  
  public void setActionCallback(IMqttActionListener paramIMqttActionListener)
  {
    this.callback = paramIMqttActionListener;
  }
  
  protected void setClient(IMqttAsyncClient paramIMqttAsyncClient)
  {
    this.client = paramIMqttAsyncClient;
  }
  
  public void setException(MqttException paramMqttException)
  {
    synchronized (this.responseLock)
    {
      this.exception = paramMqttException;
      return;
    }
  }
  
  public void setKey(String paramString)
  {
    this.key = paramString;
  }
  
  public void setMessage(MqttMessage paramMqttMessage)
  {
    this.message = paramMqttMessage;
  }
  
  public void setMessageID(int paramInt)
  {
    this.messageID = paramInt;
  }
  
  public void setNotified(boolean paramBoolean)
  {
    this.notified = paramBoolean;
  }
  
  public void setTopics(String[] paramArrayOfString)
  {
    this.topics = paramArrayOfString;
  }
  
  public void setUserContext(Object paramObject)
  {
    this.userContext = paramObject;
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("key=").append(getKey());
    localStringBuffer.append(" ,topics=");
    if (getTopics() != null)
    {
      int i = 0;
      while (i < getTopics().length)
      {
        localStringBuffer.append(getTopics()[i]).append(", ");
        i += 1;
      }
    }
    localStringBuffer.append(" ,usercontext=").append(getUserContext());
    localStringBuffer.append(" ,isComplete=").append(isComplete());
    localStringBuffer.append(" ,isNotified=").append(isNotified());
    localStringBuffer.append(" ,exception=").append(getException());
    localStringBuffer.append(" ,actioncallback=").append(getActionCallback());
    return localStringBuffer.toString();
  }
  
  public void waitForCompletion()
    throws MqttException
  {
    waitForCompletion(-1L);
  }
  
  public void waitForCompletion(long paramLong)
    throws MqttException
  {
    log.fine("Token", "waitForCompletion", "407", new Object[] { getKey(), new Long(paramLong), this });
    if ((waitForResponse(paramLong) == null) && (!this.completed))
    {
      TBaseLogger.e("Token", "waitForCompletion timeout");
      this.exception = new MqttException(32000);
      throw this.exception;
    }
    checkResult();
  }
  
  protected MqttWireMessage waitForResponse()
    throws MqttException
  {
    return waitForResponse(-1L);
  }
  
  protected MqttWireMessage waitForResponse(long paramLong)
    throws MqttException
  {
    for (;;)
    {
      synchronized (this.responseLock)
      {
        Logger localLogger = log;
        String str2 = getKey();
        Long localLong = new Long(paramLong);
        Boolean localBoolean1 = new Boolean(this.sent);
        Boolean localBoolean2 = new Boolean(this.completed);
        if (this.exception == null)
        {
          Object localObject1 = "false";
          MqttWireMessage localMqttWireMessage = this.response;
          MqttException localMqttException = this.exception;
          localLogger.fine("Token", "waitForResponse", "400", new Object[] { str2, localLong, localBoolean1, localBoolean2, localObject1, localMqttWireMessage, this }, localMqttException);
          if (this.completed) {
            break label278;
          }
          localObject1 = this.exception;
          if (localObject1 != null) {}
        }
        try
        {
          log.fine("Token", "waitForResponse", "408", new Object[] { getKey(), new Long(paramLong) });
          if (paramLong > 0L) {
            break label251;
          }
          this.responseLock.wait();
        }
        catch (InterruptedException localInterruptedException)
        {
          String str1;
          this.exception = new MqttException(localInterruptedException);
          continue;
        }
        if (this.completed) {
          continue;
        }
        if (this.exception == null) {
          break label319;
        }
        log.fine("Token", "waitForResponse", "401", null, this.exception);
        throw this.exception;
      }
      str1 = "true";
      continue;
      label251:
      this.responseLock.wait(paramLong);
    }
    for (;;)
    {
      label278:
      log.fine("Token", "waitForResponse", "402", new Object[] { getKey(), this.response });
      return this.response;
      label319:
      if (paramLong <= 0L) {
        break;
      }
    }
  }
  
  public void waitUntilSent()
    throws MqttException
  {
    synchronized (this.sentLock)
    {
      synchronized (this.responseLock)
      {
        if (this.exception != null) {
          throw this.exception;
        }
      }
    }
    for (;;)
    {
      boolean bool = this.sent;
      if (bool) {
        break;
      }
      try
      {
        log.fine("Token", "waitUntilSent", "409", new Object[] { getKey() });
        this.sentLock.wait();
      }
      catch (InterruptedException localInterruptedException) {}
    }
    if (!this.sent)
    {
      if (this.exception == null) {
        throw ExceptionHelper.createMqttException(6);
      }
      throw this.exception;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpns.mqtt.internal.Token
 * JD-Core Version:    0.7.0.1
 */