package com.tencent.android.tpns.mqtt;

import com.tencent.android.tpns.mqtt.internal.wire.MqttWireMessage;

public class BufferedMessage
{
  private MqttWireMessage message;
  private MqttToken token;
  
  public BufferedMessage(MqttWireMessage paramMqttWireMessage, MqttToken paramMqttToken)
  {
    this.message = paramMqttWireMessage;
    this.token = paramMqttToken;
  }
  
  public MqttWireMessage getMessage()
  {
    return this.message;
  }
  
  public MqttToken getToken()
  {
    return this.token;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpns.mqtt.BufferedMessage
 * JD-Core Version:    0.7.0.1
 */