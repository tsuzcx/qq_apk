package com.tencent.android.tpns.mqtt;

import com.tencent.android.tpns.mqtt.internal.Token;
import com.tencent.android.tpns.mqtt.internal.wire.MqttWireMessage;

public class MqttToken
  implements IMqttToken
{
  public Token internalTok = null;
  
  public MqttToken() {}
  
  public MqttToken(String paramString)
  {
    this.internalTok = new Token(paramString);
  }
  
  public IMqttActionListener getActionCallback()
  {
    return this.internalTok.getActionCallback();
  }
  
  public IMqttAsyncClient getClient()
  {
    return this.internalTok.getClient();
  }
  
  public MqttException getException()
  {
    return this.internalTok.getException();
  }
  
  public int[] getGrantedQos()
  {
    return this.internalTok.getGrantedQos();
  }
  
  public int getMessageId()
  {
    return this.internalTok.getMessageID();
  }
  
  public MqttWireMessage getResponse()
  {
    return this.internalTok.getResponse();
  }
  
  public boolean getSessionPresent()
  {
    return this.internalTok.getSessionPresent();
  }
  
  public String[] getTopics()
  {
    return this.internalTok.getTopics();
  }
  
  public Object getUserContext()
  {
    return this.internalTok.getUserContext();
  }
  
  public boolean isComplete()
  {
    return this.internalTok.isComplete();
  }
  
  public void setActionCallback(IMqttActionListener paramIMqttActionListener)
  {
    this.internalTok.setActionCallback(paramIMqttActionListener);
  }
  
  public void setUserContext(Object paramObject)
  {
    this.internalTok.setUserContext(paramObject);
  }
  
  public void waitForCompletion()
    throws MqttException
  {
    this.internalTok.waitForCompletion(-1L);
  }
  
  public void waitForCompletion(long paramLong)
    throws MqttException
  {
    this.internalTok.waitForCompletion(paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpns.mqtt.MqttToken
 * JD-Core Version:    0.7.0.1
 */