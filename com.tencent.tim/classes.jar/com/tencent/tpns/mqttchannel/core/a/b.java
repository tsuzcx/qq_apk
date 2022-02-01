package com.tencent.tpns.mqttchannel.core.a;

import com.tencent.tpns.baseapi.base.util.CommonWorkingThread;
import com.tencent.tpns.mqttchannel.core.common.b.a.a;

public abstract class b
  extends a.a
{
  public abstract void callback(int paramInt, String paramString);
  
  public final void handleCallback(int paramInt, String paramString)
  {
    CommonWorkingThread.getInstance().execute(new b.1(this, paramInt, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tpns.mqttchannel.core.a.b
 * JD-Core Version:    0.7.0.1
 */