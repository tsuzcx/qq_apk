package com.tencent.android.tpush.service.c;

import android.content.Context;
import com.tencent.tpns.mqttchannel.api.MqttChannel;
import com.tencent.tpns.mqttchannel.api.MqttConnectState;
import com.tencent.tpns.mqttchannel.api.OnMqttCallback;

class b$3
  extends OnMqttCallback
{
  b$3(b paramb, b.b paramb1, Context paramContext) {}
  
  public void callback(int paramInt, String paramString)
  {
    if ((paramInt == 0) && ((MqttConnectState.valueOf(paramString) == MqttConnectState.CONNECTED) || (MqttConnectState.valueOf(paramString) == MqttConnectState.SUBTOPICS)))
    {
      this.a.a();
      return;
    }
    MqttChannel.getInstance(this.b).startConnect(new b.3.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.service.c.b.3
 * JD-Core Version:    0.7.0.1
 */