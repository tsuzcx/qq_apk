package com.tencent.android.tpush.service;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.android.tpush.common.e;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.android.tpush.service.util.f;
import com.tencent.tpns.baseapi.base.util.CommonWorkingThread;
import com.tencent.tpns.mqttchannel.api.MqttChannel;

class b$2
  extends Handler
{
  b$2(b paramb, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    if (paramMessage != null) {
      TLogger.d("PushServiceManager", "initHandler, cmd:" + paramMessage.what);
    }
    switch (paramMessage.what)
    {
    default: 
      TLogger.e("PushServiceManager", "unknown handler msg = " + paramMessage.what);
    case 4: 
    case 1: 
      do
      {
        return;
        TLogger.dd("PushServiceManager", "Service's running at " + b.i().getPackageName() + ",version : " + "1.2.7.3");
        if (!e.a())
        {
          TLogger.e("PushServiceManager", "permission check failed, kill service!");
          this.a.d();
          f.e(b.e());
        }
        a.a().a(b.e());
        MqttChannel.getInstance(b.i()).startConnect(null);
      } while (b.j());
      TLogger.d("PushServiceManager", "pull up xg services on 8s later");
      CommonWorkingThread.getInstance().execute(new b.2.1(this), 8000L);
      b.b(true);
      return;
    case 2: 
      MqttChannel.getInstance(b.i()).startConnect(null);
      return;
    }
    MqttChannel.getInstance(b.i()).stopConnect(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.service.b.2
 * JD-Core Version:    0.7.0.1
 */