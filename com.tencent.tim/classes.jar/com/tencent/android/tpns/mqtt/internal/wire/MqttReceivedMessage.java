package com.tencent.android.tpns.mqtt.internal.wire;

import com.tencent.android.tpns.mqtt.MqttMessage;

public class MqttReceivedMessage
  extends MqttMessage
{
  public int getMessageId()
  {
    return super.getId();
  }
  
  public void setDuplicate(boolean paramBoolean)
  {
    super.setDuplicate(paramBoolean);
  }
  
  public void setMessageId(int paramInt)
  {
    super.setId(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpns.mqtt.internal.wire.MqttReceivedMessage
 * JD-Core Version:    0.7.0.1
 */