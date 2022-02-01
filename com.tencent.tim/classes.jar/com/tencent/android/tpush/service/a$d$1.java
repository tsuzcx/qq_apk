package com.tencent.android.tpush.service;

import android.content.Context;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.tpns.mqttchannel.api.MqttChannel;

class a$d$1
  implements Runnable
{
  a$d$1(a.d paramd, Context paramContext) {}
  
  public void run()
  {
    TLogger.dd("PushServiceBroadcastHandler", "Internl network connected, restart");
    MqttChannel.getInstance(this.a).startConnect(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.service.a.d.1
 * JD-Core Version:    0.7.0.1
 */