package com.tencent.android.tpns.mqtt;

import com.tencent.android.tpns.mqtt.internal.Token;

public class MqttDeliveryToken
  extends MqttToken
  implements IMqttDeliveryToken
{
  public MqttDeliveryToken() {}
  
  public MqttDeliveryToken(String paramString)
  {
    super(paramString);
  }
  
  public MqttMessage getMessage()
    throws MqttException
  {
    return this.internalTok.getMessage();
  }
  
  protected void setMessage(MqttMessage paramMqttMessage)
  {
    this.internalTok.setMessage(paramMqttMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpns.mqtt.MqttDeliveryToken
 * JD-Core Version:    0.7.0.1
 */