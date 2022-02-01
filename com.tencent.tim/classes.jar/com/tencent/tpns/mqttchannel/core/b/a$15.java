package com.tencent.tpns.mqttchannel.core.b;

import android.os.Process;
import com.tencent.tpns.baseapi.XGApiConfig;

class a$15
  implements Runnable
{
  a$15(a parama) {}
  
  public void run()
  {
    if (!XGApiConfig.isEnableService(a.g(this.a))) {
      Process.killProcess(Process.myPid());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tpns.mqttchannel.core.b.a.15
 * JD-Core Version:    0.7.0.1
 */