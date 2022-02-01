package com.tencent.tpns.mqttchannel.core.b;

import android.os.Handler;
import android.os.Message;
import com.tencent.tpns.mqttchannel.core.common.c.b;

class a$10
  extends Handler
{
  a$10(a parama) {}
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    if (paramMessage != null) {
      com.tencent.tpns.mqttchannel.core.common.c.a.a("IMqttServiceImpl", "handler cmd: " + paramMessage.what);
    }
    switch (paramMessage.what)
    {
    default: 
      com.tencent.tpns.mqttchannel.core.common.c.a.e("IMqttServiceImpl", "unknown handler msg = " + paramMessage.what);
      return;
    case 1: 
      if (b.a(a.g(this.a)))
      {
        a.d(this.a, null);
        return;
      }
      com.tencent.tpns.mqttchannel.core.common.c.a.c("IMqttServiceImpl", "net Work is not alive, stop connect");
      return;
    case 2: 
      this.a.a(null);
      return;
    case 1006: 
      a.t(this.a);
      return;
    case 1001: 
      a.a(this.a, 1001, paramMessage);
      return;
    case 1002: 
      a.a(this.a, 1002, paramMessage);
      return;
    case 1003: 
      a.a(this.a, 1003, paramMessage);
      return;
    }
    a.a(this.a, 1010, paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tpns.mqttchannel.core.b.a.10
 * JD-Core Version:    0.7.0.1
 */