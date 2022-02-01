package com.tencent.tpns.mqttchannel.core.b;

import com.tencent.tpns.mqttchannel.core.common.c.a;

class a$9$2$1
  implements Runnable
{
  a$9$2$1(a.9.2 param2) {}
  
  public void run()
  {
    try
    {
      this.a.a.c.a(this.a.a.b);
      return;
    }
    catch (Throwable localThrowable)
    {
      a.a("IMqttServiceImpl", this.a.a.d + " [xg] connectService connectAction.action() error: ", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tpns.mqttchannel.core.b.a.9.2.1
 * JD-Core Version:    0.7.0.1
 */