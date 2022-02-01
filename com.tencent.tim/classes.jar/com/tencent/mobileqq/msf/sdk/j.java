package com.tencent.mobileqq.msf.sdk;

import com.tencent.qphone.base.remote.ServiceMsgWrapper;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

public class j
  implements Runnable
{
  private static final String a = "MSF.S.IPCTransportMonitorTask";
  private ConcurrentHashMap b;
  private int c;
  
  public j(ConcurrentHashMap paramConcurrentHashMap, int paramInt)
  {
    this.b = paramConcurrentHashMap;
    this.c = paramInt;
  }
  
  public void run()
  {
    if ((ServiceMsgWrapper)this.b.get(Integer.valueOf(this.c)) != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.S.IPCTransportMonitorTask", 2, "transport msg to process timeout, ssoSeq is " + this.c);
      }
      this.b.remove(Integer.valueOf(this.c));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.sdk.j
 * JD-Core Version:    0.7.0.1
 */