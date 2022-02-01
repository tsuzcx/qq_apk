package com.tencent.android.tpush.service;

import android.content.Context;
import com.tencent.android.tpush.a;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.tpns.mqttchannel.api.MqttChannel;

class a$d$2
  implements Runnable
{
  a$d$2(a.d paramd, Context paramContext) {}
  
  public void run()
  {
    TLogger.dd("PushServiceBroadcastHandler", "--start Connect UserPresentReceiver--");
    MqttChannel.getInstance(this.a).startConnect(null);
    a.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.service.a.d.2
 * JD-Core Version:    0.7.0.1
 */