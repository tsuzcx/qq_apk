package com.tencent.android.tpns.mqtt;

import com.tencent.android.tpns.mqtt.internal.wire.MqttWireMessage;

public abstract interface IMqttToken
{
  public abstract IMqttActionListener getActionCallback();
  
  public abstract IMqttAsyncClient getClient();
  
  public abstract MqttException getException();
  
  public abstract int[] getGrantedQos();
  
  public abstract int getMessageId();
  
  public abstract MqttWireMessage getResponse();
  
  public abstract boolean getSessionPresent();
  
  public abstract String[] getTopics();
  
  public abstract Object getUserContext();
  
  public abstract boolean isComplete();
  
  public abstract void setActionCallback(IMqttActionListener paramIMqttActionListener);
  
  public abstract void setUserContext(Object paramObject);
  
  public abstract void waitForCompletion()
    throws MqttException;
  
  public abstract void waitForCompletion(long paramLong)
    throws MqttException;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpns.mqtt.IMqttToken
 * JD-Core Version:    0.7.0.1
 */