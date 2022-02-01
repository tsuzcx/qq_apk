package com.tencent.android.tpns.mqtt.internal;

import com.tencent.android.tpns.mqtt.BufferedMessage;
import com.tencent.android.tpns.mqtt.DisconnectedBufferOptions;
import com.tencent.android.tpns.mqtt.MqttException;
import com.tencent.android.tpns.mqtt.MqttToken;
import com.tencent.android.tpns.mqtt.internal.wire.MqttWireMessage;
import com.tencent.android.tpns.mqtt.logging.Logger;
import com.tencent.android.tpns.mqtt.logging.LoggerFactory;
import com.tencent.tpns.baseapi.base.logger.TBaseLogger;
import java.util.ArrayList;

public class DisconnectedMessageBuffer
  implements Runnable
{
  private static final String CLASS_NAME = "DisconnectedMessageBuffer";
  private static final Logger log = LoggerFactory.getLogger("com.tencent.android.tpns.mqtt.internal.nls.logcat", "DisconnectedMessageBuffer");
  private Object bufLock = new Object();
  private ArrayList buffer;
  private DisconnectedBufferOptions bufferOpts;
  private IDisconnectedBufferCallback callback;
  
  public DisconnectedMessageBuffer(DisconnectedBufferOptions paramDisconnectedBufferOptions)
  {
    this.bufferOpts = paramDisconnectedBufferOptions;
    this.buffer = new ArrayList();
  }
  
  public void deleteMessage(int paramInt)
  {
    synchronized (this.bufLock)
    {
      this.buffer.remove(paramInt);
      return;
    }
  }
  
  public BufferedMessage getMessage(int paramInt)
  {
    synchronized (this.bufLock)
    {
      BufferedMessage localBufferedMessage = (BufferedMessage)this.buffer.get(paramInt);
      return localBufferedMessage;
    }
  }
  
  public int getMessageCount()
  {
    synchronized (this.bufLock)
    {
      int i = this.buffer.size();
      return i;
    }
  }
  
  public boolean isPersistBuffer()
  {
    return this.bufferOpts.isPersistBuffer();
  }
  
  public void putMessage(MqttWireMessage arg1, MqttToken paramMqttToken)
    throws MqttException
  {
    paramMqttToken = new BufferedMessage(???, paramMqttToken);
    synchronized (this.bufLock)
    {
      if (this.buffer.size() < this.bufferOpts.getBufferSize())
      {
        this.buffer.add(paramMqttToken);
        return;
      }
      if (this.bufferOpts.isDeleteOldestMessages() == true)
      {
        this.buffer.remove(0);
        this.buffer.add(paramMqttToken);
      }
    }
    throw new MqttException(32203);
  }
  
  public void run()
  {
    log.fine("DisconnectedMessageBuffer", "run", "516");
    for (;;)
    {
      if (getMessageCount() > 0) {
        try
        {
          BufferedMessage localBufferedMessage = getMessage(0);
          this.callback.publishBufferedMessage(localBufferedMessage);
          deleteMessage(0);
        }
        catch (Throwable localThrowable)
        {
          TBaseLogger.e("DisconnectedMessageBuffer", "run", localThrowable);
        }
      }
    }
  }
  
  public void setPublishCallback(IDisconnectedBufferCallback paramIDisconnectedBufferCallback)
  {
    this.callback = paramIDisconnectedBufferCallback;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpns.mqtt.internal.DisconnectedMessageBuffer
 * JD-Core Version:    0.7.0.1
 */